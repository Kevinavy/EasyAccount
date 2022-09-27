package com.kevinavy.easyaccount.model.common.http;

public class Result {
    private Integer code;
    private String msg;
    private Object data;

    public static Result success(String msg) {
        return new Result(200, msg);
    }

    public static Result success(String msg, Object data) {
        return new Result(200, msg, data);
    }

    public static Result error(String msg) {
        return new Result(400, msg);
    }

    public static Result error(String msg, Object data) {
        return new Result(400, msg, data);
    }

    public static Result error(Integer errorCode, String msg, Object data) {
        return new Result(errorCode, msg, data);
    }

    public Result() {
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
