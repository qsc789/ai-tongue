package com.mxjsxz.demo.model.vo;

import java.io.Serializable;
import java.util.List;


/**
 * 返回给调用者结果（1）-最终体质结果
 *
 * @author xuwenbing
 * @date 2019-02-25
 */
public class TongueResultVO implements Serializable {

    /**
     * oss分割图地址
     */
    private String ossSplitImgUrl;

    /**
     * oss舌下分割图地址
     */
    private String ossSplitBackImgUrl;
    //----------------------------------------------
    /**
     * 体质标识： 逗号隔开
     */
    private String constitutionCodes;

    /**
     * 体质名： 逗号隔开
     */
    private String constitutionNames;

    /**
     * 体质曲线排序
     */
    private Integer constitutionCurveSort;

    /**
     * 体质描述
     */
    private String constitutionDescribe;

    /**
     * 单一体质序号(多个逗号隔开)
     */
    private String singleConfig;

    /**
     * 单一体质名称(多个逗号隔开)
     */
    private String singleConfigName;

    /**
     * 症候名称
     */
    private String symptomName;
    //----------------------------------------------
    /**
     * 舌色名： 逗号隔开
     */
    private String colorOfTongueNames;

    /**
     * 舌色曲线排序
     */
    private Integer colorOfTongueCurveSort;

    /**
     * 舌色描述
     */
    private String colorOfTongueDescribe;
//----------------------------------------------
    /**
     * 苔色名： 逗号隔开
     */
    private String colorOfMossNames;

    /**
     * 苔色曲线排序
     */
    private Integer colorOfMossCurveSort;

    /**
     * 苔色描述
     */
    private String colorOfMossDescribe;
//----------------------------------------------
    /**
     * 舌形名： 逗号隔开
     */
    private String shapeOfTongueNames;

    /**
     * 舌形描述
     */
    private String shapeOfTongueDescribe;
//----------------------------------------------
    /**
     * 苔质名： 逗号隔开
     */
    private String mossNames;

    /**
     * 苔质描述
     */
    private String mossDescribe;
    //----------------------------------------------
    /**
     * 津液名： 逗号隔开
     */
    private String bodyfluidNames;

    /**
     * 津液描述
     */
    private String bodyfluidDescribe;

    //----------------------------------------------
    /**
     * 络脉名： 逗号隔开
     */
    private String veinNames;

    /**
     * 络脉描述
     */
    private String veinDescribe;
    //----------------------------------------------

    /**
     * 治疗方案
     */
    private String treatPlanJson;

    //----------------------------------------------

    /**
     * 舌象属性
     */
    private List<TongueAttr> tongueAttrs;


    public static class TongueAttr {
        /**
         * 属性名称
         */
        private String attrName;

        /**
         * 属性值
         */
        private String attrValue;

        public String getAttrName() {
            return attrName;
        }

        public void setAttrName(String attrName) {
            this.attrName = attrName;
        }

        public String getAttrValue() {
            return attrValue;
        }

        public void setAttrValue(String attrValue) {
            this.attrValue = attrValue;
        }
    }

    public String getOssSplitImgUrl() {
        return ossSplitImgUrl;
    }

    public void setOssSplitImgUrl(String ossSplitImgUrl) {
        this.ossSplitImgUrl = ossSplitImgUrl;
    }

    public String getOssSplitBackImgUrl() {
        return ossSplitBackImgUrl;
    }

    public void setOssSplitBackImgUrl(String ossSplitBackImgUrl) {
        this.ossSplitBackImgUrl = ossSplitBackImgUrl;
    }

    public String getConstitutionCodes() {
        return constitutionCodes;
    }

    public void setConstitutionCodes(String constitutionCodes) {
        this.constitutionCodes = constitutionCodes;
    }

    public String getConstitutionNames() {
        return constitutionNames;
    }

    public void setConstitutionNames(String constitutionNames) {
        this.constitutionNames = constitutionNames;
    }

    public Integer getConstitutionCurveSort() {
        return constitutionCurveSort;
    }

    public void setConstitutionCurveSort(Integer constitutionCurveSort) {
        this.constitutionCurveSort = constitutionCurveSort;
    }

