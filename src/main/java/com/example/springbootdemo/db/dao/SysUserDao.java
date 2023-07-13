/**
 * 包名称：com.example.springbootdemo.db.dao
 * 类名称：SysUserDao
 * 类描述：用户实现接口
 * 创建人：@author 六叶草
 * 创建时间：2023年05月21日 17:02
 */
package com.example.springbootdemo.db.dao;

import com.example.springbootdemo.common.PageUtils;
import com.example.springbootdemo.controller.form.SysUserForm;
import com.example.springbootdemo.db.pojo.SysUser;
import com.example.springbootdemo.db.vo.SysEmployeeVo;
import com.example.springbootdemo.db.vo.SysUserVo;
import com.example.springbootdemo.units.poi.model.SysEmployeeMo;
import com.example.springbootdemo.units.poi.model.SysUserMo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年05月21日 17:02
 * 项目名称:  SpringBootDemo
 * 文件名称:  SysUserDao
 * 文件描述:  @Description: 用户实现接口
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
public interface SysUserDao {

    /**
     * @Author 六叶草
     * @Description //登录
     * @Date 2023/5/21 17:06
     **/
    public Integer login(HashMap form);

    /**
     * @Author 六叶草
     * @Description //根据用户ID查询用户信息
     * @Date 2023/5/21 17:18
     **/
    public Set<String> searchUserPermissions(int userId);

    /**
     * @Author 六叶草
     * @Description //根据用户查询是否存在
     * @Date 2023/5/22 9:27
     **/
    public Integer register(HashMap form);

    /**
     * @Author 六叶草
     * @Description //保存注册用户信息
     * @Date 2023/5/23 14:52
     **/
    public Integer insertUserPermissions(HashMap form);

    /**
     * @Author 六叶草
     * @Description //查询盐值
     * @Date 2023/5/23 14:53
     **/
    public String searchUserSalt(HashMap form);

    /**
     * @Author 六叶草
     * @Description //更新登录时间
     * @Date 2023/5/23 14:53
     **/
    public int updateUserLoginTime(HashMap form);

    /**
     * @Author 六叶草
     * @Description //查询用户名是否存在
     * @Date 2023/5/23 15:04
     **/
    public Integer selectUserNameExit(String userName);

    /**
     * @Author 六叶草
     * @Description //查询邮箱是否存在
     * @Date 2023/5/23 15:04
     **/
    public Integer selectEmailExit(String email);

    /**
     * @Author 六叶草
     * @Description //查询用户信息
     * @Date 2023/6/2 16:44
     **/
    public HashMap searchUserSummary(int userId);

    /**
     * @Author 六叶草
     * @Description //更新密码
     * @Date 2023/6/2 19:10
     **/
    public int updatePassword(HashMap param);

    /**
     * @Author 六叶草
     * @Description //查询当前的用户资料
     * @Date 2023/6/3 16:14
     **/
    public SysUserForm selectUserInfoHandle(int userId);

    /**
     * @Author 六叶草
     * @Description //更新个人资料
     * @Date 2023/6/3 17:43
     **/
    public int updateUserInfo(HashMap param);

    /**
     * @Author 六叶草
     * @Description //图片路径保存
     * @Date 2023/6/5 14:59
     **/
    public int updateimg(HashMap param);

    /**
     * @Author 六叶草
     * @Description //员工管理页面查询分页
     * @Date 2023/6/20 18:35
     **/
    public ArrayList<SysEmployeeVo> searchEmployeeByPage(HashMap param);

    /**
     * @Author 六叶草
     * @Description //查询员工总页数
     * @Date 2023/6/21 9:19
     **/
    public long searchEmployeeCount(HashMap param);

    /**
     * @Author 六叶草
     * @Description //根据用户Id删除用户表单
     * @Date 2023/6/21 17:39
     **/
    public int deleteUserByIds(Integer[] ids);


    /**
     * @Author 六叶草
     * @Description //无法删除超级用户
     * @Date 2023/6/21 17:41
     **/
    public boolean searchChaoDelete(Integer[] ids);

    /**
     * @Author 六叶草
     * @Description //根据Id进行查询用户信息
     * @Date 2023/6/22 15:06
     **/
    public HashMap searchUserById(Integer id);

    /**
     * @Author 六叶草
     * @Description //更新图片
     * @Date 2023/6/23 14:03
     **/
    public int updateimgById(HashMap param);

    /**
     * @Author 六叶草
     * @Description //更新员工信息
     * @Date 2023/6/23 15:53
     **/
    public int updateEmployee(HashMap param);

    /**
     * @Author 六叶草
     * @Description //新增员工
     * @Date 2023/6/23 18:50
     **/
    public int insertEmployee(HashMap param);

    /**
     * @Author 六叶草
     * @Description //检验用户名是否存在
     * @Date 2023/6/24 10:13
     **/
    public Integer selectUserNameCheck(String username, Integer userId);

    /**
     * @Author 六叶草
     * @Description //检验邮箱
     * @Date 2023/6/24 10:13
     **/
    public Integer selectEmailExitCheck(String email, Integer userId);

    /**
     * @Author 六叶草
     * @Description //查询用户表中最大的code
     * @Date 2023/6/24 16:29
     **/
    public String searchMaxCode();

    /**
     * @Author 六叶草
     * @Description //用户管理页面查询分页
     * @Date 2023/6/24 20:18
     **/
    public ArrayList<SysUserVo> searchUserByPage(HashMap param);

    /**
     * @Author 六叶草
     * @Description //查询用户总页数
     * @Date 2023/6/21 9:19
     **/
    public long searchUserCount(HashMap param);

    /**
     * @Author 六叶草
     * @Description //注册员工
     * @Date 2023/6/26 9:55
     **/
    public int updateUserUpEmployee(HashMap param);

    /**
     * @Author 六叶草
     * @Description //用于导出全部的用户数据
     * @Date 2023/6/28 11:15
     **/
    public List<HashMap> selectAllUserExcel();

    /**
     * @Author 六叶草
     * @Description //用于导出全部的员工数据
     * @Date 2023/6/28 11:32
     **/
    public List<HashMap> selectAllEmployeeExcel();

    /**
     * @Author 六叶草
     * @Description //导入用户信息
     * @Date 2023/7/3 15:09
     **/
    public int insertUsers(List<SysUserMo> list);

    /**
     * @Author 六叶草
     * @Description //导入员工信息
     * @Date 2023/7/4 11:50
     **/
    public int insertEmployees(List<SysEmployeeMo> list);

    /**
     * @Author 六叶草
     * @Description //根据用户Id找到photo地址
     * @Date 2023/7/6 16:35
     **/
    public String searchPhotoById(int userId);
}
