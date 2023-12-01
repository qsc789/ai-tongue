package com.mxjsxz.demo.model.vo;

/**
 * 一般的结果返回类型
 *
 * @author xuwenbing
 * @date 2019-06-10
 */
public class ResultVO<T> {
    /**
     * 返回码
     */
    private int code;
    /**
     * 返回消息
     */
    private String msg;

    /**
     * 携带数据
     */
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
