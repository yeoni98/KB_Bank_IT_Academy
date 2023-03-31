-- ������ ��������
-- WHERE�� ���
-- CLARK�� �޿����� �� ���� �޿��� �޴� ����� �˻�
-- step1 ������ ���� �� ���� sql�Ľ��� �� �� �ϱ� ����
SELECT sal FROM emp WHERE ename = 'CLARK';
SELECT ename,sal FROM emp WHERE sal >2450;

-- step2 �Ľ� 1��, ���̺��� 2�� ȣ��
SELECT ename, sal FROM emp WHERE sal >(SELECT sal FROM emp WHERE ename ='CLARK');


-- ename�� KING�� ����� ���� �μ����� ���ϴ� ����� �˻�...
-- SELECT������ ���/WHERE��
SELECT ename, deptno FROM emp WHERE deptno=(SELECT deptno FROM emp WHERE ename='KING');

-- HAVING ���� ���Ǵ� ��������. job�� ���� ���� ��ձ޿��� �˻�
SELECT job, ROUND(AVG(sal)) FROM emp 
GROUP BY job
HAVING (AVG(sal))=(SELECT MIN(AVG(sal)) FROM emp GROUP BY job); 
 
 
-- �μ��� �ּұ޿� �߿��� 20�� �μ��� �ּ� �޿����� �� ū �ּұ޿��� �˻�
SELECT deptno, MIN(sal) FROM emp
GROUP BY deptno
HAVING MIN(sal)>(SELECT MIN(sal) FROM emp WHERE deptno =20);

-- 3. FROM���� ���Ǵ� ��������
-- step1... ORDER BY ���� ���� ���߿� ����ȴ�.
SELECT ename, sal,rownum FROM emp 
WHERE rownum<=3
ORDER BY sal DESC;

-- step2... FROM������ ���Ǵ� ����Ŀ��:ORDER BY ���� ���� ����..(ORDER BY~~) 
SELECT ename, sal,rownum FROM (SELECT * FROM emp ORDER BY sal DESC) 
WHERE rownum<=3;
-- => ���������� ���� ���̺��� 2�� �̻� �ǵ帱 �� �ۿ� ����~





-- '='�� ������ ������. �׷��� ������ ������ �� ��
-- ������ �����ڸ� ��� �� => '=' => 'IN'����
SELECT empno, ename
FROM emp
WHERE sal IN (SELECT MIN(sal) FROM emp GROUP BY deptno);

--
SELECT ename, sal, job
FROM emp
WHERE job!='SALESMAN' AND sal>ANY(SELECT sal FROM emp WHERE job='SALESMAN');

SELECT ename, sal, job
FROM emp
WHERE job !='SALESMAN' AND sal>(SELECT MIN(sal) FROM emp WHERE job='SALESMAN');

SELECT ename, sal, job
FROM emp
WHERE job !='SALESMAN' AND sal>(SELECT MAX(sal) FROM emp WHERE job = 'SALESMAN');


-- SCOTT�� �޿����� �� ���� �޿��� �޴� ����� �˻�
-- 1. 
SELECT ename, sal, job
FROM emp
WHERE sal>(SELECT sal FROM emp WHERE ename ='SCOTT');

-- 2.���̺� �˸��߽� ���
SELECT a.ename, a.sal, a.job
FROM emp a, (SELECT sal FROM emp WHERE ename ='SCOTT') b
WHERE a.sal>b.sal;



-- ��ȣ ���� ��������
SELECT ename, sal, deptno, hiredate, job
FROM EMP E
WHERE sal >(SELECT AVG(sal) FROM EMP WHERE deptno = E.deptno);


SELECT*FROM emp;

-- ����� ������ �� �ִ� ����� ��� �޿����� �޿��� �� ���� �޴� ������� ��ȸ
SELECT ename, sal, deptno, hiredate, job
FROM emp e
WHERE sal>(SELECT AVG(sal) FROM emp WHERE e.empno = mgr);




--EXISTS������
-- step1 EXISTS()
SELECT deptno, dname
FROM DEPT d
WHERE EXISTS(SELECT 'A' FROM emp WHERE deptno = d.deptno);
--STEP2 DISTINCT (���������� �ߺ� �����ϴ°� ȿ���� �� ������)
SELECT DISTINCT dname, e.deptno
FROM dept d, emp e
WHERE e.deptno = d.deptno;
--step3. IN ���� ���� ����
SELECT dname, deptno
FROM dept
WHERE deptno IN(SELECT deptno FROM emp WHERE job='MANAGER');