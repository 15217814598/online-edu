package com.edu.onlineedu.pojo;

import lombok.Data;

import java.util.Map;

@Data
public class Result {
    private Boolean status;
    private String message;
    private Map<String, Object> data;

    public Result(Boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public Result(Boolean status, String message, Map<String, Object> data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
