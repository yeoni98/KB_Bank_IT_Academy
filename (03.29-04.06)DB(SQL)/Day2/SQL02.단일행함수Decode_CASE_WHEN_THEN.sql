-- Extract(년, 월, 일, 시간, 초 추출할때 사용)
-- emp테이블에서 사원의 이름과 사원이 입사한 년, 월 ,일을 추출...부서번호가 20번인 사원
-- Year, Month, Day
SELECT ename, hiredate,
EXTRACT(YEAR FROM hiredate) AS Year,
EXTRACT(MONTH FROM hiredate) AS Month,
EXTRACT(DAY FROM hiredate) AS Day
FROM emp
WHERE deptno = 20;

-- SUBSTR로도 구현 가능
-- ex) substr(hiredate, 1,2)...

-- EMP 테이블에서 10번 부서원의 입사 일자로부터 돌아오는 금요일, 토요일 계산
SELECT ename, hiredate, next_day(hiredate, 6) n_6,
        next_day(hiredate,7) n_7
FROM emp
WHERE deptno = 10
ORDER BY hiredate DESC;

-- EMP 테이블에서 입사한 달의 근무 일수를 계샇나여 조회한다.
-- 단, 토요일과 일요일도 근무일수에 포함한다.
SELECT empno, ename, hiredate, last_day(hiredate)l_last,
last_day(hiredate)- hiredate l_day
FROM emp
ORDER BY last_day(hiredate)-hiredate desc;

-- EMP 테이블에서 20번 부서 중 급여를 3자리마다 ,를 출력
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

-- 업무가 PRESIDENT면 사장
--       MANAGER면   관리자
--       ANALYST면   분석가
--       직원
--       직원분류 Alias
SELECT ename, job,
       DECODE(job, 'PRESIDENT', '사장',
                   'MANAGER', '관리자',
                   'ANALYST', '분석가',
                   '직원') AS 직원분류
FROM emp;

-- CASE
SELECT ename, deptno,
        CASE WHEN deptno='10' THEN '뉴욕'
             WHEN deptno='20' THEN '달라스'
             WHEN deptno='30' THEN '보스턴'
             ELSE '도시'
        END 도시명
FROM emp;