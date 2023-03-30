-- ���̺��� ������ Ȯ�� emp => ���̺�� / NOT NULL = �����̸Ӹ� Ű�� ������ => NOT NULL +����ũ�� �� ����
DESC emp;
DESC dept;

-- Projection :: ���÷��� �ϰ��� �ϴ� �÷��� ���,�˻��ϰ��� �ϴ� colum�� �����ؼ� �����´�.
SELECT * FROM emp;   -- ��� �÷����� �����Ͷ� => * �̷��� ���� �ȵ�. 
-- why? 1. display�Ǹ� �� �Ǵ� �ͱ��� ���� ���� �ż�/ 2. ���ɻ��� ����

-- Sales ���� �� comm == null / [�� ��]�̶�� ���� [�ڰ��� ����] or [��Ȯ��]�̶�� �ǹ̷� ���� ��.

--emp ���̺��� ����� �̸�, �޿�, ����, �μ���ȣ�� �˻� => Projection: �˻��ϰ��� �ϴ� �� ����, ���
SELECT ename, sal, job, deptno FROM emp;


-- SELECTION :: ����(where��)�� �ο��ؼ� ���� ����
-- 10�� �μ����� �ٹ��ϴ� ����� �̸�, �޿�, �Ի�⵵�� �˻� -> Projection + SELECT
SELECT ename, sal, hiredate
FROM emp
WHERE deptno=10;

-- �޿��� ���� ���� ��� ������ ����(ORDER BY)
SELECT ename, sal, hiredate, deptno
FROM emp
WHERE deptno = 10
ORDER BY sal ASC;
-- �ݴ� ������
SELECT ename, sal, hiredate, deptno
FROM emp
WHERE deptno = 10
ORDER BY sal DESC;

-- SALESMAN�μ����� ����� �����ȣ, �̸�, ����, �μ���ȣ�� �˻�
-- ������ �μ���ȣ ������ �Ѵ�.
SELECT empno �����ȣ, ename �̸�, job ����, deptno �μ���ȣ
FROM emp
WHERE job ='SALESMAN'
ORDER BY deptno;


-- step 2  �̷��� �ص� ��
SELECT empno �����ȣ, ename �̸�, job ����, deptno �μ���ȣ
FROM emp
WHERE job ='SALESMAN'
ORDER BY �����ȣ;

-- step 3  �̷��� �ص� ��
SELECT empno �����ȣ, ename �̸�, job ����, deptno �μ���ȣ
FROM emp
WHERE job ='SALESMAN'
ORDER BY 1;

-- step4 
-- WHERE���� ������ ����.. 20�� �μ��� ������� ���� ����
--SELECT empno �����ȣ, ename, job, deptno 
--FROM emp
--WHERE �����ȣ = 20 -- WHERE�������� alias(����)���� �� ��. WHERE���������� ���� ������ ���̶� �ݿ��� �� ��. => ���� ���� �߿��ϴ�~
--ORDER BY 1;

-- ��� �߿��� �Ի����� ���� ���� ��� ������ �˻�
SELECT hiredate �Ի���, ename �̸�
FROM emp
ORDER BY hiredate;
-- ��� �߿��� �޿��� ���� ���� �޴� ��� ���� 3�� �˻�(rownum => n��° �� ���� ��)
SELECT ename, job, sal
FROM emp
ORDER BY sal DESC;

-- WHERE�� ���� ORDER BY���� ���� ����ǵ��� �ؾ��Ѵ�.
-- rownum�� ORDER BY������ ���� ������ �ż� ����� �߸����´�.
SELECT ename, job, sal
FROM emp
WHERE rownum<=3
ORDER BY sal DESC;

-- ���å
-- ( ) �ȿ� ORDER BY���� ���� ���� �ǰ� WHERE���� �����ϵ��� �ۼ�
SELECT ename, job, sal
FROM (SELECT * FROM emp ORDER BY sal DESC)
WHERE rownum<=3;

