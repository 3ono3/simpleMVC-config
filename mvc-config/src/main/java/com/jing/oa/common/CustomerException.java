package com.jing.oa.common;

/**
 * 自定义异常
 * @author GuoJingyuan
 * @date 2019/8/21
 */
public class CustomerException extends RuntimeException{
    private String code;
    private String desc;

    public CustomerException(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    public CustomerException(ResultCodeEnum codeEnum) {
        this.code = codeEnum.getCode();
        this.desc = codeEnum.getDescription();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
