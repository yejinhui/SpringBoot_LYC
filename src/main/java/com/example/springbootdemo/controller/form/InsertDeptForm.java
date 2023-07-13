/**
 * 包名称：com.example.springbootdemo.controller.form
 * 类名称：UpdateDeptForm
 * 类描述：更新部门信息
 * 创建人：@author 六叶草
 * 创建时间：2023年06月26日 19:07
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
 * 创建时间:  2023年06月26日 19:07
 * 项目名称:  SpringBootDemo
 * 文件名称:  UpdateDeptForm
 * 文件描述:  @Description: 更新部门信息
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Data
@Schema(pattern = "新增部门信息")
public class InsertDeptForm {

    @NotBlank(message = "deptName不能为空")
    @Pattern(regexp = "^[\\u4e00-\\u9fa5]{3,6}$",message = "deptName内容不正确")
    @Schema(description = "部门名称")
    private String deptName;

    @Schema(description = "电子邮件")
    @Pattern(regexp = "^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((.[a-zA-Z0-9_-]{2,3}){1,2})$",message = "email内容不正确")
    private String email;

    @Pattern(regexp = "^1[0-9]{10}$",message = "tel内容不正确")
    @Schema(description = "联系电话")
    private String tel;

    @Schema(description = "状态")
    private Integer status;

    @Schema(description = "描述")
    private String desc;

}
