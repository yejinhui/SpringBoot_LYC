package com.example.springbootdemo.service;/**
 * 包名称：com.example.springbootdemo.service
 * 类名称：SysPermissionService
 * 类描述：权限接口
 * 创建人：@author 六叶草
 * 创建时间：2023年07月08日 15:39
 */

import com.example.springbootdemo.common.PageUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年07月08日 15:39
 * 项目名称:  SpringBootDemo
 * 文件名称:  SysPermissionService
 * 文件描述:  @Description: 权限接口
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
public interface SysPermissionService {

    /**
     * @Author 六叶草
     * @Description //查询全部权限
     * @Date 2023/7/8 15:42
     **/
    public ArrayList<HashMap> searchAllPermission();

    /**
     * @Author 六叶草
     * @Description //权限分页查询
     * @Date 2023/7/10 13:31
     **/
    public PageUtils searchPermissionByPage(HashMap param);

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
     * @Date 2023/7/10 15:17
     **/
    public int selectPermissionByName(HashMap param);

    /**
     * @Author 六叶草
     * @Description //根据id更新权限
     * @Date 2023/7/10 15:22
     **/
    public int updatePermission(HashMap param);

    /**
     * @Author 六叶草
     * @Description //根据id新增权限
     * @Date 2023/7/10 15:24
     **/
    public int insertPermission(HashMap param);
}
