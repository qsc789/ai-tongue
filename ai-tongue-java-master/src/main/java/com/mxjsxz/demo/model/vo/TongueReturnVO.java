package com.mxjsxz.demo.model.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 返回给调用者结果
 *
 * @author xuwenbing
 * @date 2019-02-25
 */
public class TongueReturnVO implements Serializable {
    /**
     * 第三方单据id
     */
    private String outId;

    /**
     * 返回类型
     * 0:问诊题目；此时inquiryQuestions有值，result、error为空
     * 1:最终体质结果；此时result有值，error、inquiryQuestions为空
     * 2:检测失败；此时error有值，result、inquiryQuestions为空
     * 31:预判为合法图片；此时result、error、inquiryQuestions为空
     * 32:预判为不合法图片；此时error有值，result、inquiryQuestions为空
     */
    private Integer returnType;

    /**
     * 问诊问题
     */
    private List<TongueQuestionVO> inquiryQuestions;

    /**
     * 最终体质结果
     */
    private TongueResultVO result;

    /**
     * 错误提示
     */
    private TongueErrorVO error;

    public String getOutId() {
        return outId;
    }

    public void setOutId(String outId) {
        this.outId = outId;
    }

    public Integer getReturnType() {
        return returnType;
    }

    public void setReturnType(Integer returnType) {
        this.returnType = returnType;
    }

    public List<TongueQuestionVO> getInquiryQuestions() {
        return inquiryQuestions;
    }

    public void setInquiryQuestions(List<TongueQuestionVO> inquiryQuestions) {
        this.inquiryQuestions = inquiryQuestions;
    }

    public TongueResultVO getResult() {
        return result;
    }

    public void setResult(TongueResultVO result) {
        this.result = result;
    }

    public TongueErrorVO getError() {
        return error;
    }

    public void setError(TongueErrorVO error) {
        this.error = error;
    }
}
