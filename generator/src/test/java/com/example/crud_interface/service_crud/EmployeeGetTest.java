package com.example.crud_interface.service_crud;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.crud_interface.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.*;

/**
 * @author wuchengxing
 * @version 1.0
 * @date 2019/12/25 11:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class EmployeeGetTest {

    @Autowired
    private IEmployeeService employeeService;

    private QueryWrapper<Employee> queryWrapper = Wrappers.query();

    private LambdaQueryWrapper<Employee> lambdaQueryWrapper = Wrappers.lambdaQuery();


    /**
     * 通过Id 查找到一条记录
     */
    @Test
    public void getByIdTest() {
        Employee employee = employeeService.getById(1L);
        System.out.println(employee);
    }

    /**
     * 始终这个方法的时候需要注意，getOne返回的是一条记录：
     * SELECT emp_id,emp_name,emp_age,emp_birthday,emp_addr,emp_phone FROM employee WHERE (emp_age >= ?)
     * 所以需要通过id指定，或者 .last("limit 1") 随机取一条数据
     */
    @Test
    public void getOneTest01() {
        queryWrapper.ge("emp_age", 25)
                .last("limit 1");
        Employee employee = employeeService.getOne(queryWrapper);
        System.out.println(employee);
    }

    /**
     * 这是另一种情况：
     * 当返回值有多条是，将第二个参数改成false（默认情况下是true）
     * 会输出所有查询的第一条记录
     * 但是会出现警告：
     * WARNWarn: execute Method There are  6 results.
     */
    @Test
    public void getOneTest02() {
        queryWrapper.ge("emp_age", 18);
        // .last("limit 1");
        Employee employee = employeeService.getOne(queryWrapper, false);
        System.out.println(employee);
    }

    /**
     * 这种方式就是可以返回一个map
     */
    @Test
    public void getOneTest03() {
        queryWrapper.ge("emp_age", 18)
                .last("limit 1");
        Map<String, Object> map = employeeService.getMap(queryWrapper);
        System.out.println(map);
    }


    /**
     * <V> V getObj(Wrapper<T> queryWrapper, Function<? super Object, V> mapper);
     */
    @Test
    public void getOneTest04() {
        queryWrapper.ge("emp_age", 18);
        boolean b = employeeService.getObj(queryWrapper, (m) -> {
            Employee employee = employeeService.getById((Long)m);
            employee.setEmpPhone("-----");
            boolean flag = employeeService.updateById(employee);
            return flag;
        });
        System.out.println(b);
    }


}