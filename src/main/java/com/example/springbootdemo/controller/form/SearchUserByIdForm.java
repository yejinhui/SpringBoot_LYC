/**
 * 包名称：com.example.springbootdemo.controller.form
 * 类名称：SearchUserByIdForm
 * 类描述：根据Id查询用户信息
 * 创建人：@author 六叶草
 * 创建时间：2023年06月22日 14:34
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
 * 创建时间:  2023年06月22日 14:34
 * 项目名称:  SpringBootDemo
 * 文件名称:  SearchUserByIdForm
 * 文件描述:  @Description: 根据Id查询用户信息
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Data
@Schema(description = "根据Id查询用户信息")
public class SearchUserByIdForm {

    @NotNull(message = "id不能为空")
    @Min(value = 1, message = "id不能小于1")
    @Schema(description = "用户ID")
    private Integer id;



}
