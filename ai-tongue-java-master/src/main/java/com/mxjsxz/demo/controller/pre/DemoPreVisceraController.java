package com.mxjsxz.demo.controller.pre;

import com.mxjsxz.demo.constants.AiTongueConstant;
import com.mxjsxz.demo.model.form.TongueInquiryAnswerForm;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.mxjsxz.demo.constants.AiTongueConstant.SUCCESS;

/**
 * 健康状态辨识API
 *
 * @author xuwenbing
 * @date 2019-06-10
 */
@RestController
@RequestMapping("viscera/pre")
public class DemoPreVisceraController {
    private Logger log = LoggerFactory.getLogger(DemoPreVisceraController.class);
    private final AiTongueProperties aiTongueProperties;
    private final IRestTemplateService restTemplateService;

    @Autowired
    public DemoPreVisceraController(AiTongueProperties aiTongueProperties, IRestTemplateService restTemplateService) {
        this.aiTongueProperties = aiTongueProperties;
        this.restTemplateService = restTemplateService;
    }

    /**
     * 阶段一：验证舌象
     *
     * @return
     */
    @PostMapping("index")
    public String index() throws Exception {
        // 1.获取accesstoken
        String accesstoken = this.getAccessToken(aiTongueProperties.getDevId(), aiTongueProperties.getDevSecret());
        if (StringUtils.isBlank(accesstoken)) {
            return AiTongueConstant.ERROR;
        }
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + accesstoken);

        // 2.准备待检测的数据：第三方单据id、舌面图片、舌下图片、年龄、性别和结果接收地址
        Integer outId = 1;
        File imageFile = new File(this.getClass().getClassLoader().getResource("static/tongue2.jpg").getFile());
        File backImageFile = new File(this.getClass().getClassLoader().getResource("static/tongueBack2.jpg").getFile());
        String returnUrl = "https://your.domain/viscera/pre/resultReturn"; //您的结果接收地址

        // 3.签名数据
        String signature = RsaSimpleUtil.sign(Integer.toString(outId), aiTongueProperties.getDevRsaPrivateKey());

        // 4.上传检测
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("outId", outId);
        params.add("returnUrl", returnUrl);
        params.add("signature", signature);
        params.add("images", restTemplateService.getFileSystemResource(imageFile));
        params.add("backImages", restTemplateService.getFileSystemResource(backImageFile));
        // 开启下面的代码表示使用网络舌象图片,支持http/https
//        params.add("imageType", 2);
//        params.add("imageUrl", "https://your.domaim/tongue.jpg");
//        params.add("backImageUrl", "https://your.domaim/tongueBack.jpg");

