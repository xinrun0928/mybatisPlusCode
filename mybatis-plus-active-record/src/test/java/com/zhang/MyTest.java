package com.zhang;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zhang.entity.Employee;
import com.zhang.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MyTest {

    private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void testDataSource() throws SQLException {
        DataSource dataSource = ioc.getBean("myDataSource",DataSource.class);
        System.out.println("dataSource = " + dataSource);

        Connection connection = dataSource.getConnection();
        System.out.println("connection = " + connection);
    }

    /**
     * AR  分页的复杂操作
     */
    @Test
    public void testARPage(){
        Employee employee = new Employee();

        Page<Employee> page = employee.selectPage(new Page<Employee>(1,1),new EntityWrapper<Employee>().like("last_name","Tom"));
        System.out.println(page);

        List<Employee> employeeList = page.getRecords();
        System.out.println(employeeList);
    }

    /**
     * AR  删除操作
     * 注意：删除不存在的数据，逻辑上也是成功的
     */
    @Test
    public void tesetARDelete(){
        Employee employee = new Employee();
        employee.setId(1028);

//        boolean flag = employee.deleteById(1028);
//        System.out.println(flag);

//        boolean flag = employee.deleteById();
//        System.out.println(flag);

        boolean flag = employee.delete(new EntityWrapper().like("last_name","sda"));
        System.out.println(flag);

    }

    /**
     * AR  查询操作
     */
    @Test
    public void testARSelect(){
        Employee employee = new Employee();

//        Employee result = employee.selectById(2);
//        System.out.println("result = " + result);

//        employee.setId(2);
//        Employee result = employee.selectById();
//        System.out.println("result = " + result);

//        List<Employee> employeeList = employee.selectAll();
//        System.out.println(employeeList);

//        List<Employee> employeeList = employee.selectList(new EntityWrapper().like("last_name","sda"));
//        System.out.println(employeeList);

        Integer count = employee.selectCount(new EntityWrapper().eq("gender",0));
        System.out.println(count);

    }

    /**
     * AR  修改操作
     */
    @Test
    public void testARUpdate(){
        Employee employee = new Employee();
        employee.setId(1028);
        employee.setLastName("hhh   ");
        employee.setEmail("hhh@qq.com");
        employee.setGender(0);
        employee.setAge(23);

        boolean result = employee.updateById();
        System.out.println("result = " + result);
    }


    /**
     * AR  插入操作
     */
    @Test
    public void testARInsert(){
        Employee employee = new Employee();
        employee.setLastName("zhanglaoshi");
        employee.setEmail("zhang@qq.com");
        employee.setGender(1);
        employee.setAge(35);

        Boolean flag = employee.insert();
        System.out.println("flag = " + flag);
    }
}

