package com.example.springbootdemo.service;/**
 * 包名称：com.example.springbootdemo.service
 * 类名称：SysDeptService
 * 类描述：部门接口
 * 创建人：@author 六叶草
 * 创建时间：2023年06月03日 17:11
 */

import com.example.springbootdemo.common.PageUtils;
import com.example.springbootdemo.units.poi.model.SysDeptMo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年06月03日 17:11
 * 项目名称:  SpringBootDemo
 * 文件名称:  SysDeptService
 * 文件描述:  @Description: 部门接口
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
public interface SysDeptService {

    /**
     * @Author 六叶草
     * @Description //查询部门下拉内容
     * @Date 2023/6/3 17:14
     **/
    public ArrayList<HashMap> selectDeptHandle();

    /**
     * @Author 六叶草
     * @Description //部门分页查询
     * @Date 2023/6/26 14:00
     **/
    public PageUtils searchDeptByPage(HashMap param);

    /**
     * @Author 六叶草
     * @Description //根据部门Id删除部门信息
     * @Date 2023/6/26 14:42
     **/
    public int deleteDeptByIds(Integer[] ids);

    /**
     * @Author 六叶草
     * @Description //根据部门Id查询部门信息
     * @Date 2023/6/26 15:01
     **/
    public HashMap selectDeptById(Integer id);

    /**
     * @Author 六叶草
     * @Description //更新部门信息
     * @Date 2023/6/26 19:20
     **/
    public int updateDept(HashMap param);

    /**
     * @Author 六叶草
     * @Description //根据部门名称和Id查询是否存在重复
     * @Date 2023/6/26 19:24
     **/
    public int selectDeptByName(String deptName,Integer id);

    /**
     * @Author 六叶草
     * @Description //新增部门信息
     * @Date 2023/6/26 19:20
     **/
    public int insertDept(HashMap param);

    /**
     * @Author 六叶草
     * @Description //根据部门名称查询是否存在重复
     * @Date 2023/6/26 19:24
     **/
    public int selectDeptByName(String deptName);

    /**
     * @Author 六叶草
     * @Description //导出全部部门
     * @Date 2023/6/28 11:48
     **/
    public List<HashMap> selectAllDeptExcel();

    /**
     * @Author 六叶草
     * @Description //实现导入部门
     * @Date 2023/7/4 16:08
     **/
    public int insertDepts(List<SysDeptMo> list);
}
