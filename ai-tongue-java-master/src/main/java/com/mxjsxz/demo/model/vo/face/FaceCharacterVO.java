package com.mxjsxz.demo.model.vo.face;

/**
 * 面部特征DTO
 *
 * @author xuwenbing
 * @date 2022-7-4
 */
public class FaceCharacterVO {
    /**
     * 特征编码
     */
    private String code;

    /**
     * 特征名称
     */
    private String name;

    /**
     * 特征描述
     */
    private String description;

    /**
     * 2020-01-13 增加 简述 字段
     */
    private String simpleDescription;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSimpleDescription() {
        return simpleDescription;
    }

    public void setSimpleDescription(String simpleDescription) {
        this.simpleDescription = simpleDescription;
    }
}
