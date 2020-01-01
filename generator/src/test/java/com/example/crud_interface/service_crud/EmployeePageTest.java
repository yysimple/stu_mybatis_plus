package com.example.crud_interface.service_crud;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
public class EmployeePageTest {

    @Autowired
    private IEmployeeService employeeService;

    private QueryWrapper<Employee> queryWrapper = Wrappers.query();

    private LambdaQueryWrapper<Employee> lambdaQueryWrapper = Wrappers.lambdaQuery();

    /**
     * 查询所有，并进行分页查找
     * <p>
     * ----》》》》》》 ：：：： 这里要注意，需要配置一下支持分页插件，要不然不会生效，config下的 MybatisConfig
     */
    @Test
    public void pageTest() {
        IPage<Employee> page = new Page(1, 2);
        IPage<Employee> p = employeeService.page(page);
        System.out.println("总页数： " + p.getPages());
        System.out.println("总记录数： " + p.getTotal());
        System.out.println("返回信息： " + p.getRecords());
    }

    /**
     * 通过条件查询,并进行分页
     */
    @Test
    public void pageByWrapperTest() {
        queryWrapper.like("emp_addr", "南昌");
        IPage<Employee> page = new Page(1, 2);
        IPage<Employee> employeeIPage = employeeService.page(page, queryWrapper);
        System.out.println(employeeIPage.getTotal());
        System.out.println(employeeIPage.getPages());
        System.out.println(employeeIPage.getRecords());

    }

    /**
     * 将对象转换成map的形式，只需要传入page就好，不需要带泛型
     */
    @Test
    public void pageMapsByTest() {
        queryWrapper.like("emp_addr", "南昌");
        IPage page = new Page(1, 2);
        IPage<Map<String, Object>> iPage = employeeService.pageMaps(page);
        System.out.println(iPage);
        System.out.println(iPage.getTotal());
        System.out.println(iPage.getRecords());

    }

    /**
     * 通过条件查询,并进行分页
     */
    @Test
    public void pageMapsByWrapperTest() {
        queryWrapper.like("emp_addr", "南昌");
        IPage page = new Page(1, 2);
        IPage<Map<String, Object>> iPage = employeeService.pageMaps(page, queryWrapper);
        System.out.println(iPage.getTotal());
        System.out.println(iPage.getRecords());

    }


}