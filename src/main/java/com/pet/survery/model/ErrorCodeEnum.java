package com.pet.survery.model;

/**
 *
 * @Author: ZBW-designer
 * @Descroption: 错误信息（定完后，不可修改）
 * @Date: 2019/1/19
 * @Modified By:
 **/
public enum ErrorCodeEnum {
    /** 成功 */
    SUCCESS("成功", "0"),

    /** 失败 90000----99999为服务器原因，管理员添加，其它人不可添加*/
    FAIL("服务器异常", "90000"),
    SERVER_USE_DATABASE("服务器操作数据库异常","99999"),
    REDIS_SERVER_EXCEPTION("服务器出差错了呦，请稍等", "99998"),
    VALIDATOR_FAIL("校验不合法", "92000"),
    /** 其他 */
    OTHER("其他", "91000"),

    /**
     * 宠物调查问卷的问题相关(10000-11000)
     */
    ADD_UPDATE_PET_FAIL("调查问题添加或更新失败","10000"),
    SUBMIT_FAIL("提交失败","10001"),
    SUBMIT_PHONE_REPEAT("提交手机号重复","10002"),

    /**
     * 小宠有佳后台管理系统异常提示信息(11001-12000)
     */
    REGISTER_ADMIN_FAIL("管理员注册失败","11001");

    //定义属性
    private String code;
    private String message;
    ErrorCodeEnum(String message, String code) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return new StringBuffer("{")
                .append("\"message\":\"").append(message).append("\"")
                .append(", \"code\":\"").append(code).append("\"")
                .append("}").toString();
    }

    public static ErrorCodeEnum getErrorCodeEnumForCode(String code) {
        ErrorCodeEnum[] errorCodeEnums = ErrorCodeEnum.values();
        for (ErrorCodeEnum errorCodeEnum : errorCodeEnums) {
            String errorCode = errorCodeEnum.getCode();
            if (errorCode.equalsIgnoreCase(code)) {
                return errorCodeEnum;
            }
        }
        return null;
    }

}
