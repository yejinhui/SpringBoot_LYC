/**
 * 包名称：com.example.springbootdemo.controller.form
 * 类名称：UpdateDeptForm
 * 类描述：更新公司信息
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
 * 文件描述:  @Description: 更新公司信息
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Data
@Schema(pattern = "更新公司信息")
public class UpdateCompanyForm {

    @NotNull(message = "id不能为空")
    @Min(value = 0,message = "id不能小于0")
    @Schema(description = "公司Id")
    private Integer id;

    @NotBlank(message = "deptName不能为空")
    @Pattern(regexp = "^[\\u4e00-\\u9fa5]{3,20}$",message = "companyName内容不正确")
    @Schema(description = "公司名称")
    private String companyName;

    @Schema(description = "公司英文名称")
    private String companyEngName;

    @Pattern(regexp = "^1[0-9]{10}$",message = "tel内容不正确")
    @Schema(description = "联系电话")
    private String tel;

    @Schema(description = "公司地址")
    private String address;

    @NotNull(message = "status不能为空")
    @Schema(description = "状态")
    private Integer status;

    @Schema(description = "描述")
    private String desc;

}
