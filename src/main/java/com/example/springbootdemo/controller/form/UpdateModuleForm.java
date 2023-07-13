/**
 * 包名称：com.example.springbootdemo.controller.form
 * 类名称：UpdateModuleForm
 * 类描述：根据Id更新菜单信息
 * 创建人：@author 六叶草
 * 创建时间：2023年07月07日 18:05
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
 * 创建时间:  2023年07月07日 18:05
 * 项目名称:  SpringBootDemo
 * 文件名称:  UpdateModuleForm
 * 文件描述:  @Description: 根据Id更新菜单信息
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Data
@Schema(pattern = "根据Id更新菜单信息")
public class UpdateModuleForm {

    @NotNull(message = "id不能为空")
    @Min(value = 0,message = "id不能小于0")
    @Schema(description = "菜单Id")
    private Integer id;

    @NotBlank(message = "moduleCode不能为空")
    @Pattern(regexp = "^[A-Z_]{3,30}$",message = "moduleCode内容不正确")
    @Schema(description = "菜单编码")
    private String moduleCode;

    @NotBlank(message = "moduleName不能为空")
    @Pattern(regexp = "^[\\u4e00-\\u9fa5]{2,10}$",message = "moduleName内容不正确")
    @Schema(description = "菜单名称")
    private String moduleName;

    @Schema(description = "链接")
    @Pattern(regexp = "^[a-zA-Z]{3,20}$",message = "link内容不正确")
    private String link;

    @Min(value = 0,message = "parentId不能小于0")
    @Schema(description = "父Id")
    private String parentId;

    @Pattern(regexp = "^[a-zA-Z]{2,20}$",message = "iconName内容不正确")
    @Schema(description = "图片")
    private String iconName;

    @NotNull(message = "status不能为空")
    @Schema(description = "状态")
    private Integer status;

    @NotNull(message = "defaultModule不能为空")
    @Min(value = 0,message = "不能小于0")
    @Schema(description = "是否默认功能")
    private Integer defaultModule;


}
