package com.example.dao;

import com.example.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

/**
 * @author wuchengxing
 * @version 1.0
 * @date 2019/12/24 21:26
 *
 *
 * 根据类的活动记录来进行操作
 * 一个实例就是数据库表中的一条记录
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ARtest {

    /**
     * @param
     * @return void
     * @author wuchengxing
     * @date 2019/12/24/21:30
     * 插入操作
     */
    @Test
    public void insertTest() {
        User user = new User();
        user.setName("张华");
        user.setEmail("zh@baomidou.com");
        user.setAge(18);
        user.setManagerId(1088248166370832385L);
        user.setCreateTime(LocalDateTime.now());
        boolean insert = user.insert();
        System.out.println(insert);
    }


    /**
     * 根据id查询
     */
    @Test
    public void selectById1(){
        User user = new User();
        User user1 = user.selectById(1209466803259080705L);
        System.out.println(user == user1);
        System.out.println(user1);
    }

    /**
     * 这是操作一个对象
     */
    @Test
    public void selectById2(){
        User user = new User();
        user.setId(1209466803259080705L);
        User user1 = user.selectById();
        System.out.println(user == user1);
        System.out.println(user1);
    }

    @Test
    public void deleteById(){
        User user = new User();
        user.setId(1209468821902135297L);
        boolean delete = user.deleteById();
        System.out.println(delete);
    }

    @Test
    public void update(){
        User user = new User();
        user.setId(1209466803259080705L);
        user.setAge(50);
        boolean update = user.updateById();
        System.out.println(update);
    }

    @Test
    public void insertOrUpdate(){
        User user = new User();
        user.setId(1209468964617478145L);
        user.setName("大华");
        user.setEmail("dh@baomidou.com");
        user.setAge(18);
        user.setManagerId(1088248166370832385L);
        user.setCreateTime(LocalDateTime.now());
        boolean insert = user.insertOrUpdate();
        System.out.println(insert);
    }


}


