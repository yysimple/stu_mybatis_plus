package com.example.crud_interface.service_crud;

import com.example.crud_interface.entity.Employee;
import com.example.crud_interface.mapper.EmployeeMapper;
import com.example.crud_interface.service_crud.IEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wuchengxing
 * @version 1.0
 * @date 2019/12/25 11:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class EmployeeSaveTest {

    @Autowired
    private IEmployeeService employeeService;

    /**
     * 单个插入
     */
    @Test
    public void saveOneTest(){
        Employee employee = new Employee();
        employee.setEmpName("少奇");
        employee.setEmpAddr("江西南昌");
        employee.setEmpAge(22);
        employee.setEmpBirthday(LocalDateTime.now());
        employee.setEmpPhone("18311155111");
        boolean save01 = employeeService.save(employee);
        System.out.println(save01);
    }

    /**
     * 批量插入
     */
    @Test
    public void saveBatchTest(){
        Employee employee1 = new Employee();
        employee1.setEmpName("少奇004");
        employee1.setEmpAddr("长沙");
        employee1.setEmpAge(55);
        employee1.setEmpBirthday(LocalDateTime.now());
        employee1.setEmpPhone("18311155111");

        Employee employee2 = new Employee();
        employee2.setEmpName("少奇005");
        employee2.setEmpAddr("澳门");
        employee2.setEmpAge(18);
        employee2.setEmpBirthday(LocalDateTime.now());
        employee2.setEmpPhone("15131513531");

        List<Employee> list = new ArrayList<>();
        list.add(employee1);
        list.add(employee2);

        boolean save02 = employeeService.saveBatch(list);
        System.out.println(save02);
    }

    /**
     * 可以定义多个实体类，但是只要传入指定个数
     */
    @Test
    public void saveBatchSize() {
        Employee employee1 = new Employee();
        employee1.setEmpName("少奇03");
        employee1.setEmpAddr("江西南昌");
        employee1.setEmpAge(22);
        employee1.setEmpBirthday(LocalDateTime.now());
        employee1.setEmpPhone("2565113131");

        Employee employee2 = new Employee();
        employee2.setEmpName("少奇04");
        employee2.setEmpAddr("江西抚州");
        employee2.setEmpAge(23);
        employee2.setEmpBirthday(LocalDateTime.now());
        employee2.setEmpPhone("16562435515");

        Employee employee3 = new Employee();
        employee3.setEmpName("少奇05");
        employee3.setEmpAddr("江西南昌");
        employee3.setEmpAge(25);
        employee3.setEmpBirthday(LocalDateTime.now());
        employee3.setEmpPhone("5245348324");

        Employee employee4 = new Employee();
        employee4.setEmpName("少奇06");
        employee4.setEmpAddr("江西抚州");
        employee4.setEmpAge(26);
        employee4.setEmpBirthday(LocalDateTime.now());
        employee4.setEmpPhone("42153452345");



        List<Employee> list = new ArrayList<>();
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);
        list.add(employee4);

        boolean save03 = employeeService.saveBatch(list,3);
        System.out.println(save03);

    }




}