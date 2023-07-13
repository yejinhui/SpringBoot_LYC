package com.example.springbootdemo.service;/**
 * 包名称：com.example.springbootdemo.service
 * 类名称：HomeInfoService
 * 类描述：首页接口
 * 创建人：@author 六叶草
 * 创建时间：2023年06月06日 16:32
 */

import com.example.springbootdemo.db.pojo.SysHomeImage;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年06月06日 16:32
 * 项目名称:  SpringBootDemo
 * 文件名称:  HomeInfoService
 * 文件描述:  @Description: 首页接口
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
public interface SysHomeInfoService {


    /**
     * @Author 六叶草
     * @Description //查询轮播图图片
     * @Date 2023/6/6 16:42
     **/
    public ArrayList<HashMap> selectImgList();

    /**
     * @Author 六叶草
     * @Description //遍历显示图片与描述数据
     * @Date 2023/6/7 11:55
     **/
    public ArrayList<SysHomeImage> selectImgInfoList();
}
