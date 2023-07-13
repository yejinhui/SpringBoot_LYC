/**
 * 包名称：com.example.springbootdemo.service.impl
 * 类名称：SysRoleServiceImpl
 * 类描述：角色管理业务层
 * 创建人：@author 六叶草
 * 创建时间：2023年07月08日 14:53
 */
package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.common.PageUtils;
import com.example.springbootdemo.db.dao.SysRoleDao;
import com.example.springbootdemo.db.pojo.SysRole;
import com.example.springbootdemo.db.vo.SysRoleVo;
import com.example.springbootdemo.exception.HuiException;
import com.example.springbootdemo.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年07月08日 14:53
 * 项目名称:  SpringBootDemo
 * 文件名称:  SysRoleServiceImpl
 * 文件描述:  @Description: 角色管理业务层
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleDao sysRoleDao;

    /**
     * @Author 六叶草
     * @Description //角色管理分页查询
     * @Date 2023/7/8 14:55
     **/
    @Override
    public PageUtils searchRoleByPage(HashMap param) {
        ArrayList<SysRoleVo> list = sysRoleDao.searchRoleByPage(param);
        long count = sysRoleDao.searchRoleCount(param);
        int start = (Integer) param.get("start");
        int length = (Integer) param.get("length");
        PageUtils pageUtils = new PageUtils(list, count, start, length);
        return pageUtils;
    }

    /**
     * @Author 六叶草
     * @Description //根据Id进行删除对应的角色
     * @Date 2023/7/8 15:01
     **/
    @Override
    public int deleteRoleByIds(Integer[] ids) {
        if (!sysRoleDao.searchCanDelete(ids)) {
            throw new HuiException("无法删除关联用户的角色");
        }
        int rows = sysRoleDao.deleteRoleByIds(ids);
        return rows;
    }

    /**
     * @Author 六叶草
     * @Description //根据Id进行查询角色
     * @Date 2023/7/8 15:34
     **/
    public HashMap searchRoleById(Integer id){
        HashMap map = sysRoleDao.searchRoleById(id);
        return map;
    }

    /**
     * @Author 六叶草
     * @Description //新增角色信息
     * @Date 2023/7/8 15:52
     **/
    public int insertRole(SysRole role){
        int rows = sysRoleDao.insertRole(role);
        return rows;
    }

    /**
     * @Author 六叶草
     * @Description //更新角色信息
     * @Date 2023/7/8 15:53
     **/
    public int updateRole(SysRole role){
        int rows = sysRoleDao.updateRole(role);
        return rows;
    }

    /**
     * @Author 六叶草
     * @Description //根据Id查询角色信息
     * @Date 2023/7/8 15:53
     **/
    public ArrayList<Integer> searchUserIdByRoleId(Integer roleId){
        ArrayList<Integer> list = sysRoleDao.searchUserIdByRoleId(roleId);
        return list;
    }

    /**
     * @Author 六叶草
     * @Description //查询全部角色
     * @Date 2023/7/8 16:22
     **/
    public ArrayList<HashMap> searchAllRole(){
        return sysRoleDao.searchAllRole();
    }

    /**
     * @Author 六叶草
     * @Description //角色管理详情
     * @Date 2023/7/9 15:00
     **/
    public HashMap searchRoleAllById(Integer id){
        return sysRoleDao.searchRoleAllById(id);
    }
}
