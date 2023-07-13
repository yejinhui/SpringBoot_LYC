package com.example.springbootdemo.db.dao;/**
 * 包名称：com.example.springbootdemo.db.dao
 * 类名称：SysRoleDao
 * 类描述：角色管理持久层
 * 创建人：@author 六叶草
 * 创建时间：2023年07月08日 14:54
 */

import com.example.springbootdemo.db.pojo.SysRole;
import com.example.springbootdemo.db.vo.SysRoleVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年07月08日 14:54
 * 项目名称:  SpringBootDemo
 * 文件名称:  SysRoleDao
 * 文件描述:  @Description: 角色管理持久层
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Mapper
public interface SysRoleDao {

    /**
     * @Author 六叶草
     * @Description //角色管理分页查询
     * @Date 2023/7/8 14:56
     **/
    public ArrayList<SysRoleVo> searchRoleByPage(HashMap param);

    /**
     * @Author 六叶草
     * @Description //角色管理总页数
     * @Date 2023/7/8 14:56
     **/
    public long searchRoleCount(HashMap param);

    /**
     * @Author 六叶草
     * @Description //查询是否有关联
     * @Date 2023/7/8 15:01
     **/
    public boolean searchCanDelete(Integer[] ids);

    /**
     * @Author 六叶草
     * @Description //删除对应的角色
     * @Date 2023/7/8 15:03
     **/
    public int deleteRoleByIds(Integer[] ids);

    /**
     * @Author 六叶草
     * @Description //根据Id进行查询角色
     * @Date 2023/7/8 15:35
     **/
    public HashMap searchRoleById(Integer id);

    /**
     * @Author 六叶草
     * @Description //新增角色信息
     * @Date 2023/7/8 15:52
     **/
    public int insertRole(SysRole role);

    /**
     * @Author 六叶草
     * @Description //更新角色信息
     * @Date 2023/7/8 15:53
     **/
    public int updateRole(SysRole role);

    /**
     * @Author 六叶草
     * @Description //根据Id查询角色信息
     * @Date 2023/7/8 15:53
     **/
    public ArrayList<Integer> searchUserIdByRoleId(Integer id);

    /**
     * @Author 六叶草
     * @Description //查询全部角色
     * @Date 2023/7/8 16:22
     **/
    public ArrayList<HashMap> searchAllRole();

    /**
     * @Author 六叶草
     * @Description //角色管理详情
     * @Date 2023/7/9 15:01
     **/
    public HashMap searchRoleAllById(Integer id);
}
