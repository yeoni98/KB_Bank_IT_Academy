--�׷��Լ�

FROM emp;
/*
�׷��Լ��� null���� �ǳʶڴ�.
���⿡�� ���ܵǴ� �׷��Լ��� COUNT(*)
*/
-- ��ü ����� ���� ����...
SELECT COUNT(*) FROM emp;
SELECT COUNT(empno) FROM emp;
SELECT COUNT(-1) FROM emp;
-- �� ��°�� �ξ� ���� ����

SELECT ROUND(AVG(sal)), SUM(sal), MIN(sal), MAX(sal) FROM emp;
-- �Ի����� ���� ������ ����� �Ի���?
SELECT MIN(hiredate), MAX(hiredate) FROM emp;


