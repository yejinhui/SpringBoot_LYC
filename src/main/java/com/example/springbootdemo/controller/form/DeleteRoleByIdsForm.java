/**
 * 包名称：com.example.springbootdemo.controller.form
 * 类名称：DeleteRoleByIdsForm
 * 类描述：根据Id删除角色信息
 * 创建人：@author 六叶草
 * 创建时间：2023年07月08日 14:52
 */
package com.example.springbootdemo.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年07月08日 14:52
 * 项目名称:  SpringBootDemo
 * 文件名称:  DeleteRoleByIdsForm
 * 文件描述:  @Description: 根据Id删除角色信息
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Data
@Schema(description = "删除角色表单")
public class DeleteRoleByIdsForm {

    @NotEmpty(message = "ids不能为空")
    @Schema(description = "角色ID")
    private Integer[] ids;

}
