/**
 * 包名称：com.example.springbootdemo.db.vo
 * 类名称：SysUserVo
 * 类描述：用户vo表，用于分页
 * 创建人：@author 六叶草
 * 创建时间：2023年06月30日 08:43
 */
package com.example.springbootdemo.db.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年06月30日 08:43
 * 项目名称:  SpringBootDemo
 * 文件名称:  SysUserVo
 * 文件描述:  @Description: 用户vo表，用于分页
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Data
@Schema(pattern = "用户vo表，用于分页查询返回数据")
public class SysUserVo {

    /**
     * 主键
     */
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 编号
     */
    private String code;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 头像网址
     */
    private String photo;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private String sex;
    /**
     * 手机号码
     */
    private String tel;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 生日日期
     */
    private String birthday;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 最新上线时间
     */
    private String loginDate;
    /**
     * 最新更新密码的时间
     */
    private String updateTime;

}
