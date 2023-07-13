/**
 * 包名称：com.example.springbootdemo.controller
 * 类名称：LoadFooterInfo
 * 类描述：用户页面加载资料
 * 创建人：@author 六叶草
 * 创建时间：2023年05月26日 13:37
 */
package com.example.springbootdemo.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaMode;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.json.JSONUtil;
import com.example.springbootdemo.common.R;
import com.example.springbootdemo.controller.form.PageInfoForm;
import com.example.springbootdemo.db.pojo.SysCol;
import com.example.springbootdemo.service.SysUserColInfoService;
import com.example.springbootdemo.service.SysUserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年05月26日 13:37
 * 项目名称:  SpringBootDemo
 * 文件名称:  LoadFooterInfo
 * 文件描述:  @Description: 用户页面加载资料
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@RestController
@RequestMapping("/userInfo")
@Tag(name = "UserLoadInfoController", description = "页脚内容的显示")
public class UserLoadInfoController {

    //用户/员工业务接口
    @Autowired
    private SysUserService sysUserService;

    //页面元素业务接口
    @Autowired
    private SysUserColInfoService sysUserColInfoService;

    /**
     * @Author 六叶草
     * @Description //页脚信息
     * @Date 2023/5/26 16:41
     **/
    @PostMapping("/loadFooterInfo")
    @ApiOperation(value = "页脚信息加载", notes = "获取页脚信息")//给swagger添加说明信息
    @SaCheckPermission(value = {"ROOT", "USER:CHECK"}, mode = SaMode.OR)
    public R loadFooterInfo(@Valid @RequestBody PageInfoForm form) {
        HashMap formParam = JSONUtil.parse(form).toBean(HashMap.class);
        HashMap<String, String> param = new HashMap<>();
        List<String> fnameList = sysUserColInfoService.searchfnameFooterInfo(formParam);
        if (!fnameList.isEmpty()) {
            for (String fname : fnameList) {
                String col = sysUserColInfoService.searchColFooterInfo(fname, formParam.get("page").toString());
                param.put(fname, col);
            }
        }
        HashMap<String, List<String>> list = new HashMap<>();
        List<String> masterList = sysUserColInfoService.searchmasterFooterInfo(formParam);
        if (!masterList.isEmpty()) {
            for (String master : masterList) {
                List<String> colList = sysUserColInfoService.searchcolmasterfooterInfo(master, formParam.get("page").toString());
                list.put(master, colList);
            }
        }
        return R.ok().put("param", param).put("list", list);
    }

    /**
     * @Author 六叶草
     * @Description //页首信息
     * @Date 2023/5/31 17:25
     **/
    @PostMapping("/homeInfo")
    @ApiOperation(value = "首页信息", notes = "获取首页信息")//给swagger添加说明信息
    @SaCheckPermission(value = {"ROOT", "USER:CHECK"}, mode = SaMode.OR)
    public R loadHomeInfo(@Valid @RequestBody PageInfoForm form) {
        HashMap formParam = JSONUtil.parse(form).toBean(HashMap.class);
        HashMap<String, String> List = new HashMap<>();
        List<String> fnameList = sysUserColInfoService.searchfnameFooterInfo(formParam);
        if (!fnameList.isEmpty()) {
            for (String fname : fnameList) {
                String col = sysUserColInfoService.searchColFooterInfo(fname, formParam.get("page").toString());
                List.put(fname, col);
            }
        }
        int userId = StpUtil.getLoginIdAsInt();
        HashMap summary = sysUserService.searchUserSummary(userId);
        return R.ok().put("List", List).put("summary",summary);
    }

    /**
     * @Author 六叶草
     * @Description //首页下拉栏信息
     * @Date 2023/6/14 15:46
     **/
    @PostMapping("/homeSelectInfo")
    @ApiOperation(value = "首页下拉栏信息", notes = "获取首页下拉栏信息")//给swagger添加说明信息
    @SaCheckPermission(value = {"ROOT", "USER:CHECK"}, mode = SaMode.OR)
    public R loadHomeSelectInfo(@Valid @RequestBody PageInfoForm form) {
        ArrayList<SysCol> menuList = sysUserColInfoService.queryMenuList(form.getPage());
        return R.ok().put("navList", menuList);
    }
}
