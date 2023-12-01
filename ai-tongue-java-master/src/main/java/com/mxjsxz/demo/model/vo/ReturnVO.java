package com.mxjsxz.demo.model.vo;

/**
 * 加密签名的中医舌诊返回结果类型
 *
 * @author xuwenbing
 * @date 2019-05-21
 */
public class ReturnVO {
    /**
     * 第三方单据Id
     */
    private String outId;

    /**
     * 对outId签名
     */
    private String signature;

    /**
     * 加密数据
     */
    private String encryptData;

    public String getOutId() {
        return outId;
    }

    public void setOutId(String outId) {
        this.outId = outId;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getEncryptData() {
        return encryptData;
    }

    public void setEncryptData(String encryptData) {
        this.encryptData = encryptData;
    }
}
