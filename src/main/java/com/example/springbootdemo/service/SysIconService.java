package com.example.springbootdemo.service;/**
 * 包名称：com.example.springbootdemo.service
 * 类名称：SysIconService
 * 类描述：图片业务接口
 * 创建人：@author 六叶草
 * 创建时间：2023年07月10日 10:21
 */

import java.util.HashMap;
import java.util.List;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年07月10日 10:21
 * 项目名称:  SpringBootDemo
 * 文件名称:  SysIconService
 * 文件描述:  @Description: 图片业务接口
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
public interface SysIconService {

    /**
     * @Author 六叶草
     * @Description //查询全部图片
     * @Date 2023/7/10 10:32
     **/
    public List<HashMap> searchIconName();
}
