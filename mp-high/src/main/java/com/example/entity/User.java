package com.example.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author wcx
 * @date 2020/1/5 21:09
 */
@Data
public class User {

    // @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String name;

    private Integer age;

    private String email;

    private Long managerId;

    // 自动填充 插入时
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    // 更新时
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    private Integer version;

    // 逻辑删除字段
    @TableLogic()
    // 查询时逻辑删除字段不会查出
    @TableField(select = false)
    private Integer deleted;
}
