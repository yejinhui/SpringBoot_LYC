package com.example.springbootdemo.db.pojo;

import lombok.Data;

import java.io.Serializable;

/**
*
* @TableName sys_access
*/
@Data
public class SysAccess implements Serializable {

    /**
    * 主键
    */
    private Integer id;
    /**
    * 名称
    */
    private String accessName;
    /**
    * 权限
    */
    private String root;
    /**
    * 状态
    */
    private Integer status;


}
