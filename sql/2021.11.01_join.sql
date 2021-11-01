
-- 2021.11.01
-- JOIN
-- 스키마의 결합, 행은 집합의 합 연산이다.
-- 컬럼의 개수가 늘어난다. 행은 행 x 행 의 결과가 생성
-- 의미 있는 데이터를 만들기 위해 컬럼의 비교 연산이 필요하다


-- Cross Join : 단순히 테이블을 붙이는 조인
-- 컬럼을 붙이고, 행(데이터)은 집합의 합 연산(카티즌 곱)
-- => 전체 행은 'R1의 행의 개수' X '  R2의 행의 개수'
-- emp 테이블과 dept 테이블의 join -> 14 * 4 = 56개의 행

-- Cross Join 문
-- select * from 테이블 명, 테이블 명, ...
select *
from emp, dept
order by dept.deptno;


-- Equi Join : 특정 컬럼의 값들을 비교해서 같은 결과 행만 추출
select *
from emp, dept
where emp.deptno = dept.deptno;

-- 'SCOTT' 사원의 부서이름을 출력
select ename, emp.deptno, dept.deptno, dname
from emp,dept
where emp.deptno = dept.deptno and ename = 'SCOTT';


-- 테이블의 별칭 이용
select *
from emp e, dept d
where e.deptno = d.deptno;

select *
from salgrade;

select e.ename, e.sal, s.grade
from emp e, salgrade s
where e.sal >= s.losal and e.sal <= s.hisal
order by e.empno;


-- Self Join : 나 자신을 참조해서 붙이는 조인
select e.ename, e.mgr, m.empno, m.ename
from emp e, emp m
where  e.mgr = m.empno
order by e.mgr;
-- 결과의 행의 개수가 13 --> mgr -> nul 의 경우 무조건 false가 나온다.



-- Outer Join
select e.ename as eName, nvl(m.ename,'관리자 없음') as Manager
from emp e, emp m
where  e.mgr = m.empno(+)
order by e.mgr;


-- Cross Join
select *
from emp, dept;

-- Ansi Join
select *
from emp cross join dept;

-- Inner Join
-- select * 
-- from t1 inner join t2
-- on 컬럼의 비교 조건(Join의 비교)

-- 'SCOTT' 사원의 사원 정보와 부서정보를 inner join을 이용해서 출력한다면
select *
from emp inner join dept
on emp.deptno = dept.deptno
where emp.ename = 'SCOTT';


select *
from emp e join dept d
-- on e.deptno = d.deptno
using (deptno);

select *
-- from emp inner join dept
-- on emp.deptno = dept.deptno;
from emp natural join dept;


-- ANSI Outer Join
-- from R1 [LEFT | RIGH | FULL] outer join R2
-- 사원 이름과 상관의 이름을 출력
select e.ename, m.ename
-- from emp e left outer join emp m
from emp m right outer join emp e
on e.mgr = m.empno;


-- 테이블 세개 조인 : 주문내역 (고객정보, 책의 정보, 구매정보)
-- 주문 고객의 이름과 책의 이름 구매 날짜와 구매 금액을 출력
select c.name, b.bookname, o.orderdate, o.saleprice
from book b, customer c, orders o
where o.custid = c.custid and o.bookid = b.bookid;
