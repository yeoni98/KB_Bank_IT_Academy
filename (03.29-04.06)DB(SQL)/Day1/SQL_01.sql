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
