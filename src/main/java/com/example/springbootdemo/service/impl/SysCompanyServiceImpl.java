/**
 * 包名称：com.example.springbootdemo.service.impl
 * 类名称：SysCompanyServiceImpl
 * 类描述：公司业务层
 * 创建人：@author 六叶草
 * 创建时间：2023年06月03日 17:10
 */
package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.common.PageUtils;
import com.example.springbootdemo.db.dao.SysCompanyDao;
import com.example.springbootdemo.db.vo.SysCompanyVo;
import com.example.springbootdemo.service.SysCompanyService;
import com.example.springbootdemo.units.poi.model.SysCompanyMo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年06月03日 17:10
 * 项目名称:  SpringBootDemo
 * 文件名称:  SysCompanyServiceImpl
 * 文件描述:  @Description: 公司业务层
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Service
public class SysCompanyServiceImpl implements SysCompanyService {

    @Autowired
    private SysCompanyDao sysCompanyDao;


    /**
     * @Author 六叶草
     * @Description //查询公司下拉内容
     * @Date 2023/6/3 17:17
     **/
    @Override
    public ArrayList<HashMap> selectCompanyHandle() {
        return sysCompanyDao.selectCompanyHandle();
    }

    @Override
    public PageUtils searchCompanyByPage(HashMap param) {
        ArrayList<SysCompanyVo> list = sysCompanyDao.searchCompanyByPage(param);
        long count = sysCompanyDao.searchCompanyCount(param);
        int start = (Integer) param.get("start");
        int length = (Integer) param.get("length");
        PageUtils pageUtils = new PageUtils(list, count, start, length);
        return pageUtils;
    }

    /**
     * @Author 六叶草
     * @Description //根据公司Id删除公司信息
     * @Date 2023/6/26 14:42
     **/
    public int deleteCompanyByIds(Integer[] ids){
        return sysCompanyDao.deleteCompanyByIds(ids);
    }

    /**
     * @Author 六叶草
     * @Description //根据公司Id查询公司信息
     * @Date 2023/6/26 15:01
     **/
    public HashMap selectCompanyById(Integer id){
        return sysCompanyDao.selectCompanyById(id);
    }

    /**
     * @Author 六叶草
     * @Description //更新公司信息
     * @Date 2023/6/26 19:20
     **/
    public int updateCompany(HashMap param){
        // 格式化时间
        SimpleDateFormat sdf = new SimpleDateFormat();
        // a为am/pm的标记
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
        // 获取当前时间
        Date date = new Date();
        param.put("createTime", date);
        return sysCompanyDao.updateCompany(param);
    }

    /**
     * @Author 六叶草
     * @Description //新增公司信息
     * @Date 2023/6/26 19:20
     **/
    public int insertCompany(HashMap param){
        // 格式化时间
        SimpleDateFormat sdf = new SimpleDateFormat();
        // a为am/pm的标记
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
        // 获取当前时间
        Date date = new Date();
        param.put("createTime", date);
        param.put("status", 1);
        return sysCompanyDao.insertCompany(param);
    }

    /**
     * @Author 六叶草
     * @Description //根据公司名称和Id查询是否存在重复
     * @Date 2023/6/26 19:24
     **/
    public int selectCompanyByName(String CompanyName,Integer id){
        return sysCompanyDao.selectCompanyByName(CompanyName, id);
    }

    /**
     * @Author 六叶草
     * @Description //根据公司名称查询是否存在重复
     * @Date 2023/6/26 19:24
     **/
    public int selectCompanyByName(String CompanyName){
        return sysCompanyDao.selectCompanyByName(CompanyName);
    }

    /**
     * @Author 六叶草
     * @Description //导出全部公司
     * @Date 2023/6/28 11:48
     **/
    public List<HashMap> selectAllCompanyExcel(){
        return sysCompanyDao.selectAllCompanyExcel();
    }

    /**
     * @Author 六叶草
     * @Description //导入/批量新增所属公司
     * @Date 2023/7/5 9:36
     **/
    public int insertCompanys(List<SysCompanyMo> list){
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
        return sysCompanyDao.insertCompanys(list);
    }
}
