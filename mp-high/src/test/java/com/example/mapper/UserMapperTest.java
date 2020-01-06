package com.example.mapper;

import com.example.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author wcx
 * @date 2020/1/5 21:33
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void deleteByIdTest(){
        int rows = userMapper.deleteById(1094592041087729666L);
        System.out.println("受影响行数：" + rows);
    }

    @Test
    public void selectTest() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void updateTest() {
        User user = new User();
        user.setId(1088248166370832385L);
        user.setAge(31);
        user.setUpdateTime(LocalDateTime.now());
        int rows = userMapper.updateById(user);
        System.out.println("受影响行数：" + rows);
    }

    @Test
    public void fillInsertTest() {
        User user = new User();
        user.setId(1094592041087729667L);
        user.setName("刘朝明");
        user.setAge(26);
        user.setEmail("lcm@baomidou.cn");
        user.setManagerId(1094590409767661570L);
        user.setVersion(1);
        int rows = userMapper.insert(user);
        System.out.println("受影响行数：" + rows);
    }

}