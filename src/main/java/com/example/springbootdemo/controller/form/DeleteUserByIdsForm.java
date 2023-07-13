/**
 * 包名称：com.example.springbootdemo.controller.form
 * 类名称：DeleteUserByIdsForm
 * 类描述：根据用户Id删除用户信息
 * 创建人：@author 六叶草
 * 创建时间：2023年06月21日 17:38
 */
package com.example.springbootdemo.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年06月21日 17:38
 * 项目名称:  SpringBootDemo
 * 文件名称:  DeleteUserByIdsForm
 * 文件描述:  @Description: 根据用户Id删除用户信息
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Data
@Schema(description = "删除用户表单")
public class DeleteUserByIdsForm {

    @NotEmpty(message = "ids不能为空")
    @Schema(description = "用户ID")
    private Integer[] ids;

}
