/**
 * 包名称：com.example.springbootdemo.db.vo
 * 类名称：SysDeptVo
 * 类描述：部门vo表，用于分页
 * 创建人：@author 六叶草
 * 创建时间：2023年06月30日 08:44
 */
package com.example.springbootdemo.db.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年06月30日 08:44
 * 项目名称:  SpringBootDemo
 * 文件名称:  SysDeptVo
 * 文件描述:  @Description: 部门vo表，用于分页
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Data
@Schema(pattern = "部门vo表，用于分页查询返回数据")
public class SysDeptVo {

    /**
     * 主键
     */
    private Integer id;
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
    private Integer status;
    /**
     * 创建日期
     */
    private String createTime;
    /**
     * 员工数量
     */
    private Integer emps;



}
