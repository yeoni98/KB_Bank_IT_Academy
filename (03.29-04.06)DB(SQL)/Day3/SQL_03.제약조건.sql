-- DML

-- 1. ���̺� �����ϱ�
CREATE TABLE MYDEBT(
      no number(3) CONSTRAINT PK_MYDEBT PRIMARY KEY,
      dname varchar2(30) not null,
      loc varchar2(30));
      
-- ���̺� �����ϱ� 2
-- ���̺� �������� PK�߰�
CREATE TABLE CUSTOM(
SSN NUMBER(7), CUST_NAME VARCHAR2(20), ADDRESS VARCHAR2(50), CONSTRAINT CUSTOM_PK PRIMARY KEY (SSN));

-- 2. ������ �Է��ϱ�
INSERT INTO custom(ssn, cust_name, address) VALUES(111, USER, 'Brandon');
INSERT INTO custom(ssn, cust_name, address) VALUES(211,'cindy', 'NY');
INSERT INTO custom(ssn, cust_name, address) VALUES(311, 'marie', 'CA');


SELECT SSN, CUST_NAME, ADDRESS FROM custom;

-- PK(SSN)�� ������ ����� �� �ȴ�.
-- ������ ����
UPDATE custom SET cust_name = '������', custom.address ='�Ż絿' WHERE ssn =111;

-- ������ �����ϱ� !!!!! �߿� !!!!!
/*
DELETE
 1) ���ǿ� �ش��ϴ� �ุ ������ ����
 2) �Ϻ��� ������ �� �ƴϴ�. rollback���� ������� �ǵ��� �� �ִ�.
 
TRUNCATE :: DROP + CREATE
 1) ��� �����͸� �� ����
 2) rollback�� �� �ȴ�.
 3) �����ʹ� �����ϵ� ���̺� ������ �����.
 
DROP
 1) ������ �� ����� ��ü/���� ������
 2) ��� ������ �� �����ϴ� �� �翬

*/

DELETE custom WHERE ssn = 211;
rollback;

TRUNCATE TABLE custom;
DESC custom;

DROP TABLE custom;

DROP TABLE employee;
DROP TABLE department;

CREATE TABLE employee
AS
SELECT * FROM emp;

CREATE TABLE department
AS
SELECT * FROM dept;

SELECT * FROM dept;

DESC employee;
DESC department;

ALTER TABLE employee ADD CONSTRAINT employee_empno_pk PRIMARY KEY(empno);
desc employee; 
ALTER TABLE department ADD CONSTRAINT department_deptno_pk PRIMARY KEY(deptno);

DELETE employee WHERE deptno=10;
SELECT ename,deptno FROM employee WHERE deptno=10;

DELETE department WHERE deptno=20;
-- �ڽ��� ������ �θ� ���� �� ����. fk�� �����ϴ� ���� �θ��ڽ��� ������� -> �����Ϸ��� �ϸ� ���� ��.

SELECT ename,deptno FROM employee WHERE deptno=20;

-- �ڽ��� ������ �ִ� �θ�� ������ �� ��
-- department ���̺��� �����͸� ���� ����
-- �ڽ��� ���� ���̰� �θ� ���̴� ����� �ذ�å���� ����.. on.. delete cascade Ȱ��
ALTER TABLE employee ADD CONSTRAINT employee_deptno_fk foreign key(deptno)
REFERENCES department(deptno)ON DELETE CASCADE;

SELECT * FROM department;
SELECT * FROM employee;

delete employee where deptno=10;
delete department where deptno=20;
select * from employee;