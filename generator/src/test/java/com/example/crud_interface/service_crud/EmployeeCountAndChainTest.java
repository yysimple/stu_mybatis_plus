package com.example.crud_interface.service_crud;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.example.crud_interface.entity.Employee;
import com.example.crud_interface.mapper.EmployeeMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


/**
 * @author wuchengxing
 * @version 1.0
 * @date 2019/12/25 11:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class EmployeeCountAndChainTest {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private EmployeeMapper employeeMapper;

    private QueryWrapper<Employee> queryWrapper = Wrappers.query();

    private LambdaQueryWrapper<Employee> lambdaQueryWrapper = Wrappers.lambdaQuery();



    /**
     * 通过Id 查找到一条记录
     */
    @Test
    public void countTest() {
        int count = employeeService.count();
        System.out.println(count);
    }

    @Test
    public void countByWrapperTest() {
        lambdaQueryWrapper.lt(Employee::getEmpAge, 28);
        int count = employeeService.count(lambdaQueryWrapper);
        System.out.println(count);
    }

    @Test
    public void QueryChainWrapperTest() {
        /*QueryChainWrapper<Employee> chainWrapper = new QueryChainWrapper<Employee>(employeeMapper);
        chainWrapper.eq("emp_age","15");
        List<Employee> list = employeeService.list(chainWrapper);
        list.forEach(System.out::println);*/
    }






}