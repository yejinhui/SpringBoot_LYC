package com.example.springbootdemo.service;/**
 * 包名称：com.example.springbootdemo.service
 * 类名称：SysUserColInfoService
 * 类描述：页脚信息
 * 创建人：@author 六叶草
 * 创建时间：2023年05月26日 13:45
 */

import com.example.springbootdemo.db.pojo.SysCol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年05月26日 13:45
 * 项目名称:  SpringBootDemo
 * 文件名称:  SysUserColInfoService
 * 文件描述:  @Description: 页脚信息
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
public interface SysUserColInfoService {

    /**
     * @Author 六叶草
     * @Description //查询页脚的全部fname内容当做主键
     * @Date 2023/5/26 17:10
     **/
    public List<String> searchfnameFooterInfo(HashMap formParam);


    /**
     * @Author 六叶草
     * @Description //根据传递的fname去查询col内容
     * @Date 2023/5/26 15:01
     **/
    public String searchColFooterInfo(String fname,String formParam);


    /**
     * @Author 六叶草
     * @Description //查询footerMain主数据
     * @Date 2023/5/27 15:04
     **/
    public List<String> searchmasterFooterInfo(HashMap formParam);

    /**
     * @Author 六叶草
     * @Description //查询footerMain数据集
     * @Date 2023/5/27 15:04
     **/
    public List<String> searchcolmasterfooterInfo(String master,String page);

    /**
     * @Author 六叶草
     * @Description //首页查询表头列表信息
     * @Date 2023/5/31 17:23
     **/
    public ArrayList<HashMap> searchMasterHomeInfo(String page);

    /**
     * @Author 六叶草
     * @Description //查询下拉的内容
     * @Date 2023/5/31 18:56
     **/
    public ArrayList<HashMap> searchMasterItemHomeInfo(String page);

    /**
     * @Author 六叶草
     * @Description //查询菜单的数据
     * @Date 2023/6/2 11:44
     **/
    public ArrayList<SysCol>  queryMenuList(String page);
}
