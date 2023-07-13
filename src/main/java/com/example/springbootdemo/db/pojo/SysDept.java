package com.example.springbootdemo.db.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
*
* @TableName sys_dept部门实体类
*/
@Data
public class SysDept implements Serializable {

    /**
    * 主键
    */
    private Object id;
    /**
    * 部门名称
    */
    private String deptName;
    /**
    * 部门电话
    */
    private String tel;
    /**
    * 部门邮箱
    */
    private String email;
    /**
     * 备注
     */
    private String desc;
    /**
    * 是否有效
    */
    private String status;
    /**
    * 创建日期
    */
    private Date createTime;

}
