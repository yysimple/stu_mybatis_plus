package com.example.crud_interface.mapper;

import com.example.crud_interface.entity.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wcx
 * @since 2019-12-25
 */
public interface EmployeeMapper extends BaseMapper<Employee> {
    /**
     * 通过员工id找到对应的员工
     * @return
     */
    Employee getEmployeeById(Long empId);
}
