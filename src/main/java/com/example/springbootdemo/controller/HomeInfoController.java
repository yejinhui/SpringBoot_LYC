/**
 * 包名称：com.example.springbootdemo.controller
 * 类名称：HomeInfoController
 * 类描述：首页内容显示
 * 创建人：@author 六叶草
 * 创建时间：2023年06月06日 16:12
 */
package com.example.springbootdemo.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaMode;
import cn.dev33.satoken.stp.StpUtil;
import com.example.springbootdemo.common.R;
import com.example.springbootdemo.db.pojo.SysHomeImage;
import com.example.springbootdemo.service.SysHomeInfoService;
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
 * 创建时间:  2023年06月06日 16:12
 * 项目名称:  SpringBootDemo
 * 文件名称:  HomeInfoController
 * 文件描述:  @Description: 首页内容显示
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@RestController
@RequestMapping("/home")
@Tag(name = "HomeInfoController", description = "首页内容显示")
public class HomeInfoController {

    //用户页面内容业务接口
    @Autowired
    private SysHomeInfoService sysHomeInfoService;

    /**
     * @Author 六叶草
     * @Description //加载轮播图的数据
     * @Date 2023/6/7 11:54
     **/
    @GetMapping("/homeInfo")
    @SaCheckPermission(value = {"ROOT", "USER:SEE"}, mode = SaMode.OR)
    @ApiOperation(value = "显示轮播图", notes = "显示轮播图")//给swagger添加说明信息
    public R homeInfo() {
        ArrayList<HashMap> param = sysHomeInfoService.selectImgList();
        return R.ok().put("imgList",param);
    }

    /**
     * @Author 六叶草
     * @Description //遍历显示图片与描述的数据等
     * @Date 2023/6/7 11:54
     **/
    @GetMapping("/homeInfoCard")
    @SaCheckPermission(value = {"ROOT", "USER:SEE"}, mode = SaMode.OR)
    @ApiOperation(value = "遍历显示图片与描述", notes = "遍历显示图片与描述")//给swagger添加说明信息
    public R homeInfoCard() {
        ArrayList<SysHomeImage> param = sysHomeInfoService.selectImgInfoList();
        return R.ok().put("ECardList",param);
    }


}
