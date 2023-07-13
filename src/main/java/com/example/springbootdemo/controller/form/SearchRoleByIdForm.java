/**
 * 包名称：com.example.springbootdemo.controller.form
 * 类名称：SearchRoleByIdForm
 * 类描述：根据Id进行查询
 * 创建人：@author 六叶草
 * 创建时间：2023年07月08日 15:33
 */
package com.example.springbootdemo.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年07月08日 15:33
 * 项目名称:  SpringBootDemo
 * 文件名称:  SearchRoleByIdForm
 * 文件描述:  @Description: 根据Id进行查询
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Data
@Schema(description = "根据ID查询角色表单")
public class SearchRoleByIdForm {

    @NotNull(message = "id不能为空")
    @Min(value = 0, message = "id不能小于0")
    @Schema(description = "角色ID")
    private Integer id;
}
