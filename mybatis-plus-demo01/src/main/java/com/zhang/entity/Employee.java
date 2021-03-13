package com.zhang.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 *  mybatisPlus默认会使用实体类的类名首字母小写作为表名
 * @TableName：对应实体类与数据库表名
 */
//@TableName(value = "tbl_employee")
public class Employee {

    /**
     * @TableId注解：
     *  type：设置表的主键id类型
     *  value：指定表中的字段与实体类对应，相同可省略
     *  可以使用全局策略配置替换
     */
//    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /**
     * @TableField：配置数据库字段与之对应
     */
    @TableField(value = "last_name")
    private String lastName;
    private String email;
    private Integer gender;
    private Integer age;

    @TableField(exist = false)
    private Double money;

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Employee() {
    }

    public Employee(Integer id, String lastName, String email, Integer gender, Integer age) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }
}
