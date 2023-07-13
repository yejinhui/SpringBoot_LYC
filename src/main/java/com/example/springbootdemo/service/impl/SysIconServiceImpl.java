/**
 * 包名称：com.example.springbootdemo.service.impl
 * 类名称：SysIconServiceImpl
 * 类描述：图片业务层
 * 创建人：@author 六叶草
 * 创建时间：2023年07月10日 10:21
 */
package com.example.springbootdemo.service.impl;

import cn.hutool.json.JSONUtil;
import com.example.springbootdemo.db.dao.SysIconDao;
import com.example.springbootdemo.db.pojo.SysIcon;
import com.example.springbootdemo.service.SysIconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年07月10日 10:21
 * 项目名称:  SpringBootDemo
 * 文件名称:  SysIconServiceImpl
 * 文件描述:  @Description: 图片业务层
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Service
public class SysIconServiceImpl implements SysIconService {

    @Autowired
    private SysIconDao sysIconDao;

    /**
     * @Author 六叶草
     * @Description //查询全部图片
     * @Date 2023/7/10 10:32
     **/
    public List<HashMap> searchIconName(){
        List<HashMap> list=sysIconDao.searchIconName();
        return list;
    }


}
