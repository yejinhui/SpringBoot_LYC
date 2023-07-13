/**
 * 包名称：com.example.springbootdemo.units.poi
 * 类名称：StatusConverter
 * 类描述：状态转换器
 * 创建人：@author 六叶草
 * 创建时间：2023年07月04日 10:47
 */
package com.example.springbootdemo.units.poi;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.converters.ReadConverterContext;
import com.alibaba.excel.converters.WriteConverterContext;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.data.WriteCellData;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年07月04日 10:47
 * 项目名称:  SpringBootDemo
 * 文件名称:  StatusConverter
 * 文件描述:  @Description: 状态转换器
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
public class StatusConverter implements Converter<Integer> {

    @Override
    public Class<?> supportJavaTypeKey() {
        return Integer.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public Integer convertToJavaData(ReadConverterContext<?> context) {
        return StatusEnum.convert(context.getReadCellData().getStringValue()).getValue();
    }

    @Override
    public WriteCellData<?> convertToExcelData(WriteConverterContext<Integer> context) {
        return new WriteCellData<>(StatusEnum.convert(context.getValue()).getDescription());
    }
}
