package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wcx
 * @date 2020/1/5 21:09
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
