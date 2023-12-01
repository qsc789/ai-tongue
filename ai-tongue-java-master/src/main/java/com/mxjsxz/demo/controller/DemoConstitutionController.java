package com.mxjsxz.demo.controller;

import com.mxjsxz.demo.constants.AiTongueConstant;
import com.mxjsxz.demo.model.form.TongueTaskEncryptDataForm;
import com.mxjsxz.demo.model.vo.ResultVO;
import com.mxjsxz.demo.model.vo.ReturnVO;
import com.mxjsxz.demo.model.vo.TongueReturnVO;
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
 * 体质辨识API(旧版本接口，仅供参考)
 *
 * @author xuwenbing
 * @date 2019-06-10
 */
@RestController
@RequestMapping("constitution")
public class DemoConstitutionController {
    private Logger log = LoggerFactory.getLogger(DemoConstitutionController.class);
    private final AiTongueProperties aiTongueProperties;
    private final IRestTemplateService restTemplateService;

    @Autowired
    public DemoConstitutionController(AiTongueProperties aiTongueProperties, IRestTemplateService restTemplateService) {
        this.aiTongueProperties = aiTongueProperties;
        this.restTemplateService = restTemplateService;
    }


    /**
     * 1、提交检测
     *
     * @return
     */
    @PostMapping("taskSimple")
    public String taskSimple() throws Exception {
        // 1.获取accesstoken
        String accesstoken = this.getAccessToken(aiTongueProperties.getDevId(), aiTongueProperties.getDevSecret());
        if (StringUtils.isBlank(accesstoken)) {
            return AiTongueConstant.ERROR;
        }
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + accesstoken);

        // 2.准备待检测的数据：第三方单据id、舌面图片、舌下图片、年龄、性别和结果接收地址
        Integer outId = 1;
        File imageFile = new File(this.getClass().getClassLoader().getResource("static/tongue.jpg").getFile());
        File backImageFile = new File(this.getClass().getClassLoader().getResource("static/tongueBack.jpg").getFile());
        Integer age = 20; // 大于等于0
        Integer sex = 1; // 0：未知 1：男 2：女
        String returnUrl = "https://your.domain/constitution/resultReturn"; //您的结果接收地址

        // 3.加密和签名数据
        String signature = RsaSimpleUtil.sign(Integer.toString(outId), aiTongueProperties.getDevRsaPrivateKey());
        String sourceData = JsonUtil.toJson(new TongueTaskEncryptDataForm(age, sex));
        String encryptData = AesSimpleUtil.encrypt(sourceData, aiTongueProperties.getAesKey());

        // 4.上传检测
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("outId", outId);
        params.add("returnUrl", returnUrl);
        params.add("signature", signature);
        params.add("encryptData", encryptData);
        params.add("images", restTemplateService.getFileSystemResource(imageFile));
        params.add("backImages", restTemplateService.getFileSystemResource(backImageFile));
        // 当resultVO.code=0表示上传成功：
        // （1）resultVO.data表示预计等待检测时间，
        // （2）检测的结果会回传到您设置的returnUrl上
        ResultVO resultVO = restTemplateService.postForObject(aiTongueProperties.getTongueSimpleTaskUrl(), headers, params, ResultVO.class);
        log.info("taskSimple:{}", JsonUtil.toJson(resultVO));
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
        log.info("constitution resultReturn：{}", JsonUtil.toJson(returnVO));
        // 1. 验证签名
        boolean verify = RsaSimpleUtil.verify(returnVO.getOutId(), returnVO.getSignature(), aiTongueProperties.getRsaPublicKey());
        if (verify) {
            // 2. 只有验签通过后才进行业务操作
            // 3. 解密数据
            String decryptData = AesSimpleUtil.decrypt(returnVO.getEncryptData(), aiTongueProperties.getAesKey());
            // 4. decryptData可以转化为TongueReturnVO对象,具体每个字段含义见TongueReturnVO
            // 其中returnType表示返回结果的类型
            // returnType=1 说明返回的最终体质结果
            // returnType=2 说明返回的失败提示信息
            log.info("constitution decryptData：{}", decryptData);
            TongueReturnVO tongueReturnVO = JsonUtil.parseObject(decryptData, TongueReturnVO.class);
            return SUCCESS;
        }
        log.info("验证签名失败");
        return AiTongueConstant.ERROR;
    }

    /**
     * 获取access_token（获取后建议缓存，一般30分钟有效）
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
        log.info("access_token result:{}",JsonUtil.toJson(accessTokenResult));
        if (accessTokenResult.getCode() != 0) {
            return null;
        }
        return ((Map) accessTokenResult.getData()).get("access_token").toString();
    }
}
