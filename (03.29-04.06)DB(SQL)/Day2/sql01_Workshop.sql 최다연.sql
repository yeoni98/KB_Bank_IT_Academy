--1) EMP 테이블정보의구조를확인하는SQL을작성하세요.
DESC emp;


--2) 이름이K로시작하는사원의사원번호, 이름, 입사일, 급여를검색하세요.
SELECT empno, ename, hiredate, sal
FROM emp
WHERE ename LIKE 'K%';

--3) 입사일이80년도인사람의모든정보를검색하세요.
SELECT ename, empno, hiredate, sal, deptno, job
FROM emp
WHERE hiredate LIKE '80%';

--4) 커미션이NULL이아닌사람의모든정보를검색하세요.
SELECT ename, empno, hiredate, sal, deptno, job, NVL(comm,0)
FROM emp
WHERE comm is not null;

--5) 부서가30번부서이고 급여가$1,500 이상인사람의이름, 부서,월급을검색하세요.
SELECT ename, deptno, sal/12 
FROM emp
WHERE deptno = 30 AND sal >= 1500;


--6) 부서번호가30인사람중사원번호SORT하여출력되도록검색하세요.
SELECT ename, deptno, empno
FROM emp
WHERE deptno = 30
ORDER BY empno;
--7) 급여가많은순으로SORT하여출력되도록검색하세요.
SELECT ename, empno, hiredate, sal, deptno, job
FROM emp
ORDER BY sal DESC;
--8) 부서번호로ASCENDING SORT한후급여가많은사람순으로검색하세요.
SELECT ename, empno, hiredate, sal, deptno, job
FROM emp
ORDER BY deptno, sal DESC;
--9) 부서번호가DESCENDING SORT하고, 이름순으로ASCENDING SORT,급여순으로DESCENDING SORT 하여출력되도록검색하세요.
SELECT ename, empno, hiredate, sal, deptno, job
FROM emp
ORDER BY deptno DESC, ename, sal DESC;
--10) EMP Table에서이름, 급여, 커미션금액, 총액(급여+커미션금액)을 구하여총액이많은순서로검색하세요. 단, 커미션이NULL인 사람은제외한다.(커미션금액: sal*comm/100) 총액의별칭은Total로한다.

SELECT ename, sal, sal*comm/100 comm, sal+sal*comm/100 Total
FROM emp
WHERE comm IS NOT NULL
ORDER BY Total DESC;

--11) 10번부서의 모든사람들에게 급여의13%를 보너스로 지불하기로 하였다. 이름, 급여, 보너스금액, 부서번호를검색하세요.
SELECT ename, sal, sal*0.13 보너스, deptno
FROM emp
WHERE deptno = 10;
--12) 부서번호가20인 사원의 시간당임금을 계산하여 검색하세요. 단, 1달의 근무일수는 12일이고, 1일근무시간은 5시간이다.
--출력양식은 이름, 급여, 시간당임금(소수점 이하 첫번째 자리에서 반올림)을 검색하세요.
SELECT ename, sal, round(sal/12/12/5) 시급
FROM emp
WHERE deptno = 20;

--13) 급여가$1,500부터$3,000 사이의 사람은 급여의15%를 회비로 지불하기로 하였다. 이를 이름, 급여, 회비(소수점 두자리 아래에서 반올림)를 검색하세요.
SELECT ename, sal, ROUND(sal*0.15,2) 회비
FROM emp
WHERE sal between 1500 and 3000;

--14) 모든사원의실수령액을계산하여검색하세요.. 단, 급여가 많은순으로 이름, 급여, 실수령액을 검색하세요..(실수령액은 급여에대해 10%의세금을 뺀금액)
SELECT ename,sal, sal*0.9 실수령
FROM emp
ORDER BY sal DESC;
