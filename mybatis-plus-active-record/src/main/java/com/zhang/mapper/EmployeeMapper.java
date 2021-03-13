package com.zhang.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zhang.entity.Employee;

/**
 * Mapper接口
 *
 * 基于mybatis：再Mapper接口中编写CRUD相关的方法，提供Mapper接口所对应的sql映射文件以及方法对应的sql语句
 *
 * 基于mybatis-plus：让xxxMapper接口继承BaseMapper接口即可
 *      BaseMapper<T>：泛型指定的就是当前Mapper接口所操作的实体类类型
 */
public interface EmployeeMapper extends BaseMapper<Employee> {



}
