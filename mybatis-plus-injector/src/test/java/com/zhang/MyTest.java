package com.zhang;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.plugins.Page;
import com.zhang.entity.Employee;
import com.zhang.entity.User;
import com.zhang.mapper.EmployeeMapper;
import com.zhang.mapper.UserMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {

    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

    EmployeeMapper employeeMapper = ioc.getBean("employeeMapper",EmployeeMapper.class);

    UserMapper userMapper = ioc.getBean("userMapper",UserMapper.class);

    /**
     * 测试公共字段填充
     */
    @Test
    public void testMetaObjectHandle(){
        User user = new User();
        user.setId(4);
        user.setLogicFlag(1);

//        Integer count = userMapper.insert(user);
//        System.out.println(count);

        Integer count = userMapper.updateById(user);
    }


    /**
     * 测试逻辑删除
     */
    @Test
    public void testLogicDelete(){

        Integer result = userMapper.deleteById(1);
        System.out.println("删除的数量 = " + result);


    }

    /**
     * 测试自定义全局操作
     */
    @Test
    public void testInjector(){

        //自己写的
        int count = employeeMapper.deleteAll();
        System.out.println(count);

    }

}

