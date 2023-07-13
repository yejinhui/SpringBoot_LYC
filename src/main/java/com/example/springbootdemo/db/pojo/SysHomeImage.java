package com.example.springbootdemo.db.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
*
* @TableName sys_home_image
*/
@Data
public class SysHomeImage implements Serializable {

    /**
    * 主键
    */
    private Integer id;
    /**
    * 图片链接
    */
    private String imgLink;
    /**
    * 图片描述
    */
    private String desc;
    /**
    * 唯一的键
    */
    private String onlyPre;
    /**
    * 跳转链接
    */
    private String url;
    /**
     * 状态
     */
    private Integer status;
    /**
    * 排序
    */
    private Integer sortId;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 点击按钮
     */
    private String butCon;
    /**
     * 图片日期
     */
    private Date imgTime;

}
