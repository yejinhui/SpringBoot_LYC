package com.example.springbootdemo.db.pojo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
* ElementPlus图片显示
* @TableName sys_icon
*/
@Data
public class SysIcon implements Serializable {

    /**
    * 主键
    */
    @NotNull(message="[主键]不能为空")
    @ApiModelProperty("主键")
    private Integer id;
    /**
    * 图片名称
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("图片名称")
    @Length(max= 255,message="编码长度不能超过255")
    private String iconName;
    /**
    * 图片描述
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("图片描述")
    @Length(max= 255,message="编码长度不能超过255")
    private String desc;
    /**
    * 状态
    */
    @ApiModelProperty("状态")
    private Integer status;

}
