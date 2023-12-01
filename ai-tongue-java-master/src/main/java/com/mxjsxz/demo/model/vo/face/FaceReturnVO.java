package com.mxjsxz.demo.model.vo.face;

import com.mxjsxz.demo.model.vo.TongueErrorVO;

/**
 * 面诊返回结果
 *
 * @author xuwenbing
 * @date 2022-7-4
 */
public class FaceReturnVO {
    /**
     * <strong>返回类型:</strong>
     * <p>100:最终结果</p>
     * <p>101:错误提示</p>
     * <p>110:预判是面部</p>
     * <p>111:预判不是面部</p>
     */
    private Integer returnType;

    /**
     * 第三方单据id
     */
    private String outId;

    /**
     * 错误提示（借用舌诊错误提示类）
     */
    private TongueErrorVO error;

    /**
     * 面诊结果
     */
    private FaceResultVO result;

    public Integer getReturnType() {
        return returnType;
    }

    public void setReturnType(Integer returnType) {
        this.returnType = returnType;
    }

    public String getOutId() {
        return outId;
    }

    public void setOutId(String outId) {
        this.outId = outId;
    }

    public TongueErrorVO getError() {
        return error;
    }

    public void setError(TongueErrorVO error) {
        this.error = error;
    }

    public FaceResultVO getResult() {
        return result;
    }

    public void setResult(FaceResultVO result) {
        this.result = result;
    }
}
