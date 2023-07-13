package com.example.springbootdemo.db.pojo;

import java.io.Serializable;
import lombok.Data;

/**
* 角色表
* @TableName sys_role
*/
@Data
public class SysRole implements Serializable {

    /**
    * 主键
    */
    private Object id;
    /**
    * 角色名称
    */
    private String roleName;
    /**
    * 权限集合
    */
    private String permissions;
    /**
    * 描述
    */
    private String desc;
    /**
    * 系统角色内置权限
    */
    private String defaultPermissions;
    /**
    * 是否为系统内置角色
    */
    private Boolean systemic;

}
