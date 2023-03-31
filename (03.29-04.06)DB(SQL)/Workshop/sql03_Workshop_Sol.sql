-- ### equi join ###

-- 1).  emp�� dept Table�� JOIN�Ͽ� �μ���ȣ, �μ���, �̸�, �޿���  ����϶�.

select  dept.deptno, dname, ename, sal
from emp , dept 
where emp.deptno = dept.deptno 
order by dept.deptno;

-- =====================================
select d.deptno, d.dname, e.ename, e.sal 
from emp e  join dept d on e.deptno=d.deptno
order by d.deptno;
-- =====================================
select deptno, d.dname, e.ename, e.sal 
from emp e  join dept d using (deptno);

-- 2).  �̸��� ��SMITH���� ����� �μ����� ����϶�.

select  dname
from emp, dept
where emp.deptno  = dept.deptno  and emp.ename='SMITH';

-- ========================================
select d.dname, e.ename
from emp e  join  dept d using (deptno)
where  e.ename='SMITH';

select d.dname, e.ename
from emp e  join  dept d on e.deptno=d.deptno
where  e.ename='SMITH';


 
-- ### outer join ###
-- 3).  dept Table�� �ִ� ��� �μ��� ����ϰ�, emp Table�� �ִ� DATA�� JOIN�Ͽ� 
-- ��� ����� �̸�, �μ���ȣ, �μ���, �޿��� ��� �϶�.

SELECT e.ename, e.deptno, d.dname, e.sal
FROM emp e, dept d
WHERE e.deptno(+)=d.deptno;

-- ========================================

SELECT e.ename, e.deptno, d.dname, e.sal
FROM emp e RIGHT JOIN  dept d
ON e.deptno(+)=d.deptno;



-- ###self join###
-- 4.  emp Table�� �ִ� empno�� mgr�� �̿��Ͽ� ������ ���踦 ������ ���� ����϶�. ��SMTH�� �Ŵ����� FORD�̴١�
-- ���� ������ ���  || 

SELECT  e.ename  ||' �� �Ŵ����� ' || m.ename || '�̴�.'
FROM emp e, emp m
WHERE e.mgr = m.empno;



-- ### SubQuery ###

-- 1).  ��ü ����� ��ձ޿����� �޿��� ���� ����� �����ȣ, �̸�,�μ���ȣ, �Ի���,�޿��� ����϶�.
select empno, ename, DEPTNO, hiredate,  sal
from emp
where sal >=(select avg(sal) from emp);


-- 2). 10�� �μ��� ���� ���� �ϴ� ����� �����ȣ, �̸�, �޿��� �˻�..�޿��� ���� ������ ����϶�.
select empno, ename, sal
from emp 
where job in  ( select job from emp where deptno=10)
order by sal desc;

-- ===========================================
select e.empno, e.ename, d.dname, d.loc, sal
from emp e join dept d on e.deptno=d.deptno
where e.job  in (select job from emp where deptno=10)
Order by sal  desc;


-- 3).  10�� �μ� �߿��� 30�� �μ����� ���� ������ �ϴ� ����� �����ȣ, �̸�, �μ���ȣ,����, �Ի����� ����϶�.
select empno, ename, hiredate, job
from emp 
where  (deptno=10 and job not in (select job from emp  where deptno=30));

-- ===========================================================

select e.empno, e.ename, d.dname, hiredate, d.loc
from emp e join dept d on e.deptno=d.deptno
where e.deptno=10
and e.job not in (select job from emp where deptno=30);

-- 4).  ��KING���̳� ��JAMES'�� �޿��� ���� ����� �����ȣ, �̸�,�޿��� ����϶�.
select empno, ename, sal
from emp
where sal in (select sal from emp where ename in ('KING','JAMES'));


-- 5).  �޿��� 30�� �μ��� �ְ� �޿����� ���� ����� �����ȣ,�̸�, �޿��� ����϶�.
select empno, ename, sal
from emp
where sal >( select max(sal) from emp where deptno=30);


-- 6). SCOTT�� �޿����� ������ �޿��� �޴� ����� �˻�
-- 2���� ����� ��� 1) ��������  2) ���̺� �˸��߽��� ���
-- 1) 
SELECT * FROM emp WHERE sal > (SELECT sal FROM emp WHERE ename='SCOTT');

-- 2) 
SELECT * FROM emp a, (SELECT sal FROM emp WHERE ename='SCOTT') b
WHERE a.sal > b.sal;

-- 7). �μ��� �ּұ޿� �߿��� 20�� �μ��� �ּұ޿����� �� ū �ּұ޿��� �˻�
SELECT deptno, min(sal) FROM emp 
GROUP BY deptno
HAVING min(sal) > (SELECT min(sal) FROM emp WHERE deptno=20);



-- 8). ���������� �Ŵ��� ����� �˻� . ����̸��� ����� �����ȣ�� �˻��ǵ���(�⸮�߽� ����̸�, �������ȣ)
-- 1)
SELECT distinct mgr FROM emp;
SELECT * FROM emp WHERE empno IN (SELECT distinct mgr FROM emp);

-- 2)
SELECT e.ename ����̸�, e.empno ����ǻ����ȣ FROM emp e 
WHERE e.empno IN (SELECT m.mgr FROM emp m);
