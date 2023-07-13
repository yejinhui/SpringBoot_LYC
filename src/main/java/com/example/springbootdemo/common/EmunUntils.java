package com.example.springbootdemo.common;/**
 * 包名称：com.example.springbootdemo.common
 * 类名称：EmunUntils
 * 类描述：枚举工具类
 * 创建人：@author 六叶草
 * 创建时间：2023年05月22日 15:46
 */

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年05月22日 15:46
 * 项目名称:  SpringBootDemo
 * 文件名称:  EmunUntils
 * 文件描述:  @Description: 枚举工具类
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
public enum EmunUntils {

    usernameError("10001", "账号不存在！"),
    passwordError("10002", "密码错误！"),
    emailError("10002", "邮箱已存在！"),
    usernameExit("10003", "账号已存在！");

    private String CODE;

    private String MSG;

    private EmunUntils(String CODE,String MSG){
        this.CODE = CODE;
        this.MSG = MSG;
    }


}
