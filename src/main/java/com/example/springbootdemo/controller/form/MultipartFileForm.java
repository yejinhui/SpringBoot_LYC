/**
 * 包名称：com.example.springbootdemo.controller.form
 * 类名称：MultipartFileForm
 * 类描述：多参数上传图片
 * 创建人：@author 六叶草
 * 创建时间：2023年06月23日 13:59
 */
package com.example.springbootdemo.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年06月23日 13:59
 * 项目名称:  SpringBootDemo
 * 文件名称:  MultipartFileForm
 * 文件描述:  @Description: 多参数上传图片
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Data
@Schema(pattern = "多参数上传图片")
public class MultipartFileForm {

    @NotBlank(message = "图片数据不能为空")
    @Schema(description = "图片格式")
    private MultipartFile file;

    @NotNull(message = "id不能为空")
    @Schema(description = "编号")
    private Integer id;

}
