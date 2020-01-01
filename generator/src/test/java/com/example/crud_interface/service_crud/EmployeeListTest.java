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

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wuchengxing
 * @version 1.0
 * @date 2019/12/25 11:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class EmployeeListTest {

    @Autowired
    private IEmployeeService employeeService;

    private QueryWrapper<Employee> queryWrapper = Wrappers.query();

    private LambdaQueryWrapper<Employee> lambdaQueryWrapper = Wrappers.lambdaQuery();

    /**
     * 查询所有，返回一个list集合
     */
    @Test
    public void listTest() {
        List<Employee> employees = employeeService.list();
        employees.forEach(System.out::println);
    }

    /**
     * 通过条件查询
     */
    @Test
    public void listByWrapperTest() {
        queryWrapper.like("emp_addr", "南昌");
        List<Employee> employees = employeeService.list(queryWrapper);
        employees.forEach(System.out::println);
    }


    /**
     * 通过id 集合来查询
     */
    @Test
    public void listByIdsTest() {
        List<Employee> employees = employeeService.listByIds(Arrays.asList(7L, 8L, 9L));
        employees.forEach(System.out::println);
    }

    /**
     * 通过map 指定参数和条件进行查找
     */
    @Test
    public void listByMapTest() {
        Map<String, Object> map = new HashMap<>();
        map.put("emp_age", 15);
        List<Employee> employees = employeeService.listByMap(map);
        employees.forEach(System.out::println);
    }


    /**
     * 查询所有，返回一个list集合，里面的对象转换成map集合
     */
    @Test
    public void listMapsTest() {
        List<Map<String, Object>> list = employeeService.listMaps();
        list.forEach(System.out::println);
    }

    /**
     * 返回所有的记录：所有id的集合
     */
    @Test
    public void listObjsTest() {
        List<Object> list = employeeService.listObjs();
        list.forEach(System.out::println);
    }

    @Test
    public void listObjsByMapper() {
        List<Object> o = employeeService.listObjs(m -> {
            lambdaQueryWrapper.lt(Employee::getEmpAge, 30);
            List<Employee> employees = employeeService.list(lambdaQueryWrapper);
            return employees;
        });
        System.out.println(o.get(0));
    }


}