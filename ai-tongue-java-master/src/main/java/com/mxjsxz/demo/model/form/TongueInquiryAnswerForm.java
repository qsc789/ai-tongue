package com.mxjsxz.demo.model.form;

import java.util.List;

/**
 * 问诊回答Form
 *
 * @author xuwenbing
 * @date 2019-02-23
 */
public class TongueInquiryAnswerForm {
    /**
     * 第三方单据id
     */
    private String outId;

    /**
     * 问诊回答-答案
     */
    private List<InquiryAnswer> inquiryAnswers;


    public static class InquiryAnswer {
        /**
         * 问题序号
         */
        private Integer questionIndex;

        /**
         * 问题答案项
         */
        private String answerCode;

        public InquiryAnswer() {
        }

        public InquiryAnswer(Integer questionIndex, String answerCode) {
            this.questionIndex = questionIndex;
            this.answerCode = answerCode;
        }

        public Integer getQuestionIndex() {
            return questionIndex;
        }

        public void setQuestionIndex(Integer questionIndex) {
            this.questionIndex = questionIndex;
        }

        public String getAnswerCode() {
            return answerCode;
        }

        public void setAnswerCode(String answerCode) {
            this.answerCode = answerCode;
        }
    }

    public String getOutId() {
        return outId;
    }

    public void setOutId(String outId) {
        this.outId = outId;
    }

    public List<InquiryAnswer> getInquiryAnswers() {
        return inquiryAnswers;
    }

    public void setInquiryAnswers(List<InquiryAnswer> inquiryAnswers) {
        this.inquiryAnswers = inquiryAnswers;
    }
}
