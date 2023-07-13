package com.example.springbootdemo.service;
/**
 * 包名称：com.example.springbootdemo.service
 * 类名称：DropDownService
 * 类描述：下拉功能接口
 * 创建人：@author 六叶草
 * 创建时间：2023年06月14日 13:55
 */

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年06月14日 13:55
 * 项目名称:  SpringBootDemo
 * 文件名称:  DropDownService
 * 文件描述:  @Description: 下拉功能接口
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
public interface SysDropDownService {

    /**
     * @Author 六叶草
     * @Description //右击功能
     * @Date 2023/6/14 13:56
     **/
    public ArrayList<HashMap> searchDropDownElInfo();
}
