package com.example.springbootdemo.db.dao;/**
 * 包名称：com.example.springbootdemo.db.dao
 * 类名称：SysActionDao
 * 类描述：功能管理持久层
 * 创建人：@author 六叶草
 * 创建时间：2023年07月08日 09:19
 */

import com.example.springbootdemo.db.vo.SysActionVo;
import com.example.springbootdemo.units.poi.model.SysActionMo;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年07月08日 09:19
 * 项目名称:  SpringBootDemo
 * 文件名称:  SysActionDao
 * 文件描述:  @Description: 功能管理持久层
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Mapper
public interface SysActionDao {

    /**
     * @Author 六叶草
     * @Description //查询全部的功能信息
     * @Date 2023/7/8 10:09
     **/
    public ArrayList<HashMap> selectActionHandle();

    /**
     * @Author 六叶草
     * @Description //查询分页的内容
     * @Date 2023/7/8 10:19
     **/
    public ArrayList<SysActionVo> searchActionByPage(HashMap param);

    /**
     * @Author 六叶草
     * @Description //查询总页数
     * @Date 2023/7/8 10:19
     **/
    public long searchActionCount(HashMap param);

    /**
     * @Author 六叶草
     * @Description //根据id查询功能信息
     * @Date 2023/7/8 10:25
     **/
    public HashMap selectActionById(Integer id);

    /**
     * @Author 六叶草
     * @Description //根据Id查询是否是默认功能
     * @Date 2023/7/8 10:36
     **/
    public String selectActionDefaultById(Integer id);

    /**
     * @Author 六叶草
     * @Description //根据Id删除功能信息
     * @Date 2023/7/8 10:39
     **/
    public int deleteActionByIds(Integer[] ids);

    /**
     * @Author 六叶草
     * @Description //根据code和id查询功能信息数据
     * @Date 2023/7/8 10:47
     **/
    public int selectActionByCode(String actionCode, Integer id);

    /**
     * @Author 六叶草
     * @Description //根据code查询功能信息数据
     * @Date 2023/7/8 10:47
     **/
    public int selectActionByCode(String actionCode);

    /**
     * @Author 六叶草
     * @Description //根据Id更新功能信息
     * @Date 2023/7/8 10:55
     **/
    public int updateAction(HashMap param);

    /**
     * @Author 六叶草
     * @Description //新增功能信息
     * @Date 2023/7/8 10:59
     **/
    public int insertAction(HashMap param);

    /**
     * @Author 六叶草
     * @Description //查询全部功能信息
     * @Date 2023/7/8 11:01
     **/
    public List<HashMap> selectAllActionExcel();

    /**
     * @Author 六叶草
     * @Description //根据导入的信息进行批量新增
     * @Date 2023/7/8 11:07
     **/
    public int insertImportAction(List<SysActionMo> list);
}
