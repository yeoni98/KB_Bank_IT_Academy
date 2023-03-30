--1) EMP ���̺������Ǳ�����Ȯ���ϴ�SQL���ۼ��ϼ���.
DESC emp;


--2) �̸���K�ν����ϴ»���ǻ����ȣ, �̸�, �Ի���, �޿����˻��ϼ���.
SELECT empno, ename, hiredate, sal
FROM emp
WHERE ename LIKE 'K%';

--3) �Ի�����80�⵵�λ���Ǹ���������˻��ϼ���.
SELECT ename, empno, hiredate, sal, deptno, job
FROM emp
WHERE hiredate LIKE '80%';

--4) Ŀ�̼���NULL�̾ƴѻ���Ǹ���������˻��ϼ���.
SELECT ename, empno, hiredate, sal, deptno, job, NVL(comm,0)
FROM emp
WHERE comm is not null;

--5) �μ���30���μ��̰� �޿���$1,500 �̻��λ�����̸�, �μ�,�������˻��ϼ���.
SELECT ename, deptno, sal/12 
FROM emp
WHERE deptno = 30 AND sal >= 1500;


--6) �μ���ȣ��30�λ���߻����ȣSORT�Ͽ���µǵ��ϰ˻��ϼ���.
SELECT ename, deptno, empno
FROM emp
WHERE deptno = 30
ORDER BY empno;
--7) �޿�������������SORT�Ͽ���µǵ��ϰ˻��ϼ���.
SELECT ename, empno, hiredate, sal, deptno, job
FROM emp
ORDER BY sal DESC;
--8) �μ���ȣ��ASCENDING SORT���ı޿���������������ΰ˻��ϼ���.
SELECT ename, empno, hiredate, sal, deptno, job
FROM emp
ORDER BY deptno, sal DESC;
--9) �μ���ȣ��DESCENDING SORT�ϰ�, �̸�������ASCENDING SORT,�޿�������DESCENDING SORT �Ͽ���µǵ��ϰ˻��ϼ���.
SELECT ename, empno, hiredate, sal, deptno, job
FROM emp
ORDER BY deptno DESC, ename, sal DESC;
--10) EMP Table�����̸�, �޿�, Ŀ�̼Ǳݾ�, �Ѿ�(�޿�+Ŀ�̼Ǳݾ�)�� ���Ͽ��Ѿ��̸��������ΰ˻��ϼ���. ��, Ŀ�̼���NULL�� ����������Ѵ�.(Ŀ�̼Ǳݾ�: sal*comm/100) �Ѿ��Ǻ�Ī��Total���Ѵ�.

SELECT ename, sal, sal*comm/100 comm, sal+sal*comm/100 Total
FROM emp
WHERE comm IS NOT NULL
ORDER BY Total DESC;

--11) 10���μ��� ������鿡�� �޿���13%�� ���ʽ��� �����ϱ�� �Ͽ���. �̸�, �޿�, ���ʽ��ݾ�, �μ���ȣ���˻��ϼ���.
SELECT ename, sal, sal*0.13 ���ʽ�, deptno
FROM emp
WHERE deptno = 10;
--12) �μ���ȣ��20�� ����� �ð����ӱ��� ����Ͽ� �˻��ϼ���. ��, 1���� �ٹ��ϼ��� 12���̰�, 1�ϱٹ��ð��� 5�ð��̴�.
--��¾���� �̸�, �޿�, �ð����ӱ�(�Ҽ��� ���� ù��° �ڸ����� �ݿø�)�� �˻��ϼ���.
SELECT ename, sal, round(sal/12/12/5) �ñ�
FROM emp
WHERE deptno = 20;

--13) �޿���$1,500����$3,000 ������ ����� �޿���15%�� ȸ��� �����ϱ�� �Ͽ���. �̸� �̸�, �޿�, ȸ��(�Ҽ��� ���ڸ� �Ʒ����� �ݿø�)�� �˻��ϼ���.
SELECT ename, sal, ROUND(sal*0.15,2) ȸ��
FROM emp
WHERE sal between 1500 and 3000;

--14) ������ǽǼ��ɾ�������Ͽ��˻��ϼ���.. ��, �޿��� ���������� �̸�, �޿�, �Ǽ��ɾ��� �˻��ϼ���..(�Ǽ��ɾ��� �޿������� 10%�Ǽ����� ���ݾ�)
SELECT ename,sal, sal*0.9 �Ǽ���
FROM emp
ORDER BY sal DESC;
