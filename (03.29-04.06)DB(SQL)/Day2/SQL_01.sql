-- 테이블의 구조를 확인 emp => 테이블명 / NOT NULL = 프라이머리 키로 지정됨 => NOT NULL +유니크한 값 가짐
DESC emp;
DESC dept;

-- Projection :: 디스플레이 하고자 하는 컬럼만 명시,검색하고자 하는 colum명만 지정해서 가져온다.
SELECT * FROM emp;   -- 모든 컬럼에서 가져와라 => * 이렇게 쓰면 안됨. 
-- why? 1. display되면 안 되는 것까지 같이 노출 돼서/ 2. 성능상의 문제

-- Sales 빼고 다 comm == null / [빈 값]이라기 보단 [자격이 없음] or [미확정]이라는 의미로 봐야 함.

--emp 테이블에서 사원의 이름, 급여, 업무, 부서번호를 검색 => Projection: 검색하고자 하는 걸 지정, 명시
SELECT ename, sal, job, deptno FROM emp;


-- SELECTION :: 조건(where절)을 부여해서 행을 제한
-- 10번 부서에서 근무하는 사원의 이름, 급여, 입사년도를 검색 -> Projection + SELECT
SELECT ename, sal, hiredate
FROM emp
WHERE deptno=10;

-- 급여를 많이 받은 사원 순으로 정렬(ORDER BY)
SELECT ename, sal, hiredate, deptno
FROM emp
WHERE deptno = 10
ORDER BY sal ASC;
-- 반대 순으로
SELECT ename, sal, hiredate, deptno
FROM emp
WHERE deptno = 10
ORDER BY sal DESC;

-- SALESMAN부서에서 사원의 사원번호, 이름, 업무, 부서번호를 검색
-- 정렬은 부서번호 순으로 한다.
SELECT empno 사원번호, ename 이름, job 직업, deptno 부서번호
FROM emp
WHERE job ='SALESMAN'
ORDER BY deptno;


-- step 2  이렇게 해도 됨
SELECT empno 사원번호, ename 이름, job 직업, deptno 부서번호
FROM emp
WHERE job ='SALESMAN'
ORDER BY 사원번호;

-- step 3  이렇게 해도 됨
SELECT empno 사원번호, ename 이름, job 직업, deptno 부서번호
FROM emp
WHERE job ='SALESMAN'
ORDER BY 1;

-- step4 
-- WHERE절의 조건을 변경.. 20번 부서의 사원으로 행을 제한
--SELECT empno 사원번호, ename, job, deptno 
--FROM emp
--WHERE 사원번호 = 20 -- WHERE절에서는 alias(별명)오면 안 됨. WHERE시점에서는 실행 순서가 앞이라 반영이 안 됨. => 실행 순서 중요하다~
--ORDER BY 1;

-- 사원 중에서 입사일이 가장 빠른 사원 순으로 검색
SELECT hiredate 입사일, ename 이름
FROM emp
ORDER BY hiredate;
-- 사원 중에서 급여를 가장 많이 받는 사원 상위 3명 검색(rownum => n번째 행 구할 때)
SELECT ename, job, sal
FROM emp
ORDER BY sal DESC;

-- WHERE절 보다 ORDER BY절이 먼저 실행되도록 해야한다.
-- rownum이 ORDER BY절보다 먼저 실행이 돼서 결과가 잘못나온다.
SELECT ename, job, sal
FROM emp
WHERE rownum<=3
ORDER BY sal DESC;

-- 대안책
-- ( ) 안에 ORDER BY절이 먼저 실행 되고 WHERE절이 동작하도록 작성
SELECT ename, job, sal
FROM (SELECT * FROM emp ORDER BY sal DESC)
WHERE rownum<=3;

-- 모든 사원의 급여를 기존 급여의 2배에 20달러를 추가한 급여로 인상
-- Alias에 공백, 특수문자, 대소문자를 구분해야 하는 경우 => " " 로 묶어준다
-- 컬럼을 ','으로 구분 한다고.
SELECT ename, sal, sal*2+20 "인상 급여" 
FROM emp;

-- step3
SELECT ename, sal, sal*2+20 IncrementSalary 
FROM emp;


 
-- =>SQL에서는 안 됨


-- 사원 급여에서 세금을 제외한 수령한 월급을 검색
SELECT ename, sal, sal*0.9 실수령
FROM emp;

-- EMP테이블에서 모든 사원의 연봉을 검색
-- 이 때 연봉에 대한 Alias 를 AnnualSalary로 지정함
-- Step1.
SELECT ename, job, sal, sal*12+comm AnnualSalary
FROM emp;

-- step2
-- null 값으로 연산이 진행될 때 반드시 다른 값으로 치환해서 사용
-- NVL(comm,0): comm이 null이면 0,null이 아니면 comm을 그대로 사용
SELECT ename, job, sal, sal*12+NVL(comm,0) AnnualSalary
FROM emp;

-- step3
-- comm이 null이 아닌 사원의 연봉을 구한다 라는 조건
SELECT ename, job, sal, sal*12+comm AnnualSalary
FROM emp
WHERE comm is not null;

-- step4
-- comm이 null이 아닌 사원의 연봉을 구한다 라는 조건
SELECT ename, job, sal, sal*12+comm AnnualSalary
FROM emp
WHERE comm is not null;

-- EMP 테이블에 있는 부서(deptno)를 검색 
SELECT deptno FROM emp;

-- EMP테이블에 있는 부서 (deptno)를 검색, DISTINCT(중복을 벗김)
SELECT DISTINCT deptno FROM emp;
SELECT DISTINCT (deptno) FROM emp; 
-- DISTINCT 가 그닥 효율적이지 못함. 성능 떨어짐

-- 자동 정렬 안 됨
SELECT DISTINCT deptno FROM emp ORDER BY 1;

