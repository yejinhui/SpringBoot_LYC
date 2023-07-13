/**
 * 包名称：com.example.springbootdemo.service.impl
 * 类名称：SysAdminTitleInfoServiceImpl
 * 类描述：管理页面的抬头信息业务层
 * 创建人：@author 六叶草
 * 创建时间：2023年06月14日 15:48
 */
package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.db.dao.SysAdminTitleInfoDao;
import com.example.springbootdemo.service.SysAdminTitleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年06月14日 15:48
 * 项目名称:  SpringBootDemo
 * 文件名称:  SysAdminTitleInfoServiceImpl
 * 文件描述:  @Description: 管理页面的抬头信息业务层
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Service
public class SysAdminTitleInfoServiceImpl implements SysAdminTitleInfoService {

    @Autowired
    private SysAdminTitleInfoDao sysAdminTitleInfoDao;

    /**
     * @Author 六叶草
     * @Description //管理页面的抬头信息查询
     * @Date 2023/6/14 15:50
     **/
    @Override
    public HashMap searchTitleInfo() {
        return sysAdminTitleInfoDao.searchTitleInfo();
    }
}
