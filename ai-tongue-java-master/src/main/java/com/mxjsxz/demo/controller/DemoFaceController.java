package com.mxjsxz.demo.controller;

import com.mxjsxz.demo.constants.AiTongueConstant;
import com.mxjsxz.demo.model.form.FaceTaskEncryptDataForm;
import com.mxjsxz.demo.model.vo.ResultVO;
import com.mxjsxz.demo.model.vo.ReturnVO;
import com.mxjsxz.demo.model.vo.face.FaceReturnVO;
import com.mxjsxz.demo.properties.AiTongueProperties;
import com.mxjsxz.demo.service.IRestTemplateService;
import com.mxjsxz.demo.utils.AesSimpleUtil;
import com.mxjsxz.demo.utils.JsonUtil;
import com.mxjsxz.demo.utils.RsaSimpleUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static com.mxjsxz.demo.constants.AiTongueConstant.SUCCESS;

/**
 * 面诊API(旧版本接口，仅供参考)
 *
 * @author xuwenbing
 * @date 2022-07-06
 */
@RestController
@RequestMapping("face")
public class DemoFaceController {
    private Logger log = LoggerFactory.getLogger(DemoFaceController.class);
    private final AiTongueProperties aiTongueProperties;
    private final IRestTemplateService restTemplateService;
    // 结果接收地址前缀，完整路径形如：https://your.domain/face/resultReturn
    private final static String RETURN_URL_PREFIX = "https://your.domain";
    // 第三方单据id
    private Integer outId = 1;

    @Autowired
    public DemoFaceController(AiTongueProperties aiTongueProperties, IRestTemplateService restTemplateService) {
        this.aiTongueProperties = aiTongueProperties;
        this.restTemplateService = restTemplateService;
    }


    /**
     * 1、提交检测
     *
     * @return
     */
    @PostMapping("task")
    public String task() throws Exception {
        // 1.获取accesstoken
        String accesstoken = this.getAccessToken(aiTongueProperties.getDevId(), aiTongueProperties.getDevSecret());
        if (StringUtils.isBlank(accesstoken)) {
            return AiTongueConstant.ERROR;
        }
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + accesstoken);

        // 2.准备待检测的数据：第三方单据id、舌面图片、舌下图片、年龄、性别和结果接收地址
        FaceTaskEncryptDataForm form = new FaceTaskEncryptDataForm();
        form.setImageType((short) 1);
        form.setReturnUrl(RETURN_URL_PREFIX + "/face/resultReturn");
        form.setAge(100);
        form.setSex((short) 1);
        File faceImg = new File(this.getClass().getClassLoader().getResource("images/face_main.jpg").getFile());
        File faceLeftImg = new File(this.getClass().getClassLoader().getResource("images/face_left.jpg").getFile());
        File faceRightImg = new File(this.getClass().getClassLoader().getResource("images/face_right.jpg").getFile());


        // 3.加密和签名数据
        String signature = RsaSimpleUtil.sign(Integer.toString(outId), aiTongueProperties.getDevRsaPrivateKey());
        String sourceData = JsonUtil.toJson(form);
        String encryptData = AesSimpleUtil.encrypt(sourceData, aiTongueProperties.getAesKey());

        // 4.上传检测
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("outId", outId);
        params.add("signature", signature);
        params.add("encryptData", encryptData);
        params.add("faceImg", restTemplateService.getFileSystemResource(faceImg));
        params.add("faceLeftImg", restTemplateService.getFileSystemResource(faceLeftImg));
        params.add("faceRightImg", restTemplateService.getFileSystemResource(faceRightImg));
        // 当resultVO.code=0表示上传成功：
        // （1）resultVO.data表示预计等待检测时间，
        // （2）检测的结果会回传到您设置的returnUrl上
        ResultVO resultVO = restTemplateService.postForObject(aiTongueProperties.getFaceTaskUrl(), headers, params, ResultVO.class);
        log.info("face task:{}", JsonUtil.toJson(resultVO));
        return AiTongueConstant.OK;
    }

    /**
     * 2、结果接收地址
     *
     * @param returnVO
     * @return
     */
    @PostMapping("resultReturn")
    public String resultReturn(ReturnVO returnVO) throws Exception {
        log.info("face task resultReturn：{}", JsonUtil.toJson(returnVO));
        // 1. 验证签名
        boolean verify = RsaSimpleUtil.verify(returnVO.getOutId(), returnVO.getSignature(), aiTongueProperties.getRsaPublicKey());
        if (verify) {
            // 2. 只有验签通过后才进行业务操作
            // 3. 解密数据
            String decryptData = AesSimpleUtil.decrypt(returnVO.getEncryptData(), aiTongueProperties.getAesKey());
            // 4. decryptData可以转化为FaceReturnVO对象,具体每个字段含义见FaceReturnVO
            // 其中returnType表示返回结果的类型
            //      * <strong>返回类型:</strong>
            //     * <p>100:最终结果</p>
            //     * <p>101:错误提示</p>
            //     * <p>110:预判是面部</p>
            //     * <p>111:预判不是面部</p>
            log.info("face task decryptData：{}", decryptData);
            FaceReturnVO faceReturnVO = JsonUtil.parseObject(decryptData, FaceReturnVO.class);
            return SUCCESS;
        }
        log.info("验证签名失败");
        return AiTongueConstant.ERROR;
    }

    /**
     * 获取access_token（获取后建议缓存，一般1小时有效）
     *
     * @param devId
     * @param devSecret
     * @return
     */
    private String getAccessToken(String devId, String devSecret) {
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("devid", devId);
        params.add("devsecret", devSecret);
        ResultVO accessTokenResult = restTemplateService.postForObject(aiTongueProperties.getGetTokenUrl(), params, ResultVO.class);
        log.info("access_token result:{}", JsonUtil.toJson(accessTokenResult));
        if (accessTokenResult.getCode() != 0) {
            return null;
        }
        return ((Map) accessTokenResult.getData()).get("access_token").toString();
    }
}
