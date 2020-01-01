package com.example.dao;

import com.example.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.*;


/**
 * @author wuchengxing
 * @version 1.0
 * @date 2019/12/23 16:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    /**
     * @param
     * @return void
     * @author wuchengxing
     * @date 2019/12/24/9:35
     * <p>
     * 查询所有，selectList可以传入指定条件
     */
    @Test
    public void testFindAll() {
        List<User> users = userMapper.selectList(null);
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * @param
     * @return void
     * @author wuchengxing
     * @date 2019/12/24/9:36
     * <p>
     * 保存一个用户
     */
    @Test
    public void testSave() {
        User user = new User();
        // user.setId(1088248166378832385L);
        user.setAge(22);
        user.setManagerId(1088248166378832385L);
        user.setName("whl");
        user.setCreateTime(LocalDateTime.now());
        int i = userMapper.insert(user);
        log.info("插入成功", i);
    }

    /**
     * @param
     * @return void
     * @author wuchengxing
     * @date 2019/12/24/9:36
     * <p>
     * 通过id查找一个用户
     */
    @Test
    public void testFindById() {
        User user = userMapper.selectById(1088248166378832385L);
        System.out.println(user);
    }

    /**
     * @param
     * @return void
     * @author wuchengxing
     * @date 2019/12/24/9:37
     * <p>
     * 通过id集合 批量查询
     */
    @Test
    public void testFindByIds() {
        List<Long> ids = Arrays.asList(1088248166370832385L, 1088248166378832385L, 1088250446457389058L);
        List<User> users = userMapper.selectBatchIds(ids);
        users.forEach(System.out::println);

    }

    /**
     * @param
     * @return void
     * @author wuchengxing
     * @date 2019/12/24/9:37
     *
     * 通过传入一个map进行条件查询
     * map 前面的 age 是数据库中的字段名
     */
    @Test
    public void testSelectByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("age", 35);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);

    }

}