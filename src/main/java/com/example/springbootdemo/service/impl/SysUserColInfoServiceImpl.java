/**
 * 包名称：com.example.springbootdemo.service.impl
 * 类名称：SysUserColInfoServiceImpl
 * 类描述：用户页脚信息加载
 * 创建人：@author 六叶草
 * 创建时间：2023年05月26日 13:46
 */
package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.db.dao.SysUserColInfoDao;
import com.example.springbootdemo.db.pojo.SysCol;
import com.example.springbootdemo.service.SysUserColInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年05月26日 13:46
 * 项目名称:  SpringBootDemo
 * 文件名称:  SysUserColInfoServiceImpl
 * 文件描述:  @Description: 用户页脚信息加载
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Service
public class SysUserColInfoServiceImpl implements SysUserColInfoService {

    @Autowired
    private SysUserColInfoDao sysUserColInfoDao;

    /**
     * @Author 六叶草
     * @Description //查询页脚的全部fname内容当做主键
     * @Date 2023/5/26 17:11
     **/
    @Override
    public List<String> searchfnameFooterInfo(HashMap formParam) {
        List<String> fnameList = sysUserColInfoDao.searchfnameFooterInfo(formParam);
        return fnameList;
    }

    /**
     * @Author 六叶草
     * @Description //根据传递的fname去查询col内容
     * @Date 2023/5/26 15:01
     **/
    @Override
    public String searchColFooterInfo(String fname, String formParam) {
        String param = sysUserColInfoDao.searchColFooterInfo(fname, formParam);
        return param;
    }

    /**
     * @Author 六叶草
     * @Description //查询footerMain主数据
     * @Date 2023/5/27 15:04
     **/
    @Override
    public List<String> searchmasterFooterInfo(HashMap formParam) {
        List<String> param = sysUserColInfoDao.searchmasterFooterInfo(formParam);
        return param;
    }

    /**
     * @Author 六叶草
     * @Description //查询footerMain数据集
     * @Date 2023/5/27 15:04
     **/
    @Override
    public List<String> searchcolmasterfooterInfo(String master, String page) {
        List<String> list = sysUserColInfoDao.searchcolmasterfooterInfo(master, page);
        return list;
    }

    /**
     * @Author 六叶草
     * @Description //首页查询表头列表信息
     * @Date 2023/5/31 17:24
     **/
    @Override
    public ArrayList<HashMap> searchMasterHomeInfo(String page) {
        return sysUserColInfoDao.searchMasterHomeInfo(page);
    }

    @Override
    public ArrayList<HashMap> searchMasterItemHomeInfo(String page) {
        return sysUserColInfoDao.searchMasterItemHomeInfo(page);
    }

    /**
     * @Author 六叶草
     * @Description //下拉菜单
     * @Date 2023/6/2 12:03
     **/
    @Override
    public ArrayList<SysCol> queryMenuList(String page) {
        // 原始的数据
        ArrayList<SysCol> colList = sysUserColInfoDao.queryMenuList(page);
        // 最后的结果
        ArrayList<SysCol> menuList = new ArrayList<>();
        // 先找到所有的一级菜单
        for (int i = 0; i < colList.size(); i++) {
            // 一级菜单没有parentId
            if (colList.get(i).getParentId() == null) {
                menuList.add(colList.get(i));
            }
        }
        // 为一级菜单设置子菜单，getChild是递归调用的
        for (SysCol sysCol : menuList) {
            sysCol.setColChild(getChild(sysCol.getId(), colList));
        }
        return menuList;
    }

    /**
     * @Author 六叶草
     * @Description //子方法
     * @Date 2023/6/2 13:33
     **/
    private ArrayList<SysCol> getChild(Integer id, ArrayList<SysCol> colList) {
        // 子菜单
        ArrayList<SysCol> childList = new ArrayList<>();
        for (SysCol sysCol : colList) {
            // 遍历所有节点，将父菜单id与传过来的id比较
            if (sysCol.getParentId() != null) {
                if (sysCol.getParentId().equals(id)) {
                    childList.add(sysCol);
                }
            }
        }
        // 把子菜单的子菜单再循环一遍
        for (SysCol sysCol : childList) {
            //该节点不含子节点
            if (StringUtils.isBlank(sysCol.getLink())) {
                // 递归
                sysCol.setColChild(getChild(sysCol.getId(), colList));
            }
        }
        // 递归退出条件
        if (childList.isEmpty()) {
            return null;
        }
        return childList;
    }

}
