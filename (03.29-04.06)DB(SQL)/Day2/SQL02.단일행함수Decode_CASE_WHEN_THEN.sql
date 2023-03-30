-- Extract(��, ��, ��, �ð�, �� �����Ҷ� ���)
-- emp���̺��� ����� �̸��� ����� �Ի��� ��, �� ,���� ����...�μ���ȣ�� 20���� ���
-- Year, Month, Day
SELECT ename, hiredate,
EXTRACT(YEAR FROM hiredate) AS Year,
EXTRACT(MONTH FROM hiredate) AS Month,
EXTRACT(DAY FROM hiredate) AS Day
FROM emp
WHERE deptno = 20;

-- SUBSTR�ε� ���� ����
-- ex) substr(hiredate, 1,2)...

-- EMP ���̺��� 10�� �μ����� �Ի� ���ڷκ��� ���ƿ��� �ݿ���, ����� ���
SELECT ename, hiredate, next_day(hiredate, 6) n_6,
        next_day(hiredate,7) n_7
FROM emp
WHERE deptno = 10
ORDER BY hiredate DESC;

-- EMP ���̺��� �Ի��� ���� �ٹ� �ϼ��� �蘸���� ��ȸ�Ѵ�.
-- ��, ����ϰ� �Ͽ��ϵ� �ٹ��ϼ��� �����Ѵ�.
SELECT empno, ename, hiredate, last_day(hiredate)l_last,
last_day(hiredate)- hiredate l_day
FROM emp
ORDER BY last_day(hiredate)-hiredate desc;

-- EMP ���̺��� 20�� �μ� �� �޿��� 3�ڸ����� ,�� ���
SELECT empno, ename, job, sal, to_char(sal,'999,999')
FROM emp
WHERE deptno = 20
ORDER BY sal desc;

CREATE TABLE test(num number);
DESC test;
INSERT INTO test VALUES(20003050);
SELECT num FROM test;
SELECT num, to_char(num,'999,999,999')
FROM test;

-- ������ PRESIDENT�� ����
--       MANAGER��   ������
--       ANALYST��   �м���
--       ����
--       �����з� Alias
SELECT ename, job,
       DECODE(job, 'PRESIDENT', '����',
                   'MANAGER', '������',
                   'ANALYST', '�м���',
                   '����') AS �����з�
FROM emp;

-- CASE
SELECT ename, deptno,
        CASE WHEN deptno='10' THEN '����'
             WHEN deptno='20' THEN '�޶�'
             WHEN deptno='30' THEN '������'
             ELSE '����'
        END ���ø�
FROM emp;