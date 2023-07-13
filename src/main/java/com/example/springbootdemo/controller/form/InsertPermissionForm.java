/**
 * 包名称：com.example.springbootdemo.controller.form
 * 类名称：InsertPermissionForm
 * 类描述：新增权限
 * 创建人：@author 六叶草
 * 创建时间：2023年07月10日 15:00
 */
package com.example.springbootdemo.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年07月10日 15:00
 * 项目名称:  SpringBootDemo
 * 文件名称:  InsertPermissionForm
 * 文件描述:  @Description: 新增权限
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Data
@Schema(description = "新增权限")
public class InsertPermissionForm {

    @NotBlank(message = "moduleCode不能为空")
    @Pattern(regexp = "^[A-Z_]{3,30}$",message = "菜单内容不正确")
    @Schema(description = "菜单")
    private String moduleCode;

    @NotBlank(message = "actionCode不能为空")
    @Pattern(regexp = "^[A-Z]{3,30}$",message = "功能内容不正确")
    @Schema(description = "功能")
    private String actionCode;

}
