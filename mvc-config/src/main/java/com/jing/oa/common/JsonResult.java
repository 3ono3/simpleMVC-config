package com.jing.oa.common;

/**
 * 统一返回类型
 * @author GuoJingyuan
 * @date 2019/8/21
 */
public class JsonResult {
    /**
     * 返回状态码
     */
    public String code;
    /**
     * 返回描述
     */
    public String desc;
    /**
     * 返回数据
     */
    public Object data;

    public JsonResult(String code, String desc, Object data) {
        this.code = code;
        this.desc = desc;
        this.data = data;
    }
    public JsonResult(ResultCodeEnum codeEnum, Object data) {
        this(codeEnum.getCode(), codeEnum.getDescription(), data);
    }
    public static JsonResult ok(){
        return new JsonResult(ResultCodeEnum.SUCCESS, null);
    }
    public static JsonResult ok(Object data) {
        return new JsonResult(ResultCodeEnum.SUCCESS, data);
    }
    public static JsonResult error(CustomerException e) {
        return new JsonResult(e.getCode(),e.getDesc(), null);
    }
    public static JsonResult error(CustomerException e, Object data) {
        return new JsonResult(e.getCode(),e.getDesc(), data);
    }
    public static JsonResult unexpectedError() {
        return new JsonResult(ResultCodeEnum.SYSTEM_ERROR, null);
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
