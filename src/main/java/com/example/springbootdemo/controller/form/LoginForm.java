/**
 * 包名称：com.example.springbootdemo.controller.form
 * 类名称：RegisterForm
 * 类描述：登录信息类
 * 创建人：@author 六叶草
 * 创建时间：2023年05月22日 09:05
 */
package com.example.springbootdemo.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年05月22日 09:05
 * 项目名称:  SpringBootDemo
 * 文件名称:  RegisterForm
 * 文件描述:  @Description: 登录信息类
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Data
@Schema(description = "登陆表单类")
public class LoginForm {

    @NotBlank(message = "username不能为空")
    @Pattern(regexp = "^[a-zA-z0-9]{5,20}$",message = "username内容不正确")
    @Schema(description = "用户名")
    private String username;

    @NotBlank(message = "password不能为空")
    @Pattern(regexp = "^[a-zA-z0-9]{6,20}$",message = "password内容不正确")
    @Schema(description = "密码")
    private String password;

    @Schema(description = "登录时长验证")
    private Boolean loginCheck;

}
