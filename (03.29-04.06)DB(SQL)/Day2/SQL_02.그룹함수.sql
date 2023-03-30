--그룹함수

FROM emp;
/*
그룹함수는 null값을 건너뛴다.
여기에서 제외되는 그룹함수가 COUNT(*)
*/
-- 전체 사원의 수를 리턴...
SELECT COUNT(*) FROM emp;
SELECT COUNT(empno) FROM emp;
SELECT COUNT(-1) FROM emp;
-- 세 번째가 훨씬 성능 좋음

SELECT ROUND(AVG(sal)), SUM(sal), MIN(sal), MAX(sal) FROM emp;
-- 입사한지 가장 오래된 사원의 입사일?
SELECT MIN(hiredate), MAX(hiredate) FROM emp;


