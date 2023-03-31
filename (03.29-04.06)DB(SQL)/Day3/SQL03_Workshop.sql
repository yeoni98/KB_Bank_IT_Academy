--### Equi join ###
--1) EMP�� DEPT Table�� JOIN�Ͽ� �μ���ȣ, �μ���, �̸�, �޿��� ����϶�.
SELECT d.deptno, dname, ename, sal 
FROM emp e,dept d
WHERE e.deptno = d.deptno;
--2) �̸��� ��SMITH���� ����� �μ����� ����϶�.
SELECT dname
FROM emp e, dept d
WHERE e.deptno = d.deptno
AND
e.ename = 'SMITH';

--### Outer join ###
--3) dept Table�� �ִ� ��� �μ��� ����ϰ�, emp Table�� �ִ� DATA�� JOIN�Ͽ�
--��� ����� �̸�, �μ���ȣ, �μ���, �޿��� ��� �϶�.
SELECT e.ename, e.sal, e.deptno, d.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno;


--### Self join###
--4) EMP Table�� �ִ� empno�� mgr�� �̿��Ͽ� ������ ���踦 ������ ���� ����϶�.
--��SMTH�� �Ŵ����� FORD�̴١�
SELECT e.ename ||'�� �Ŵ����� '|| m.ename || '�̴�.'
FROM emp e, emp m
WHERE e.mgr = m.empno;


--### Sub Query ###
--1) ��ü ����� ��ձ޿����� �޿��� ���� ����� �����ȣ, �̸�,�μ���ȣ, �Ի���, �޿��� ����϶�.
SELECT empno, ename, deptno, hiredate, sal
FROM emp
WHERE sal >(SELECT AVG(sal)FROM emp);


--2) 10�� �μ��� ���� ���� �ϴ� ����� �����ȣ, �̸�, �޿��� �˻�..�޿��� ���� ������
--����϶�.
SELECT empno, ename, sal FROM emp
WHERE job IN(SELECT job FROM emp WHERE deptno = 10)
ORDER BY sal DESC;
--3) 10�� �μ� �߿��� 30�� �μ����� ���� ������ �ϴ� ����� �����ȣ, �̸�, �μ���ȣ,
--����, �Ի����� ����϶�.
SELECT empno, ename,job, hiredate FROM emp
WHERE(deptno = 10 and job NOT IN(SELECT job FROM emp WHERE deptno = 30));


--4) ��KING���̳� ��JAMES'�� �޿��� ���� ����� �����ȣ, �̸�,�޿��� ����϶�.
SELECT empno, ename, sal FROM emp
WHERE sal IN(SELECT sal FROM emp WHERE ename='KING' OR ename = 'JAMES');


--5) �޿��� 30�� �μ��� �ְ� �޿����� ���� ����� �����ȣ,�̸�, �޿��� ����϶�.
SELECT empno, ename, sal FROM emp 
WHERE sal>(SELECT MAX(sal) FROM emp WHERE deptno=30);
--6) SCOTT�� �޿����� �� ���� �޿��� �޴� ����� �˻��϶�.
--2���� ����� ��� 1) �������� 2) ���̺� �˸��߽� ���
--6-1)
SELECT ename, sal FROM emp
WHERE sal>(SELECT sal FROM emp WHERE ename = 'SCOTT');
--6-2)
SELECT a.ename, a.sal, a.job
FROM emp a, (SELECT sal FROM emp WHERE ename='SCOTT') b
WHERE a.sal>b.sal;

--7) �μ��� �ּұ޿� �߿��� 20�� �μ��� �ּұ޿����� �� ū �ּұ޿��� �˻��϶�.
SELECT deptno, MIN(sal) FROM emp
GROUP BY deptno
HAVING MIN(sal) > (SELECT MIN(sal) FROM emp WHERE deptno = 20);
--8) ���������� �Ŵ��� ����� �˻��϶� . �̶� ����̸��� ����� �����ȣ�� �˻��ǵ��� �Ѵ�.
SELECT distinct mgr FROM emp;
SELECT * FROM emp WHERE empno IN(SELECT DISTINCT mgr FROM emp);