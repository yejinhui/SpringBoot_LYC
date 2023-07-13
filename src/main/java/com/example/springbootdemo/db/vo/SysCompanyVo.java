/**
 * 包名称：com.example.springbootdemo.db.vo
 * 类名称：SysCompanyVo
 * 类描述：公司vo表，用于分页
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
 * 文件名称:  SysCompanyVo
 * 文件描述:  @Description: 公司vo表，用于分页
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Data
@Schema(pattern = "公司vo表，用于分页查询返回数据")
public class SysCompanyVo {

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
    private String createTime;
    /**
     * 员工人数
     */
    private Integer emps;

}
