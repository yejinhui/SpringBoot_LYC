package com.example.springbootdemo.db.pojo;


import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* 行为表
* @TableName sys_action
*/
@Data
public class SysAction implements Serializable {

    /**
    * 主键
    */
    @ApiModelProperty("主键")
    private Object id;
    /**
    * 行为编号
    */
    @ApiModelProperty("行为编号")
    private String actionCode;
    /**
    * 行为名称
    */
    @ApiModelProperty("行为名称")
    private String actionName;
    /**
    * 状态
    */
    @ApiModelProperty("状态")
    private Integer status;
    /**
    * 是否默认功能
    */
    @ApiModelProperty("是否默认功能")
    private Integer defaultAction;

}
