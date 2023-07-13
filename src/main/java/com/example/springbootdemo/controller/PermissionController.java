/**
 * 包名称：com.example.springbootdemo.controller
 * 类名称：PermissionController
 * 类描述：权限查询
 * 创建人：@author 六叶草
 * 创建时间：2023年07月08日 15:38
 */
package com.example.springbootdemo.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaMode;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.json.JSONUtil;
import com.example.springbootdemo.common.PageUtils;
import com.example.springbootdemo.common.R;
import com.example.springbootdemo.controller.form.*;
import com.example.springbootdemo.exception.HuiException;
import com.example.springbootdemo.service.SysPermissionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年07月08日 15:38
 * 项目名称:  SpringBootDemo
 * 文件名称:  PermissionController
 * 文件描述:  @Description: 权限Web接口
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@RestController
@RequestMapping("/permission")
@Tag(name="PermissionController",description = "权限Web接口")
public class PermissionController {

    //权限接口
    @Autowired
    private SysPermissionService sysPermissionService;

    /**
     * @Author 六叶草
     * @Description //查询所有权限
     * @Date 2023/7/8 15:40
     **/
    @GetMapping("/searchAllPermission")
    @Operation(summary = "查询所有权限")
    @SaCheckPermission(value = {"ROOT","ROLE:INSERT","ROLE:UPDATE"},mode = SaMode.OR)
    public R searchAllPermission(){
        ArrayList<HashMap> list=sysPermissionService.searchAllPermission();
        return R.ok().put("list",list);
    }


    /**
     * @Author 六叶草
     * @Description //查询部门管理的分页信息
     * @Date 2023/6/21 15:07
     **/
    @PostMapping("/searchPermissionByPage")
    @Operation(summary = "查询权限管理的分页信息")
    @SaCheckPermission(value = {"ROOT", "ADMIN_PERMISSION:SEE"}, mode = SaMode.OR)
    public R searchPermissionByPage(@Valid @RequestBody SearchPermissionByPageForm form){
        int page= form.getPage();
        int length= form.getLength();
        int start=(page-1)*length;
        HashMap param= JSONUtil.parse(form).toBean(HashMap.class);
        param.put("start",start);
        if(!(StpUtil.hasPermission("ROOT")||StpUtil.hasPermission("ADMIN_PERMISSION:SELECT"))){
            param.put("userId",StpUtil.getLoginIdAsInt());
        }
        PageUtils pageUtils=sysPermissionService.searchPermissionByPage(param);
        return R.ok().put("page",pageUtils);
    }

    @PostMapping("/deletePermissionByIds")
    @Operation(summary = "删除权限记录")
    @SaCheckPermission(value = {"ROOT", "ADMIN_PERMISSION:DELETE"}, mode = SaMode.OR)
    public R deletePermissionByIds(@Valid @RequestBody DeletePermissionByIdsForm form) {
        int rows = sysPermissionService.deletePermissionByIds(form.getIds());
        return R.ok().put("rows", rows);
    }

    @SaCheckPermission(value = {"ROOT", "ADMIN_PERMISSION:UPLOAD"}, mode = SaMode.OR)
    @ApiOperation(value = "导出全部权限数据Excel", notes = "导出Excel")//给swagger添加说明信息
    @GetMapping(value = "selectAllPermissionExcel")
    public R selectAllPermissionExcel() {
        List<HashMap> list = sysPermissionService.selectAllPermissionExcel();
        return R.ok().put("list",list);
    }

    @PostMapping("/searchPermissionById")
    @Operation(summary = "根据id查询权限信息")
    @SaCheckPermission(value = {"ROOT", "ADMIN_PERMISSION:SELECT"}, mode = SaMode.OR)
    public R searchPermissionById(@Valid @RequestBody SearchPermissionByIdForm form){
        HashMap params = sysPermissionService.selectPermissionById(form.getId());
        return R.ok().put("params", params);
    }

    /**
     * @Author 六叶草
     * @Description //更新权限资料
     * @Date 2023/6/4 11:15
     **/
    @PostMapping("/updatePermission")
    @SaCheckPermission(value = {"ROOT", "ADMIN_PERMISSION:UPDATE"}, mode = SaMode.OR)
    @ApiOperation(value = "根据权限Id更新权限信息", notes = "更新权限信息")//给swagger添加说明信息
    public R updatePermission(@Valid @RequestBody UpdatePermissionForm form) {
        HashMap param = JSONUtil.parse(form).toBean(HashMap.class);
        int count = sysPermissionService.selectPermissionByName(param);
        if (count > 0) {
            throw new HuiException("权限重复！");
        }
        int rows = sysPermissionService.updatePermission(param);
        return R.ok("更新成功！").put("rows", rows);
    }

    /**
     * @Author 六叶草
     * @Description //新增权限资料
     * @Date 2023/6/25 13:55
     **/
    @PostMapping("/insertPermission")
    @SaCheckPermission(value = {"ROOT", "ADMIN_PERMISSION:INSERT"}, mode = SaMode.OR)
    @ApiOperation(value = "新增权限资料", notes = "新增权限资料")//给swagger添加说明信息
    public R insertPermission(@Valid @RequestBody InsertPermissionForm form) {
        HashMap param=JSONUtil.parse(form).toBean(HashMap.class);
        int count = sysPermissionService.selectPermissionByName(param);
        if (count > 0) {
            throw new HuiException("新增权限重复！");
        }
        int rows = sysPermissionService.insertPermission(param);
        return R.ok("新增成功！").put("rows",rows);
    }

}
