/**
 * 包名称：com.example.springbootdemo.controller.form
 * 类名称：SearchModuleByIdForm
 * 类描述：根据菜单id进行查询
 * 创建人：@author 六叶草
 * 创建时间：2023年07月07日 16:52
 */
package com.example.springbootdemo.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年07月07日 16:52
 * 项目名称:  SpringBootDemo
 * 文件名称:  SearchModuleByIdForm
 * 文件描述:  @Description: 根据菜单id进行查询
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Data
@Schema(description = "根据菜单id进行查询")
public class SearchModuleByIdForm {

    /**
     * @Author 六叶草
     * @Description //前端传进来的id
     * @Date 2023/7/7 16:52
     **/
    @NotNull(message = "id不能为空")
    @Min(value = 1, message = "id不能小于1")
    @Schema(description = "菜单ID")
    private Integer id;


}
