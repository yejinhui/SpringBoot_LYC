package com.example.springbootdemo.db.dao;/**
 * 包名称：com.example.springbootdemo.db.dao
 * 类名称：SysModuleDao
 * 类描述：菜单显示持久层
 * 创建人：@author 六叶草
 * 创建时间：2023年06月12日 09:57
 */

import com.example.springbootdemo.db.pojo.SysCol;
import com.example.springbootdemo.db.pojo.SysModule;
import com.example.springbootdemo.db.vo.SysModuleVo;
import com.example.springbootdemo.units.poi.model.SysModuleMo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年06月12日 09:57
 * 项目名称:  SpringBootDemo
 * 文件名称:  SysModuleDao
 * 文件描述:  @Description: 菜单显示持久层
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
public interface SysModuleDao {


    /**
     * @Author 六叶草
     * @Description //菜单列表查询
     * @Date 2023/6/12 9:56
     **/
    public ArrayList<SysModule> queryModuleList();

    /**
     * @Author 六叶草
     * @Description //加载菜单的下拉
     * @Date 2023/7/7 16:19
     **/
    public ArrayList<HashMap> selectModuleHandle();

    /**
     * @Author 六叶草
     * @Description //查询菜单的分页内容
     * @Date 2023/7/7 16:29
     **/
    public ArrayList<SysModuleVo> searchModuleByPage(HashMap param);

    /**
     * @Author 六叶草
     * @Description //查询菜单总页数
     * @Date 2023/7/7 16:30
     **/
    public long searchModuleCount(HashMap param);

    /**
     * @Author 六叶草
     * @Description //根据Id查询菜单信息
     * @Date 2023/7/7 16:46
     **/
    public HashMap selectModuleById(Integer id);

    /**
     * @Author 六叶草
     * @Description //根据Id删除菜单信息
     * @Date 2023/7/7 17:21
     **/
    public int deleteModuleByIds(Integer[] ids);

    /**
     * @Author 六叶草
     * @Description //根据菜单id和菜单编码进行查询菜单是否重复
     * @Date 2023/7/7 18:53
     **/
    public int selectModuleByCode(String moduleCode, Integer id);

    /**
     * @Author 六叶草
     * @Description //根据菜单编码进行查询菜单是否重复
     * @Date 2023/7/7 18:53
     **/
    public int selectModuleByCode(String moduleCode);

    /**
     * @Author 六叶草
     * @Description //更新菜单信息
     * @Date 2023/7/7 18:58
     **/
    public int updateModule(HashMap param);

    /**
     * @Author 六叶草
     * @Description //新增菜单信息
     * @Date 2023/7/7 18:58
     **/
    public int insertModule(HashMap param);

    /**
     * @Author 六叶草
     * @Description //查询全部菜单资料进行导出
     * @Date 2023/7/7 19:14
     **/
    public List<HashMap> selectAllModuleExcel();

    /**
     * @Author 六叶草
     * @Description //批量导入菜单信息
     * @Date 2023/7/7 18:57
     **/
    public int insertImportModule(List<SysModuleMo> list);
}
