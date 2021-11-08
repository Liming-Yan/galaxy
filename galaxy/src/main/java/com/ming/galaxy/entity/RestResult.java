package com.ming.galaxy.entity;

/**
 * web接口统一返回数据结构
 */
public class RestResult {
    /**
     * 状态码
     */
    private int code;
    /**
     * 描述信息
     */
    private String message;
    /**
     * 数据
     */
    private Object data;

    public RestResult() {
    }

    public static RestResult success(Object data) {
        return new RestResult(0, "", data);
    }

    public RestResult(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
