package com.example.springbootdemo.db.dao;/**
 * 包名称：com.example.springbootdemo.db.dao
 * 类名称：DropDownDao
 * 类描述：下拉功能持久层
 * 创建人：@author 六叶草
 * 创建时间：2023年06月14日 13:55
 */

import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年06月14日 13:55
 * 项目名称:  SpringBootDemo
 * 文件名称:  DropDownDao
 * 文件描述:  @Description: 下拉功能持久层
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
public interface SysDropDownDao {

    /**
     * @Author 六叶草
     * @Description //右击功能
     * @Date 2023/6/14 13:56
     **/
    public ArrayList<HashMap> searchDropDownElInfo();

}
