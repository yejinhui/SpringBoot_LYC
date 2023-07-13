/**
 * 包名称：com.example.springbootdemo.controller
 * 类名称：RoleController
 * 类描述：角色管理控制类
 * 创建人：@author 六叶草
 * 创建时间：2023年07月08日 14:48
 */
package com.example.springbootdemo.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaMode;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.json.JSONUtil;
import com.example.springbootdemo.common.PageUtils;
import com.example.springbootdemo.common.R;
import com.example.springbootdemo.controller.form.*;
import com.example.springbootdemo.db.pojo.SysRole;
import com.example.springbootdemo.service.SysRoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年07月08日 14:48
 * 项目名称:  SpringBootDemo
 * 文件名称:  RoleController
 * 文件描述:  @Description: 角色管理控制类
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@RestController
@RequestMapping("/role")
@Tag(name = "RoleController", description = "角色管理控制类")
public class RoleController {


    @Autowired
    private SysRoleService sysRoleService;

    @PostMapping("/searchRoleByPage")
    @Operation(summary = "查询角色分页数据")
    @SaCheckPermission(value = {"ROOT", "ROLE:SELECT"}, mode = SaMode.OR)
    public R searchRoleByPage(@Valid @RequestBody SearchRoleByPageForm form) {
        int page = form.getPage();
        int length = form.getLength();
        int start = (page - 1) * length;
        HashMap param = JSONUtil.parse(form).toBean(HashMap.class);
        param.put("start", start);
        PageUtils pageUtils = sysRoleService.searchRoleByPage(param);
        return R.ok().put("page", pageUtils);
    }

    @PostMapping("/deleteRoleByIds")
    @Operation(summary = "删除角色记录")
    @SaCheckPermission(value = {"ROOT", "ROLE:DELETE"}, mode = SaMode.OR)
    public R deleteRoleByIds(@Valid @RequestBody DeleteRoleByIdsForm form) {
        int rows = sysRoleService.deleteRoleByIds(form.getIds());
        return R.ok().put("rows", rows);
    }

    @PostMapping("/searchRoleById")
    @Operation(summary = "根据ID查询角色")
    @SaCheckPermission(value = {"ROOT", "ROLE:SELECT"}, mode = SaMode.OR)
    public R searchRoleById(@Valid @RequestBody SearchRoleByIdForm form) {
        HashMap map = sysRoleService.searchRoleById(form.getId());
        return R.ok(map);
    }

    @PostMapping("/insertRole")
    @Operation(summary = "添加角色")
    @SaCheckPermission(value = {"ROOT", "ROLE:INSERT"}, mode = SaMode.OR)
    public R insertRole(@Valid @RequestBody InsertRoleForm form) {
        SysRole role = new SysRole();
        role.setRoleName(form.getRoleName());
        role.setPermissions(JSONUtil.parseArray(form.getPermissions()).toString());
        role.setDesc(form.getDesc());
        int rows = sysRoleService.insertRole(role);
        return R.ok().put("rows", rows);
    }

    @PostMapping("/updateRole")
    @Operation(summary = "更新角色")
    @SaCheckPermission(value = {"ROOT", "ROLE:UPDATE"}, mode = SaMode.OR)
    public R updateRole(@Valid @RequestBody UpdateRoleForm form) {
        SysRole role = new SysRole();
        role.setId(form.getId());
        role.setRoleName(form.getRoleName());
        role.setPermissions(JSONUtil.parseArray(form.getPermissions()).toString());
        role.setDesc(form.getDesc());
        int rows = sysRoleService.updateRole(role);
        //如果用户修改成功，并且用户修改了该角色的关联权限
        if (rows == 1 && form.getChanged()) {
            //把该角色关联的用户踢下线
            ArrayList<Integer> list = sysRoleService.searchUserIdByRoleId(form.getId());
            list.forEach(userId -> {
                StpUtil.logoutByLoginId(userId);
            });
        }
        return R.ok().put("rows", rows);
    }

    @GetMapping("/searchAllRole")
    @SaCheckLogin
    @Operation(summary = "查询所有角色")
    public R searchAllRole() {
        ArrayList<HashMap> roleList = sysRoleService.searchAllRole();
        return R.ok().put("roleList", roleList);
    }

    @PostMapping("/searchRoleAllById")
    @Operation(summary = "根据ID查询详情角色")
    @SaCheckPermission(value = {"ROOT", "ROLE:SELECT"}, mode = SaMode.OR)
    public R searchRoleAllById(@Valid @RequestBody SearchRoleAllByIdForm form) {
        HashMap param = sysRoleService.searchRoleAllById(form.getId());
        return R.ok().put("param",param);
    }

}
