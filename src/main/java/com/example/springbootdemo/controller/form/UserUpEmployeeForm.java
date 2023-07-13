/**
 * 包名称：com.example.springbootdemo.controller.form
 * 类名称：UserUpEmployeeForm
 * 类描述：用户升级为员工Form
 * 创建人：@author 六叶草
 * 创建时间：2023年06月26日 09:11
 */
package com.example.springbootdemo.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年06月26日 09:11
 * 项目名称:  SpringBootDemo
 * 文件名称:  UserUpEmployeeForm
 * 文件描述:  @Description: 用户升级为员工Form
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Data
@Schema(description = "用户升级为员工Form")
public class UserUpEmployeeForm {

    @NotNull(message = "userId不能为空")
    @Min(value = 1, message = "userId不能小于1")
    @Schema(description = "用户Id")
    private Integer userId;

    @NotBlank(message = "companyName不能为空")
    @Schema(description = "所属公司")
    private String companyName;

    @NotBlank(message = "deptName不能为空")
    @Schema(description = "部门")
    private String deptName;

    @Schema(description = "入职日期")
    private String hiredate;

}
