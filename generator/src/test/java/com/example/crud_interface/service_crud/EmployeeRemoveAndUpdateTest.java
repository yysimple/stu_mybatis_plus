package com.example.crud_interface.service_crud;

import com.example.crud_interface.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @author wuchengxing
 * @version 1.0
 * @date 2019/12/25 11:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class EmployeeRemoveAndUpdateTest {

    @Autowired
    private IEmployeeService employeeService;

    /**
     * 根据id删除一条记录
     */
    @Test
    public void removeOneTest() {
        boolean rem01 = employeeService.removeById(10L);
        System.out.println("rem01");
    }

    /**
     * 批量删除记录
     */
    @Test
    public void removeBatchByIdsTest() {

        boolean rem02 = employeeService.removeByIds(Arrays.asList(11L, 12L, 13L));
        System.out.println(rem02);
    }

    /**
     * 通过map传参的方式进行条件删除
     */
    @Test
    public void removeByMapTest() {

        Map<String, Object> map = new HashMap<>();
        map.put("emp_addr", "江西南昌北京路");
        boolean rem03 = employeeService.removeByMap(map);
        System.out.println(rem03);

    }

    /**
     * 通过传入id 进行修改
     */

    @Test
    public void updateByIdTest() {
        Employee employee = new Employee();
        employee.setEmpId(6L);
        employee.setEmpName("少奇01-updateByIdTest");
        boolean update01 = employeeService.updateById(employee);
        System.out.println(update01);
    }

    /**
     * 批量修改
     */
    @Test
    public void updateBatchByIdsTest() {
        Employee employee1 = new Employee();
        employee1.setEmpId(6L);
        employee1.setEmpName("少奇01-updateByIdTest-updateByIdsTest");

        Employee employee2 = new Employee();
        employee2.setEmpId(7L);
        employee2.setEmpName("我是修改后的少奇07");

        boolean update02 = employeeService.updateBatchById(Arrays.asList(employee1, employee2));
        System.out.println(update02);
    }

    /**
     * 批量修改并取第一条
     */
    @Test
    public void updateBatchByIdsBySizeTest() {
        Employee employee1 = new Employee();
        employee1.setEmpId(1L);
        employee1.setEmpName("少奇001");

        Employee employee2 = new Employee();
        employee2.setEmpId(7L);
        employee2.setEmpName("我是修改后的少奇07");

        boolean update02 = employeeService.updateBatchById(Arrays.asList(employee1, employee2), 1);
        System.out.println(update02);
    }


}