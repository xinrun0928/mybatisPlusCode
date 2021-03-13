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
import com.zhang.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {

    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

    EmployeeMapper employeeMapper = ioc.getBean("employeeMapper",EmployeeMapper.class);


    /**
     * 乐观锁插件
     * 1、注册乐观锁插件
     *      com.baomidou.mybatisplus.plugins.OptimisticLockerInterceptor
     * 2、使用乐观锁插件
     */
    @Test
    public void testOptimisticLocker(){

        Employee employee = new Employee();
        employee.setId(2278);
        employee.setLastName("vvhjgk");
        employee.setEmail("hffhjfh@qq.com");
        employee.setGender("0");
        employee.setAge(23);
        employee.setVersion(3);

        //更新操作
        Integer count = employeeMapper.updateById(employee);
        System.out.println(count);


    }


    /**
     * 性能分析插件
     * 1、注册性能分析插件
     *      com.baomidou.mybatisplus.plugins.PerformanceInterceptor
     * 2、使用性能分析插件
     *
     *
     */
    @Test
    public void testPerformart(){

        Employee employee = new Employee();
        employee.setLastName("xiaozhang");
        employee.setEmail("xiaozhang@qq.com");
        employee.setGender("0");
        employee.setAge(21);

        Integer count = employeeMapper.insert(employee);
        System.out.println(count);

    }


    /**
     * 执行分析插件
     * 1、注册执行分析插件
     *      com.baomidou.mybatisplus.plugins.SqlExplainInterceptor
     * 2、使用执行分析插件
     *
     *      注意：SQL 执行分析拦截器，只支持 MySQL5.6.3 以上版本
     */
    @Test
    public void testSQLExplain(){

        //全表删除
        employeeMapper.delete(null);
//        Integer count = employeeMapper.delete(null);
//        System.out.println("删除的总记录条数 = " + count);

    }


    /**
     * 分页插件的使用
     * 1、在applicationContext.xml注入分页插件
     *      com.baomidou.mybatisplus.plugins.PaginationInterceptor
     * 2、使用分页插件功能
     */
    @Test
    public void testPageList(){
        Page<Employee> page = new Page<>(1,10);
        System.out.println("pageBefore = " + page);

        List<Employee> employeeList = employeeMapper.selectPage(page,null);
        System.out.println("employeeList = " + employeeList);

        System.out.println("总记录条数 = " + page.getTotal());
        System.out.println("当前页码 = " + page.getCurrent());
        System.out.println("总页码 = " + page.getPages());
        System.out.println("每页显示的条数 = " + page.getSize());
        System.out.println("是否有上一页 = " + page.hasPrevious());
        System.out.println("是否有下一页 = " + page.hasNext());

        page.setRecords(employeeList);
        System.out.println("pageAfter = " + page);

    }


    /**
     * 测试分页插件
     */
    @Test
    public void testPage(){
        List<Employee> employeeList = employeeMapper.selectPage(new Page<Employee>(1,2),null);

        System.out.println("employeeList = " + employeeList);
    }

    /**
     * 插入数据
     */
    @Test
    public void insertEmployeeData(){

        for(int i = 0; i<50;i++){
            Employee employee = new Employee();
            employee.setLastName("xiaozhang");
            employee.setAge(21);
            employee.setEmail("xiaozhang@qq.com");
            employee.setGender("0");

            boolean result = employee.insert();
            System.out.println("result = " + result);
        }


    }


}

