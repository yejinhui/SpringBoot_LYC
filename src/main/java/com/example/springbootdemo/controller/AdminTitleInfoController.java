/**
 * 包名称：com.example.springbootdemo.controller
 * 类名称：AdminTitleInfoController
 * 类描述：管理页面抬头信息
 * 创建人：@author 六叶草
 * 创建时间：2023年06月14日 14:59
 */
package com.example.springbootdemo.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaMode;
import com.example.springbootdemo.common.R;
import com.example.springbootdemo.service.SysAdminTitleInfoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年06月14日 14:59
 * 项目名称:  SpringBootDemo
 * 文件名称:  AdminTitleInfoController
 * 文件描述:  @Description: 管理页面抬头信息
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@RestController
@RequestMapping("/adminCol")
@Tag(name = "AdminTitleInfoController", description = "管理页面抬头信息")
public class AdminTitleInfoController {

    //管理页面业务接口
    @Autowired
    private SysAdminTitleInfoService sysAdminTitleInfoService;

    /**
     * @Author 六叶草
     * @Description //管理页面的抬头信息查询
     * @Date 2023/6/14 15:01
     **/
    @GetMapping("/titleInfo")
    @ApiOperation(value = "管理页面的抬头信息查询", notes = "获取管理页面的抬头信息查询")//给swagger添加说明信息
    @SaCheckPermission(value = {"ROOT", "EMPLOYEE:SEE"}, mode = SaMode.OR)
    public R selectAdminTitleInfo() {
        HashMap params = sysAdminTitleInfoService.searchTitleInfo();
        return R.ok().put("params",params);
    }

}