        // 当resultVO.code=0表示上传成功：
        // （1）检测的结果会回传到您设置的returnUrl上
        ResultVO resultVO = restTemplateService.postForObject(aiTongueProperties.getPreTongueUrl(), headers, params, ResultVO.class);
        log.info("index:{}", JsonUtil.toJson(resultVO));
        return AiTongueConstant.OK;
    }

    /**
     * 阶段二：1、确认提交检测
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
        Integer outId = 1;
        Integer age = 20; // 大于等于0
        Integer sex = 1; // 0：未知 1：男 2：女

        // 3.加密和签名数据
        String signature = RsaSimpleUtil.sign(Integer.toString(outId), aiTongueProperties.getDevRsaPrivateKey());
        String sourceData = JsonUtil.toJson(new TongueTaskEncryptDataForm(age, sex));
        String encryptData = AesSimpleUtil.encrypt(sourceData, aiTongueProperties.getAesKey());

        // 4.上传检测
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("outId", outId);
        params.add("signature", signature);
        params.add("encryptData", encryptData);
        // 当resultVO.code=0表示上传成功：
        // （1）resultVO.data表示预计等待检测时间，
        // （2）检测的结果会回传到您设置的returnUrl上
        ResultVO resultVO = restTemplateService.postForObject(aiTongueProperties.getPreTongueTaskUrl(), headers, params, ResultVO.class);
        log.info("task:{}", JsonUtil.toJson(resultVO));
        return AiTongueConstant.OK;
    }

    /**
     * 阶段二：2、回答问诊问题
     *
     * @return
     */
    @PostMapping("inquiry")
    public String inquiry() throws Exception {
        // 1.获取accesstoken
        String accesstoken = this.getAccessToken(aiTongueProperties.getDevId(), aiTongueProperties.getDevSecret());
        if (StringUtils.isBlank(accesstoken)) {
            return AiTongueConstant.ERROR;
        }
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + accesstoken);

        // 2.准备问诊回答数据：第三方单据id和问诊回答数据
        // 务必保证每个问题都有答案，如果用户没有回答则使用默认答案（TongueQuestionVO.defaultOption）
        Integer outId = 1;
        List<TongueInquiryAnswerForm.InquiryAnswer> inquiryAnswerList = new ArrayList<>();
        inquiryAnswerList.add(new TongueInquiryAnswerForm.InquiryAnswer(1, "经常"));
        inquiryAnswerList.add(new TongueInquiryAnswerForm.InquiryAnswer(2, "偶尔"));
        inquiryAnswerList.add(new TongueInquiryAnswerForm.InquiryAnswer(3, "没有"));
        inquiryAnswerList.add(new TongueInquiryAnswerForm.InquiryAnswer(4, "没有"));
        TongueInquiryAnswerForm inquiryAnswerForm = new TongueInquiryAnswerForm();
        inquiryAnswerForm.setOutId(Integer.toString(outId));
        inquiryAnswerForm.setInquiryAnswers(inquiryAnswerList);

        // 3.加密和签名数据
        String signature = RsaSimpleUtil.sign(Integer.toString(outId), aiTongueProperties.getDevRsaPrivateKey());
        String sourceData = JsonUtil.toJson(inquiryAnswerForm);
        String encryptData = AesSimpleUtil.encrypt(sourceData, aiTongueProperties.getAesKey());

        // 4.上传问诊答案
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("outId", outId);
        params.add("signature", signature);
        params.add("encryptData", encryptData);
        // 当resultVO.code=0表示上传成功：
        // （1）resultVO.data表示预计等待检测时间，
        // （2）检测的结果会回传到您设置的returnUrl上
        ResultVO resultVO = restTemplateService
                .postForObject(aiTongueProperties.getTongueInquiryTaskUrl(), headers, params, ResultVO.class);
        log.info("inquiry:{}", JsonUtil.toJson(resultVO));
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
        log.info("viscera resultReturn：{}", JsonUtil.toJson(returnVO));
        // 1. 验证签名
        boolean verify = RsaSimpleUtil.verify(returnVO.getOutId(), returnVO.getSignature(), aiTongueProperties.getRsaPublicKey());
        if (verify) {
            // 2. 只有验签通过后才进行业务操作
            // 3. 解密数据
            String decryptData = AesSimpleUtil.decrypt(returnVO.getEncryptData(), aiTongueProperties.getAesKey());
            // 4. decryptData可以转化为TongueReturnVO对象,具体每个字段含义见TongueReturnVO
            // 其中returnType表示返回结果的类型
            // returnType=0 说明返回的问诊题目，此时您可以保存结果并返回给用户，用户回答问诊后调用“阶段二：2、回答问诊问题”接口
            // returnType=1 说明返回的最终体质结果，此时您可以保存结果并返回给用户
            // returnType=2 说明返回的失败提示信息，此时您可以反馈给用户
            // returnType=31 预判为合法图片，此时您可以调用“阶段二：确认提交检测”接口
            // returnType=32 预判为不合法图片，此时您可以反馈给用户，并且不推荐继续调用“阶段二：1、确认提交检测”接口
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
        log.info("access_token result:{}", JsonUtil.toJson(accessTokenResult));
        if (accessTokenResult.getCode() != 0) {
            return null;
        }
        return ((Map) accessTokenResult.getData()).get("access_token").toString();
    }
}
