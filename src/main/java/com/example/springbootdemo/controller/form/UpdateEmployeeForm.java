/**
 * 包名称：com.example.springbootdemo.controller.form
 * 类名称：UpdateEmployeeForm
 * 类描述：根据用户Id更新用户信息
 * 创建人：@author 六叶草
 * 创建时间：2023年06月23日 15:28
 */
package com.example.springbootdemo.controller.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年06月23日 15:28
 * 项目名称:  SpringBootDemo
 * 文件名称:  UpdateEmployeeForm
 * 文件描述:  @Description: 根据用户Id更新用户信息
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Data
@Schema(pattern = "根据用户Id更新用户信息")
public class UpdateEmployeeForm {

    @NotBlank(message = "username不能为空")
    @Pattern(regexp = "^[a-zA-Z0-9]{5,50}$", message = "username不正确")
    @Schema(description = "用户名")
    private String username;

    @Pattern(regexp = "^[a-zA-Z0-9\\u4e00-\\u9fa5]{2,10}$", message = "nickname不正确")
    @Schema(description = "昵称")
    private String nickname;

    @NotBlank(message = "photo不能为空")
    @Schema(description = "照片")
    private String photo;

    @NotBlank(message = "name不能为空")
    @Pattern(regexp = "^[\\u4e00-\\u9fa5]{2,20}$", message = "name不正确")
    @Schema(description = "真实姓名")
    private String name;

    @NotBlank(message = "email不能为空")
    @Pattern(regexp = "^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((.[a-zA-Z0-9_-]{2,3}){1,2})$", message = "email不正确")
    @Schema(description = "邮箱")
    private String email;

    @Schema(description = "性别")
    private String sex;

    @Schema(description = "生日日期")
    private Date birthday;

    @Schema(description = "入职日期")
    private String hiredate;

    @Schema(description = "所属部门")
    private String deptId;

    @Pattern(regexp = "^[a-zA-z0-9]{6,20}$",message = "password内容不正确")
    @Schema(description = "密码")
    private String password;

    @Schema(description = "所输公司")
    private String companyId;

    @Schema(description = "角色")
    private Integer[] role;

    @NotBlank(message = "tel不能为空")
    @Pattern(regexp = "^1[0-9]{10}$", message = "tel不正确")
    @Schema(description = "电话")
    private String tel;

    @NotNull(message = "status不能为空")
    @Min(value = 0, message = "status不能小于0")
    @Schema(description = "状态")
    private Byte status;

    @NotBlank(message = "code不能为空")
    @Schema(description = "编号")
    private String code;

    @NotNull(message = "userId不能为空")
    @Min(value = 1, message = "userId不能小于1")
    @Schema(description = "用户Id")
    private Integer userId;

}
