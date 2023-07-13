/**
 * 包名称：com.example.springbootdemo.service.impl
 * 类名称：SysPermissionServiceImpl
 * 类描述：权限业务层
 * 创建人：@author 六叶草
 * 创建时间：2023年07月08日 15:41
 */
package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.common.PageUtils;
import com.example.springbootdemo.db.dao.SysPermissionDao;
import com.example.springbootdemo.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年07月08日 15:41
 * 项目名称:  SpringBootDemo
 * 文件名称:  SysPermissionServiceImpl
 * 文件描述:  @Description: 权限业务层
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Service
public class SysPermissionServiceImpl implements SysPermissionService {

    @Autowired
    private SysPermissionDao permissionDao;

    /**
     * @Author 六叶草
     * @Description //查询全部权限
     * @Date 2023/7/8 15:42
     **/
    @Override
    public ArrayList<HashMap> searchAllPermission() {
        ArrayList<HashMap> list = permissionDao.searchAllPermission();
        return list;
    }

    /**
     * @Author 六叶草
     * @Description //权限分页查询
     * @Date 2023/7/10 13:31
     **/
    public PageUtils searchPermissionByPage(HashMap param){
        ArrayList<HashMap> list = permissionDao.searchPermissionByPage(param);
        long count = permissionDao.searchPermissionCount(param);
        int start = (Integer) param.get("start");
        int length = (Integer) param.get("length");
        PageUtils pageUtils = new PageUtils(list, count, start, length);
        return pageUtils;
    }

    /**
     * @Author 六叶草
     * @Description //根据ids删除对应权限
     * @Date 2023/7/10 14:17
     **/
    public int deletePermissionByIds(Integer[] ids){
        return permissionDao.deletePermissionByIds(ids);
    }

    /**
     * @Author 六叶草
     * @Description //查询全部权限信息
     * @Date 2023/7/10 14:23
     **/
    public List<HashMap> selectAllPermissionExcel(){
        return permissionDao.selectAllPermissionExcel();
    }

    /**
     * @Author 六叶草
     * @Description //根据id查询权限信息
     * @Date 2023/7/10 14:48
     **/
    public HashMap selectPermissionById(Integer id){
        return permissionDao.selectPermissionById(id);
    }

    /**
     * @Author 六叶草
     * @Description //查询权限是否重复
     * @Date 2023/7/10 15:17
     **/
    public int selectPermissionByName(HashMap param){
        return permissionDao.selectPermissionByName(param);
    }

    /**
     * @Author 六叶草
     * @Description //根据id更新权限
     * @Date 2023/7/10 15:22
     **/
    public int updatePermission(HashMap param){
        return permissionDao.updatePermission(param);
    }

    /**
     * @Author 六叶草
     * @Description //根据id新增权限
     * @Date 2023/7/10 15:24
     **/
    public int insertPermission(HashMap param){
        return permissionDao.insertPermission(param);
    }






}
