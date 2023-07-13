package com.example.springbootdemo.db.pojo;

import java.io.Serializable;
import lombok.Data;

/**
* 管理页面抬头内容
* @TableName sys_admin_col
*/
@Data
public class SysAdminCol implements Serializable {

    /**
    * 主键
    */
    private Integer id;
    /**
    * 标题名称
    */
    private String titleName;
    /**
    * 小标题
    */
    private String smallName;
    /**
     * 小标题链接
     */
    private String smallLink;
    /**
    * 链接
    */
    private String link;
    /**
    * 关闭图标
    */
    private String icon;
    /**
    * 打开图标
    */
    private String smallIcon;
    /**
    * 描述
    */
    private String desc;
    /**
    * 状态
    */
    private Integer status;
    /**
    * 排序
    */
    private Integer sortId;


}
