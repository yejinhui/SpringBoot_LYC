/**
 * 包名称：com.example.springbootdemo.service.impl
 * 类名称：HomeInfoServiceImpl
 * 类描述：首页业务层
 * 创建人：@author 六叶草
 * 创建时间：2023年06月06日 16:32
 */
package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.db.dao.SysHomeInfoDao;
import com.example.springbootdemo.db.pojo.SysHomeImage;
import com.example.springbootdemo.service.SysHomeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年06月06日 16:32
 * 项目名称:  SpringBootDemo
 * 文件名称:  HomeInfoServiceImpl
 * 文件描述:  @Description: 首页业务层
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Service
public class SysHomeInfoServiceImpl implements SysHomeInfoService {

    @Autowired
    private SysHomeInfoDao homeInfoDao;


    /**
     * @Author 六叶草
     * @Description //显示轮播图的数据
     * @Date 2023/6/7 11:56
     **/
    @Override
    public ArrayList<HashMap> selectImgList() {
        return homeInfoDao.selectImgList();
    }

    /**
     * @Author 六叶草
     * @Description //遍历显示图片与描述数据
     * @Date 2023/6/7 11:56
     **/
    @Override
    public ArrayList<SysHomeImage> selectImgInfoList() {
        return homeInfoDao.selectImgInfoList();
    }
}
