/**
 * 包名称：com.example.springbootdemo.config
 * 类名称：StpInterfaceImpl
 * 类描述：自定义权限验证接口扩展
 * 创建人：@author 六叶草
 * 创建时间：2023年06月21日 11:36
 */
package com.example.springbootdemo.config;

import cn.dev33.satoken.stp.StpInterface;
import com.example.springbootdemo.db.dao.SysUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年06月21日 11:36
 * 项目名称:  SpringBootDemo
 * 文件名称:  StpInterfaceImpl
 * 文件描述:  @Description: 自定义权限验证接口扩展
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Component
public class StpInterfaceImpl implements StpInterface {

    @Autowired
    private SysUserDao sysUserDao;

    /**
     * 返回一个用户所拥有的权限集合
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginKey) {
        int userId = Integer.parseInt(loginId.toString());
        Set<String> permissions = sysUserDao.searchUserPermissions(userId);
        ArrayList list = new ArrayList();
        list.addAll(permissions);
        return list;
    }

    /**
     * 返回一个用户所拥有的角色标识集合
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginKey) {
        //因为本项目不需要用到角色判定，所以这里就返回一个空的ArrayList对象
        ArrayList<String> list = new ArrayList<String>();
        return list;
    }
}