-- ��� ����� �޿��� ���� �޿��� 2�迡 20�޷��� �߰��� �޿��� �λ�
-- Alias�� ����, Ư������, ��ҹ��ڸ� �����ؾ� �ϴ� ��� => " " �� �����ش�
-- �÷��� ','���� ���� �Ѵٰ�.
SELECT ename, sal, sal*2+20 "�λ� �޿�" 
FROM emp;

-- step3
SELECT ename, sal, sal*2+20 IncrementSalary 
FROM emp;


 
-- =>SQL������ �� ��


-- ��� �޿����� ������ ������ ������ ������ �˻�
SELECT ename, sal, sal*0.9 �Ǽ���
FROM emp;

-- EMP���̺��� ��� ����� ������ �˻�
-- �� �� ������ ���� Alias �� AnnualSalary�� ������
-- Step1.
SELECT ename, job, sal, sal*12+comm AnnualSalary
FROM emp;

-- step2
-- null ������ ������ ����� �� �ݵ�� �ٸ� ������ ġȯ�ؼ� ���
-- NVL(comm,0): comm�� null�̸� 0,null�� �ƴϸ� comm�� �״�� ���
SELECT ename, job, sal, sal*12+NVL(comm,0) AnnualSalary
FROM emp;

-- step3
-- comm�� null�� �ƴ� ����� ������ ���Ѵ� ��� ����
SELECT ename, job, sal, sal*12+comm AnnualSalary
FROM emp
WHERE comm is not null;

-- step4
-- comm�� null�� �ƴ� ����� ������ ���Ѵ� ��� ����
SELECT ename, job, sal, sal*12+comm AnnualSalary
FROM emp
WHERE comm is not null;

-- EMP ���̺� �ִ� �μ�(deptno)�� �˻� 
SELECT deptno FROM emp;

-- EMP���̺� �ִ� �μ� (deptno)�� �˻�, DISTINCT(�ߺ��� ����)
SELECT DISTINCT deptno FROM emp;
SELECT DISTINCT (deptno) FROM emp; 
-- DISTINCT �� �״� ȿ�������� ����. ���� ������

-- �ڵ� ���� �� ��
SELECT DISTINCT deptno FROM emp ORDER BY 1;

-- DISTINCT�� ����ؼ� �μ� ��ȣ�� �ߺ��� ���ܼ� �����;� �ϴ� ���
-- EXISTS�� ���
SELECT deptno from dept d
WHERE EXISTS(SELECT * FROM emp e WHERE d.deptno = e.deptno);

-- Ư���� �������� �˻�
-- LIKE������ + ���ϵ�ī��(%, -)�� ���� ����.
-- Like -> %�� ���� ����, ���� ���� ���� //// 
--      -> - �� ���� �� ����
-- ��� �߿��� �̸��� S�� �����ϴ� ����� �˻� => 'S%'
-- if �� ��°�� S�� ������ �� => '_S%' �̷���
SELECT ename, job
FROM emp
WHERE ename LIKE 'S%';

-- ��� �߿��� �̸��� A�� ���Ե� ���
SELECT ename, job
FROM emp
WHERE ename LIKE '%A%';

-- 80�⿡ �Ի��� ��� �˻�
SELECT hiredate, ename, job
FROM emp
WHERE hiredate LIKE '80%';




-- IN ������
-- ���� ���� �� �߿� ��� �ϳ��� ��ġ�ϴ����� ��
-- �����ȣ�� 7369�̰ų� 7521�̰ų� 7782���� ����� �˻�
-- STEP1.
SELECT empno, ename, job FROM emp WHERE empno = 7369;
SELECT empno, ename, job FROM emp WHERE empno = 7519;
SELECT empno, ename, job FROM emp WHERE empno = 7269;
SELECT empno, ename, job FROM emp WHERE empno = 7421;

-- Step2
SELECT empno, ename, job 
FROM emp 
WHERE empno = 7369 OR empno = 7519 OR empno=5921;

-- Step3
SELECT empno, ename, job 
FROM emp 
WHERE empno IN(7369, 7521, 5921);

-- STEP4
-- �����ȣ�� 7369 �ƴϰ� 7521 �ƴϰ� 7782�� �ƴ� ����� �˻�
SELECT empno, ename, job 
FROM emp 
WHERE empno NOT IN(7369, 7521, 5921);

