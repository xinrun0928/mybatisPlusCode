-- Mysql


-- ������
CREATE DATABASE mp;
-- ʹ�ÿ�
USE mp;
-- ������
CREATE TABLE tbl_employee(
   id INT(11) PRIMARY KEY AUTO_INCREMENT,
   last_name VARCHAR(50),
   email VARCHAR(50),
   gender CHAR(1),
   age INT
);
INSERT INTO tbl_employee(last_name,email,gender,age) VALUES('Tom','tom@atguigu.com',1,22);
INSERT INTO tbl_employee(last_name,email,gender,age) VALUES('Jerry','jerry@atguigu.com',0,25);
INSERT INTO tbl_employee(last_name,email,gender,age) VALUES('Black','black@atguigu.com',1,30);
INSERT INTO tbl_employee(last_name,email,gender,age) VALUES('White','white@atguigu.com',0,35);

SELECT  * FROM tbl_employee;

EXPLAIN DELETE FROM tbl_employee WHERE id = 100

CREATE TABLE  tbl_user(
  id INT(11) PRIMARY KEY  AUTO_INCREMENT,
  NAME VARCHAR(50),
  logic_flag INT(11)
)





-- Oracle
-- ����һ�����Ա�
drop table tbl_user;
create table tbl_user(
  id number(11) primary key,
  name varchar2(50),
  logic_flag number(11) 
);

-- ����
create sequence seq_user start with 100 increment by 2 ;

-- ���еĳ��ò���
-- ��ѯ���е���һ��ֵ

select seq_user.nextval from dual;
-- ��ѯ���еĵ�ǰֵ
select seq_user.currval from dual ;

select * from tbl_user;