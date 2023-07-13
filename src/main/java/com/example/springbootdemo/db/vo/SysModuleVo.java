/**
 * 包名称：com.example.springbootdemo.db.vo
 * 类名称：SysDmoduleVo
 * 类描述：菜单vo表，用于分页
 * 创建人：@author 六叶草
 * 创建时间：2023年06月30日 08:44
 */
package com.example.springbootdemo.db.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年06月30日 08:44
 * 项目名称:  SpringBootDemo
 * 文件名称:  SysDmoduleVo
 * 文件描述:  @Description: 菜单vo表，用于分页
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Data
@Schema(pattern = "菜单vo表，用于分页查询返回数据")
public class SysModuleVo {

    /**
     * 主键
     */
    private Integer id;
    /**
     * 菜单编码
     */
    private String moduleCode;
    /**
     * 菜单名称
     */
    private String moduleName;
    /**
     * 链接
     */
    private String link;
    /**
     * 父ID
     */
    private String parentId;
    /**
     * 图片
     */
    private String iconName;
    /**
     * 是否有效
     */
    private Integer status;
    /**
     * 是否默认功能
     */
    private Integer defaultModule;


}