-- ����������, ������ ����߸���...
-- �� ���� �Ľ����� ..

-- ���ڿ�
-- SUBSTR(������ ���ڿ�, ������ġ)
-- SUBSTR(������ ���ڿ�, ������ġ, ���ⰹ��)
-- ���ڿ��� �����ϴ� ���... �Լ����� ���ڰ��� ��Ȯ�� ����
SELECT SUBSTR('HelloWorld', 6) FROM dual;
SELECT SUBSTR('HelloWorld', 6, 3) FROM dual;
SELECT SUBSTR('HelloWorld', -4, 2) FROM dual;
-- ��� �̸��� N���� ������ ����� �˻�
SELECT ename
FROM emp
WHERE ename LIKE '%N';
-- WHERE SUBSTR(ename,-1) = 'N'; �̰͵� ��

-- emp���̺��� �⵵�� ����.. 10�� �μ����� �˻��ǵ���
SELECT ename, hiredate, SUBSTR(hiredate, 1, 2) �⵵
FROM emp
WHERE deptno = 10;
-- OR
SELECT ename, hiredate
FROM emp
WHERE hiredate LIKE '80%';

-- PAD :: LPAD, RPAD
-- ������ �ʿ��� ��쿡 ����.
SELECT LPAD('abc', 6, '*') FROM DUAL;
SELECT RPAD('abc', 6, '*') FROM DUAL;
SELECT RPAD(deptno,10) FROM emp;

-- TRIM :: ������ ������ RTRIM, LTRIM, TRIM, REPLACE 
-- => �����ϰ� ��Ȯ�ϰ� �� ������ �� ���
SELECT RTRIM('    James Gosling    ') FROM dual;
SELECT LTRIM('    James Gosling    ') FROM dual;
SELECT TRIM('    James Gosling    ') FROM dual;
SELECT REPLACE('    James    Gosling    ',' ', '') FROM dual;

-- �����Լ�
SELECT ROUND(45.923,2) FROM dual;
-- �Ҽ��� ���� 3��° �ڸ����� �ݿø��� �ؼ� => 2��° �ڸ����� ǥ�� 
SELECT ROUND(45.923) FROM dual;

-- FLOOR :: �Ҽ��� �Ʒ��� ����(�����θ� ǥ��  ) => �ڸ��� ���� X 
SELECT FLOOR(45.923) FROM dual;
--SELECT FLOOR(45.923,2) FROM dual;
SELECT FLOOR(7.6) FROM dual;

-- TRUNC :: ������ �ڸ��� ���ϸ� ����
SELECT TRUNC(45.923,2)FROM dual;

-- CEIL :: �ø�, �����θ� ǥ�õ�
SELECT CEIL(45.923) FROM dual;
--SELECT CEIL(45.923, 2) FROM dual;

-- ��¥ �Լ�
/*
��¥ + ���� = ��¥
��¥ - ���� = ��¥
��¥ - ��¥ = �Ⱓ(����)
*/
SELECT SYSDATE +1 "Tomorrow" FROM dual;
SELECT SYSDATE -1 "Yesterday" FROM dual;
SELECT SYSDATE +100 "�츮������ 100��" FROM dual;
SELECT SYSDATE - (SYSDATE+1) FROM dual;

-- ���ݱ��� ��ƿ� �ϻ��� �˻�
SELECT round(SYSDATE -TO_DATE('1998/09/25')) "�¾�� �󸶳�?" FROM dual;
-- ���÷κ��� 4���� ���� ��¥�� �˻�
SELECT ADD_MONTHS(SYSDATE,4) FROM dual;
-- ���濬���� ��ƿ� ������ ���
SELECT MONTHS_BETWEEN(SYSDATE,TO_DATE('2000/12/08'))FROM dual;
-- emp���̺��� ������� ������� �ٹ��� �� ���� �˻�
SELECT ename, hiredate, ROUND((SYSDATE - hiredate)/7) "�ٹ��� ��"
FROM emp;