/**
 * 包名称：com.example.springbootdemo.service.impl
 * 类名称：DropDownServiceImpl
 * 类描述：下拉功能业务层
 * 创建人：@author 六叶草
 * 创建时间：2023年06月14日 13:57
 */
package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.db.dao.SysDropDownDao;
import com.example.springbootdemo.service.SysDropDownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年06月14日 13:57
 * 项目名称:  SpringBootDemo
 * 文件名称:  DropDownServiceImpl
 * 文件描述:  @Description: 下拉功能业务层
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Service
public class SysDropDownServiceImpl implements SysDropDownService {

    @Autowired
    private SysDropDownDao dropDownDao;

    /**
     * @Author 六叶草
     * @Description //下拉功能
     * @Date 2023/6/14 13:58
     **/
    @Override
    public ArrayList<HashMap> searchDropDownElInfo() {
        return dropDownDao.searchDropDownElInfo();
    }
}
