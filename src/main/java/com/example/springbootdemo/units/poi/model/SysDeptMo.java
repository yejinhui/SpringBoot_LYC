/**
 * 包名称：com.example.springbootdemo.units.poi.model
 * 类名称：SysDeptMo
 * 类描述：部门导入模版类
 * 创建人：@author 六叶草
 * 创建时间：2023年07月04日 16:02
 */
package com.example.springbootdemo.units.poi.model;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.example.springbootdemo.units.poi.StatusConverter;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年07月04日 16:02
 * 项目名称:  SpringBootDemo
 * 文件名称:  SysDeptMo
 * 文件描述:  @Description: 部门导入模版类
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Data
@ExcelIgnoreUnannotated
public class SysDeptMo {

    /**
     * 主键
     */
    private Integer id;
    /**
     * 强制读取第三个 这里不建议 index 和 name 同时用，要么一个对象只用index，要么一个对象只用name去匹配
     */
    /**
     * 部门名称
     */
    @ExcelProperty("部门名称")
    private String deptName;
    /**
     * 部门电话
     */
    @ExcelProperty("手机号码")
    private String tel;
    /**
     * 部门邮箱
     */
    @ExcelProperty("电子邮箱")
    private String email;
    /**
     * 备注
     */
    @ExcelProperty("备注")
    private String desc;
    /**
     * 是否有效
     */
    @ExcelProperty(value = "状态",converter = StatusConverter.class)
    private Integer status;
    /**
     * 创建日期
     */
    private Date createTime;

}
