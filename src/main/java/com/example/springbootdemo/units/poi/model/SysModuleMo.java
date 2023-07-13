/**
 * 包名称：com.example.springbootdemo.units.poi.model
 * 类名称：SysModuleMo
 * 类描述：菜单模版
 * 创建人：@author 六叶草
 * 创建时间：2023年07月07日 19:21
 */
package com.example.springbootdemo.units.poi.model;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.example.springbootdemo.units.poi.StatusConverter;
import lombok.Data;

import java.util.Date;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年07月07日 19:21
 * 项目名称:  SpringBootDemo
 * 文件名称:  SysModuleMo
 * 文件描述:  @Description: 菜单模版
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Data
@ExcelIgnoreUnannotated
public class SysModuleMo {

    /**
     * 主键
     */
    private Integer id;
    /**
     * 强制读取第三个 这里不建议 index 和 name 同时用，要么一个对象只用index，要么一个对象只用name去匹配
     */
    /**
     * 菜单名称
     */
    @ExcelProperty("菜单名称")
    private String moduleName;
    /**
     * 菜单名称
     */
    @ExcelProperty("菜单编码")
    private String moduleCode;
    /**
     * 链接
     */
    @ExcelProperty("链接")
    private String link;
    /**
     * 父Id
     */
    @ExcelProperty("父ID")
    private String parentId;
    /**
     * 图片
     */
    @ExcelProperty("图片")
    private String iconName;
    /**
     * 是否默认菜单
     */
    private final Integer defaultModule = 0;
    /**
     * 是否有效
     */
    @ExcelProperty(value = "状态",converter = StatusConverter.class)
    private Integer status;

}
