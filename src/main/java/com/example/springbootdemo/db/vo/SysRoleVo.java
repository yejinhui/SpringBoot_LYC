/**
 * 包名称：com.example.springbootdemo.db.vo
 * 类名称：SysRoleVo
 * 类描述：角色管理分页查询
 * 创建人：@author 六叶草
 * 创建时间：2023年07月08日 15:27
 */
package com.example.springbootdemo.db.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年07月08日 15:27
 * 项目名称:  SpringBootDemo
 * 文件名称:  SysRoleVo
 * 文件描述:  @Description: 角色管理分页查询
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Data
@Schema(pattern = "权限vo表，用于分页查询返回数据")
public class SysRoleVo {

    /**
     * 主键
     */
    private Object id;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 权限集合
     */
    private String permissions;
    /**
     * 描述
     */
    private String desc;
    /**
     * 系统角色内置权限
     */
    private String defaultPermissions;
    /**
     * 是否为系统内置角色
     */
    private Boolean systemic;
    /**
     * 是否为系统内置角色
     */
    private Integer users;

}
