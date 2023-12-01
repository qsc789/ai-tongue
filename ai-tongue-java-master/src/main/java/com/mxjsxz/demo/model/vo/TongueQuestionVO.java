package com.mxjsxz.demo.model.vo;

/**
 * 返回给调用者结果（0）-问诊问题
 *
 * @author xuwenbing
 * @date 2019-02-25
 */
public class TongueQuestionVO {
    /**
     * 问题序号
     */
    private Integer questionIndex;

    /**
     * 问题内容
     */
    private String questionContent;

    /**
     * 问题答案可选项，逗号隔开
     */
    private String answerOptions;

    /**
     * 问题默认选项
     */
    private String defaultOption;

    public Integer getQuestionIndex() {
        return questionIndex;
    }

    public void setQuestionIndex(Integer questionIndex) {
        this.questionIndex = questionIndex;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public String getAnswerOptions() {
        return answerOptions;
    }

    public void setAnswerOptions(String answerOptions) {
        this.answerOptions = answerOptions;
    }

    public String getDefaultOption() {
        return defaultOption;
    }

    public void setDefaultOption(String defaultOption) {
        this.defaultOption = defaultOption;
    }
}
