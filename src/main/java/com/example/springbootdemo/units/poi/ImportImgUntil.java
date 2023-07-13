/**
 * 包名称：com.example.springbootdemo.units.poi
 * 类名称：ImportImgUntil
 * 类描述：导入图片工具类
 * 创建人：@author 六叶草
 * 创建时间：2023年07月05日 16:11
 */
package com.example.springbootdemo.units.poi;

import com.example.springbootdemo.common.R;
import com.example.springbootdemo.exception.HuiException;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年07月05日 16:11
 * 项目名称:  SpringBootDemo
 * 文件名称:  ImportImgUntil
 * 文件描述:  @Description: 导入图片工具类
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Component
public class ImportImgUntil {

    public String imgName(MultipartFile file) throws IOException {
        return importImgStatic(file);
    }

    /**
     * @Author 六叶草
     * @Description //导入到项目下的static文件中
     * @Date 2023/7/6 14:15
     **/
    public String importImgStatic(MultipartFile file) throws FileNotFoundException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("/yyyy-MM-dd/");
        //取得文件名称
        String filename = file.getOriginalFilename();
        if (!filename.endsWith(".png") && !filename.endsWith(".jpg") && !filename.endsWith(".gif")) {
            throw new HuiException("文件类型不对");
        }
        String format = dateFormat.format(new Date());

        //tarPath为文件保存的位置(缓存)
        String tarPath = ResourceUtils.getURL("classpath:").getPath() + "static/img" + format;
        tarPath = tarPath.substring(1);//去掉第一个/符号
        File pathder = new File(tarPath);
        if (!pathder.exists()) {
            pathder.mkdirs();
        }
        String pathName;
        if (filename.endsWith(".png")) {
            pathName = UUID.randomUUID().toString() + ".png";
        } else if (filename.endsWith(".jpg")) {
            pathName = UUID.randomUUID().toString() + ".jpg";
        } else {
            pathName = UUID.randomUUID().toString() + ".gif";
        }
        try {
            //新建文件
            file.transferTo(new File(pathder, pathName));
        } catch (IOException e) {
            //新建文件失败
            throw new HuiException("系统异常，请联系管理！创建文件失败！" + e.getMessage());
        }

        //realPath为文件保存的位置(项目地址)
        String realPath = ResourceUtils.getURL("src/main/resources/static/img").getPath();

        //去掉第一个/符号
        realPath = realPath.substring(1);
        //去掉第一个/符号
        format = format.substring(1);
        realPath = realPath + format;
        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        //将文件复制到对应的路径中
        try {
            int bytesum = 0;
            int byteread = 0;
            File oldfile = new File(tarPath + pathName);
            if (oldfile.exists()) { //文件存在时
                InputStream inStream = new FileInputStream(tarPath + pathName); //读入原文件
                FileOutputStream fs = new FileOutputStream(realPath + pathName);
                byte[] buffer = new byte[1444];
                while ((byteread = inStream.read(buffer)) != -1) {
                    bytesum += byteread; //字节数 文件大小
                    fs.write(buffer, 0, byteread);
                }
                inStream.close();
                fs.close();
            }
        }catch (IOException e){
            throw new HuiException("系统异常，请联系管理！复制文件错误！"+e.getMessage());
        }
        return format + pathName;
    }


}
