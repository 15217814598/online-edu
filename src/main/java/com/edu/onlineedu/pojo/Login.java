package com.edu.onlineedu.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "com.edu.onlineedu.pojo.Login", description = "用户参数")
public class Login {
    @ApiModelProperty(value = "账号")
    private String name;
    @ApiModelProperty(value = "密码")
    private String pwd;
}
