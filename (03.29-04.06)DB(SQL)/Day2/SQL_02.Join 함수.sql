-- JOIN
SELECT  FROM DEPT;
SELECT  FROM EMP;

SELECT DISTINCT e.ename, d.loc 
FROM emp e, dept d
WHERE e.deptno = d.deptno;

/*
조인
하나 이상(Self Join) 테이블에서 질의를 던지는 경우
일반적인 경우 FK에 의해서 조인 조건이 성립된다.
Equi Join, Self Join, Outer Join을 주요하게 살펴보자
*/
SELECT empno, ename, sal, job FROM emp; -- 해당 사원의 정보를 알고 싶을때 
SELECT deptno, dname, loc FROM dept; -- 해당 부서의 정보를 알고 싶을때

SELECT  FROM emp, dept;
/*
Cartesian Product
::
emp, dept 테이블이 수평적으로 결합
14  *  4 = 56

1) 조인 조건을 생략했을 때
2) 조인 조건을 잘못 줬을 때
*/

-- STEP1.
SELECT * FROM emp, dept
WHERE emp.deptno = dept.deptno;

-- STEP2. 테이블 Alias
SELECT * FROM emp e, dept d
WHERE e.deptno = d.deptno;

-- STEP3. Projection...성능상 문제가 심각하다
SELECT empno,ename,sal,deptno,dname,loc 
FROM emp e, dept d
WHERE e.deptno = d.deptno; -- 성능 가장 안 좋은 것 중 2번째

-- STEP4. Projection...컬럼마다 테이블 별칭을 각각 다 준다
SELECT e.empno, e.ename, e.sal, e.deptno, d.dname, d.loc 
FROM emp e, dept d
WHERE e.deptno = d.deptno; -- 성능 가장 안 좋은 것 중 2번째

-- STEP5. Equi Join AND Non Join조건
SELECT e.empno, e.ename, e.sal, e.deptno, d.dname, d.loc 
FROM emp e, dept d
WHERE 
e.deptno = d.deptno
AND
d.deptno=10;

/
Self Join
::
하나의 테이블을 자체적으로 조인함
/*
-- 쿼리문 작성 잘 하는 방법 : 천천히 step by step으로 조합하면서
-- 특정 사원의 상사의 이름을 조회
/*

emp테이블에서 먼저 특정한 사원의 ename을 조회
ename에 해당하는 mgr번호를 찾는다
다시 emp테이블에서 empno가 mgr인 사원을 찾아서 ename을 찾는다.
*/

-- STEP1.
SELECT ename, mgr FROM emp; -- BLAKE 사원의 상사번호를 찾고
SELECT empno, ename FROM emp; -- 상사번호와 일치하는 사원번호를 찾고 그에 해당하는 사원 이름을 찾는다.

-- STEP2
SELECT * FROM(SELECT ename, mgr FROM emp) e,
(SELECT empno, ename FROM emp)m;

-- STEP3
SELECT * FROM(SELECT ename, mgr FROM emp) e,
(SELECT empno, ename FROM emp)m
WHERE e.mgr = m.empno;

-- STEP4. 조인 조건 추가
SELECT e.ename 사원이름, m.ename 상사이름
FROM emp e, emp m
WHERE e.mgr = m.empno
AND 
e.ename='BLAKE';

--123 예제1
SELECT e.empno, e.job, e.deptno e_deptno,
       d.deptno d_deptno, d.dname
FROM dept d, emp e
WHERE d.deptno = e.deptno(+); -- Right Outer Join

SELECT e.empno, e.job, e.deptno e_deptno,
       d.deptno d_deptno, d.dname
FROM emp e Right join dept d
ON d.deptno = e.deptno; 

SELECT e.ename, e.sal, e.deptno, d.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno
AND e.sal>2000;

SELECT e.ename, e.sal, e.deptno, d.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno
AND e.sal(+) > 2000;