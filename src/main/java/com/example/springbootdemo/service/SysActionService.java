package com.example.springbootdemo.service;/**
 * 包名称：com.example.springbootdemo.service
 * 类名称：SysActionService
 * 类描述：功能管理接口
 * 创建人：@author 六叶草
 * 创建时间：2023年07月08日 09:20
 */

import com.example.springbootdemo.common.PageUtils;
import com.example.springbootdemo.units.poi.model.SysActionMo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年07月08日 09:20
 * 项目名称:  SpringBootDemo
 * 文件名称:  SysActionService
 * 文件描述:  @Description: 功能管理接口
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
public interface SysActionService {

    /**
     * @Author 六叶草
     * @Description //查询全部的功能信息
     * @Date 2023/7/8 10:08
     **/
    public ArrayList<HashMap> selectActionHandle();

    /**
     * @Author 六叶草
     * @Description //查询功能分页
     * @Date 2023/7/8 10:17
     **/
    public PageUtils searchActionByPage(HashMap param);

    /**
     * @Author 六叶草
     * @Description //根据id查询功能信息
     * @Date 2023/7/8 10:24
     **/
    public HashMap selectActionById(Integer id);

    /**
     * @Author 六叶草
     * @Description //根据Id删除功能信息
     * @Date 2023/7/8 10:32
     **/
    public int deleteActionByIds(Integer[] ids);

    /**
     * @Author 六叶草
     * @Description //根据code和id查询功能信息数据
     * @Date 2023/7/8 10:46
     **/
    public int selectActionByCode(String actionCode, Integer id);

    /**
     * @Author 六叶草
     * @Description //根据code查询功能信息数据
     * @Date 2023/7/8 10:46
     **/
    public int selectActionByCode(String actionCode);

    /**
     * @Author 六叶草
     * @Description //根据Id进行更新功能，基础功能不允许更新
     * @Date 2023/7/8 10:51
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
     * @Date 2023/7/8 11:00
     **/
    public List<HashMap> selectAllActionExcel();

    /**
     * @Author 六叶草
     * @Description //根据导入的信息进行批量新增
     * @Date 2023/7/8 11:03
     **/
    public int insertImportAction(List<SysActionMo> list);
}
