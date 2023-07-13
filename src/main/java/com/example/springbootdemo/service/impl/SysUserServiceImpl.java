/**
 * 包名称：com.example.springbootdemo.service.impl
 * 类名称：SysUserServiceImpl
 * 类描述：用户业务层
 * 创建人：@author 六叶草
 * 创建时间：2023年05月21日 17:08
 */
package com.example.springbootdemo.service.impl;

import cn.hutool.core.lang.UUID;
import cn.hutool.json.JSONUtil;
import com.example.springbootdemo.common.PageUtils;
import com.example.springbootdemo.controller.form.SysUserForm;
import com.example.springbootdemo.db.dao.SysUserDao;
import com.example.springbootdemo.db.pojo.SysUser;
import com.example.springbootdemo.db.vo.SysEmployeeVo;
import com.example.springbootdemo.db.vo.SysUserVo;
import com.example.springbootdemo.exception.HuiException;
import com.example.springbootdemo.service.SysUserService;
import com.example.springbootdemo.units.SnSgUntils;
import com.example.springbootdemo.units.poi.model.SysDeptMo;
import com.example.springbootdemo.units.poi.model.SysEmployeeMo;
import com.example.springbootdemo.units.poi.model.SysUserMo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年05月21日 17:08
 * 项目名称:  SpringBootDemo
 * 文件名称:  SysUserServiceImpl
 * 文件描述:  @Description: 用户业务层
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;

    @Autowired
    private SnSgUntils snSgUntils;

    /**
     * @Author 六叶草
     * @Description //登录
     * @Date 2023/5/21 17:09
     **/
    @Override
    public Integer login(HashMap form) {
        Object pwd = form.get("password");
        //随机数加盐法
        String salt = sysUserDao.searchUserSalt(form);// 盐
        /**
         * 参数1: 加密方式
         * 参数2: 要加密的字符串
         * 参数3: 盐
         * 参数4: 加密次数
         */
        SimpleHash password = new SimpleHash("MD5", pwd, salt, 6);// 定义simpleHash对象
        String hashedPwd = password.toHex();// 生成16进制密文
        // 替换key为2的映射
        form.replace("password", hashedPwd);
        Integer userId = sysUserDao.login(form);
        if (userId != null) {
            SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
            sdf.applyPattern("yyyy-MM-dd HH:mm:ss");// a为am/pm的标记
            Date date = new Date();// 获取当前时间
            form.put("logintime", sdf.format(date));
            form.put("userId", userId);
            //更新登录时间
            Integer num = sysUserDao.updateUserLoginTime(form);
            if (num < 0) {
                throw new RuntimeException("更新登录时间失败");
            }
        }
        return userId;
    }

    /**
     * @Author 六叶草
     * @Description //根据用户ID查询用户信息
     * @Date 2023/5/21 17:20
     **/
    @Override
    public Set<String> searchUserPermissions(int userId) {
        Set<String> permissions = sysUserDao.searchUserPermissions(userId);
        return permissions;
    }

    /**
     * @Author 六叶草
     * @Description //查询用户是否存在
     * @Date 2023/5/22 9:26
     **/
    @Override
    public Integer register(HashMap form) {
        Integer userId = sysUserDao.register(form);
        return userId;
    }

    /**
     * @Author 六叶草
     * @Description //新增注册的用户
     * @Date 2023/5/22 9:59
     **/
    @Override
    public Integer insertUserPermissions(HashMap form) {
        Object pwd = form.get("password");
        //随机数加盐法
        String salt = UUID.randomUUID().toString();// 盐
        /**
         * 参数1: 加密方式
         * 参数2: 要加密的字符串
         * 参数3: 盐
         * 参数4: 加密次数
         */
        SimpleHash password = new SimpleHash("MD5", pwd, salt, 6);// 定义simpleHash对象
        String hashedPwd = password.toHex();// 生成16进制密文
        form.put("salt", salt);
        // 替换key为2的映射
        form.replace("password", hashedPwd);
        form.put("root", 0);
        form.put("role", 8);
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");// a为am/pm的标记
        Date date = new Date();// 获取当前时间
        form.put("createtime", sdf.format(date));
        form.put("logintime", sdf.format(date));
        form.put("status", 1);
        Integer num = sysUserDao.insertUserPermissions(form);
        return num;
    }

    /**
     * @Author 六叶草
     * @Description //查询用户名是否存在
     * @Date 2023/5/23 15:02
     **/
    @Override
    public Integer selectUserNameExit(String userName) {
        return sysUserDao.selectUserNameExit(userName);
    }

    /**
     * @Author 六叶草
     * @Description //查询邮箱是否存在
     * @Date 2023/5/23 15:02
     **/
    @Override
    public Integer selectEmailExit(String email) {
        return sysUserDao.selectEmailExit(email);
    }

    /**
     * @Author 六叶草
     * @Description //查询用户信息
     * @Date 2023/6/2 16:45
     **/
    @Override
    public HashMap searchUserSummary(int userId) {
        HashMap map = sysUserDao.searchUserSummary(userId);
        return map;
    }

    /**
     * @Author 六叶草
     * @Description //更新密码
     * @Date 2023/6/2 19:11
     **/
    @Override
    public int updatePassword(HashMap param) {
        Object pwd = param.get("password");
        //随机数加盐法
        String salt = UUID.randomUUID().toString();// 盐
        /**
         * 参数1: 加密方式
         * 参数2: 要加密的字符串
         * 参数3: 盐
         * 参数4: 加密次数
         */
        SimpleHash password = new SimpleHash("MD5", pwd, salt, 6);// 定义simpleHash对象
        String hashedPwd = password.toHex();// 生成16进制密文
        param.put("salt", salt);
        // 替换key为2的映射
        param.replace("password", hashedPwd);
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");// a为am/pm的标记
        Date date = new Date();// 获取当前时间
        param.put("updatetime", sdf.format(date));
        int rows = sysUserDao.updatePassword(param);
        return rows;
    }

    /**
     * @Author 六叶草
     * @Description //根据用户id查询用户信息
     * @Date 2023/6/3 16:14
     **/
    @Override
    public HashMap selectUserInfoHandle(int userId) {
        SysUserForm sysUserForm = sysUserDao.selectUserInfoHandle(userId);
        HashMap param = JSONUtil.parse(sysUserForm).toBean(HashMap.class);
        return param;
    }

    /**
     * @Author 六叶草
     * @Description //更新个人资料
     * @Date 2023/6/3 17:43
     **/
    @Override
    public int updateUserInfo(HashMap param) {
        return sysUserDao.updateUserInfo(param);
    }

    /**
     * @Author 六叶草
     * @Description //图片路径更新
     * @Date 2023/6/5 15:00
     **/
    @Override
    public int updateimg(HashMap param) {
        return sysUserDao.updateimg(param);
    }

    /**
     * @Author 六叶草
     * @Description //员工管理页面查询分页
     * @Date 2023/6/20 18:35
     **/
    public PageUtils searchEmployeeByPage(HashMap param) {
        ArrayList<SysEmployeeVo> list = sysUserDao.searchEmployeeByPage(param);
        long count = sysUserDao.searchEmployeeCount(param);
        int start = (Integer) param.get("start");
        int length = (Integer) param.get("length");
        PageUtils pageUtils = new PageUtils(list, count, start, length);
        return pageUtils;
    }

    /**
     * @Author 六叶草
     * @Description //根据传入的用户Id/ids进行删除用户信息
     * @Date 2023/6/24 16:35
     **/
    @Override
    public int deleteUserByIds(Integer[] ids, int userId) {
        if (!sysUserDao.searchChaoDelete(ids)) {
            throw new HuiException("无法删除超级管理员");
        }
        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == userId) {
                throw new HuiException("无法删除当前用户");
            }
        }
        int rows = sysUserDao.deleteUserByIds(ids);
        return rows;
    }

    /**
     * @Author 六叶草
     * @Description //根据用户Id查询用户信息
     * @Date 2023/6/24 16:35
     **/
    @Override
    public HashMap searchUserById(Integer id) {
        return sysUserDao.searchUserById(id);
    }

    /**
     * @Author 六叶草
     * @Description //更新图片信息
     * @Date 2023/6/24 16:35
     **/
    @Override
    public int updateimgById(HashMap param) {
        return sysUserDao.updateimgById(param);
    }

    /**
     * @Author 六叶草
     * @Description //更新员工信息
     * @Date 2023/6/24 16:34
     **/
    @Override
    public int updateEmployee(HashMap param) {
        Object pwd = param.get("password");
        if (pwd != null && pwd != "") {
            //随机数加盐法
            String salt = UUID.randomUUID().toString();// 盐
            /**
             * 参数1: 加密方式
             * 参数2: 要加密的字符串
             * 参数3: 盐
             * 参数4: 加密次数
             */
            // 定义simpleHash对象
            SimpleHash password = new SimpleHash("MD5", pwd, salt, 6);
            // 生成16进制密文
            String hashedPwd = password.toHex();
            param.put("salt", salt);
            // 替换key为2的映射
            param.replace("password", hashedPwd);
        }
        // 格式化时间
        SimpleDateFormat sdf = new SimpleDateFormat();
        // a为am/pm的标记
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
        // 获取当前时间
        Date date = new Date();
        param.put("updatetime", sdf.format(date));
        return sysUserDao.updateEmployee(param);
    }

    /**
     * @Author 六叶草
     * @Description //新增员工信息
     * @Date 2023/6/24 16:34
     **/
    @Override
    public int insertEmployee(HashMap param) {
        Object pwd = param.get("password");
        //随机数加盐法
        String salt = UUID.randomUUID().toString();// 盐
        /**
         * 参数1: 加密方式
         * 参数2: 要加密的字符串
         * 参数3: 盐
         * 参数4: 加密次数
         */
        // 定义simpleHash对象
        SimpleHash password = new SimpleHash("MD5", pwd, salt, 6);
        // 生成16进制密文
        String hashedPwd = password.toHex();
        param.put("salt", salt);
        // 替换key为2的映射
        param.replace("password", hashedPwd);
        // 格式化时间
        SimpleDateFormat sdf = new SimpleDateFormat();
        // a为am/pm的标记
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
        // 获取当前时间
        Date date = new Date();
        param.put("createTime", sdf.format(date));
        param.put("root", 0);
        param.put("role", 8);
        return sysUserDao.insertEmployee(param);
    }

    /**
     * @Author 六叶草
     * @Description //根据传入的username检查username是否存在（排除自身的username）
     * @Date 2023/6/24 16:34
     **/
    @Override
    public Integer selectUserNameCheck(String username, Integer userId) {
        return sysUserDao.selectUserNameCheck(username,userId);
    }

    /**
     * @Author 六叶草
     * @Description //根据传入的email检查Email是否存在（排除自身的email）
     * @Date 2023/6/24 16:33
     **/
    @Override
    public Integer selectEmailExitCheck(String email, Integer userId) {
        return sysUserDao.selectEmailExitCheck(email,userId);
    }

    /**
     * @Author 六叶草
     * @Description //查询最大的code
     * @Date 2023/6/24 16:33
     **/
    @Override
    public String searchMaxCode() {
        return sysUserDao.searchMaxCode();
    }

    /**
     * @Author 六叶草
     * @Description //用户管理页面查询分页
     * @Date 2023/6/20 18:35
     **/
    @Override
    public PageUtils searchUserByPage(HashMap param) {
        ArrayList<SysUserVo> list = sysUserDao.searchUserByPage(param);
        long count = sysUserDao.searchUserCount(param);
        int start = (Integer) param.get("start");
        int length = (Integer) param.get("length");
        PageUtils pageUtils = new PageUtils(list, count, start, length);
        return pageUtils;
    }

    /**
     * @Author 六叶草
     * @Description //注册员工
     * @Date 2023/6/26 9:55
     **/
    public int updateUserUpEmployee(HashMap param){
        return sysUserDao.updateUserUpEmployee(param);
    }

    /**
     * @Author 六叶草
     * @Description //用于导出全部的用户数据
     * @Date 2023/6/28 11:15
     **/
    public List<HashMap> selectAllUserExcel(){
        return sysUserDao.selectAllUserExcel();
    }

    /**
     * @Author 六叶草
     * @Description //用于导出全部的员工数据
     * @Date 2023/6/28 11:15
     **/
    public List<HashMap> selectAllEmployeeExcel(){
        return sysUserDao.selectAllEmployeeExcel();
    }

    /**
     * @Author 六叶草
     * @Description //导入用户
     * @Date 2023/7/3 15:09
     **/
    public int insertUsers(List<SysUserMo> list){
        // 格式化时间
        SimpleDateFormat sdf = new SimpleDateFormat();
        // a为am/pm的标记
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
        // 获取当前时间
        Date date = new Date();
        //随机数加盐法
        String salt = UUID.randomUUID().toString();// 盐
        /**
         * 参数1: 加密方式
         * 参数2: 要加密的字符串
         * 参数3: 盐
         * 参数4: 加密次数
         */
        // 定义simpleHash对象
        SimpleHash password = new SimpleHash("MD5", "123456", salt, 6);
        // 生成16进制密文
        String hashedPwd = password.toHex();
        //查询最大的code
        String code = sysUserDao.searchMaxCode();
        String newCode = snSgUntils.sfGenNum(code,null,4);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setCode(newCode);
            newCode = snSgUntils.sfGenNum(newCode,null,4);
            list.get(i).setCreateTime(date);
            list.get(i).setRoot(0);
            list.get(i).setRole(8);
            list.get(i).setPassword(hashedPwd);
            list.get(i).setSalt(salt);
            if (list.get(i).getStatus() == null) {
                list.get(i).setStatus(1);
            }
        }
        return sysUserDao.insertUsers(list);
    }

    /**
     * @Author 六叶草
     * @Description //导入员工信息
     * @Date 2023/7/4 11:48
     **/
    public int insertEmployees(List<SysEmployeeMo> list){
        // 格式化时间
        SimpleDateFormat sdf = new SimpleDateFormat();
        // a为am/pm的标记
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
        // 获取当前时间
        Date date = new Date();
        //随机数加盐法
        String salt = UUID.randomUUID().toString();// 盐
        /**
         * 参数1: 加密方式
         * 参数2: 要加密的字符串
         * 参数3: 盐
         * 参数4: 加密次数
         */
        // 定义simpleHash对象
        SimpleHash password = new SimpleHash("MD5", "123456", salt, 6);
        // 生成16进制密文
        String hashedPwd = password.toHex();
        //查询最大的code
        String code = sysUserDao.searchMaxCode();
        String newCode = snSgUntils.sfGenNum(code,null,4);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setCode(newCode);
            newCode = snSgUntils.sfGenNum(newCode,null,4);
            list.get(i).setCreateTime(date);
            list.get(i).setRoot(0);
            list.get(i).setRole(3);
            list.get(i).setPassword(hashedPwd);
            list.get(i).setSalt(salt);
            if (list.get(i).getStatus() == null) {
                list.get(i).setStatus(1);
            }
        }
        return sysUserDao.insertEmployees(list);
    }

    /**
     * @Author 六叶草
     * @Description //根据用户Id找到photo地址
     * @Date 2023/7/6 16:34
     **/
    public String searchPhotoById(int userId){
        return sysUserDao.searchPhotoById(userId);
    }


}
