package com.edu.onlineedu.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Student {
    private Integer studentId;

    private String studentName;

    private String studentAge;

    private Date studentTime;

    private String studentPhone;

    private String studentEmail;
}
