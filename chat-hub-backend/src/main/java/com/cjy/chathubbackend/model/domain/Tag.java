package com.cjy.chathubbackend.model.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @TableName tag
 */
@TableName(value = "tag")
@Data
public class Tag implements Serializable {
    /**
     * 标签id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 标签名称
     */
    private String tagName;

    /**
     * 定义标签的用户
     */
    private Long userId;

    /**
     * 父标签id
     */
    private Long parentId;

    /**
     * 是否为父标签
     * 0 - 不是
     * 1 - 是
     */
    private Integer isParent;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 逻辑删除
     */
    @TableLogic
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
