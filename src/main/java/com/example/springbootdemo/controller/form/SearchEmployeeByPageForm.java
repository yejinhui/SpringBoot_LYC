/**
 * 包名称：com.example.springbootdemo.controller.form
 * 类名称：SearchUserByPageForm
 * 类描述：员工管理分页信息
 * 创建人：@author 六叶草
 * 创建时间：2023年06月20日 17:47
 */
package com.example.springbootdemo.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年06月20日 17:47
 * 项目名称:  SpringBootDemo
 * 文件名称:  SearchUserByPageForm
 * 文件描述:  @Description: 员工管理分页信息
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Data
@Schema(description = "员工管理分页信息")
public class SearchEmployeeByPageForm {

    @Schema(description = "性别")
    private String sex;

    @Schema(description = "用户编号")
    private String code;

    @Min(value = 0, message = "status不能小于0")
    @Schema(description = "状态")
    private Byte status;

    @Pattern(regexp = "^1[0-9]{10}$", message = "tel格式不正确")
    @Schema(description = "联系电话")
    private String tel;

    //^[a-zA-Z0-9\u4e00-\u9fa5]{2,10}$
    @Pattern(regexp = "^[\\u4e00-\\u9fa5]{1,20}$", message = "name内容不正确")
    @Schema(description = "真实姓名")
    private String name;

    @Pattern(regexp = "^((((1[6-9]|[2-9]\\d)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|(((1[6-9]|[2-9]\\d)\\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\\d|30))|(((1[6-9]|[2-9]\\d)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-))$", message = "startHireDate内容不正确")
    @Schema(description = "入职开始日期")
    private String startHireDate;

    @Pattern(regexp = "^((((1[6-9]|[2-9]\\d)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|(((1[6-9]|[2-9]\\d)\\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\\d|30))|(((1[6-9]|[2-9]\\d)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-))$", message = "endHireDate内容不正确")
    @Schema(description = "入职截止日期")
    private String endHireDate;

    @Pattern(regexp = "^((((1[6-9]|[2-9]\\d)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|(((1[6-9]|[2-9]\\d)\\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\\d|30))|(((1[6-9]|[2-9]\\d)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-))$", message = "startLoginDate内容不正确")
    @Schema(description = "最近登录开始日期")
    private String startLoginDate;

    @Pattern(regexp = "^((((1[6-9]|[2-9]\\d)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|(((1[6-9]|[2-9]\\d)\\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\\d|30))|(((1[6-9]|[2-9]\\d)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-))$", message = "endLoginDate内容不正确")
    @Schema(description = "最近登录截止日期")
    private String endLoginDate;

    @Pattern(regexp = "^[a-zA-Z0-9\\u4e00-\\u9fa5]{2,10}$", message = "role内容不正确")
    @Schema(description = "角色")
    private String role;

    @NotNull(message = "page不能为空")
    @Min(value = 1, message = "page不能小于1")
    @Schema(description = "页数")
    private Integer page;

    @NotNull(message = "length不能为空")
    @Range(min = 10, max = 50, message = "length必须在10~50之间")
    @Schema(description = "每页记录数")
    private Integer length;


}
