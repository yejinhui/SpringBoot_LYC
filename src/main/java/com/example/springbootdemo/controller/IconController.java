/**
 * 包名称：com.example.springbootdemo.controller
 * 类名称：IconController
 * 类描述：图片控制层
 * 创建人：@author 六叶草
 * 创建时间：2023年07月10日 10:19
 */
package com.example.springbootdemo.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaMode;
import com.example.springbootdemo.common.R;
import com.example.springbootdemo.service.SysIconService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年07月10日 10:19
 * 项目名称:  SpringBootDemo
 * 文件名称:  IconController
 * 文件描述:  @Description: 图片控制层
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@RestController
@RequestMapping("/icon")
@Tag(name = "IconController", description = "图片控制层")
public class IconController {

    //图片业务接口
    @Autowired
    private SysIconService sysIconService;

    @GetMapping("/searchIconName")
    @ApiOperation(value = "查询图片名称", notes = "查询图片名称")
    @SaCheckPermission(value = {"ROOT", "ICON:SELECT"}, mode = SaMode.OR)
    public R searchIconName(){
        List<HashMap> iconNameList = sysIconService.searchIconName();
        return R.ok().put("iconNameList",iconNameList);
    }


}
