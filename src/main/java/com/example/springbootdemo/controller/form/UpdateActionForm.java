/**
 * 包名称：com.example.springbootdemo.controller.form
 * 类名称：UpdateActionForm
 * 类描述：更新功能信息
 * 创建人：@author 六叶草
 * 创建时间：2023年07月08日 10:41
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
 * 创建时间:  2023年07月08日 10:41
 * 项目名称:  SpringBootDemo
 * 文件名称:  UpdateActionForm
 * 文件描述:  @Description: 更新功能信息
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Data
@Schema(pattern = "更新功能信息")
public class UpdateActionForm {

    @NotNull(message = "id不能为空")
    @Min(value = 0,message = "id不能小于0")
    @Schema(description = "功能Id")
    private Integer id;

    @NotBlank(message = "actionCode不能为空")
    @Pattern(regexp = "^[A-Z]{3,20}$",message = "actionCode内容不正确")
    @Schema(description = "功能名称")
    private String actionCode;

    @NotBlank(message = "actionName不能为空")
    @Pattern(regexp = "^[\\u4e00-\\u9fa5]{2,10}$",message = "actionName内容不正确")
    @Schema(description = "功能名称")
    private String actionName;

    @NotNull(message = "status不能为空")
    @Schema(description = "状态")
    private Integer status;

    @NotNull(message = "defaultAction不能为空")
    @Min(value = 0,message = "不能小于0")
    @Schema(description = "是否默认功能")
    private Integer defaultAction;

}
