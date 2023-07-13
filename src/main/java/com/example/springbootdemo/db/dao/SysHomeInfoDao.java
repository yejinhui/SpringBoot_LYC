package com.example.springbootdemo.db.dao;/**
 * 包名称：com.example.springbootdemo.db.dao
 * 类名称：HomeInfoDao
 * 类描述：首页持久层
 * 创建人：@author 六叶草
 * 创建时间：2023年06月06日 16:33
 */

import com.example.springbootdemo.db.pojo.SysHomeImage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年06月06日 16:33
 * 项目名称:  SpringBootDemo
 * 文件名称:  HomeInfoDao
 * 文件描述:  @Description: 首页持久层
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
//标注这个是Mapper类
@Mapper
//事务的回滚与提交(避免出现关闭sql失败的错误或者失败后依然执行更新删除新增等操作)
@Transactional
public interface SysHomeInfoDao {

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
