package com.edu.onlineedu.pojo;

import lombok.Data;

import java.util.Map;

@Data
public class Result {
    private Boolean status;
    private String message;
    private Map<String, Object> data;


}
