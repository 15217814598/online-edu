package com.edu.onlineedu.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Schedule {
    private Integer classId;

    private String className;

    private String classTeacher;

    private Date classTime;

    private String isOver;

    private String classPeriod;
}
