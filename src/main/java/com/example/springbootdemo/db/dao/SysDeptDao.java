package com.example.springbootdemo.db.dao;/**
 * 包名称：com.example.springbootdemo.db.dao
 * 类名称：SysDeptDao
 * 类描述：部门持久层
 * 创建人：@author 六叶草
 * 创建时间：2023年06月03日 17:12
 */

import com.example.springbootdemo.db.vo.SysDeptVo;
import com.example.springbootdemo.units.poi.model.SysDeptMo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年06月03日 17:12
 * 项目名称:  SpringBootDemo
 * 文件名称:  SysDeptDao
 * 文件描述:  @Description: 部门持久层
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
public interface SysDeptDao {

    /**
     * @Author 六叶草
     * @Description //查詢部门下拉内容
     * @Date 2023/6/3 17:15
     **/
    public ArrayList<HashMap> selectDeptHandle();

    /**
     * @Author 六叶草
     * @Description //查询部门的分页数据
     * @Date 2023/6/26 14:13
     **/
    public ArrayList<SysDeptVo> searchDeptByPage(HashMap param);

    /**
     * @Author 六叶草
     * @Description //查询部门数据的总页数
     * @Date 2023/6/26 14:13
     **/
    public long searchDeptCount(HashMap param);

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
     * @Date 2023/7/4 16:09
     **/
    public int insertDepts(List<SysDeptMo> list);
}
