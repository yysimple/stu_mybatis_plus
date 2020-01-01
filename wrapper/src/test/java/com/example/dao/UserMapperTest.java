package com.example.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author wuchengxing
 * @version 1.0
 * @date 2019/12/24 9:33
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    private QueryWrapper<User> queryWrapper = Wrappers.query();

    private LambdaQueryWrapper<User> lambdaQueryWrapper = Wrappers.lambdaQuery();


    /**
     * @param
     * @return void
     * @author wuchengxing
     * @date 2019/12/24/10:13
     * <p>
     * 名字中包含雨并且年龄小于40
     * name like '%雨%' and age<40
     */
    @Test
    public void testWrapper1() {
        queryWrapper.like("name", "雨").lt("age", 40);
        out(queryWrapper);
    }

    /**
     * @param
     * @return void
     * @author wuchengxing
     * @date 2019/12/24/10:14
     * <p>
     * 名字中包含雨年并且龄大于等于20且小于等于40并且email不为空
     * name like '%雨%' and age between 20 and 40 and email is not null
     */
    @Test
    public void testWrapper2() {
        queryWrapper.like("name", "雨").between("age", 30, 35).isNotNull("email");
        out(queryWrapper);
    }

    /**
     * @param
     * @return void
     * @author wuchengxing
     * @date 2019/12/24/10:16
     * <p>
     * 名字为王姓或者年龄大于等于25，按照年龄降序排列，年龄相同按照id升序排列
     * name like '王%' or age>=25 order by age desc,id asc
     */
    @Test
    public void testWrapper3() {
        queryWrapper.likeRight("name", "王").or()
                .gt("age", 25)
                .orderByDesc("age")
                .orderByAsc("id");
        out(queryWrapper);
    }

    /**
     * @param
     * @return void
     * @author wuchengxing
     * @date 2019/12/24/10:21
     * <p>
     * 创建日期为2019年2月14日并且直属上级为名字为王姓
     * date_format(create_time,'%Y-%m-%d')='2019-02-14' and manager_id in (select id from user where name like '王%')
     */
    @Test
    public void testWrapper4() {
        queryWrapper.apply("date_format(create_time,'%Y-%m-%d') = {0}", "2019-02-14")
                .inSql("manager_id", "select id from user where name like '王%'");
        out(queryWrapper);
    }

    /**
     * @param
     * @return void
     * @author wuchengxing
     * @date 2019/12/24/11:26
     * <p>
     * 名字为王姓并且（年龄小于40或邮箱不为空）
     * name like '王%' and (age<40 or email is not null)
     */
    @Test
    public void testWrapper5() {
        queryWrapper.likeRight("name", "王")
                .and(queryWrapper1 -> queryWrapper1.lt("age", 40).or().isNotNull("email"));
        out(queryWrapper);
    }

    /**
     * @param
     * @return void
     * @author wuchengxing
     * @date 2019/12/24/11:30
     * <p>
     * 名字为王姓或者（年龄小于40并且年龄大于20并且邮箱不为空）
     * name like '王%' or (age<40 and age>20 and email is not null)
     */
    @Test
    public void testWrapper6() {
        queryWrapper.likeRight("name", "王")
                .or(queryWrapper1 -> queryWrapper1.lt("age", 40).gt("age", 25).isNotNull("email"));
        out(queryWrapper);
    }

    /**
     * @param
     * @return void
     * @author wuchengxing
     * @date 2019/12/24/11:33
     * <p>
     * （年龄小于40或邮箱不为空）并且名字为王姓
     * (age<40 or email is not null) and name like '王%'
     */
    @Test
    public void testWrapper7() {
        queryWrapper.nested(queryWrapper1 -> queryWrapper1.lt("age", 40).isNotNull("email"))
                .likeRight("name", "王");

        out(queryWrapper);
    }

    /**
     * @param
     * @return void
     * @author wuchengxing
     * @date 2019/12/24/11:36
     * <p>
     * 年龄为30、31、34、35
     * age in (30、31、34、35)
     */
    @Test
    public void testWrapper8() {
        queryWrapper.in("age", Arrays.asList(30, 31, 32, 33));
        out(queryWrapper);
    }

    /**
     * @param
     * @return void
     * @author wuchengxing
     * @date 2019/12/24/11:41
     * <p>
     * limit 1
     */
    @Test
    public void testWrapper9() {
        queryWrapper.in("age", Arrays.asList(30, 31, 32, 33)).last("limit 1");
        out(queryWrapper);
    }


    /**
     * @param
     * @return void
     * @author wuchengxing
     * @date 2019/12/24/11:48
     * <p>
     * 1. 只需要指定的字段，直接选用
     * <p>
     * 2. 排除一些字段
     * <p>
     * 第一种情况：select id,name
     * from user
     * where name like '%雨%' and age<40
     * 第二种情况：select id,name,age,email
     * from user
     * where name like '%雨%' and age<40
     */
    @Test
    public void testWrapperSuper1() {
        queryWrapper.select("id", "name").like("name", "雨").lt("age", 40);
        out(queryWrapper);
    }

    @Test
    public void testWrapperSuper2() {
        queryWrapper.like("name", "雨").lt("age", 40)
                .select(User.class, user -> !user.getColumn().equals("create_time") &&
                        !user.getColumn().equals("manager_id"));
        out(queryWrapper);
    }

    /**
     * 通过 condition 来判断要不要将where条件执行
     */
    @Test
    public void testCondition() {
        String name = "王";
        String email = "";
        condition(name, email);
    }

    public void condition(String name, String email) {
        queryWrapper.like(StringUtils.isNotEmpty(name), "name", name)
                .like(StringUtils.isNotEmpty(email), "email", email);
        out(queryWrapper);
    }


    /**
     * allEq(Map<R, V> params)
     * allEq(Map<R, V> params, boolean null2IsNull)
     * allEq(boolean condition, Map<R, V> params, boolean null2IsNull)
     */
    @Test
    public void selectByWrapperAllEq() {
        Map<String, Object> params = new HashMap<>();
        params.put("name", "王天风");
        params.put("age", null);
        queryWrapper.allEq((k, v) -> !k.equals("age"), params);
        out(queryWrapper);
    }

    /**
     * 使用Lambda的Wrapper可以防止写错，导致数据查不出来
     */
    @Test
    public void selectLambda() {
        lambdaQueryWrapper.like(User::getName, "雨").lt(User::getAge, 40);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        users.forEach(System.out::println);
    }

    /**
     * @param
     * @return void
     * @author wuchengxing
     * @date 2019/12/24/14:48
     * <p>
     * 进行分页查找
     */
    @Test
    public void testSelectPage() {
        queryWrapper.ge("age", 25);
        Page<User> page = new Page(1, 2);
        IPage<User> iPage = userMapper.selectPage(page, queryWrapper);
        System.out.println("总记录数： " + iPage.getTotal());
        System.out.println("总页数：:  " + iPage.getPages());
        System.out.println(iPage.getRecords());
    }


    @Test
    public void testUpdate() {
        queryWrapper.like("name", "王");
        User user = userMapper.selectOne(queryWrapper);
        user.setAge(35);
        // Long id = user.getId();
        int rows = userMapper.updateById(user);
        System.out.println("受影响数： " + rows);
    }

    /**
     * @param
     * @return void
     * @author wuchengxing
     * @date 2019/12/24/17|:05
     * <p>
     * 更新操作
     */
    @Test
    public void updateByWrapper1() {
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("name", "李艺伟").eq("age", 28);
        User user = new User();
        user.setEmail("lyw2019@baomidou.com");
        user.setAge(29);
        int rows = userMapper.update(user, userUpdateWrapper);
        System.out.println("受影响数： " + rows);
    }

    @Test
    public void updateByWrapper2() {
        User whereUser = new User();
        whereUser.setName("李艺伟");
        // 直接往构造器里面传值
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>(whereUser);
        // 加了这个会在sql里面出现两次名字
        // updateWrapper.eq("name", "李艺伟").eq("age", 28);
        User user = new User();
        user.setEmail("lyw2019@baomidou.com");
        user.setAge(29);
        int rows = userMapper.update(user, updateWrapper);
        System.out.println("受影响数： " + rows);
    }

    @Test
    public void updateByWrapper3() {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("name", "李艺伟").eq("age", 28)
                .set("age", 29);
        int rows = userMapper.update(null, updateWrapper);
        System.out.println("受影响数： " + rows);
    }

    /**
     * lambda 表达式
     */
    @Test
    public void updateByWrapper4() {
        LambdaUpdateWrapper<User> userLambdaUpdateWrapper = Wrappers.<User>lambdaUpdate();
        userLambdaUpdateWrapper.eq(User::getName, "李艺伟").eq(User::getAge, 29)
                .set(User::getAge, 39);
        int rows = userMapper.update(null, userLambdaUpdateWrapper);
        System.out.println("受影响数： " + rows);
    }

    @Test
    public void deleteById() {
        int rows = userMapper.deleteById(1209285142158327809L);
        System.out.println("删除的行数： " + rows);
    }

    @Test
    public void deleteByMaps(){
        Map<String, Object> map = new HashMap<>();
        map.put("name", "陈龙");
        map.put("age", 30);
        int rows = userMapper.deleteByMap(map);
        System.out.println("删除的行数： " + rows);
    }


    public void out(QueryWrapper<User> queryWrapper) {
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }


}