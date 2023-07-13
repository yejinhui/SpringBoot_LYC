package com.example.springbootdemo.db.pojo;

import java.io.Serializable;
import lombok.Data;

/**
* 下拉功能
* @TableName sys_dropdown_el
*/
@Data
public class SysDropdownEl implements Serializable {

    /**
    * 主键
    */
    private Integer id;
    /**
    * 下拉功能名称
    */
    private String dropdownName;
    /**
    * 图片
    */
    private String icon;
    /**
    * 点击方法名
    */
    private String methodsName;
    /**
    * 排序
    */
    private Integer sortId;
    /**
    * 状态
    */
    private Integer status;


}
