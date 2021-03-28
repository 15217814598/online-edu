package com.edu.onlineedu.pojo;

import lombok.Data;

import java.util.Map;

@Data
public class Result {
    private Boolean status;
    private String message;
    private Object data;

    public Result(Boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public Result(Boolean status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static Result success(String message, Object data) {
        return new Result(true, message, data);
    }

    public static Result fail(String message, Object data) {
        return new Result(false, message, data);
    }
}
