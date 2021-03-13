package com.zhang;

import com.baomidou.mybatisplus.mapper.Condition;
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
import java.util.*;

public class MyTest {

    private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

    private EmployeeMapper employeeMapper = ioc.getBean("employeeMapper",EmployeeMapper.class);

    @Test
    public void testDataSource() throws SQLException {
        DataSource dataSource = ioc.getBean("myDataSource",DataSource.class);
        System.out.println("dataSource = " + dataSource);

        Connection connection = dataSource.getConnection();
        System.out.println("connection = " + connection);
    }


    /**
     * 条件构造器
     *      删除方法
     */
    @Test
    public void testEntityWrapperDelete(){
        Integer count = employeeMapper.delete(new EntityWrapper<Employee>()
                .eq("last_name","sdaf")
                .eq("age","22")
        );

        System.out.println("count = " + count);

    }

    /**
     * 条件构造器
     *      修改操作
     */
    @Test
    public void testEntityWrapperUpdate(){

        Employee employee = new Employee();
        employee.setLastName("sdaf");
        employee.setEmail("asdf@email.com");
        employee.setGender(1);

        Integer count = employeeMapper.update(employee,new EntityWrapper<Employee>()
                .eq("last_name","mybatis-plus")
                .or()
                .eq("age",22));
        System.out.println("count = " + count);

    }

    /**
     * 条件构造器
     *      EntityWapper
     *        查询操作
     */
    @Test
    public void testEntityWrapperSelect(){

//        List<Employee> employeeList = employeeMapper.selectPage(new Page<Employee>(),
//                new EntityWrapper<Employee>()
//                        .between("age",18,50)
//                        .eq("gender",1)
//                        .eq("last_name","Tom"));
//        System.out.println("employeeList = " + employeeList);

//        List<Employee> employeeList = employeeMapper.selectList(new EntityWrapper<Employee>()
//                .eq("gender",0)
//                .like("last_name","mybatis-plus")
//                .or()
//                .orNew()
//                .like("email","alibaba@qq.com"));
//        System.out.println("employeeList = " + employeeList);

//        List<Employee> employeeList = employeeMapper.selectList(new EntityWrapper<Employee>().eq("gender",0).orderBy("age"));
//        List<Employee> employeeList = employeeMapper.selectList(new EntityWrapper<Employee>().eq("gender",0).orderDesc(Arrays.asList(new String[]{"age"})));
        // last()：存在sql注入风险
//        List<Employee> employeeList = employeeMapper.selectList(new EntityWrapper<Employee>().eq("gender",0).orderBy("age").last("desc limit 1,2"));
//        System.out.println("employeeList = " + employeeList);

        //Condition
        List<Employee> employeeList = employeeMapper.selectPage(new Page<Employee>(1,3), Condition.create()
                .between("age",2,53).eq("gender",1));
        System.out.println("employeeList = " + employeeList);
    }

    /**
     * 通用删除（delete）操作
     */
    @Test
    public void testCommonDelete(){

        //通过id删除
//        Integer count = employeeMapper.deleteById(1014);
//        System.out.println(count);

        //根据条件进行删除
//        Map<String, Object> map = new HashMap<>();
//        map.put("last_name","mybatis-plus");
//        map.put("email","alibaba@qq.com");
//        Integer count = employeeMapper.deleteByMap(map);
//        System.out.println(count);

        //批量删除
        List<Integer> idList = new ArrayList<>();
        idList.add(1043);
        idList.add(1044);
        idList.add(1045);
        Integer count = employeeMapper.deleteBatchIds(idList);
        System.out.println(count);

    }

    /**
     * 通用查询（select）操作
     */
    @Test
    public void testCommonSelect(){

        //通过id查询
//        Employee employee = employeeMapper.selectById(3);
//        System.out.println("employee = " + employee);

        //通过多个列查询,返回一条数据，如果返回多条，则抛异常
//        Employee employee = new Employee();
//        employee.setId(4);
//        employee.setLastName("White");
//        employee.setGender(0);
//        Employee employee1 = employeeMapper.selectOne(employee);
//        System.out.println(employee1);

//        List<Integer> idList = new ArrayList<>();
//        idList.add(1);
//        idList.add(2);
//        idList.add(3);
//        idList.add(4);
//
//        //通过多个id进行查询，传递一个集合
//        List<Employee> employeeList = employeeMapper.selectBatchIds(idList);
//        System.out.println(employeeList);

//        Map<String, Object> map = new HashMap<>();
//        map.put("last_name","Tom");
//        map.put("gender","1");
//
//        //通过map封装条件查询
//        List<Employee> employeeList = employeeMapper.selectByMap(map);
//        System.out.println(employeeList);

        //分页查询,没有存在 limit关键字
        List<Employee> employeeList = employeeMapper.selectPage(new Page<>(2,3),null);
        System.out.println("employeeList = " + employeeList);

    }



    /**
     * 通用更新（update）操作
     */
    @Test
    public void testCommonUpdate(){

        Employee employee = new Employee();
        employee.setId(5);
        employee.setAge(18);
        employee.setEmail("hengdajituan@qq.com");
        employee.setGender(0);
        employee.setLastName("zhang");

        Integer result = employeeMapper.updateById(employee);
        //改所有列
//        Integer result = employeeMapper.updateAllColumnById(employee);

        System.out.println("result = " + result);
    }

    /**
     * 通用插入（Insert）操作
     */
    @Test
    public void testCommonInsert(){

    //        for (int i = 1;i < 1000;i++){
            //初始化Employee对象
            Employee employee = new Employee();
            employee.setAge(22);
            employee.setEmail("alibaba@qq.com");
            employee.setGender(1);
            employee.setLastName("mybatis-plus");

            //该方法在插入时，会根据实体类的每个属性进行判断，只有非空的属性对应的字段才会出现到sql语句中
//            Integer result = employeeMapper.insert(employee);

            //该方法在插入时，不管属性值是否非空，属性对应的字段都会出现在sql语句中
            Integer result = employeeMapper.insertAllColumn(employee);

            System.out.println("result = " + result);

            //插入的时候获取主键值
            Integer key = employee.getId();
            System.out.println("key = " + key);
//        }
    }

}

