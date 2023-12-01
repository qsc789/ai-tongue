package com.mxjsxz.demo.model.vo;

/**
 * 返回给调用者结果（2）-错误提示
 *
 * @author xuwenbing
 * @date 2019-02-25
 */
public class TongueErrorVO {
    /**
     * 错误码
     */
    private Integer code;

    /**
     * 详细说明
     */
    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
