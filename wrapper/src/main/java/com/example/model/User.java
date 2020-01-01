package com.example.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author wuchengxing
 * @version 1.0
 * @date 2019/12/23 16:53
 */
@Data
// 对应的数据库表名
@TableName("user")
public class User extends Model<User> {

    private static final long serialVersionUID = 6511406791411005831L;
    /**
     * 主键
     * @TableId： 指定是数据库中的主键
     */
    @TableId
    private Long id;

    /**
     * 用户名称
     * @TableField: 指定与数据库中的哪个字段对应
     */
    @TableField("name")
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 主管id
     */
    private Long managerId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * transient: 不加入序列化，不会跟表映射
     * static：也不加入映射
     * @TableField(exist = false): 也可以不加入数据库
     *
     */
    @TableField(exist = false)
    private String remark;
}
