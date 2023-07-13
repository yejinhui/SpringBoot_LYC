/**
 * 包名称：com.example.springbootdemo.controller
 * 类名称：DeptController
 * 类描述：部门控制类
 * 创建人：@author 六叶草
 * 创建时间：2023年06月03日 17:02
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
import com.example.springbootdemo.exception.HuiException;
import com.example.springbootdemo.service.SysDeptService;
import com.example.springbootdemo.units.poi.ImportExcelUntil;
import com.example.springbootdemo.units.poi.model.SysDeptMo;
import com.example.springbootdemo.units.poi.model.SysEmployeeMo;
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
 * 创建时间:  2023年06月03日 17:02
 * 项目名称:  SpringBootDemo
 * 文件名称:  DeptController
 * 文件描述:  @Description: 部门控制类
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@RestController
@RequestMapping("/dept")
@Tag(name = "DeptController", description = "部门接口")
public class DeptController {

    //部门业务接口
    @Autowired
    private SysDeptService sysDeptService;

    //导入Excel工具类及路径处理
    @Autowired
    private ImportExcelUntil importExcelUntil;

    @GetMapping("/selectDeptInfoList")
    @ApiOperation(value = "查询部门信息", notes = "获取部门列表数据")//给swagger添加说明信息
    @SaCheckLogin
    public R loadSelectDeptInfoList() {
        //查询当前用户的所属部门
        ArrayList<HashMap> deptNameList = sysDeptService.selectDeptHandle();
        return R.ok().put("deptNameList", deptNameList);
    }

    /**
     * @Author 六叶草
     * @Description //查询部门管理的分页信息
     * @Date 2023/6/21 15:07
     **/
    @PostMapping("/searchDeptByPage")
    @Operation(summary = "查询部门管理的分页信息")
    @SaCheckPermission(value = {"ROOT", "EMPLOYEE:SEE"}, mode = SaMode.OR)
    public R searchDeptByPage(@Valid @RequestBody SearchDeptByPageForm form){
        int page= form.getPage();
        int length= form.getLength();
        int start=(page-1)*length;
        HashMap param= JSONUtil.parse(form).toBean(HashMap.class);
        param.put("start",start);
        if(!(StpUtil.hasPermission("ROOT")||StpUtil.hasPermission("DEPT:SELECT"))){
            param.put("userId",StpUtil.getLoginIdAsInt());
        }
        PageUtils pageUtils=sysDeptService.searchDeptByPage(param);
        return R.ok().put("page",pageUtils);
    }

    @PostMapping("/deleteDeptByIds")
    @Operation(summary = "删除部门记录")
    @SaCheckPermission(value = {"ROOT", "DEPT:DELETE"}, mode = SaMode.OR)
    public R deleteDeptByIds(@Valid @RequestBody DeleteDeptByIdsForm form) {
        int rows = sysDeptService.deleteDeptByIds(form.getIds());
        return R.ok().put("rows", rows);
    }

    @PostMapping("/searchDeptById")
    @Operation(summary = "查询部门记录")
    @SaCheckPermission(value = {"ROOT", "DEPT:SELECT"}, mode = SaMode.OR)
    public R searchDeptById(@Valid @RequestBody SelectDeptByIdForm form) {
        HashMap params = sysDeptService.selectDeptById(form.getId());
        return R.ok().put("params", params);
    }

    /**
     * @Author 六叶草
     * @Description //更新个人资料
     * @Date 2023/6/4 11:15
     **/
    @PostMapping("/updateDept")
    @SaCheckPermission(value = {"ROOT", "DEPT:UPDATE"}, mode = SaMode.OR)
    @ApiOperation(value = "根据部门Id更新部门信息", notes = "更新部门信息")//给swagger添加说明信息
    public R updateDept(@Valid @RequestBody UpdateDeptForm form) {
        int count = sysDeptService.selectDeptByName(form.getDeptName(),form.getId());
        if (count > 0) {
            throw new HuiException("部门名称重复！");
        }
        HashMap param = JSONUtil.parse(form).toBean(HashMap.class);
        int rows = sysDeptService.updateDept(param);
        return R.ok("更新成功！").put("rows", rows);
    }

    /**
     * @Author 六叶草
     * @Description //新增部门资料
     * @Date 2023/6/25 13:55
     **/
    @PostMapping("/insertDept")
    @SaCheckPermission(value = {"ROOT", "DEPT:INSERT"}, mode = SaMode.OR)
    @ApiOperation(value = "新增部门资料", notes = "新增部门资料")//给swagger添加说明信息
    public R insertDept(@Valid @RequestBody InsertDeptForm form) {
        int count = sysDeptService.selectDeptByName(form.getDeptName());
        if (count > 0) {
            throw new HuiException("部门名称重复！");
        }
        HashMap param=JSONUtil.parse(form).toBean(HashMap.class);
        int rows = sysDeptService.insertDept(param);
        return R.ok("新增成功！").put("rows",rows);
    }

    @SaCheckPermission(value = {"ROOT", "DEPT:UPLOAD"}, mode = SaMode.OR)
    @ApiOperation(value = "导出全部部门数据Excel", notes = "导出Excel")//给swagger添加说明信息
    @GetMapping(value = "selectAllDeptExcel")
    public R selectAllDeptExcel() {
        List<HashMap> list = sysDeptService.selectAllDeptExcel();
        return R.ok().put("list",list);
    }

    @PostMapping("/uploadDeptExcel")
    @SaCheckLogin
    @ApiOperation(value = "接收上传的Excel文件（部门）", notes = "接收上传的Excel文件（部门）")//给swagger添加说明信息
    public R uploadDeptExcel(@RequestParam MultipartFile file) throws FileNotFoundException {
        String filePath = importExcelUntil.excelName(file);
        if (filePath == "文件类型不对") {
            return R.ok(filePath).put("result",false);
        } else if (filePath.indexOf("系统异常")!=-1) {
            return R.ok(filePath).put("result",false);
        }
        FileInputStream inputStream = new FileInputStream(filePath);
        // 1.自定义一个工具类拿到要解析的文件并解析成要存储的数据
        List<SysDeptMo> list = EasyExcelFactory.read(inputStream).head(SysDeptMo.class).sheet().doReadSync();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getDeptName() == null) {
                return R.ok("部门不能为空，请检查！").put("result",false);
            }
            Integer numDeptName = sysDeptService.selectDeptByName(list.get(i).getDeptName());
            if (numDeptName > 0) {
                return R.ok("有部门存在于数据库中，请检查！").put("result",false);
            }
        }
        int rows = sysDeptService.insertDepts(list);
        if (rows < 1) {
            return R.ok("上传失败！").put("result",false);
        }
        return R.ok("上传成功!").put("rows", rows).put("result",true);
    }

}
