package com.example.springbootdemo.db.dao;/**
 * 包名称：com.example.springbootdemo.db.dao
 * 类名称：SysIconDao
 * 类描述：图片持久层
 * 创建人：@author 六叶草
 * 创建时间：2023年07月10日 10:21
 */

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年07月10日 10:21
 * 项目名称:  SpringBootDemo
 * 文件名称:  SysIconDao
 * 文件描述:  @Description: 图片持久层
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Mapper
public interface SysIconDao {

    /**
     * @Author 六叶草
     * @Description //查询全部图片信息
     * @Date 2023/7/10 10:35
     **/
    public List<HashMap> searchIconName();
}
