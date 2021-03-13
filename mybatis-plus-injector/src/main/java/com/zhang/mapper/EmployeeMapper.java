package com.zhang.mapper;

import com.zhang.entity.Employee;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ZhangXinRun
 * @since 2021-03-13
 */
public interface EmployeeMapper extends BaseMapper<Employee> {


    int deleteAll();


}
