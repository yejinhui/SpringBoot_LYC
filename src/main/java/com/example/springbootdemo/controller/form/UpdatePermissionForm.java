/**
 * 包名称：com.example.springbootdemo.controller.form
 * 类名称：UpdatePermissionForm
 * 类描述：更新权限
 * 创建人：@author 六叶草
 * 创建时间：2023年07月10日 14:59
 */
package com.example.springbootdemo.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年07月10日 14:59
 * 项目名称:  SpringBootDemo
 * 文件名称:  UpdatePermissionForm
 * 文件描述:  @Description: 更新权限
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Data
@Schema(description = "更新权限")
public class UpdatePermissionForm {

    @NotNull(message = "id不能为空")
    @Min(value = 0,message = "id不能小于0")
    @Schema(description = "功能Id")
    private Integer id;

    @NotBlank(message = "moduleCode不能为空")
    @Pattern(regexp = "^[A-Z_]{3,30}$",message = "moduleCode内容不正确")
    @Schema(description = "菜单编码")
    private String moduleCode;

    @NotBlank(message = "actionCode不能为空")
    @Pattern(regexp = "^[A-Z]{3,30}$",message = "actionCode内容不正确")
    @Schema(description = "功能")
    private String actionCode;
}
