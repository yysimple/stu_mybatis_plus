package com.example.crud_interface.service_crud.impl;

import com.example.crud_interface.entity.Employee;
import com.example.crud_interface.mapper.EmployeeMapper;
import com.example.crud_interface.service_crud.IEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wcx
 * @since 2019-12-25
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

}
