package com.example.springbootdemo.db.dao;/**
 * 包名称：com.example.springbootdemo.db.dao
 * 类名称：SysCompanyDao
 * 类描述：公司持久层
 * 创建人：@author 六叶草
 * 创建时间：2023年06月03日 17:10
 */

import com.example.springbootdemo.common.PageUtils;
import com.example.springbootdemo.db.vo.SysCompanyVo;
import com.example.springbootdemo.units.poi.model.SysCompanyMo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年06月03日 17:10
 * 项目名称:  SpringBootDemo
 * 文件名称:  SysCompanyDao
 * 文件描述:  @Description: 公司持久层
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
//标注这个是Mapper类
@Mapper
//事务的回滚与提交(避免出现关闭sql失败的错误或者失败后依然执行更新删除新增等操作)
@Transactional
public interface SysCompanyDao {

    /**
     * @Author 六叶草
     * @Description //查询公司下拉内容
     * @Date 2023/6/3 17:17
     **/
    public ArrayList<HashMap> selectCompanyHandle();

    /**
     * @Author 六叶草
     * @Description //公司的分页查询
     * @Date 2023/6/28 16:56
     **/
    public ArrayList<SysCompanyVo> searchCompanyByPage(HashMap param);

    /**
     * @Author 六叶草
     * @Description //根据id删除公司信息
     * @Date 2023/6/28 16:56
     **/
    public int deleteCompanyByIds(Integer[] ids);

    /**
     * @Author 六叶草
     * @Description //查询公司记录
     * @Date 2023/6/28 16:57
     **/
    public HashMap selectCompanyById(Integer id);

    /**
     * @Author 六叶草
     * @Description //查询公司名称是否有重复
     * @Date 2023/6/28 16:58
     **/
    public int selectCompanyByName(String companyName, Integer id);

    /**
     * @Author 六叶草
     * @Description //查询公司名称是否有重复
     * @Date 2023/6/28 16:58
     **/
    public int selectCompanyByName(String companyName);

    /**
     * @Author 六叶草
     * @Description //更新公司信息
     * @Date 2023/6/28 16:58
     **/
    public int updateCompany(HashMap param);

    /**
     * @Author 六叶草
     * @Description //新增公司信息
     * @Date 2023/6/28 16:59
     **/
    public int insertCompany(HashMap param);

    /**
     * @Author 六叶草
     * @Description //查询所有的公司信息
     * @Date 2023/6/28 17:00
     **/
    public List<HashMap> selectAllCompanyExcel();

    /**
     * @Author 六叶草
     * @Description //统计公司总数
     * @Date 2023/6/28 17:14
     **/
    public long searchCompanyCount(HashMap param);

    /**
     * @Author 六叶草
     * @Description //导入/批量新增所属公司
     * @Date 2023/7/5 9:37
     **/
    public int insertCompanys(List<SysCompanyMo> list);
}
