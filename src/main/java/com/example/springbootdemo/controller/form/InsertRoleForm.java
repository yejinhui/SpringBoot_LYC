/**
 * 包名称：com.example.springbootdemo.controller.form
 * 类名称：InsertRoleForm
 * 类描述：新增角色信息
 * 创建人：@author 六叶草
 * 创建时间：2023年07月08日 15:51
 */
package com.example.springbootdemo.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年07月08日 15:51
 * 项目名称:  SpringBootDemo
 * 文件名称:  InsertRoleForm
 * 文件描述:  @Description: 新增角色信息
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Data
@Schema(description = "添加角色表单")
public class InsertRoleForm {

    @NotBlank(message = "roleName不能为空")
    @Schema(description = "角色名称")
    private String roleName;

    @NotEmpty(message = "permissions不能为空")
    @Schema(description = "权限")
    private Integer[] permissions;


    @Length(max = 20,message = "desc不能超过20个字符")
    @Schema(description = "备注")
    private String desc;

}
