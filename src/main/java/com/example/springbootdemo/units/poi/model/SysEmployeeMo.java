/**
 * 包名称：com.example.springbootdemo.units.poi
 * 类名称：vo
 * 类描述：导入模型类
 * 创建人：@author 六叶草
 * 创建时间：2023年07月03日 19:28
 */
package com.example.springbootdemo.units.poi.model;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.example.springbootdemo.units.poi.StatusConverter;
import lombok.Data;

import java.util.Date;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年07月03日 19:28
 * 项目名称:  SpringBootDemo
 * 文件名称:  vo
 * 文件描述:  @Description: 导入模型类
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Data
@ExcelIgnoreUnannotated
public class SysEmployeeMo {

    /**
     * id
     */
    private Integer id;

    /**
     * 强制读取第三个 这里不建议 index 和 name 同时用，要么一个对象只用index，要么一个对象只用name去匹配
     */
    /**
     * 用户名
     */
    @ExcelProperty(value = "用户名")
    private String username;
    /**
     * 编号
     */
    private String code;
    /**
     * 昵称
     */
    @ExcelProperty(value = "昵称")
    private String nickname;
    /**
     * 真实姓名
     */
    @ExcelProperty(value = "真实姓名")
    private String name;
    /**
     * 性别
     */
    @ExcelProperty(value = "性别")
    private String sex;
    /**
     * 手机号码
     */
    @ExcelProperty(value = "手机号码")
    private String tel;
    /**
     * 邮箱
     */
    @ExcelProperty(value = "电子邮箱")
    private String email;
    /**
     * 生日日期
     */
    @ExcelProperty(value = "生日日期")
    private Date birthday;
    /**
     * 部门
     */
    @ExcelProperty(value = "部门")
    private String deptName;
    /**
     * 所属公司
     */
    @ExcelProperty(value = "所属公司")
    private String companyName;
    /**
     * 入职日期
     */
    @ExcelProperty(value = "入职日期")
    private Date hiredate;
    /**
     * 状态
     */
    @ExcelProperty(value = "状态",converter = StatusConverter.class)
    private Integer status;
    /**
     * 创建日期
     */
    private Date createTime;
    /**
     * 权限
     */
    private Object role;
    /**
     * 是否是超级管理员
     */
    private Integer root;
    /**
     * 密码
     */
    private String password;
    /**
     * 加盐
     */
    private String salt;

}
