-- ##################  ���ڿ� �Լ� �ǽ� ######################

-- 1) ���� ���� �� �����ȣ, �̸�, �޿��� ����Ѵ�.  ��, �̸��� �տ��� 3���ھ��� ����϶�.
select empno, substr(ename,1,3), sal  from emp;

-- 2) �̸��� ���ڼ��� 6�� �̻��� ����� �̸��� �տ��� 3�ڸ� ���Ͽ� �ҹ��ڷ� �̸����� ����϶�.
select ename,  lower(substr(ename, 1,3)) 
from emp
where  length(ename) >=6;

-- 3) ���������� �Է��ϴ��� �Ʒ��� ���� �Է� �Ǿ���.(�̸��� ������ �Էµ�)
insert into emp values(8001,'   PARK   ', 'IT' ,  7521 , '21/11/10', 20000,1000,10);
select * from emp;

-- �̸��� 'PARK'�� ������ ������ ����Ͽ� ����.
  select * from emp  where  ename='PARK';

-- �̸� �¿쿡 ������ �ִ��� ������ �����ϰ� �̸��� 'PARK'�� ������ ������ ����Ͽ� ����.
 select * from emp  where  trim(ename)='PARK';


-- ##################  ���� �Լ� �ǽ� ######################
-- 4) �޿��� $1,500���� $3,000 ������ ����� �޿��� 15%�� ȸ��� �����ϱ�� �Ͽ���. 
-- �̸� �̸�, �޿�, ȸ��(�Ҽ��� �� �ڸ� �Ʒ����� �ݿø�)�� ����϶�.
select ename, sal, round(sal*0.15, 2) ȸ��
from emp
where sal between 1500 and 3000;
 
-- 5) �޿��� $2,000 �̻��� ��� ����� �޿��� 5%�� ������� ���� �� �Ͽ���. 
-- �̸�, �޿�, ������(�Ҽ��� ���� ����)�� ����϶�.
select ename, sal, FLOOR(sal*0.05) ������
from emp
where sal>=2000;
  

-- ##################  ��¥ �Լ� �ǽ� ######################

-- 6)�Ի��Ϸκ��� 100���� ���� �ĸ� ���غ���. ����̸�, �Ի���, 100�� ���� ��, �޿��� ����϶�.
select ename, hiredate, hiredate+100, sal   from emp;

-- 7) �Ի��Ϸκ��� 6������ ���� ���� ��¥�� ���Ϸ��� �Ѵ�.  �Ի���, 6���� ���� ��¥, �޿��� ����϶�
SELECT hiredate �Ի���, add_months(hiredate, 6) "6���� ���� ��¥", sal �޿� from emp;

-- 8) �Ի��� ���� �ٹ��ϼ��� ����Ͽ� �μ���ȣ, �̸�, �ٹ��ϼ��� ����϶�.
select ename,hiredate,last_day(hiredate)from emp;
select deptno, ename, last_day(hiredate)-hiredate �ٹ��ϼ� from emp;

-- 9) ��� ����� �Ի��� �������� 100���� ���� ���� �������� ��¥�� ���ؼ� �̸�, �Ի���,��MONDAY���� ����϶�.
select ename, hiredate, next_day(hiredate+100,'������') as MONDAY  from emp; 
select ename, hiredate, next_day(hiredate+100,2) as MONDAY  from emp; 

-- 10) ������ �̸�, �ټӳ���� ���Ͽ� ����϶�.
select ename, trunc((sysdate-hiredate)/365) �ټӳ�� from emp;


-- ##################  ��ȯ �Լ� �ǽ� ######################

-- 11) ��� ������ �̸��� �Ի����� ��1996-05-14���� ���·� ��� �϶�.
select ename, hiredate from emp;
select ename, to_char(hiredate,'yyyy-mm-dd') �Ի��� from emp;

-- 12) ��� ������ ��ȣ, �̸�, �޿��� ����϶�. ��, �޿��տ� ȭ��ǥ��($), �׸��� õ����(,)ǥ��, �Ҽ������� 2�ڸ��� ǥ�õǵ��� �϶�.
select empno, ename, to_char(sal,'$99,999.99') �޿� from emp;

-- 13) ��� ������ �̸��� �Ի��� ������ ����϶�.
SELECT ename, hiredate �Ի���, to_char(hiredate,'DAY') �Ի���� from emp;


-- ##################  �Ϲ� �Լ� �ǽ� ######################

-- mgr�� null�̸� ���������/ null�̸� mgr���� �������� �Ѵ�.
-- ��Ī�� mgr2�� ����

SELECT ename, mgr,
		CASE  WHEN mgr is null THEN '���������'       
			 ELSE mgr || '' 
		END mgr2
FROM emp;

select ename, mgr,
        CASE  WHEN mgr is null THEN '���������'  
        ELSE mgr || '�����'
        END MGR2
from emp;

SELECT ename, mgr,
		CASE  WHEN mgr is null THEN '���������'       
			 ELSE TO_CHAR(mgr)
		END mgr2
FROM emp;

select ename, mgr, 
       decode(mgr, null, '����������', mgr ||'��� ')
 from emp;
 
 select ename, mgr, nvl2(mgr, mgr||'��� ', '���������� ')
  from emp;