-- DISTINCT를 사용해서 부서 번호를 중복을 벗겨서 가져와야 하는 경우
-- EXISTS를 사용
SELECT deptno from dept d
WHERE EXISTS(SELECT * FROM emp e WHERE d.deptno = e.deptno);

-- 특정한 패턴으로 검색
-- LIKE연산자 + 와일드카드(%, -)와 같이 쓴다.
-- Like -> %는 있을 수도, 없을 수도 있음 //// 
--      -> - 는 오직 한 개만
-- 사원 중에서 이름이 S로 시작하는 사원을 검색 => 'S%'
-- if 두 번째가 S로 시작할 때 => '_S%' 이런식
SELECT ename, job
FROM emp
WHERE ename LIKE 'S%';

-- 사원 중에서 이름에 A가 포함된 사원
SELECT ename, job
FROM emp
WHERE ename LIKE '%A%';

-- 80년에 입사한 사원 검색
SELECT hiredate, ename, job
FROM emp
WHERE hiredate LIKE '80%';




-- IN 연산자
-- 여러 개의 값 중에 어느 하나와 일치하는지를 비교
-- 사원번호가 7369이거나 7521이거나 7782번인 사원을 검색
-- STEP1.
SELECT empno, ename, job FROM emp WHERE empno = 7369;
SELECT empno, ename, job FROM emp WHERE empno = 7519;
SELECT empno, ename, job FROM emp WHERE empno = 7269;
SELECT empno, ename, job FROM emp WHERE empno = 7421;

-- Step2
SELECT empno, ename, job 
FROM emp 
WHERE empno = 7369 OR empno = 7519 OR empno=5921;

-- Step3
SELECT empno, ename, job 
FROM emp 
WHERE empno IN(7369, 7521, 5921);

-- STEP4
-- 사원번호가 7369 아니고 7521 아니고 7782도 아닌 사원을 검색
SELECT empno, ename, job 
FROM emp 
WHERE empno NOT IN(7369, 7521, 5921);

-- 저차원적인, 성능을 떨어뜨리는...
-- 한 번의 파싱으로 ..

-- 문자열
-- SUBSTR(추출할 문자열, 시작위치)
-- SUBSTR(추출할 문자열, 시작위치, 추출갯수)
-- 문자열을 추출하는 기능... 함수안의 인자값을 정확히 이해
SELECT SUBSTR('HelloWorld', 6) FROM dual;
SELECT SUBSTR('HelloWorld', 6, 3) FROM dual;
SELECT SUBSTR('HelloWorld', -4, 2) FROM dual;
-- 사원 이름이 N으로 끝나는 사원을 검색
SELECT ename
FROM emp
WHERE ename LIKE '%N';
-- WHERE SUBSTR(ename,-1) = 'N'; 이것도 됨

-- emp테이블에서 년도만 추출.. 10번 부서에서 검색되도록
SELECT ename, hiredate, SUBSTR(hiredate, 1, 2) 년도
FROM emp
WHERE deptno = 10;
-- OR
SELECT ename, hiredate
FROM emp
WHERE hiredate LIKE '80%';

-- PAD :: LPAD, RPAD
-- 공백이 필요한 경우에 쓴다.
SELECT LPAD('abc', 6, '*') FROM DUAL;
SELECT RPAD('abc', 6, '*') FROM DUAL;
SELECT RPAD(deptno,10) FROM emp;

-- TRIM :: 공백을 제거함 RTRIM, LTRIM, TRIM, REPLACE 
-- => 안전하고 정확하게 값 전달할 때 사용
SELECT RTRIM('    James Gosling    ') FROM dual;
SELECT LTRIM('    James Gosling    ') FROM dual;
SELECT TRIM('    James Gosling    ') FROM dual;
SELECT REPLACE('    James    Gosling    ',' ', '') FROM dual;

-- 숫자함수
SELECT ROUND(45.923,2) FROM dual;
-- 소수점 이하 3번째 자리에서 반올림을 해서 => 2번째 자리까지 표시 
SELECT ROUND(45.923) FROM dual;

-- FLOOR :: 소수점 아래를 버림(정수로만 표시  ) => 자리수 지정 X 
SELECT FLOOR(45.923) FROM dual;
--SELECT FLOOR(45.923,2) FROM dual;
SELECT FLOOR(7.6) FROM dual;

-- TRUNC :: 지정된 자릿수 이하를 버림
SELECT TRUNC(45.923,2)FROM dual;

-- CEIL :: 올림, 정수로만 표시됨
SELECT CEIL(45.923) FROM dual;
--SELECT CEIL(45.923, 2) FROM dual;

-- 날짜 함수
/*
날짜 + 숫자 = 날짜
날짜 - 숫자 = 날짜
날짜 - 날짜 = 기간(숫자)
*/
SELECT SYSDATE +1 "Tomorrow" FROM dual;
SELECT SYSDATE -1 "Yesterday" FROM dual;
SELECT SYSDATE +100 "우리만난지 100일" FROM dual;
SELECT SYSDATE - (SYSDATE+1) FROM dual;

-- 지금까지 살아온 일생을 검색
SELECT round(SYSDATE -TO_DATE('1998/09/25')) "태어난지 얼마나?" FROM dual;
-- 오늘로부터 4개월 후의 날짜를 검색
SELECT ADD_MONTHS(SYSDATE,4) FROM dual;
-- 정길연님의 살아온 월수를 계산
SELECT MONTHS_BETWEEN(SYSDATE,TO_DATE('2000/12/08'))FROM dual;
-- emp테이블에서 사원들이 현재까지 근무한 주 수를 검색
SELECT ename, hiredate, ROUND((SYSDATE - hiredate)/7) "근무한 주"
FROM emp;