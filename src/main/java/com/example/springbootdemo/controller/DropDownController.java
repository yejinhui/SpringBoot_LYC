/**
 * 包名称：com.example.springbootdemo.controller
 * 类名称：DropDownController
 * 类描述：下拉功能展示
 * 创建人：@author 六叶草
 * 创建时间：2023年06月14日 13:51
 */
package com.example.springbootdemo.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaMode;
import com.example.springbootdemo.common.R;
import com.example.springbootdemo.service.SysDropDownService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年06月14日 13:51
 * 项目名称:  SpringBootDemo
 * 文件名称:  DropDownController
 * 文件描述:  @Description: 下拉功能展示
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@RestController
@RequestMapping("/dropdown")
@Tag(name = "DropDownController", description = "下拉功能展示")
public class DropDownController {

    //下拉功能业务接口
    @Autowired
    private SysDropDownService dropDownService;

    @GetMapping("/dropdownInfo")
    @SaCheckPermission(value = {"ROOT", "USER:SEE"}, mode = SaMode.OR)
    @ApiOperation(value = "下拉功能展示", notes = "显示下拉功能")//给swagger添加说明信息
    public R dropdownInfo() {
        ArrayList<HashMap> dropdownList = dropDownService.searchDropDownElInfo();
        return R.ok().put("dropdownList",dropdownList);
    }

}
