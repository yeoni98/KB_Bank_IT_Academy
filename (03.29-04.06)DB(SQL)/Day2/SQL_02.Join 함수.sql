-- JOIN
SELECT  FROM DEPT;
SELECT  FROM EMP;

SELECT DISTINCT e.ename, d.loc 
FROM emp e, dept d
WHERE e.deptno = d.deptno;

/*
����
�ϳ� �̻�(Self Join) ���̺��� ���Ǹ� ������ ���
�Ϲ����� ��� FK�� ���ؼ� ���� ������ �����ȴ�.
Equi Join, Self Join, Outer Join�� �ֿ��ϰ� ���캸��
*/
SELECT empno, ename, sal, job FROM emp; -- �ش� ����� ������ �˰� ������ 
SELECT deptno, dname, loc FROM dept; -- �ش� �μ��� ������ �˰� ������

SELECT  FROM emp, dept;
/*
Cartesian Product
::
emp, dept ���̺��� ���������� ����
14  *  4 = 56

1) ���� ������ �������� ��
2) ���� ������ �߸� ���� ��
*/

-- STEP1.
SELECT * FROM emp, dept
WHERE emp.deptno = dept.deptno;

-- STEP2. ���̺� Alias
SELECT * FROM emp e, dept d
WHERE e.deptno = d.deptno;

-- STEP3. Projection...���ɻ� ������ �ɰ��ϴ�
SELECT empno,ename,sal,deptno,dname,loc 
FROM emp e, dept d
WHERE e.deptno = d.deptno; -- ���� ���� �� ���� �� �� 2��°

-- STEP4. Projection...�÷����� ���̺� ��Ī�� ���� �� �ش�
SELECT e.empno, e.ename, e.sal, e.deptno, d.dname, d.loc 
FROM emp e, dept d
WHERE e.deptno = d.deptno; -- ���� ���� �� ���� �� �� 2��°

-- STEP5. Equi Join AND Non Join����
SELECT e.empno, e.ename, e.sal, e.deptno, d.dname, d.loc 
FROM emp e, dept d
WHERE 
e.deptno = d.deptno
AND
d.deptno=10;

/
Self Join
::
�ϳ��� ���̺��� ��ü������ ������
/*
-- ������ �ۼ� �� �ϴ� ��� : õõ�� step by step���� �����ϸ鼭
-- Ư�� ����� ����� �̸��� ��ȸ
/*

emp���̺��� ���� Ư���� ����� ename�� ��ȸ
ename�� �ش��ϴ� mgr��ȣ�� ã�´�
�ٽ� emp���̺��� empno�� mgr�� ����� ã�Ƽ� ename�� ã�´�.
*/

-- STEP1.
SELECT ename, mgr FROM emp; -- BLAKE ����� ����ȣ�� ã��
SELECT empno, ename FROM emp; -- ����ȣ�� ��ġ�ϴ� �����ȣ�� ã�� �׿� �ش��ϴ� ��� �̸��� ã�´�.

-- STEP2
SELECT * FROM(SELECT ename, mgr FROM emp) e,
(SELECT empno, ename FROM emp)m;

-- STEP3
SELECT * FROM(SELECT ename, mgr FROM emp) e,
(SELECT empno, ename FROM emp)m
WHERE e.mgr = m.empno;

-- STEP4. ���� ���� �߰�
SELECT e.ename ����̸�, m.ename ����̸�
FROM emp e, emp m
WHERE e.mgr = m.empno
AND 
e.ename='BLAKE';

--123 ����1
SELECT e.empno, e.job, e.deptno e_deptno,
       d.deptno d_deptno, d.dname
FROM dept d, emp e
WHERE d.deptno = e.deptno(+); -- Right Outer Join

SELECT e.empno, e.job, e.deptno e_deptno,
       d.deptno d_deptno, d.dname
FROM emp e Right join dept d
ON d.deptno = e.deptno; 

SELECT e.ename, e.sal, e.deptno, d.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno
AND e.sal>2000;

SELECT e.ename, e.sal, e.deptno, d.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno
AND e.sal(+) > 2000;