/**
 * 包名称：com.example.springbootdemo.controller.form
 * 类名称：PageInfoForm
 * 类描述：传递的页面路径
 * 创建人：@author 六叶草
 * 创建时间：2023年05月29日 10:10
 */
package com.example.springbootdemo.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年05月29日 10:10
 * 项目名称:  SpringBootDemo
 * 文件名称:  PageInfoForm
 * 文件描述:  @Description: 传递的页面路径
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Data
@Schema(description = "传递的页面路径")
public class PageInfoForm {

    @NotBlank(message = "Page不能为空")
    @Schema(description = "页面路径")
    private String page;

}
