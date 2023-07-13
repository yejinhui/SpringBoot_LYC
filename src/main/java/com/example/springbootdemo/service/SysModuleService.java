package com.example.springbootdemo.service;/**
 * 包名称：com.example.springbootdemo.service
 * 类名称：SysModuleService
 * 类描述：菜单显示接口
 * 创建人：@author 六叶草
 * 创建时间：2023年06月12日 09:55
 */

import com.example.springbootdemo.common.PageUtils;
import com.example.springbootdemo.db.pojo.SysCol;
import com.example.springbootdemo.db.pojo.SysModule;
import com.example.springbootdemo.units.poi.model.SysModuleMo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年06月12日 09:55
 * 项目名称:  SpringBootDemo
 * 文件名称:  SysModuleService
 * 文件描述:  @Description: 菜单显示接口
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
public interface SysModuleService {


    /**
     * @Author 六叶草
     * @Description //菜单列表查询
     * @Date 2023/6/12 9:56
     **/
    public ArrayList<SysModule> queryModuleList();

    /**
     * @Author 六叶草
     * @Description //加载菜单下拉
     * @Date 2023/7/7 16:18
     **/
    public ArrayList<HashMap> selectModuleHandle();

    /**
     * @Author 六叶草
     * @Description //管理页面的菜单分页查询
     * @Date 2023/7/7 16:25
     **/
    public PageUtils searchModuleByPage(HashMap param);

    /**
     * @Author 六叶草
     * @Description //根据Id查询菜单信息
     * @Date 2023/7/7 16:45
     **/
    public HashMap selectModuleById(Integer id);

    /**
     * @Author 六叶草
     * @Description //根据Id删除菜单信息
     * @Date 2023/7/7 17:20
     **/
    public int deleteModuleByIds(Integer[] ids);

    /**
     * @Author 六叶草
     * @Description //根据菜单id和菜单名称进行查询菜单是否重复
     * @Date 2023/7/7 18:52
     **/
    public int selectModuleByCode(String moduleCode, Integer id);

    /**
     * @Author 六叶草
     * @Description //根据菜单名称进行查询菜单是否重复
     * @Date 2023/7/7 18:52
     **/
    public int selectModuleByCode(String moduleCode);

    /**
     * @Author 六叶草
     * @Description //更新菜单信息
     * @Date 2023/7/7 18:56
     **/
    public int updateModule(HashMap param);

    /**
     * @Author 六叶草
     * @Description //新增菜单信息
     * @Date 2023/7/7 18:57
     **/
    public int insertModule(HashMap param);

    /**
     * @Author 六叶草
     * @Description //查询全部菜单资料进行导出
     * @Date 2023/7/7 19:13
     **/
    public List<HashMap> selectAllModuleExcel();

    /**
     * @Author 六叶草
     * @Description //批量导入菜单信息
     * @Date 2023/7/7 18:57
     **/
    public int insertImportModule(List<SysModuleMo> list);
}
