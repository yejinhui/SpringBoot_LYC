/**
 * 包名称：com.example.springbootdemo.controller.form
 * 类名称：DeletePermissionByIdsForm
 * 类描述：删除权限
 * 创建人：@author 六叶草
 * 创建时间：2023年07月10日 14:16
 */
package com.example.springbootdemo.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年07月10日 14:16
 * 项目名称:  SpringBootDemo
 * 文件名称:  DeletePermissionByIdsForm
 * 文件描述:  @Description: 删除权限
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Data
@Schema(description = "根据Id删除菜单信息")
public class DeletePermissionByIdsForm {

    @NotNull(message = "id不能为空")
    @Schema(description = "权限ID")
    private Integer[] ids;

}
