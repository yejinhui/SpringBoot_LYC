package com.example.springbootdemo.db.pojo;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.Data;

/**
* 模块资源表
* @TableName sys_module
*/
@Data
public class SysModule implements Serializable {

    /**
    * 主键
    */
    private String id;
    /**
    * 模块编号
    */
    private String moduleCode;
    /**
    * 模块名称
    */
    private String moduleName;
    /**
     * 模块名称
     */
    private String link;
    /**
    * 菜单主键
    */
    private String parentId;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 图片
     */
    private String iconName;
    /**
     * 是否默认菜单
     */
    private Integer defaultModule;
    /**
     * 层级关系
     */
    private String index;
    /**
     * 子菜单
     */
    private ArrayList<SysModule> childList;

}
