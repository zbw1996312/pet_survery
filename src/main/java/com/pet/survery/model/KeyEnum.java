package com.pet.survery.model;

/**
 * @author zhangbowei
 * @description 各种key的枚举类型
 * @since 2020/09/17 17:14:23
 */
public enum  KeyEnum {
    AES_KEY(",?h&69_F;XsZ(@Rc");
    //定义属性
    private String code;

    KeyEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "KeyEnum{" +
                "code='" + code + '\'' +
                '}';
    }
}
