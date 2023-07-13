package com.example.springbootdemo.db.pojo;

import cn.hutool.core.date.DateTime;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
* 用户表
* @TableName sys_user用户资料实体类
*/
@Data
public class SysUser implements Serializable {

    /**
    * 主键
    */
    private Integer id;
    /**
    * 用户名
    */
    private String username;
    /**
    * 密码
    */
    private String password;
    /**
    * 编号
    */
    private String code;
    /**
    * 长期授权字符串
    */
    private String openId;
    /**
    * 昵称
    */
    private String nickname;
    /**
    * 头像网址
    */
    private String photo;
    /**
    * 姓名
    */
    private String name;
    /**
    * 性别
    */
    private String sex;
    /**
    * 手机号码
    */
    private String tel;
    /**
    * 邮箱
    */
    private String email;
    /**
    * 生日日期
    */
    private Date birthday;
    /**
    * 入职日期
    */
    private Date hiredate;
    /**
    * 角色
    */
    private Object role;
    /**
    * 是否是超级管理员
    */
    private Integer root;
    /**
    * 部门编号
    */
    private Integer deptId;
    /**
     * 页面权限
     */
    private Integer assessId;
    /**
    * 状态
    */
    private Integer status;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 最新上线时间
    */
    private Date loginTime;
    /**
     * 最新更新密码的时间
     */
    private Date updateTime;
    /**
    * 所属公司
    */
    private Integer companyId;

    /**
     * 盐值
     */
    private String salt;

    private static final long serialVersionUID = 1L;


}
