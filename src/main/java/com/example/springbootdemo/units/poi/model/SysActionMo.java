/**
 * 包名称：com.example.springbootdemo.units.poi.model
 * 类名称：SysActionMo
 * 类描述：功能导入模版类
 * 创建人：@author 六叶草
 * 创建时间：2023年07月04日 16:02
 */
package com.example.springbootdemo.units.poi.model;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.example.springbootdemo.units.poi.StatusConverter;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年07月04日 16:02
 * 项目名称:  SpringBootDemo
 * 文件名称:  SysActionMo
 * 文件描述:  @Description: 功能导入模版类
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Data
@ExcelIgnoreUnannotated
public class SysActionMo {

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
    @ExcelProperty("功能名称")
    private String actionName;
    /**
     * 功能编码
     */
    @ExcelProperty("功能编码")
    private String actionCode;
    /**
     * 是否有效
     */
    @ExcelProperty(value = "状态",converter = StatusConverter.class)
    private Integer status;
    /**
     * 是否默认功能
     */
    private final Integer defaultAction = 0;



}
