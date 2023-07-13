package com.example.springbootdemo.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
* 用户Form表
* @TableName sys_user用户资料实体类
*/
@Data
@Schema(description = "注册表单类")
public class SysUserForm implements Serializable {

    /**
    * 编号
    */
    @NotBlank(message = "code不能为空")
    @Schema(description = "编号")
    private String code;
    /**
    * 昵称
    */
    @NotBlank(message = "nickname不能为空")
    @Pattern(regexp = "^[a-zA-Z0-9\\u4e00-\\u9fa5]{2,10}$",message = "nickname内容不正确")
    @Schema(description = "昵称")
    private String nickname;
    /**
    * 头像网址
    */
    @NotBlank(message = "photo不能为空")
    @Schema(description = "头像网址")
    private String photo;
    /**
    * 姓名
    */
    @NotBlank(message = "name不能为空")
    @Pattern(regexp = "^[\\u4e00-\\u9fa5]{2,20}$",message = "name内容不正确")
    @Schema(description = "真实姓名")
    private String name;
    /**
     * 姓名
     */
    @NotBlank(message = "userName不能为空")
    @Pattern(regexp = "^[a-zA-Z0-9\\u4e00-\\u9fa5]{2,10}$",message = "userName内容不正确")
    @Schema(description = "用户名")
    private String userName;
    /**
    * 性别
    */
    @NotBlank(message = "sex不能为空")
    @Schema(description = "性别")
    private String sex;
    /**
    * 手机号码
    */
    @NotBlank(message = "tel不能为空")
    @Pattern(regexp = "^1[0-9]{10}$",message = "tel内容不正确")
    @Schema(description = "联系电话")
    private String tel;
    /**
    * 邮箱
    */
    @NotBlank(message = "email不能为空")
    @Pattern(regexp = "^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((.[a-zA-Z0-9_-]{2,3}){1,2})$",message = "email内容不正确")
    @Schema(description = "邮箱")
    private String email;
    /**
    * 生日日期
    */
    @NotBlank(message = "birthday不能为空")
    @Schema(description = "生日日期")
    private Date birthday;
    /**
    * 入职日期
    */
    @NotBlank(message = "hiredate不能为空")
    @Schema(description = "入职日期")
    private Date hiredate;
    /**
    * 部门
    */
    @NotBlank(message = "deptName不能为空")
    @Schema(description = "部门")
    private String deptName;
    /**
    * 状态
    */
    @NotBlank(message = "status不能为空")
    @Schema(description = "状态")
    private Byte status;
    /**
    * 创建时间
    */
    @NotBlank(message = "createTime不能为空")
    @Schema(description = "创建时间")
    private Date createTime;
    /**
    * 最新上线时间
    */
    @NotBlank(message = "loginTime不能为空")
    @Schema(description = "最新上线时间")
    private Date loginTime;
    /**
     * 最新更新密码的时间
     */
    @NotBlank(message = "updateTime不能为空")
    @Schema(description = "最新更新密码的时间")
    private Date updateTime;
    /**
    * 所属公司
    */
    @NotBlank(message = "companyName不能为空")
    @Schema(description = "所属公司")
    private String companyName;


}
