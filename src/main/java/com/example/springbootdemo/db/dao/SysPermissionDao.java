package com.example.springbootdemo.db.dao;/**
 * 包名称：com.example.springbootdemo.db.dao
 * 类名称：SysPermissionDao
 * 类描述：权限持久层
 * 创建人：@author 六叶草
 * 创建时间：2023年07月08日 15:41
 */

import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年07月08日 15:41
 * 项目名称:  SpringBootDemo
 * 文件名称:  SysPermissionDao
 * 文件描述:  @Description: 权限持久层
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Mapper
public interface SysPermissionDao {

    /**
     * @Author 六叶草
     * @Description //查询全部权限
     * @Date 2023/7/8 15:43
     **/
    public ArrayList<HashMap> searchAllPermission();

    /**
     * @Author 六叶草
     * @Description //权限的分页查询
     * @Date 2023/7/10 13:31
     **/
    public ArrayList<HashMap> searchPermissionByPage(HashMap param);

    /**
     * @Author 六叶草
     * @Description //权限的总页数
     * @Date 2023/7/10 13:32
     **/
    public long searchPermissionCount(HashMap param);

    /**
     * @Author 六叶草
     * @Description //根据ids删除对应权限
     * @Date 2023/7/10 14:17
     **/
    public int deletePermissionByIds(Integer[] ids);

    /**
     * @Author 六叶草
     * @Description //查询全部权限信息
     * @Date 2023/7/10 14:23
     **/
    public List<HashMap> selectAllPermissionExcel();

    /**
     * @Author 六叶草
     * @Description //根据id查询权限信息
     * @Date 2023/7/10 14:48
     **/
    public HashMap selectPermissionById(Integer id);

    /**
     * @Author 六叶草
     * @Description //查询权限是否重复
     * @Date 2023/7/10 15:20
     **/
    public int selectPermissionByName(HashMap param);

    /**
     * @Author 六叶草
     * @Description //根据id更新权限
     * @Date 2023/7/10 15:25
     **/
    public int updatePermission(HashMap param);

    /**
     * @Author 六叶草
     * @Description //根据id新增权限
     * @Date 2023/7/10 15:25
     **/
    public int insertPermission(HashMap param);
}
