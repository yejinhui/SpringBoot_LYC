/**
 * 包名称：com.example.springbootdemo.controller.form
 * 类名称：UpdatePasswordFrom
 * 类描述：修改密码
 * 创建人：@author 六叶草
 * 创建时间：2023年06月02日 19:08
 */
package com.example.springbootdemo.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年06月02日 19:08
 * 项目名称:  SpringBootDemo
 * 文件名称:  UpdatePasswordFrom
 * 文件描述:  @Description: 修改密码
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Data
@Schema(description = "修改密码表单")
public class UpdatePasswordForm {

    @NotBlank(message = "password不能为空")
    @Pattern(regexp = "^[a-zA-Z0-9]{6,20}$", message = "password不正确")
    @Schema(description = "密码")
    private String password;

}
