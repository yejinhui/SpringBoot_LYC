package com.example.springbootdemo.db.pojo;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import lombok.Data;

/**
*
* @TableName sys_col页面数据实体类
*/
@Data
public class SysCol implements Serializable {

    /**
    * 主键
    */
    private Integer id;
    /**
    * 字段
    */
    private String fname;
    /**
    * 标题
    */
    private String title;
    /**
     * 序号
     */
    private String item;
    /**
    * 描述
    */
    private String desc;
    /**
    * 图片
    */
    private String img;
    /**
    * 链接
    */
    private String link;
    /**
    * 内容
    */
    private String col;
    /**
    * 标题栏级别（1表头2页体内容3页脚）
    */
    private String grade;
    /**
     * 排序
     */
    private String order;
    /**
     * 父Id
     */
    private Integer parentId;
    /**
    * 内容级别（1是内容2内容下一级3内容下下级。。。。）
    */
    private String rank;
    /**
    * 外链id
    */
    private Integer linkId;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
     * 是否有效
     */
    private Integer status;

    /**
     * 子菜单
     */
    private ArrayList<SysCol> colChild;


}
