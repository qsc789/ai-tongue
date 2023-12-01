package com.mxjsxz.demo.model.form;

/**
 * 提交检测加密数据form
 *
 * @author xuwenbing
 * @date 2019-06-13
 */
public class TongueTaskEncryptDataForm {
    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别：0未知 1男 2女
     */
    private Integer sex;

    public TongueTaskEncryptDataForm() {
    }

    public TongueTaskEncryptDataForm(Integer age, Integer sex) {
        this.age = age;
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
