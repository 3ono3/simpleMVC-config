package com.jing.oa.common;

/**
 * 返回提示
 * @author GuoJingyuan
 * @date 2019/8/21
 */
public enum ResultCodeEnum {

    SUCCESS("00000", "成功"),
    SYSTEM_ERROR("99999", "系统异常"),

    USER_INSERT_ERROR("01000", "用户插入异常"),
    LOGIN_ERROR("010001", "用户名或密码错误"),
    ;

    private String code;
    private String description;

    ResultCodeEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
