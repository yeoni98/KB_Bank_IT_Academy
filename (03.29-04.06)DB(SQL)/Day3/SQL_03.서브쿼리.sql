-- 단일행 서브쿼리
-- WHERE절 사용
-- CLARK의 급여보다 더 많은 급여를 받는 사원을 검색
-- step1 성능이 가장 안 좋음 sql파싱을 두 번 하기 때문
SELECT sal FROM emp WHERE ename = 'CLARK';
SELECT ename,sal FROM emp WHERE sal >2450;

-- step2 파싱 1번, 테이블은 2번 호출
SELECT ename, sal FROM emp WHERE sal >(SELECT sal FROM emp WHERE ename ='CLARK');


-- ename이 KING인 사원과 같은 부서에서 일하는 사원을 검색...
-- SELECT절에서 사용/WHERE절
SELECT ename, deptno FROM emp WHERE deptno=(SELECT deptno FROM emp WHERE ename='KING');

-- HAVING 절에 사용되는 서브쿼리. job별 가장 작은 평균급여를 검색
SELECT job, ROUND(AVG(sal)) FROM emp 
GROUP BY job
HAVING (AVG(sal))=(SELECT MIN(AVG(sal)) FROM emp GROUP BY job); 
 
 
-- 부서별 최소급여 중에서 20번 부서의 최소 급여보다 더 큰 최소급여를 검색
SELECT deptno, MIN(sal) FROM emp
GROUP BY deptno
HAVING MIN(sal)>(SELECT MIN(sal) FROM emp WHERE deptno =20);

-- 3. FROM절에 사용되는 서브쿼리
-- step1... ORDER BY 절이 가장 나중에 실행된다.
SELECT ename, sal,rownum FROM emp 
WHERE rownum<=3
ORDER BY sal DESC;

-- step2... FROM절에서 사용되는 서브커리:ORDER BY 절이 먼저 실행..(ORDER BY~~) 
SELECT ename, sal,rownum FROM (SELECT * FROM emp ORDER BY sal DESC) 
WHERE rownum<=3;
-- => 서브쿼리를 쓰면 테이블을 2번 이상 건드릴 수 밖에 없다~





-- '='은 단일행 연산자. 그래서 여러줄 나오면 못 씀
-- 다중행 연산자를 써야 됨 => '=' => 'IN'으로
SELECT empno, ename
FROM emp
WHERE sal IN (SELECT MIN(sal) FROM emp GROUP BY deptno);

--
SELECT ename, sal, job
FROM emp
WHERE job!='SALESMAN' AND sal>ANY(SELECT sal FROM emp WHERE job='SALESMAN');

SELECT ename, sal, job
FROM emp
WHERE job !='SALESMAN' AND sal>(SELECT MIN(sal) FROM emp WHERE job='SALESMAN');

SELECT ename, sal, job
FROM emp
WHERE job !='SALESMAN' AND sal>(SELECT MAX(sal) FROM emp WHERE job = 'SALESMAN');


-- SCOTT의 급여보다 더 많은 급여를 받는 사원을 검색
-- 1. 
SELECT ename, sal, job
FROM emp
WHERE sal>(SELECT sal FROM emp WHERE ename ='SCOTT');

-- 2.테이블 알리야스 사용
SELECT a.ename, a.sal, a.job
FROM emp a, (SELECT sal FROM emp WHERE ename ='SCOTT') b
WHERE a.sal>b.sal;



-- 상호 연관 서브쿼리
SELECT ename, sal, deptno, hiredate, job
FROM EMP E
WHERE sal >(SELECT AVG(sal) FROM EMP WHERE deptno = E.deptno);


SELECT*FROM emp;

-- 사원을 관리할 수 있는 사람의 평균 급여보다 급여를 더 많이 받는 사원정보 조회
SELECT ename, sal, deptno, hiredate, job
FROM emp e
WHERE sal>(SELECT AVG(sal) FROM emp WHERE e.empno = mgr);




--EXISTS연산자
-- step1 EXISTS()
SELECT deptno, dname
FROM DEPT d
WHERE EXISTS(SELECT 'A' FROM emp WHERE deptno = d.deptno);
--STEP2 DISTINCT (내부적으로 중복 삭제하는게 효율이 좀 떨어짐)
SELECT DISTINCT dname, e.deptno
FROM dept d, emp e
WHERE e.deptno = d.deptno;
--step3. IN 가장 많이 쓰임
SELECT dname, deptno
FROM dept
WHERE deptno IN(SELECT deptno FROM emp WHERE job='MANAGER');