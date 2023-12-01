package com.mxjsxz.demo.model.form;

/**
 * 提交检测加密数据form
 *
 * @author xuwenbing
 * @date 2019-06-13
 */
public class FaceTaskEncryptDataForm {
    /**
     * <pre>
     *  面部图片类型
     *  1文件对象
     *  2网络地址
     * </pre>
     *
     */
    private Short imageType;

    /**
     * 结果回调地址
     */
    private String returnUrl;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     * 0未知
     * 1男
     * 2女
     */
    private Short sex;

    /**
     * 正面部图地址，支持http/https;imageType=2时必传
     */
    private String faceImgUrl;

    /**
     * 左侧面部图地址，支持http/https;imageType=2时有效
     */
    private String faceLeftImgUrl;

    /**
     * 右侧面部图地址，支持http/https;imageType=2时有效
     */
    private String faceRightImgUrl;

    /**
     * 正面部图OSS Bucket Name;imageType=3时必传
     */
    private String faceImgOssBucketName;

    /**
     * 正面部图OSS访问地址;imageType=3时必传
     */
    private String faceImgOssPath;

    /**
     * 左侧面部图OSS Bucket Name;imageType=3时有效
     */
    private String faceLeftImgOssBucketName;

    /**
     * 左侧面部图OSS访问地址;imageType=3时有效
     */
    private String faceLeftImgOssPath;

    /**
     * 右侧面部图OSS Bucket Name;imageType=3时有效
     */
    private String faceRightImgOssBucketName;

    /**
     * 右侧面部图OSS访问地址;imageType=3时有效
     */
    private String faceRightImgOssPath;


    public Short getImageType() {
        return imageType;
    }

    public void setImageType(Short imageType) {
        this.imageType = imageType;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Short getSex() {
        return sex;
    }

    public void setSex(Short sex) {
        this.sex = sex;
    }

    public String getFaceImgUrl() {
        return faceImgUrl;
    }

    public void setFaceImgUrl(String faceImgUrl) {
        this.faceImgUrl = faceImgUrl;
    }

    public String getFaceLeftImgUrl() {
        return faceLeftImgUrl;
    }

    public void setFaceLeftImgUrl(String faceLeftImgUrl) {
        this.faceLeftImgUrl = faceLeftImgUrl;
    }

    public String getFaceRightImgUrl() {
        return faceRightImgUrl;
    }

    public void setFaceRightImgUrl(String faceRightImgUrl) {
        this.faceRightImgUrl = faceRightImgUrl;
    }

    public String getFaceImgOssBucketName() {
        return faceImgOssBucketName;
    }

    public void setFaceImgOssBucketName(String faceImgOssBucketName) {
        this.faceImgOssBucketName = faceImgOssBucketName;
    }

    public String getFaceImgOssPath() {
        return faceImgOssPath;
    }

    public void setFaceImgOssPath(String faceImgOssPath) {
        this.faceImgOssPath = faceImgOssPath;
    }

    public String getFaceLeftImgOssBucketName() {
        return faceLeftImgOssBucketName;
    }

    public void setFaceLeftImgOssBucketName(String faceLeftImgOssBucketName) {
        this.faceLeftImgOssBucketName = faceLeftImgOssBucketName;
    }

    public String getFaceLeftImgOssPath() {
        return faceLeftImgOssPath;
    }

    public void setFaceLeftImgOssPath(String faceLeftImgOssPath) {
        this.faceLeftImgOssPath = faceLeftImgOssPath;
    }

    public String getFaceRightImgOssBucketName() {
        return faceRightImgOssBucketName;
    }

    public void setFaceRightImgOssBucketName(String faceRightImgOssBucketName) {
        this.faceRightImgOssBucketName = faceRightImgOssBucketName;
    }

    public String getFaceRightImgOssPath() {
        return faceRightImgOssPath;
    }

    public void setFaceRightImgOssPath(String faceRightImgOssPath) {
        this.faceRightImgOssPath = faceRightImgOssPath;
    }
}
