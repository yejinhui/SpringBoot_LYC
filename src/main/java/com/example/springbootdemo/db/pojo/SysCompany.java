package com.example.springbootdemo.db.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
*
* @TableName sys_company公司实体类
*/
@Data
public class SysCompany implements Serializable {

    /**
     * 主键
     */
    private Integer id;
    /**
    * 公司名称
    */
    private String companyName;
    /**
    * 公司英文名称
    */
    private String companyEngName;
    /**
    * 公司地址
    */
    private String address;
    /**
    * 公司电话
    */
    private String tel;
    /**
     * 备注
     */
    private String desc;
    /**
    * 状态
    */
    private Integer status;
    /**
     * 创建日期
     */
    private Date createTime;

}
