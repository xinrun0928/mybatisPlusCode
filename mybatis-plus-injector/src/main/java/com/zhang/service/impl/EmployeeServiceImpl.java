package com.zhang.service.impl;

import com.zhang.entity.Employee;
import com.zhang.mapper.EmployeeMapper;
import com.zhang.service.EmployeeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ZhangXinRun
 * @since 2021-03-13
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

    //不用再进行mapper注入

    /**
     * EmployeeServiceImpl：继承了ServiceImpl
     * 1、再ServiceImpl中已经完成了Mapper对象的注入，直接在EmployeeServiceImpl中可以进行使用
     * 2、在ServiceImpl中也帮我们提供了常用的CRUD方法，基本的一些CRUD方法在Service中不需要我们自己定义
     */

}
