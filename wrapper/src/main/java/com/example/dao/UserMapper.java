package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wuchengxing
 * @version 1.0
 * @date 2019/12/23 16:55
 */
@Mapper
public interface UserMapper extends BaseMapper <User>{

}
