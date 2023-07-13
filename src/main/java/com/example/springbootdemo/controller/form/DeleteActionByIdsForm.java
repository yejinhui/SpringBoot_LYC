/**
 * 包名称：com.example.springbootdemo.controller.form
 * 类名称：DeleteActionByIdsForm
 * 类描述：根据Id删除功能信息
 * 创建人：@author 六叶草
 * 创建时间：2023年07月08日 10:31
 */
package com.example.springbootdemo.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年07月08日 10:31
 * 项目名称:  SpringBootDemo
 * 文件名称:  DeleteActionByIdsForm
 * 文件描述:  @Description: 根据Id删除功能信息
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Data
@Schema(description = "根据Id删除功能信息")
public class DeleteActionByIdsForm {

    @NotNull(message = "id不能为空")
    @Schema(description = "功能ID")
    private Integer[] ids;


}
