/**
 * 包名称：com.example.springbootdemo.controller
 * 类名称：ActionController
 * 类描述：功能管理控制类
 * 创建人：@author 六叶草
 * 创建时间：2023年07月08日 09:18
 */
package com.example.springbootdemo.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaMode;
import cn.hutool.json.JSONUtil;
import com.alibaba.excel.EasyExcelFactory;
import com.example.springbootdemo.common.PageUtils;
import com.example.springbootdemo.common.R;
import com.example.springbootdemo.controller.form.*;
import com.example.springbootdemo.exception.HuiException;
import com.example.springbootdemo.service.SysActionService;
import com.example.springbootdemo.units.poi.ImportExcelUntil;
import com.example.springbootdemo.units.poi.model.SysActionMo;
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
 * 创建时间:  2023年07月08日 09:18
 * 项目名称:  SpringBootDemo
 * 文件名称:  ActionController
 * 文件描述:  @Description: 功能管理控制类
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@RestController
@RequestMapping("/action")
@Tag(name = "ActionController", description = "功能管理控制类")
public class ActionController {

    //功能借口
    @Autowired
    private SysActionService sysActionService;

    //导入Excel工具类及路径处理
    @Autowired
    private ImportExcelUntil importExcelUntil;

    @GetMapping("/selectActionInfoList")
    @ApiOperation(value = "查询功能信息", notes = "获取功能列表数据")//给swagger添加说明信息
    @SaCheckLogin
    public R selectActionInfoList() {
        //查询当前用户的所属功能
        ArrayList<HashMap> actionNameList = sysActionService.selectActionHandle();
        return R.ok().put("actionNameList", actionNameList);
    }

    /**
     * @Author 六叶草
     * @Description //查询功能管理的分页信息
     * @Date 2023/6/21 15:07
     **/
    @PostMapping("/searchActionByPage")
    @Operation(summary = "查询功能管理的分页信息")
    @SaCheckPermission(value = {"ROOT", "ACTION:SELECT"}, mode = SaMode.OR)
    public R searchActionByPage(@Valid @RequestBody SearchActionByPageForm form){
        int page= form.getPage();
        int length= form.getLength();
        int start=(page-1)*length;
        HashMap param= JSONUtil.parse(form).toBean(HashMap.class);
        param.put("start",start);
        PageUtils pageUtils=sysActionService.searchActionByPage(param);
        return R.ok().put("page",pageUtils);
    }

    @PostMapping("/searchActionById")
    @Operation(summary = "查询功能记录")
    @SaCheckPermission(value = {"ROOT", "ACTION:SELECT"}, mode = SaMode.OR)
    public R searchActionById(@Valid @RequestBody SearchActionByIdForm form){
        HashMap params = sysActionService.selectActionById(form.getId());
        return R.ok().put("params", params);
    }

    @PostMapping("/deleteActionByIds")
    @Operation(summary = "删除功能记录")
    @SaCheckPermission(value = {"ROOT", "ACTION:DELETE"}, mode = SaMode.OR)
    public R deleteActionByIds(@Valid @RequestBody DeleteActionByIdsForm form) {
        int rows = sysActionService.deleteActionByIds(form.getIds());
        return R.ok().put("rows", rows);
    }

    /**
     * @Author 六叶草
     * @Description //更新功能资料
     * @Date 2023/6/4 11:15
     **/
    @PostMapping("/updateAction")
    @SaCheckPermission(value = {"ROOT", "ACTION:UPDATE"}, mode = SaMode.OR)
    @ApiOperation(value = "根据功能Id更新功能信息", notes = "更新功能信息")//给swagger添加说明信息
    public R updateAction(@Valid @RequestBody UpdateActionForm form) {
        int count = sysActionService.selectActionByCode(form.getActionCode(),form.getId());
        if (count > 0) {
            throw new HuiException("功能编码重复！");
        }
        HashMap param = JSONUtil.parse(form).toBean(HashMap.class);
        int rows = sysActionService.updateAction(param);
        return R.ok("更新成功！").put("rows", rows);
    }

    /**
     * @Author 六叶草
     * @Description //新增功能资料
     * @Date 2023/6/25 13:55
     **/
    @PostMapping("/insertAction")
    @SaCheckPermission(value = {"ROOT", "ACTION:INSERT"}, mode = SaMode.OR)
    @ApiOperation(value = "新增功能资料", notes = "新增功能资料")//给swagger添加说明信息
    public R insertAction(@Valid @RequestBody InsertActionForm form) {
        int count = sysActionService.selectActionByCode(form.getActionCode());
        if (count > 0) {
            throw new HuiException("功能编码重复！");
        }
        HashMap param=JSONUtil.parse(form).toBean(HashMap.class);
        int rows = sysActionService.insertAction(param);
        return R.ok("新增成功！").put("rows",rows);
    }

    @SaCheckPermission(value = {"ROOT", "ACTION:UPLOAD"}, mode = SaMode.OR)
    @ApiOperation(value = "导出全部功能数据Excel", notes = "导出Excel")//给swagger添加说明信息
    @GetMapping(value = "selectAllActionExcel")
    public R selectAllActionExcel() {
        List<HashMap> list = sysActionService.selectAllActionExcel();
        return R.ok().put("list",list);
    }

    @PostMapping("/uploadActionExcel")
    @SaCheckLogin
    @ApiOperation(value = "接收上传的Excel文件（功能）", notes = "接收上传的Excel文件（功能）")//给swagger添加说明信息
    public R uploadActionExcel(@RequestParam MultipartFile file) throws FileNotFoundException {
        String filePath = importExcelUntil.excelName(file);
        if (filePath == "文件类型不对") {
            return R.ok(filePath).put("result",false);
        } else if (filePath.indexOf("系统异常")!=-1) {
            return R.ok(filePath).put("result",false);
        }
        FileInputStream inputStream = new FileInputStream(filePath);
        // 1.自定义一个工具类拿到要解析的文件并解析成要存储的数据
        List<SysActionMo> list = EasyExcelFactory.read(inputStream).head(SysActionMo.class).sheet().doReadSync();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getActionCode() == null) {
                return R.ok("功能编码不能为空，请检查！").put("result",false);
            }
            Integer numDeptName = sysActionService.selectActionByCode(list.get(i).getActionCode());
            if (numDeptName > 0) {
                return R.ok("有功能编码存在于数据库中，请检查！").put("result",false);
            }
        }
        int rows = sysActionService.insertImportAction(list);
        if (rows < 1) {
            return R.ok("上传失败！").put("result",false);
        }
        return R.ok("上传成功!").put("rows", rows).put("result",true);
    }

}
