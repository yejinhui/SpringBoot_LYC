/**
 * 包名称：com.example.springbootdemo.controller.form
 * 类名称：SearchActionByPageForm
 * 类描述：功能分页Form
 * 创建人：@author 六叶草
 * 创建时间：2023年07月08日 10:16
 */
package com.example.springbootdemo.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年07月08日 10:16
 * 项目名称:  SpringBootDemo
 * 文件名称:  SearchActionByPageForm
 * 文件描述:  @Description: 功能分页Form
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Data
@Schema(description = "功能分页Form")
public class SearchActionByPageForm {

    @Schema(description = "功能名称")
    private String actionName;

    @NotNull(message = "page不能为空")
    @Min(value = 1, message = "page不能小于1")
    @Schema(description = "页数")
    private Integer page;

    @NotNull(message = "length不能为空")
    @Range(min = 10, max = 50, message = "length必须在10~50之间")
    @Schema(description = "每页记录数")
    private Integer length;

}
