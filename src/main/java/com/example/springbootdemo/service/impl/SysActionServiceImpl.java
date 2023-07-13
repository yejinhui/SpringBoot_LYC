/**
 * 包名称：com.example.springbootdemo.service.impl
 * 类名称：SysActionServiceImpl
 * 类描述：功能管理业务层
 * 创建人：@author 六叶草
 * 创建时间：2023年07月08日 09:21
 */
package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.common.PageUtils;
import com.example.springbootdemo.db.dao.SysActionDao;
import com.example.springbootdemo.db.vo.SysActionVo;
import com.example.springbootdemo.exception.HuiException;
import com.example.springbootdemo.service.SysActionService;
import com.example.springbootdemo.units.poi.model.SysActionMo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年07月08日 09:21
 * 项目名称:  SpringBootDemo
 * 文件名称:  SysActionServiceImpl
 * 文件描述:  @Description: 功能管理业务层
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Service
public class SysActionServiceImpl implements SysActionService {

    @Autowired
    private SysActionDao sysActionDao;

    /**
     * @Author 六叶草
     * @Description //查询全部的功能信息
     * @Date 2023/7/8 10:08
     **/
    @Override
    public ArrayList<HashMap> selectActionHandle() {
        return sysActionDao.selectActionHandle();
    }

    /**
     * @Author 六叶草
     * @Description //查询功能分页
     * @Date 2023/7/8 10:17
     **/
    public PageUtils searchActionByPage(HashMap param){
        ArrayList<SysActionVo> list=sysActionDao.searchActionByPage(param);
        long count=sysActionDao.searchActionCount(param);
        int start=(Integer) param.get("start");
        int length=(Integer) param.get("length");
        PageUtils pageUtils=new PageUtils(list,count,start,length);
        return pageUtils;
    }

    /**
     * @Author 六叶草
     * @Description //根据id查询功能信息
     * @Date 2023/7/8 10:24
     **/
    public HashMap selectActionById(Integer id){
        return sysActionDao.selectActionById(id);
    }

    /**
     * @Author 六叶草
     * @Description //根据Id删除功能信息
     * @Date 2023/7/8 10:32
     **/
    public int deleteActionByIds(Integer[] ids){
        for (Integer id : ids) {
            String actionCode = sysActionDao.selectActionDefaultById(id);
            if (actionCode != null) {
                throw new HuiException(actionCode + "是默认功能，不允许删除！");
            }
        }
        return sysActionDao.deleteActionByIds(ids);
    }

    /**
     * @Author 六叶草
     * @Description //根据code和id查询功能信息数据
     * @Date 2023/7/8 10:46
     **/
    public int selectActionByCode(String actionCode, Integer id){
        return sysActionDao.selectActionByCode(actionCode, id);
    }

    /**
     * @Author 六叶草
     * @Description //根据code查询功能信息数据
     * @Date 2023/7/8 10:46
     **/
    public int selectActionByCode(String actionCode){
        return sysActionDao.selectActionByCode(actionCode);
    }

    /**
     * @Author 六叶草
     * @Description //根据Id进行更新功能，基础功能不允许更新
     * @Date 2023/7/8 10:51
     **/
    public int updateAction(HashMap param){
        return sysActionDao.updateAction(param);
    }

    /**
     * @Author 六叶草
     * @Description //新增功能信息
     * @Date 2023/7/8 10:59
     **/
    public int insertAction(HashMap param){
        return sysActionDao.insertAction(param);
    }

    /**
     * @Author 六叶草
     * @Description //查询全部功能信息
     * @Date 2023/7/8 11:00
     **/
    public List<HashMap> selectAllActionExcel(){
        return sysActionDao.selectAllActionExcel();
    }

    /**
     * @Author 六叶草
     * @Description //根据导入的信息进行批量新增
     * @Date 2023/7/8 11:03
     **/
    public int insertImportAction(List<SysActionMo> list){
        return sysActionDao.insertImportAction(list);
    }
}
