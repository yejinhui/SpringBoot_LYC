package com.example.springbootdemo.units.poi;/**
 * 包名称：com.example.springbootdemo.units.poi
 * 类名称：StatusEnum
 * 类描述：状态枚举
 * 创建人：@author 六叶草
 * 创建时间：2023年07月04日 10:49
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年07月04日 10:49
 * 项目名称:  SpringBootDemo
 * 文件名称:  StatusEnum
 * 文件描述:  @Description: 状态枚举
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Getter
@AllArgsConstructor
public enum StatusEnum {


    /**
     * 未知
     */
    UNKNOWN(1, "有效"),

    /**
     * 男性
     */
    MALE(1, "有效"),

    /**
     * 女性
     */
    FEMALE(0, "无效");

    private final Integer value;

    @JsonFormat
    private final String description;

    public static StatusEnum convert(Integer value) {
        return Stream.of(values())
                .filter(bean -> bean.value.equals(value))
                .findAny()
                .orElse(UNKNOWN);
    }

    public static StatusEnum convert(String description) {
        return Stream.of(values())
                .filter(bean -> bean.description.equals(description))
                .findAny()
                .orElse(UNKNOWN);
    }

}
