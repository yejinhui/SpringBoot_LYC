/**
 * 包名称：com.example.springbootdemo.controller
 * 类名称：CompanyController
 * 类描述：公司控制类
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
import com.example.springbootdemo.service.SysCompanyService;
import com.example.springbootdemo.units.poi.ImportExcelUntil;
import com.example.springbootdemo.units.poi.model.SysCompanyMo;
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
 * 文件名称:  CompanyController
 * 文件描述:  @Description: 公司控制类
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@RestController
@RequestMapping("/company")
@Tag(name = "CompanyController", description = "公司接口")
public class CompanyController {

    //所属公司业务接口
    @Autowired
    private SysCompanyService sysCompanyService;

    //导入Excel工具类及路径处理
    @Autowired
    private ImportExcelUntil importExcelUntil;

    @GetMapping("/selectCompanyInfoList")
    @ApiOperation(value = "查询公司信息", notes = "获取公司列表数据")//给swagger添加说明信息
    @SaCheckLogin
    public R loadSelectCompanyInfoList() {
        //查询当前用户的所属公司
        ArrayList<HashMap> companyNameList = sysCompanyService.selectCompanyHandle();
        return R.ok().put("companyNameList", companyNameList);
    }


    /**
     * @Author 六叶草
     * @Description //查询公司管理的分页信息
     * @Date 2023/6/21 15:07
     **/
    @PostMapping("/searchCompanyByPage")
    @Operation(summary = "查询公司管理的分页信息")
    @SaCheckLogin
    public R searchCompanyByPage(@Valid @RequestBody SearchCompanyByPageForm form){
        int page= form.getPage();
        int length= form.getLength();
        int start=(page-1)*length;
        HashMap param= JSONUtil.parse(form).toBean(HashMap.class);
        param.put("start",start);
        if(!(StpUtil.hasPermission("ROOT")||StpUtil.hasPermission("Company:SELECT"))){
            param.put("userId",StpUtil.getLoginIdAsInt());
        }
        PageUtils pageUtils=sysCompanyService.searchCompanyByPage(param);
        return R.ok().put("page",pageUtils);
    }

    @PostMapping("/deleteCompanyByIds")
    @Operation(summary = "删除公司记录")
    @SaCheckPermission(value = {"ROOT", "COMPANY:DELETE"}, mode = SaMode.OR)
    public R deleteCompanyByIds(@Valid @RequestBody DeleteCompanyByIdsForm form) {
        int rows = sysCompanyService.deleteCompanyByIds(form.getIds());
        return R.ok().put("rows", rows);
    }

    @PostMapping("/searchCompanyById")
    @Operation(summary = "查询公司记录")
    @SaCheckPermission(value = {"ROOT", "COMPANY:SELECT"}, mode = SaMode.OR)
    public R searchCompanyById(@Valid @RequestBody SelectCompanyByIdForm form) {
        HashMap params = sysCompanyService.selectCompanyById(form.getId());
        return R.ok().put("params", params);
    }

    /**
     * @Author 六叶草
     * @Description //更新个人资料
     * @Date 2023/6/4 11:15
     **/
    @PostMapping("/updateCompany")
    @SaCheckPermission(value = {"ROOT", "COMPANY:UPDATE"}, mode = SaMode.OR)
    @ApiOperation(value = "根据公司Id更新公司信息", notes = "更新公司信息")//给swagger添加说明信息
    public R updateCompany(@Valid @RequestBody UpdateCompanyForm form) {
        int count = sysCompanyService.selectCompanyByName(form.getCompanyName(),form.getId());
        if (count > 0) {
            throw new HuiException("公司名称重复！");
        }
        HashMap param = JSONUtil.parse(form).toBean(HashMap.class);
        int rows = sysCompanyService.updateCompany(param);
        return R.ok("更新成功！").put("rows", rows);
    }

    /**
     * @Author 六叶草
     * @Description //新增公司资料
     * @Date 2023/6/25 13:55
     **/
    @PostMapping("/insertCompany")
    @SaCheckPermission(value = {"ROOT", "COMPANY:INSERT"}, mode = SaMode.OR)
    @ApiOperation(value = "新增公司资料", notes = "新增公司资料")//给swagger添加说明信息
    public R insertCompany(@Valid @RequestBody InsertCompanyForm form) {
        int count = sysCompanyService.selectCompanyByName(form.getCompanyName());
        if (count > 0) {
            throw new HuiException("公司名称重复！");
        }
        HashMap param=JSONUtil.parse(form).toBean(HashMap.class);
        int rows = sysCompanyService.insertCompany(param);
        return R.ok("新增成功！").put("rows",rows);
    }

    @SaCheckPermission(value = {"ROOT", "COMPANY:UPLOAD"}, mode = SaMode.OR)
    @ApiOperation(value = "导出全部公司数据Excel", notes = "导出Excel")//给swagger添加说明信息
    @GetMapping(value = "selectAllCompanyExcel")
    public R selectAllCompanyExcel() {
        List<HashMap> list = sysCompanyService.selectAllCompanyExcel();
        return R.ok().put("list",list);
    }

    @PostMapping("/uploadCompanyExcel")
    @SaCheckLogin
    @ApiOperation(value = "接收上传的Excel文件（所属公司）", notes = "接收上传的Excel文件（所属公司）")//给swagger添加说明信息
    public R uploadCompanyExcel(@RequestParam MultipartFile file) throws FileNotFoundException {
        String filePath = importExcelUntil.excelName(file);
        if (filePath == "文件类型不对") {
            return R.ok(filePath).put("result",false);
        } else if (filePath.indexOf("系统异常")!=-1) {
            return R.ok(filePath).put("result",false);
        }
        FileInputStream inputStream = new FileInputStream(filePath);
        // 1.自定义一个工具类拿到要解析的文件并解析成要存储的数据
        List<SysCompanyMo> list = EasyExcelFactory.read(inputStream).head(SysCompanyMo.class).sheet().doReadSync();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCompanyName() == null) {
                return R.ok("公司名称不能为空，请检查！").put("result",false);
            }
            Integer numCompanyName = sysCompanyService.selectCompanyByName(list.get(i).getCompanyName());
            if (numCompanyName > 0) {
                return R.ok("有所属公司存在于数据库中，请检查！").put("result",false);
            }
        }
        int rows = sysCompanyService.insertCompanys(list);
        if (rows < 1) {
            return R.ok("上传失败！").put("result",false);
        }
        return R.ok("上传成功!").put("rows", rows).put("result",true);
    }

}
