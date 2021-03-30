package com.edu.onlineedu.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class Teacher {

    //@JsonIgnore
    private Integer teacherId;

    private String teacherName;

    private String teacherTitle;

    private String teacherExp;

    private String teacherPhone;

    private String teacherEmail;
}
