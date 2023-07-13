/**
 * 包名称：com.example.springbootdemo.db.vo
 * 类名称：SysActionVo
 * 类描述：功能管理分页表
 * 创建人：@author 六叶草
 * 创建时间：2023年07月08日 13:44
 */
package com.example.springbootdemo.db.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年07月08日 13:44
 * 项目名称:  SpringBootDemo
 * 文件名称:  SysActionVo
 * 文件描述:  @Description: 功能管理分页表
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Data
@Schema(pattern = "功能vo表，用于分页查询返回数据")
public class SysActionVo {

    /**
     * 主键
     */
    private Integer id;
    /**
     * 功能编码
     */
    private String actionCode;
    /**
     * 功能名称
     */
    private String actionName;
    /**
     * 是否有效
     */
    private String status;
    /**
     * 是否默认功能
     */
    private Integer defaultAction;
    /**
     * 关联用户
     */
    private String users;

}