    public String getConstitutionDescribe() {
        return constitutionDescribe;
    }

    public void setConstitutionDescribe(String constitutionDescribe) {
        this.constitutionDescribe = constitutionDescribe;
    }

    public String getSingleConfig() {
        return singleConfig;
    }

    public void setSingleConfig(String singleConfig) {
        this.singleConfig = singleConfig;
    }

    public String getSingleConfigName() {
        return singleConfigName;
    }

    public void setSingleConfigName(String singleConfigName) {
        this.singleConfigName = singleConfigName;
    }

    public String getSymptomName() {
        return symptomName;
    }

    public void setSymptomName(String symptomName) {
        this.symptomName = symptomName;
    }

    public String getColorOfTongueNames() {
        return colorOfTongueNames;
    }

    public void setColorOfTongueNames(String colorOfTongueNames) {
        this.colorOfTongueNames = colorOfTongueNames;
    }

    public Integer getColorOfTongueCurveSort() {
        return colorOfTongueCurveSort;
    }

    public void setColorOfTongueCurveSort(Integer colorOfTongueCurveSort) {
        this.colorOfTongueCurveSort = colorOfTongueCurveSort;
    }

    public String getColorOfTongueDescribe() {
        return colorOfTongueDescribe;
    }

    public void setColorOfTongueDescribe(String colorOfTongueDescribe) {
        this.colorOfTongueDescribe = colorOfTongueDescribe;
    }

    public String getColorOfMossNames() {
        return colorOfMossNames;
    }

    public void setColorOfMossNames(String colorOfMossNames) {
        this.colorOfMossNames = colorOfMossNames;
    }

    public Integer getColorOfMossCurveSort() {
        return colorOfMossCurveSort;
    }

    public void setColorOfMossCurveSort(Integer colorOfMossCurveSort) {
        this.colorOfMossCurveSort = colorOfMossCurveSort;
    }

    public String getColorOfMossDescribe() {
        return colorOfMossDescribe;
    }

    public void setColorOfMossDescribe(String colorOfMossDescribe) {
        this.colorOfMossDescribe = colorOfMossDescribe;
    }

    public String getShapeOfTongueNames() {
        return shapeOfTongueNames;
    }

    public void setShapeOfTongueNames(String shapeOfTongueNames) {
        this.shapeOfTongueNames = shapeOfTongueNames;
    }

    public String getShapeOfTongueDescribe() {
        return shapeOfTongueDescribe;
    }

    public void setShapeOfTongueDescribe(String shapeOfTongueDescribe) {
        this.shapeOfTongueDescribe = shapeOfTongueDescribe;
    }

    public String getMossNames() {
        return mossNames;
    }

    public void setMossNames(String mossNames) {
        this.mossNames = mossNames;
    }

    public String getMossDescribe() {
        return mossDescribe;
    }

    public void setMossDescribe(String mossDescribe) {
        this.mossDescribe = mossDescribe;
    }

    public String getBodyfluidNames() {
        return bodyfluidNames;
    }

    public void setBodyfluidNames(String bodyfluidNames) {
        this.bodyfluidNames = bodyfluidNames;
    }

    public String getBodyfluidDescribe() {
        return bodyfluidDescribe;
    }

    public void setBodyfluidDescribe(String bodyfluidDescribe) {
        this.bodyfluidDescribe = bodyfluidDescribe;
    }

    public String getVeinNames() {
        return veinNames;
    }

    public void setVeinNames(String veinNames) {
        this.veinNames = veinNames;
    }

    public String getVeinDescribe() {
        return veinDescribe;
    }

    public void setVeinDescribe(String veinDescribe) {
        this.veinDescribe = veinDescribe;
    }

    public String getTreatPlanJson() {
        return treatPlanJson;
    }

    public void setTreatPlanJson(String treatPlanJson) {
        this.treatPlanJson = treatPlanJson;
    }

    public List<TongueAttr> getTongueAttrs() {
        return tongueAttrs;
    }

    public void setTongueAttrs(List<TongueAttr> tongueAttrs) {
        this.tongueAttrs = tongueAttrs;
    }
}
