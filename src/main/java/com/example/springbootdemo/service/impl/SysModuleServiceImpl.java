/**
 * 包名称：com.example.springbootdemo.service.impl
 * 类名称：SysModuleServiceImpl
 * 类描述：菜单显示业务层
 * 创建人：@author 六叶草
 * 创建时间：2023年06月12日 09:58
 */
package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.common.PageUtils;
import com.example.springbootdemo.db.dao.SysModuleDao;
import com.example.springbootdemo.db.pojo.SysCol;
import com.example.springbootdemo.db.pojo.SysModule;
import com.example.springbootdemo.db.vo.SysDeptVo;
import com.example.springbootdemo.db.vo.SysModuleVo;
import com.example.springbootdemo.service.SysModuleService;
import com.example.springbootdemo.units.poi.model.SysModuleMo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年06月12日 09:58
 * 项目名称:  SpringBootDemo
 * 文件名称:  SysModuleServiceImpl
 * 文件描述:  @Description: 菜单显示业务层
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Service
public class SysModuleServiceImpl implements SysModuleService {

    @Autowired
    private SysModuleDao sysModuleDao;

    /**
     * @Author 六叶草
     * @Description //菜单列表显示
     * @Date 2023/6/12 9:59
     **/
    @Override
    public ArrayList<SysModule> queryModuleList() {
        // 原始的数据
        ArrayList<SysModule> sysModulesList = sysModuleDao.queryModuleList();
        // 最后的结果
        ArrayList<SysModule> modulesList = new ArrayList<>();
        // 先找到所有的一级菜单
        for (SysModule module : sysModulesList) {
            // 一级菜单没有parentId
            if (module.getParentId() == null) {
                modulesList.add(module);
            }
        }
        // 为一级菜单设置子菜单，getChild是递归调用的
        for (SysModule sysModule : modulesList) {
            sysModule.setChildList(getChild(sysModule.getId(), sysModulesList));
        }
        return modulesList;
    }

    private ArrayList<SysModule> getChild(String id, ArrayList<SysModule> moduleList) {
        // 子菜单
        ArrayList<SysModule> childList = new ArrayList<>();
        for (SysModule sysModule : moduleList) {
            // 遍历所有节点，将父菜单id与传过来的id比较
            if (sysModule.getParentId() != null) {
                if (sysModule.getParentId().equals(id)) {
                    childList.add(sysModule);
                }
            }
        }
        // 把子菜单的子菜单再循环一遍
        for (SysModule sysModule : childList) {
            //该节点不含子节点
            if (StringUtils.isBlank(sysModule.getLink())) {
                // 递归
                sysModule.setChildList(getChild(sysModule.getId(), moduleList));
            }
        }
        // 递归退出条件
        if (childList.isEmpty()) {
            return null;
        }
        return childList;
    }

    /**
     * @Author 六叶草
     * @Description //加载菜单下拉
     * @Date 2023/7/7 16:18
     **/
    @Override
    public ArrayList<HashMap> selectModuleHandle() {
        return sysModuleDao.selectModuleHandle();
    }

    /**
     * @Author 六叶草
     * @Description //管理页面的菜单分页查询
     * @Date 2023/7/7 16:26
     **/
    @Override
    public PageUtils searchModuleByPage(HashMap param) {
        ArrayList<SysModuleVo> list = sysModuleDao.searchModuleByPage(param);
        long count = sysModuleDao.searchModuleCount(param);
        int start = (Integer) param.get("start");
        int length = (Integer) param.get("length");
        PageUtils pageUtils = new PageUtils(list, count, start, length);
        return pageUtils;
    }

    /**
     * @Author 六叶草
     * @Description //根据Id查询菜单信息
     * @Date 2023/7/7 17:20
     **/
    @Override
    public HashMap selectModuleById(Integer id) {
        return sysModuleDao.selectModuleById(id);
    }

    /**
     * @Author 六叶草
     * @Description //根据Id删除菜单信息
     * @Date 2023/7/7 17:20
     **/
    public int deleteModuleByIds(Integer[] ids){
        return sysModuleDao.deleteModuleByIds(ids);
    }



    /**
     * @Author 六叶草
     * @Description //根据菜单id和菜单编码进行查询菜单是否重复
     * @Date 2023/7/7 18:52
     **/
    public int selectModuleByCode(String moduleCode, Integer id){
        return sysModuleDao.selectModuleByCode(moduleCode, id);
    }

    /**
     * @Author 六叶草
     * @Description //根据菜单编码进行查询菜单是否重复
     * @Date 2023/7/7 18:52
     **/
    public int selectModuleByCode(String moduleCode){
        return sysModuleDao.selectModuleByCode(moduleCode);
    }

    /**
     * @Author 六叶草
     * @Description //更新菜单信息
     * @Date 2023/7/7 18:56
     **/
    public int updateModule(HashMap param){
        return sysModuleDao.updateModule(param);
    }

    /**
     * @Author 六叶草
     * @Description //新增菜单信息
     * @Date 2023/7/7 18:57
     **/
    public int insertModule(HashMap param){
        param.put("status", 1);
        return sysModuleDao.insertModule(param);
    }

    /**
     * @Author 六叶草
     * @Description //查询全部菜单资料进行导出
     * @Date 2023/7/7 19:13
     **/
    public List<HashMap> selectAllModuleExcel(){
        return sysModuleDao.selectAllModuleExcel();
    }

    /**
     * @Author 六叶草
     * @Description //批量导入菜单信息
     * @Date 2023/7/7 18:57
     **/
    public int insertImportModule(List<SysModuleMo> list){
        for (SysModuleMo sysModuleMo : list) {
            if (sysModuleMo.getStatus()==null){
                sysModuleMo.setStatus(1);
            }
        }
        return sysModuleDao.insertImportModule(list);
    }

}
