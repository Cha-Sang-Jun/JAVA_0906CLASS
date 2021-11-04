
-- 2021.11.04

-- View
-- 가상 테이블 : 물리적인 테이블의 select의 결과를 테이블로 사용
-- 1. 복잡한 sql(select)문을 간단히 사용할 수 있음
-- 2. 보안이 필요한 컬럼의 데이터를 보호하는 기능


-- create or replace view {뷰 이름}
-- as {sub query}

-- 자주 사용되는 30번 부서에 소속된 사원들의 사번과 이름과 부서번호를 출력하기 위한 select 문을 하나의 뷰로 정의
select empno, ename, deptno
from emp
where deptno = 30;

-- View 생성
create or replace view emp_view30
as
select empno, ename, deptno
from emp
where deptno = 30;

-- 가상테이블 View 를 이용해서 질의
select * from emp_view30;

select * from user_views;  --> 사용자의 view를 확인해 볼 수 있음.

select text from user_views where view_name = 'EMP_VIEW30'; --> 사용자가 생성한 view 중 검색하는 기능?

-- view 삭제
drop view emp_view30;

-- rownum : 테이블 생성시 입력 순서, 그러나 인라인뷰로 세팅을 다시해서 바꿀 수 있다.
select rownum, ename, hiredate
from emp
order by hiredate;

-- 입사일이 가장 오래된 5명 출력 (rownum 보다 작은범위만 계산가능 rownum >= 5 는 출력X)
select rownum, ename, hiredate
from (select * from emp order by hiredate)
where rownum <= 5;

-- 급여액 TOP3
select rownum, ename, sal
from (select * from emp order by sal desc)
where rownum <= 3;

-- 게시물의 리스트 --> 범위를 인라인뷰로 지정 가능
-- 회원 리스트
-- 1page = 10개 => 1~10개 출력
-- 2page = 10개 => 11 ~ 20개 출력

-- 입사일 기준으로 정렬한 가상 테이블
create or replace view emp_hir
as
select * from emp order by hiredate;

select rownum, ename, hiredate
from emp_hir
where rownum <= 5;










