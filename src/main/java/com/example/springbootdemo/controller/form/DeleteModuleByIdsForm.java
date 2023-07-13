/**
 * 包名称：com.example.springbootdemo.controller.form
 * 类名称：DeleteModuleByIdsForm
 * 类描述：根据Id删除菜单信息
 * 创建人：@author 六叶草
 * 创建时间：2023年07月07日 17:19
 */
package com.example.springbootdemo.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年07月07日 17:19
 * 项目名称:  SpringBootDemo
 * 文件名称:  DeleteModuleByIdsForm
 * 文件描述:  @Description: 根据Id删除菜单信息
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Data
@Schema(description = "根据Id删除菜单信息")
public class DeleteModuleByIdsForm {

    @NotNull(message = "id不能为空")
    @Schema(description = "菜单ID")
    private Integer[] ids;

}
