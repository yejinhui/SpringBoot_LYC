/**
 * 包名称：com.example.springbootdemo.service.impl
 * 类名称：SysDeptServiceImpl
 * 类描述：部门业务层
 * 创建人：@author 六叶草
 * 创建时间：2023年06月03日 17:12
 */
package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.common.PageUtils;
import com.example.springbootdemo.db.dao.SysDeptDao;
import com.example.springbootdemo.db.vo.SysDeptVo;
import com.example.springbootdemo.service.SysDeptService;
import com.example.springbootdemo.units.poi.model.SysDeptMo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年06月03日 17:12
 * 项目名称:  SpringBootDemo
 * 文件名称:  SysDeptServiceImpl
 * 文件描述:  @Description: 部门业务层
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Service
public class SysDeptServiceImpl implements SysDeptService {

    @Autowired
    private SysDeptDao sysDeptDao;

    /**
     * @Author 六叶草
     * @Description //查詢部门下拉内容
     * @Date 2023/6/3 17:16
     **/
    @Override
    public ArrayList<HashMap> selectDeptHandle() {
        return sysDeptDao.selectDeptHandle();
    }

    @Override
    public PageUtils searchDeptByPage(HashMap param) {
        ArrayList<SysDeptVo> list = sysDeptDao.searchDeptByPage(param);
        long count = sysDeptDao.searchDeptCount(param);
        int start = (Integer) param.get("start");
        int length = (Integer) param.get("length");
        PageUtils pageUtils = new PageUtils(list, count, start, length);
        return pageUtils;
    }

    /**
     * @Author 六叶草
     * @Description //根据部门Id删除部门信息
     * @Date 2023/6/26 14:42
     **/
    public int deleteDeptByIds(Integer[] ids){
        return sysDeptDao.deleteDeptByIds(ids);
    }

    /**
     * @Author 六叶草
     * @Description //根据部门Id查询部门信息
     * @Date 2023/6/26 15:01
     **/
    public HashMap selectDeptById(Integer id){
        return sysDeptDao.selectDeptById(id);
    }

    /**
     * @Author 六叶草
     * @Description //更新部门信息
     * @Date 2023/6/26 19:20
     **/
    public int updateDept(HashMap param){
        // 格式化时间
        SimpleDateFormat sdf = new SimpleDateFormat();
        // a为am/pm的标记
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
        // 获取当前时间
        Date date = new Date();
        param.put("createTime", date);
        return sysDeptDao.updateDept(param);
    }

    /**
     * @Author 六叶草
     * @Description //新增部门信息
     * @Date 2023/6/26 19:20
     **/
    public int insertDept(HashMap param){
        // 格式化时间
        SimpleDateFormat sdf = new SimpleDateFormat();
        // a为am/pm的标记
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
        // 获取当前时间
        Date date = new Date();
        param.put("createTime", date);
        param.put("status", 1);
        return sysDeptDao.insertDept(param);
    }

    /**
     * @Author 六叶草
     * @Description //根据部门名称和Id查询是否存在重复
     * @Date 2023/6/26 19:24
     **/
    public int selectDeptByName(String deptName,Integer id){
        return sysDeptDao.selectDeptByName(deptName, id);
    }

    /**
     * @Author 六叶草
     * @Description //根据部门名称查询是否存在重复
     * @Date 2023/6/26 19:24
     **/
    public int selectDeptByName(String deptName){
        return sysDeptDao.selectDeptByName(deptName);
    }

    /**
     * @Author 六叶草
     * @Description //导出全部部门
     * @Date 2023/6/28 11:48
     **/
    public List<HashMap> selectAllDeptExcel(){
        return sysDeptDao.selectAllDeptExcel();
    }

    /**
     * @Author 六叶草
     * @Description //实现导入部门
     * @Date 2023/7/4 16:08
     **/
    public int insertDepts(List<SysDeptMo> list){
        // 格式化时间
        SimpleDateFormat sdf = new SimpleDateFormat();
        // a为am/pm的标记
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
        // 获取当前时间
        Date date = new Date();
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setCreateTime(date);
            if (list.get(i).getStatus() == null) {
                list.get(i).setStatus(1);
            }
        }
        return sysDeptDao.insertDepts(list);
    }
}
