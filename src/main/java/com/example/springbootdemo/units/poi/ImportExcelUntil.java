/**
 * 包名称：com.example.springbootdemo.units.poi
 * 类名称：ImportExcelUntil
 * 类描述：导入工具栏
 * 创建人：@author 六叶草
 * 创建时间：2023年07月04日 10:21
 */
package com.example.springbootdemo.units.poi;

import com.example.springbootdemo.common.R;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年07月04日 10:21
 * 项目名称:  SpringBootDemo
 * 文件名称:  ImportExcelUntil
 * 文件描述:  @Description: 导入工具栏
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Component
public class ImportExcelUntil {

    public String excelName(MultipartFile file) throws FileNotFoundException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("/yyyy-MM-dd/");
        String filename = file.getOriginalFilename();//取得文件名称
        if (!filename.endsWith(".xls") && !filename.endsWith(".xlsx")) {
            return "文件类型不对";
        }
        String format = dateFormat.format(new Date());
        //realPath为文件保存的位置
        String realPath = ResourceUtils.getURL("src/main/resources/static/excel").getPath();
        realPath = realPath.substring(1);//去掉第一个/符号
        format = format.substring(1);//去掉第一个/符号
        realPath = realPath + format;
        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String newName;
        if (filename.endsWith(".xls")){
            newName = UUID.randomUUID().toString() + ".xls";
        }else {
            newName = UUID.randomUUID().toString() + ".xlsx";
        }
        try {
            //新建文件
            file.transferTo(new File(folder, newName));
        } catch (IOException e) {
            //新建文件失败
            return "系统异常，请联系管理！"+e.getMessage();
        }
        return realPath + newName;
    }



}
