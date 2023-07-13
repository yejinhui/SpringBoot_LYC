/**
 * 包名称：com.example.springbootdemo.controller.form
 * 类名称：DeleteDeptByIdsForm
 * 类描述：查询部门表单
 * 创建人：@author 六叶草
 * 创建时间：2023年06月26日 14:38
 */
package com.example.springbootdemo.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年06月26日 14:38
 * 项目名称:  SpringBootDemo
 * 文件名称:  DeleteDeptByIdsForm
 * 文件描述:  @Description: 查询部门表单
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Data
@Schema(description = "查询部门表单")
public class SelectDeptByIdForm {

    @NotNull(message = "ids不能为空")
    @Min(value = 1, message = "id不能小于1")
    @Schema(description = "部门ID")
    private Integer id;


}
