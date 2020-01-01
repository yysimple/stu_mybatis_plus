package com.example.crud_interface.service_crud;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.crud_interface.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @author wuchengxing
 * @version 1.0
 * @date 2019/12/25 14:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class EmployeeSaveOrUpdate {

    @Autowired
    private IEmployeeService employeeService;

    private QueryWrapper queryWrapper = Wrappers.query();

    /**
     * 增加或者更新：
     * <p>
     * 传入id 进行匹配，判断是更新操作还是新增操作
     */
    @Test
    public void saveOrUpdateTest() {
        Employee employee = new Employee();
        employee.setEmpId(2L);
        employee.setEmpName("少奇第一个");
        employee.setEmpAddr("江西南昌北京路");
        employee.setEmpAge(22);
        employee.setEmpBirthday(LocalDateTime.now());
        employee.setEmpPhone("18311155111");
        boolean save01 = employeeService.saveOrUpdate(employee);
        System.out.println(save01);
    }

    /**
     * 先判断   like %南昌的是否存在，存在就对这些记录，进行同样的修改操作
     * 所以操作需谨慎
     * 结果是：符合要求的所有员工的地址全部改成了 --》 江西南昌北京路
     */
    @Test
    public void saveOrUpdateByWrapperTest() {
        queryWrapper.likeLeft("emp_addr", "南昌");
        Employee employee = new Employee();
        // employee.setEmpId(1L);
        // employee.setEmpName("少奇第一个");
        employee.setEmpAddr("江西南昌北京路");
        employee.setEmpAge(15);
        // employee.setEmpBirthday(LocalDateTime.now());
        // employee.setEmpPhone("18311155111");
        boolean save02 = employeeService.saveOrUpdate(employee, queryWrapper);
        System.out.println(save02);
    }

    /**
     * 进行批量修改操作
     *
     * 后面还有一个参数：batchSize 要去前几条记录进行保存或者更新
     */
    @Test
    public void saveOrUpdateBatchTest() {
        Employee employee1 = new Employee();
        employee1.setEmpId(14L);
        employee1.setEmpName("批量修改少奇14");

        Employee employee2 = new Employee();
        employee2.setEmpId(15L);
        employee2.setEmpName("批量修改少奇15");

        Employee employee3 = new Employee();
        employee3.setEmpId(16L);
        employee3.setEmpName("批量修改少奇16");

        boolean save03 = employeeService.saveOrUpdateBatch(Arrays.asList(employee1, employee2, employee3));
        System.out.println(save03);
    }


}
