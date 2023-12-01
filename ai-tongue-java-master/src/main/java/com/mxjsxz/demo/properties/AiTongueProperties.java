package com.mxjsxz.demo.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 中医舌诊示例配置
 *
 * @author xuwenbing
 * @date 2019-06-10
 */
@ConfigurationProperties(prefix = "ai-tongue")
public class AiTongueProperties {
    /**
     * 开发者账号
     */
    private String devId;

    /**
     * 开发者密钥
     */
    private String devSecret;

    /**
     * 获取access_token地址
     */
    private String getTokenUrl;

    /**
     * 脏腑健康api-检测地址
     */
    private String tongueTaskUrl;

    /**
     * 脏腑健康api-问诊地址
     */
    private String tongueInquiryTaskUrl;

    /**
     * 体质健康api-检测地址
     */
    private String tongueSimpleTaskUrl;

    /**
     * aesKey
     */
    private String aesKey;

    /**
     * 开发者rsa公钥
     */
    private String devRsaPublicKey;

    /**
     * 开发者rsa私钥，请妥善保管
     */
    private String devRsaPrivateKey;

    /**
     * 中医舌诊rsa平台公钥
     */
    private String rsaPublicKey;

    /**
     * 两段式检测-验证舌象地址
     */
    private String preTongueUrl;

    /**
     * 两段式检测-脏腑健康api-检测地址
     */
    private String preTongueTaskUrl;

    /**
     * 两段式检测-体质健康api-检测地址
     */
    private String preTongueSimpleTaskUrl;

    /**
     * 两段式检测-舌象特征api-检测地址
     */
    private String preTongueCharacterTaskUrl;

    /**
     * 面诊-完整
     */
    private String faceTaskUrl;

    /**
     * 面诊-阶段一
     */
    private String facePreTaskUrl;

    /**
     * 面诊-阶段二
     */
    private String faceDoTaskUrl;


    public String getFaceTaskUrl() {
        return faceTaskUrl;
    }

    public void setFaceTaskUrl(String faceTaskUrl) {
        this.faceTaskUrl = faceTaskUrl;
    }

    public String getFacePreTaskUrl() {
        return facePreTaskUrl;
    }

    public void setFacePreTaskUrl(String facePreTaskUrl) {
        this.facePreTaskUrl = facePreTaskUrl;
    }

    public String getFaceDoTaskUrl() {
        return faceDoTaskUrl;
    }

    public void setFaceDoTaskUrl(String faceDoTaskUrl) {
        this.faceDoTaskUrl = faceDoTaskUrl;
    }

    public String getPreTongueCharacterTaskUrl() {
        return preTongueCharacterTaskUrl;
    }

    public void setPreTongueCharacterTaskUrl(String preTongueCharacterTaskUrl) {
        this.preTongueCharacterTaskUrl = preTongueCharacterTaskUrl;
    }

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId;
    }

    public String getDevSecret() {
        return devSecret;
    }

    public void setDevSecret(String devSecret) {
        this.devSecret = devSecret;
    }

    public String getGetTokenUrl() {
        return getTokenUrl;
    }

    public void setGetTokenUrl(String getTokenUrl) {
        this.getTokenUrl = getTokenUrl;
    }

    public String getTongueTaskUrl() {
        return tongueTaskUrl;
    }

    public void setTongueTaskUrl(String tongueTaskUrl) {
        this.tongueTaskUrl = tongueTaskUrl;
    }

    public String getTongueInquiryTaskUrl() {
        return tongueInquiryTaskUrl;
    }

    public void setTongueInquiryTaskUrl(String tongueInquiryTaskUrl) {
        this.tongueInquiryTaskUrl = tongueInquiryTaskUrl;
    }

    public String getTongueSimpleTaskUrl() {
        return tongueSimpleTaskUrl;
    }

    public void setTongueSimpleTaskUrl(String tongueSimpleTaskUrl) {
        this.tongueSimpleTaskUrl = tongueSimpleTaskUrl;
    }

    public String getAesKey() {
        return aesKey;
    }

    public void setAesKey(String aesKey) {
        this.aesKey = aesKey;
    }

    public String getDevRsaPublicKey() {
        return devRsaPublicKey;
    }

    public void setDevRsaPublicKey(String devRsaPublicKey) {
        this.devRsaPublicKey = devRsaPublicKey;
    }

    public String getDevRsaPrivateKey() {
        return devRsaPrivateKey;
    }

    public void setDevRsaPrivateKey(String devRsaPrivateKey) {
        this.devRsaPrivateKey = devRsaPrivateKey;
    }

    public String getRsaPublicKey() {
        return rsaPublicKey;
    }

    public void setRsaPublicKey(String rsaPublicKey) {
        this.rsaPublicKey = rsaPublicKey;
    }

    public String getPreTongueUrl() {
        return preTongueUrl;
    }

    public void setPreTongueUrl(String preTongueUrl) {
        this.preTongueUrl = preTongueUrl;
    }

    public String getPreTongueTaskUrl() {
        return preTongueTaskUrl;
    }

    public void setPreTongueTaskUrl(String preTongueTaskUrl) {
        this.preTongueTaskUrl = preTongueTaskUrl;
    }

    public String getPreTongueSimpleTaskUrl() {
        return preTongueSimpleTaskUrl;
    }

    public void setPreTongueSimpleTaskUrl(String preTongueSimpleTaskUrl) {
        this.preTongueSimpleTaskUrl = preTongueSimpleTaskUrl;
    }
}
