
-- 2021.11.01

-- 서브쿼리 (부속 질의)
-- select 구문 안에 또 다른 select 구문을 이용하는 sql 문

-- SCOTT 사원의 부서 이름을 출력
select dname, emp.deptno
from emp, dept
where emp.deptno = dept.deptno and ename ='SCOTT';

-- SCOTT 사원의 부서 이름    
-- 1. 내부 쿼리를 먼저 작성 : SCOTT 사원의 부서 번호
select deptno from emp where ename = 'SCOTT';
-- 2. 외부 쿼리 작성 : 부서 번호로 부서이름을 검색
select dname 
from dept 
where deptno = (
    select deptno from emp where ename = 'SCOTT');


-- 마당서점의 고객별 판매액을 보이시오(결과는 고객이름과 고객별 판매액 출력)
-- JOIN 이용
select o.custid, c.name, sum(o.saleprice)
from orders o, customer c
where o.custid = c.custid
group by o.custid, c.name;

-- SUB QUERY
select custid,
    (select name from customer c where o.custid = c.custid) as name,
    sum(saleprice)
from orders o
group by custid;


-- 사원의 이름과 부서 이름을 출력
select ename, deptno,
    (select dname from dept where emp.deptno = dept.deptno)
from emp;

-- join
select ename, dname
from emp, dept
where emp.deptno = dept.deptno;

---------------------------------------------------------

-- 인라인 뷰 : from 뒤에 오는 서브 쿼리 -> select 의 결과를 테이블로 사용

-- 고객번호가 2 이하인 고객의 판매액을 보이시오 (결과는 고객이름과 고객별 판매액 출력)

select custid, name
from customer where custid <= 2;

select o.custid, sum(saleprice)
from orders o,
    (select custid, name from customer where custid <= 2) c
    where o.custid = c.custid
group by o.custid;


select custid
from orders
where custid <= 2
group by custid;

-- 30번 부서의 인라인 뷰를 만들어서 사용
select *
from (select * from emp where deptno = 30);

select e.ename, e.deptno, s.ename
from emp e, emp s
where e.deptno = s.deptno and s.ename='SCOTT';

----------------------------------------------------------------

-- 2021.11.02

-- 중첩 질의

-- 평균 급여보다 더 많은 급여를 받는 사원을 검색하는 문장
select avg(sal) from emp;
-- 평균급여 : 2073.214285714285714285714285714285714286
select ename, sal
from emp
where sal > 2073.214285714285714285714285714285714286;

select ename, sal
from emp
where sal > (select avg(sal) from emp);


-- 평균 주문금액 이하의 주문에 대해서 주문번호와 금액을 보이시오. 
-- 평균 주문 금액 (sub query)
select avg(saleprice) from orders;
-- 주문금액 이하의 주문에 대해서 주문번호와 금액
select orderid, saleprice
from orders
where saleprice <= (select avg(saleprice) from orders);

-- 각 고객의 평균 금액보다 큰 금액의 주문 내역에 대해서 주문번호, 고객번호, 금액을 보이시오
-- 각 고객의 평균 주문금액
select avg(saleprice) from orders where custid = 1;
-- 조건 : 각 고객의 평균 주문금액보다 큰 금액의 주문 내역
-- 주문 내역에 대해서 주문번호, 고객번호, 금액
select custid, orderid, saleprice
from orders o
where saleprice > (select avg(saleprice) from orders OA where OA.custid = O.custid);


-- 다중행 서브 쿼리
-- IN, SOME, ANY, ALL, EXISTS

-- 3000 이상 받는 사원이 소속된 부서와 동일한 부서에서 근무하는 사원
select ename, sal, deptno  
from emp   
where deptno in
    (select distinct deptno from emp where sal >= 3000);
    

-- 대한민국에 거주하는 고객에게 판매한 도서의 총 판매액을 구하시오.
-- 대한민국에 거주하는 고객
select custid from customer where address like '%대한민국%';
-- 도서 총 판매액
select sum(saleprice) from orders;

select sum(saleprice)
from orders
where custid in
    (select custid from customer where address like '%대한민국%');
    

-- 3번 고객이 주문한 도서의 최고 금액보다 더 비싼 도서를 구입한 주문의 고객번호와 금액을 보이시오
-- 3번 고객의 주문 도서의 금액들
select saleprice from orders where custid = 3;
-- 더 비싼 도서를 구입한 주문의 주문번호와 금액
select orderid, saleprice
from orders
where saleprice > all
    (select saleprice from orders where custid = 3);
    

-- 부서번호가 30번인 사원들의 급여 중 가장 작은 값(950)보다 많은 급여를 받는 사원의 이름, 급여를 출력
-- 부서번호가 30번인 사원들의 급여
select sal from emp where deptno = 30;
-- 그 중 가장 작은 값 (필요 없는 부분)
select min(sal) from emp where deptno = 30;
-- 그 보다 많은 급여를 받는 사원의 이름, 급여
select ename, deptno,   sal
from emp
where sal > any
    (select sal from emp where deptno = 30);
    

-- 30번 소속 사원들 중에서 급여를 가장 많이 받는 사원보다 더 많은 급여를 받는 사람의 이름, 급여를 출력하는 쿼리문을 작성
-- 30번 소속 사원들의 급여
select sal from emp where deptno = 30;
-- 그 중 급여를 가장 많이 받는 사원
select max(sal) from emp where deptno = 30;
-- 그 보다 더 많은 급여를 받는 사원의 이름, 급여
select ename, deptno, sal
from emp
where sal > all
    (select sal from emp where deptno = 30);


-- EXISTS 연산자로 대한민국에 거주하는 고객에게 판매한 도서의 총 판매액을 구하시오
-- 대한민국에 거주하는 고객
select custid from customer where address like '%대한민국%';
-- 그 고객에게 판매한 도서의 총 판매액
select sum(saleprice)
from orders o
where exists 
    (select * from customer c where address like '%대한민국%' and c.custid = o.custid);










