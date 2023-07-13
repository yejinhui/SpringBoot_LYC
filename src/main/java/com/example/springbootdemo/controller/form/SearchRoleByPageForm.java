/**
 * 包名称：com.example.springbootdemo.controller.form
 * 类名称：SearchRoleByPageForm
 * 类描述：角色分页查询
 * 创建人：@author 六叶草
 * 创建时间：2023年07月08日 14:51
 */
package com.example.springbootdemo.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年07月08日 14:51
 * 项目名称:  SpringBootDemo
 * 文件名称:  SearchRoleByPageForm
 * 文件描述:  @Description: 角色分页查询
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Data
@Schema(description = "查询角色分页表单")
public class SearchRoleByPageForm {

    @Pattern(regexp = "^[0-9a-zA-Z\\u4e00-\\u9fa5]{1,10}$", message = "roleName内容不正确")
    @Schema(description = "角色名称")
    private String roleName;

    @NotNull(message = "page不能为空")
    @Min(value = 1, message = "page不能小于1")
    @Schema(description = "页数")
    private Integer page;

    @NotNull(message = "length不能为空")
    @Range(min = 10, max = 50, message = "length必须在10~50之间")
    @Schema(description = "每页记录数")
    private Integer length;

}
