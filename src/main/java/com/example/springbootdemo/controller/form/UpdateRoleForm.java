/**
 * 包名称：com.example.springbootdemo.controller.form
 * 类名称：UpdateRoleForm
 * 类描述：更新角色信息
 * 创建人：@author 六叶草
 * 创建时间：2023年07月08日 15:52
 */
package com.example.springbootdemo.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年07月08日 15:52
 * 项目名称:  SpringBootDemo
 * 文件名称:  UpdateRoleForm
 * 文件描述:  @Description: 更新角色信息
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Schema(description = "更新角色表单")
@Data
public class UpdateRoleForm {

    @NotNull(message = "id不能为空")
    @Schema(description = "角色ID")
    private Integer id;

    @NotBlank(message = "roleName不能为空")
    @Pattern(regexp = "^[a-zA-Z0-9\\u4e00-\\u9fa5]{2,10}", message = "roleName内容不正确")
    @Schema(description = "角色名称")
    private String roleName;

    @NotEmpty(message = "permissions不能为空")
    @Schema(description = "权限")
    private Integer[] permissions;

    @Length(max = 20, message = "desc不能超过20个字符")
    @Schema(description = "简介")
    private String desc;

    @NotNull(message = "changed不能为空")
    @Schema(description = "权限是否改动了")
    private Boolean changed;
}
