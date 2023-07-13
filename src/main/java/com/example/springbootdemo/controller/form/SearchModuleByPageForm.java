/**
 * 包名称：com.example.springbootdemo.controller.form
 * 类名称：SearchModuleByPageForm
 * 类描述：菜单分页查询Form
 * 创建人：@author 六叶草
 * 创建时间：2023年06月26日 13:50
 */
package com.example.springbootdemo.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年06月26日 13:50
 * 项目名称:  SpringBootDemo
 * 文件名称:  SearchModuleByPageForm
 * 文件描述:  @Description: 菜单分页查询Form
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Data
@Schema(description = "菜单管理分页信息")
public class SearchModuleByPageForm {

    @Schema(description = "菜单名称")
    private String moduleName;

    @NotNull(message = "page不能为空")
    @Min(value = 1, message = "page不能小于1")
    @Schema(description = "页数")
    private Integer page;

    @NotNull(message = "length不能为空")
    @Range(min = 10, max = 50, message = "length必须在10~50之间")
    @Schema(description = "每页记录数")
    private Integer length;

}
