-- DML

-- 1. 테이블 생성하기
CREATE TABLE MYDEBT(
      no number(3) CONSTRAINT PK_MYDEBT PRIMARY KEY,
      dname varchar2(30) not null,
      loc varchar2(30));
      
-- 테이블 생성하기 2
-- 테이블 레벨에서 PK추가
CREATE TABLE CUSTOM(
SSN NUMBER(7), CUST_NAME VARCHAR2(20), ADDRESS VARCHAR2(50), CONSTRAINT CUSTOM_PK PRIMARY KEY (SSN));

-- 2. 데이터 입력하기
INSERT INTO custom(ssn, cust_name, address) VALUES(111, USER, 'Brandon');
INSERT INTO custom(ssn, cust_name, address) VALUES(211,'cindy', 'NY');
INSERT INTO custom(ssn, cust_name, address) VALUES(311, 'marie', 'CA');


SELECT SSN, CUST_NAME, ADDRESS FROM custom;

-- PK(SSN)은 수정의 대상이 안 된다.
-- 데이터 수정
UPDATE custom SET cust_name = '이정재', custom.address ='신사동' WHERE ssn =111;

-- 데이터 삭제하기 !!!!! 중요 !!!!!
/*
DELETE
 1) 조건에 해당하는 행만 삭제를 진행
 2) 완벽히 삭제된 건 아니다. rollback으로 원래대로 되돌릴 수 있다.
 
TRUNCATE :: DROP + CREATE
 1) 모든 데이터를 다 삭제
 2) rollback이 안 된다.
 3) 데이터는 삭제하되 테이블 구조는 남긴다.
 
DROP
 1) 구조도 안 남기고 객체/구조 삭제함
 2) 모든 데이터 다 삭제하는 건 당연

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
-- 자식을 가지는 부모를 죽일 수 없다. fk를 설정하는 순간 부모자식이 만들어짐 -> 삭제하려고 하면 에러 뜸.

SELECT ename,deptno FROM employee WHERE deptno=20;

-- 자식을 가지고 있는 부모는 삭제가 안 됨
-- department 테이블의 데이터를 삭제 못함
-- 자식을 먼저 죽이고 부모를 죽이는 방법을 해결책으로 제시.. on.. delete cascade 활용
ALTER TABLE employee ADD CONSTRAINT employee_deptno_fk foreign key(deptno)
REFERENCES department(deptno)ON DELETE CASCADE;

SELECT * FROM department;
SELECT * FROM employee;

delete employee where deptno=10;
delete department where deptno=20;
select * from employee;