/**
 * 包名称：com.example.springbootdemo.controller
 * 类名称：MenuController
 * 类描述：菜单控制类
 * 创建人：@author 六叶草
 * 创建时间：2023年06月12日 09:20
 */
package com.example.springbootdemo.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaMode;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.excel.EasyExcelFactory;
import com.example.springbootdemo.common.PageUtils;
import com.example.springbootdemo.common.R;
import com.example.springbootdemo.controller.form.*;
import com.example.springbootdemo.db.pojo.SysModule;
import com.example.springbootdemo.exception.HuiException;
import com.example.springbootdemo.service.SysModuleService;
import com.example.springbootdemo.units.poi.ImportExcelUntil;
import com.example.springbootdemo.units.poi.model.SysDeptMo;
import com.example.springbootdemo.units.poi.model.SysModuleMo;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年06月12日 09:20
 * 项目名称:  SpringBootDemo
 * 文件名称:  MenuController
 * 文件描述:  @Description: 菜单控制类
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@RestController
@RequestMapping("/module")
@Tag(name = "ModuleController", description = "菜单控制类")
public class ModuleController {

    //菜单业务接口
    @Autowired
    private SysModuleService sysModuleService;

    //导入Excel工具类及路径处理
    @Autowired
    private ImportExcelUntil importExcelUntil;

    /**
     * @Author 六叶草
     * @Description //加载菜单显示
     * @Date 2023/6/12 10:07
     **/
    @GetMapping("/moduleInfo")
    @SaCheckPermission(value = {"ROOT", "EMPLOYEE:SEE"}, mode = SaMode.OR)
    @ApiOperation(value = "加载菜单页面", notes = "获取菜单页面")//给swagger添加说明信息
    public R moduleListInfo() {
        ArrayList<SysModule> moduleList = sysModuleService.queryModuleList();
        return R.ok().put("moduleList", moduleList);
    }

    @GetMapping("/selectModuleInfoList")
    @ApiOperation(value = "查询菜单信息", notes = "获取菜单列表数据")//给swagger添加说明信息
    @SaCheckLogin
    public R selectModuleInfoList() {
        //查询当前用户的所属菜单
        ArrayList<HashMap> moduleNameList = sysModuleService.selectModuleHandle();
        return R.ok().put("moduleNameList", moduleNameList);
    }

    /**
     * @Author 六叶草
     * @Description //查询菜单管理的分页信息
     * @Date 2023/6/21 15:07
     **/
    @PostMapping("/searchModuleByPage")
    @Operation(summary = "查询菜单管理的分页信息")
    @SaCheckPermission(value = {"ROOT", "MODULE:SELECT"}, mode = SaMode.OR)
    public R searchModuleByPage(@Valid @RequestBody SearchModuleByPageForm form){
        int page= form.getPage();
        int length= form.getLength();
        int start=(page-1)*length;
        HashMap param= JSONUtil.parse(form).toBean(HashMap.class);
        param.put("start",start);
        PageUtils pageUtils=sysModuleService.searchModuleByPage(param);
        return R.ok().put("page",pageUtils);
    }

    @PostMapping("/searchModuleById")
    @Operation(summary = "查询菜单记录")
    @SaCheckPermission(value = {"ROOT", "MODULE:SELECT"}, mode = SaMode.OR)
    public R searchModuleById(@Valid @RequestBody SearchModuleByIdForm form){
        HashMap params = sysModuleService.selectModuleById(form.getId());
        return R.ok().put("params", params);
    }

    @PostMapping("/deleteModuleByIds")
    @Operation(summary = "删除菜单记录")
    @SaCheckPermission(value = {"ROOT", "MODULE:DELETE"}, mode = SaMode.OR)
    public R deleteModuleByIds(@Valid @RequestBody DeleteModuleByIdsForm form) {
        int rows = sysModuleService.deleteModuleByIds(form.getIds());
        return R.ok().put("rows", rows);
    }

    /**
     * @Author 六叶草
     * @Description //更新菜单资料
     * @Date 2023/6/4 11:15
     **/
    @PostMapping("/updateModule")
    @SaCheckPermission(value = {"ROOT", "MODULE:UPDATE"}, mode = SaMode.OR)
    @ApiOperation(value = "根据菜单Id更新菜单信息", notes = "更新菜单信息")//给swagger添加说明信息
    public R updateModule(@Valid @RequestBody UpdateModuleForm form) {
        int count = sysModuleService.selectModuleByCode(form.getModuleCode(),form.getId());
        if (count > 0) {
            throw new HuiException("菜单编码重复！");
        }
        HashMap param = JSONUtil.parse(form).toBean(HashMap.class);
        int rows = sysModuleService.updateModule(param);
        return R.ok("更新成功！").put("rows", rows);
    }

    /**
     * @Author 六叶草
     * @Description //新增菜单资料
     * @Date 2023/6/25 13:55
     **/
    @PostMapping("/insertModule")
    @SaCheckPermission(value = {"ROOT", "MODULE:INSERT"}, mode = SaMode.OR)
    @ApiOperation(value = "新增菜单资料", notes = "新增菜单资料")//给swagger添加说明信息
    public R insertModule(@Valid @RequestBody InsertModuleForm form) {
        int count = sysModuleService.selectModuleByCode(form.getModuleCode());
        if (count > 0) {
            throw new HuiException("菜单编码重复！");
        }
        HashMap param=JSONUtil.parse(form).toBean(HashMap.class);
        int rows = sysModuleService.insertModule(param);
        return R.ok("新增成功！").put("rows",rows);
    }

    @SaCheckPermission(value = {"ROOT", "MODULE:UPLOAD"}, mode = SaMode.OR)
    @ApiOperation(value = "导出全部菜单数据Excel", notes = "导出Excel")//给swagger添加说明信息
    @GetMapping(value = "selectAllModuleExcel")
    public R selectAllModuleExcel() {
        List<HashMap> list = sysModuleService.selectAllModuleExcel();
        return R.ok().put("list",list);
    }

    @PostMapping("/uploadModuleExcel")
    @SaCheckLogin
    @ApiOperation(value = "接收上传的Excel文件（菜单）", notes = "接收上传的Excel文件（菜单）")//给swagger添加说明信息
    public R uploadModuleExcel(@RequestParam MultipartFile file) throws FileNotFoundException {
        String filePath = importExcelUntil.excelName(file);
        if (filePath == "文件类型不对") {
            return R.ok(filePath).put("result",false);
        } else if (filePath.indexOf("系统异常")!=-1) {
            return R.ok(filePath).put("result",false);
        }
        FileInputStream inputStream = new FileInputStream(filePath);
        // 1.自定义一个工具类拿到要解析的文件并解析成要存储的数据
        List<SysModuleMo> list = EasyExcelFactory.read(inputStream).head(SysModuleMo.class).sheet().doReadSync();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getModuleCode() == null) {
                return R.ok("菜单不能为空，请检查！").put("result",false);
            }
            Integer numDeptName = sysModuleService.selectModuleByCode(list.get(i).getModuleCode());
            if (numDeptName > 0) {
                return R.ok("有菜单名称存在于数据库中，请检查！").put("result",false);
            }
        }
        int rows = sysModuleService.insertImportModule(list);
        if (rows < 1) {
            return R.ok("上传失败！").put("result",false);
        }
        return R.ok("上传成功!").put("rows", rows).put("result",true);
    }
}
