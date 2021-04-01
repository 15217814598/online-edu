package com.edu.onlineedu.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Feedback {
    private Integer feedbackId;
    private String feedbackAdvice;
    private Date feedbackTime;
}
