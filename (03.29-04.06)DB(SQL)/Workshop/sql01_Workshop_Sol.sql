--  1) EMP ���̺� ������ ������ Ȯ���ϴ� SQL�� �ۼ� �ϼ���.
DESC emp;

-- 2) �̸��� K�� �����ϴ� ����� �����ȣ, �̸�, �Ի���, �޿��� �˻��ϼ���.
SELECT empno, ename, hiredate, sal
FROM emp
WHERE ename LIKE 'K%';

-- 3)�Ի����� 80�⵵�� ����� ��� ������ �˻��ϼ���.
SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno
FROM emp
WHERE hiredate LIKE '80%';

-- 4)Ŀ�̼��� NULL�� �ƴ� ����� ��� ������ �˻��ϼ���.
SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno
FROM emp
WHERE comm IS NOT NULL;

-- 5)�μ��� 30�� �μ��̰� �޿��� $1,500 �̻��� ����� �̸�, �μ� ,������ �˻��ϼ���.
SELECT ename, deptno, sal
FROM emp
WHERE deptno = 30 and sal >= 1500;

-- 6)�μ���ȣ�� 30�� ��� �� �����ȣ SORT�Ͽ� ��µǵ��� �˻��ϼ���.
SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno
FROM emp
WHERE deptno = 30
ORDER BY empno;

-- 7)�޿��� ���� ������ SORT�Ͽ� ��µǵ��� �˻��ϼ���
SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno
FROM emp
ORDER BY sal DESC;

-- 8)�μ���ȣ�� ASCENDING SORT�� �� �޿��� ���� ��� ������  �˻��ϼ���
SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno
FROM emp
ORDER BY deptno, sal DESC;

-- 9)�μ���ȣ�� DESCENDING SORT�ϰ�, �̸� ������ ASCENDING SORT,
-- �޿� ������ DESCENDING SORT �Ͽ� ��µǵ��� �˻��ϼ���.
SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno
FROM emp
ORDER BY deptno DESC, ename, sal DESC;

-- 10)  EMP Table���� �̸�, �޿�, Ŀ�̼� �ݾ�, �Ѿ�(�޿�+Ŀ�̼Ǳݾ�)�� 
-- ���Ͽ� �Ѿ��� ���� ������ �˻��ϼ���. ��, Ŀ�̼��� NULL��
-- ����� �����Ѵ�.(Ŀ�̼Ǳݾ�: sal*comm/100) 
-- �Ѿ��� ��Ī�� Total�� �Ѵ�.
SELECT ename, sal, sal*comm/100 comm, sal+sal*comm/100 Total
FROM emp
WHERE comm IS NOT NULL
ORDER BY Total DESC;

-- 11)10�� �μ��� ��� ����鿡�� �޿��� 13%�� ���ʽ��� �����ϱ�� �Ͽ���. �̸�, �޿�, ���ʽ� �ݾ�, �μ���ȣ�� �˻��ϼ���.
SELECT ename, sal, sal*0.13 Bonus, deptno
FROM emp
WHERE deptno = 10;

SELECT ename, sal, sal*.13 Bonus, deptno
FROM emp
WHERE deptno = 10;

-- 12)�μ���ȣ�� 20�� ����� �ð��� �ӱ��� ����Ͽ� �˻��ϼ���.
-- ��, 1���� �ٹ��ϼ��� 12���̰�, 1�� �ٹ��ð��� 5�ð��̴�. 
-- ��¾���� �̸�, �޿�, �ð��� �ӱ�(�Ҽ��� ���� ù ��° �ڸ����� �ݿø�)�� �˻��ϼ���
SELECT ename, sal, round(sal/12/5) HourSal
FROM emp
WHERE deptno = 20;

-- 13)�޿��� $1,500���� $3,000 ������ ����� �޿��� 15%�� ȸ��� �����ϱ�� �Ͽ���. �̸� �̸�, �޿�, ȸ��(�Ҽ��� ���ڸ� �Ʒ����� �ݿø�)�� �˻��ϼ���.
SELECT ename, sal, round(sal*.15, 2) ȸ��
FROM emp
WHERE sal between 1500 and 3000;

SELECT ename, sal, round(sal*.15, 2) ȸ��
FROM emp
WHERE sal <=3000 AND sa>=1500;

-- 14) ��� ����� �� ���ɾ��� ����Ͽ� �˻��ϼ���.. ��, �޿��� ����  ������ �̸�, �޿�, �� ���ɾ��� �˻��ϼ���..(�� ���ɾ��� �޿���  ���� 10%�� ������ �� �ݾ�)
SELECT ename, sal, sal*.9 as �Ǽ��ɾ�
FROM emp
ORDER BY sal DESC;
