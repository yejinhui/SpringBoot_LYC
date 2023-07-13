/**
 * 包名称：com.example.springbootdemo.units
 * 类名称：SnSgUntils
 * 类描述：生成流水号工具类
 * 创建人：@author 六叶草
 * 创建时间：2023年06月24日 15:04
 */
package com.example.springbootdemo.units;

import com.example.springbootdemo.exception.HuiException;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年06月24日 15:04
 * 项目名称:  SpringBootDemo
 * 文件名称:  SnSgUntils
 * 文件描述:  @Description: 生成流水号工具类
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@Component
public class SnSgUntils {

    /**
     * @Author 六叶草
     * @Description //根据传入的字符串进行加1处理
     * @Date 2023/6/24 16:25
     **/
    public String sfGenNum(String code,String dateTime,Integer numCount){
        if (dateTime == null) {
            String numStr = printNum();//数值字符串
            String str = printStr();//字符串
            Integer num = Integer.parseInt(numStr);//将numStr转成数值类型
            //获取numStr的长度
            int numStrLen = numStr.length();
            //获取num+1后的长度
            Integer num2 = num + 1;
            int numLen = num2.toString().length();
            if ( numLen > numStrLen) {
                throw new HuiException("字符串超出范围，请联系管理员！");
            }
            //将num2转成字符串类型
            String num3 = num2.toString();
            //不足补0
            String b = "0";
            if ((numStrLen-numLen) > 0) {
                for (int i = 0; i < (numStrLen-numLen); i++) {
                    str = str + b;
                }
                str = str+num3;
            }else{
                str = str+num3;
            }
            return str;
        }else {
            //将内容取反
            String str2=new StringBuilder(code).reverse().toString();
            //从第一位开始，截取到输入的位数，得出流水号
            String lshRe = StringUtils.substring(str2, 0, numCount);
            String lsh = new StringBuilder(lshRe).reverse().toString();
            //将lsh转成数值类型
            Integer num = Integer.parseInt(lsh);
            //获取流水号的长度
            int lshLen = lsh.length();
            //获取num+1后的长度
            Integer num2 = num + 1;
            int numLen = num2.toString().length();
            if ( numLen > lshLen) {
                throw new HuiException("字符串超出范围，请联系管理员！");
            }
            //将流水号转成字符串类型
            String num3 = num2.toString();
            //以下是日期转换
            String str4 = StringUtils.substring(str2,  numCount);
            String str = printStr();//字符串
            //将拿到日期字符串与字符串进行取反
            String strRe=new StringBuilder(str).reverse().toString();
            String strReDate = strRe + dateTime;
            //不足补0
            String b = "0";
            if ((lshLen-numLen) > 0) {
                for (int i = 0; i < (lshLen-numLen); i++) {
                    strReDate = strReDate + b;
                }
                strReDate = strReDate+num3;
            }else{
                strReDate = strReDate+num3;
            }
            return strReDate;
        }
    }

    private String s;

    public String[] getStr(){
        String[] str_string = s.split("\\d");//  \d 为正则表达式表示[0-9]数字
        return str_string;
    }

    public int[] getNum(){
        String[] num_string = s.split("\\D");  // \D 为正则表达式表示非数字
        String a = "";

        for(String m : num_string){
            a += m;
        }

        String[] num = a.split("");  //将分离出的重新保存在新数组num中不要直接用num_string，  因为在正则表达式对字符串进行选择时若前面的几个字符不符合要求但num_string数组中仍会存有其位置 是空格
        int[] inte = new int[num.length];

        for(int i =0; i < num.length; i++){
            inte[i] = Integer.parseInt(num[i]); //将该数组中的数字存入int数组
        }

        return inte;
    }
    //打印字符串中的字母
    public String printStr(){
        String a = "";
        for(String n : getStr()){
            a += n;
        }
        return a;
    }
    //打印字符串中的数字
    public String printNum(){
        String a = "";
        for(int n : getNum()){
            a += n;
        }
        return a;
    }
}
