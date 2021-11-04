
-- 2021.11.03
-- DML : 입력, 수정, 삭제


-- 테스트 테이블 생성
drop table dept01;

create table dept01
as
select * from dept where 1=0
;


-- 데이터의 입력 
-- insert into {테이블 명} (컬러명, ...) values (data, ...);
-- 입력하고자 하는 컬럼의 개수와 입력데이터의 개수는 일치해야 한다.
-- 컬럼의 도메인과 입력데이터의 타입이 일치해야 한다!!!
-- 컬럼의 제약중에 not null 인 컬럼을 생략하면 안된다!!!

desc dept01;

insert into dept (dname, loc) values ('개발팀', '판교');

insert into dept01 (deptno, dname) values (20, 'DEV', '서울');

-- 모든 컬럼의 데이터를 입력할 경우 컬럼을 기술하는것을 생략 가능
insert into dept01 values (30, 'ACCOUNTING', null);
insert into dept01 values (30, 'ACCOUNTING', '');
insert into dept01 (deptno, dname) values (20, 'DEV');

select * from dept01;

--------------------------------------------------------------
-- 서브 쿼리를 이용한 데이터 입력

drop table dept02;

create table dept02
as
select * from dept where 1=2;

select * from dept02;

-- 서브 쿼리를 이용해서 데이터 삽입
insert into dept02 select * from dept;
insert into dept02 select * from dept02;
select * from dept02;


---------------------------------------------------------------------

-- 2021.11.04

-- DML : 데이터의 변경 -> 데이터 삽입, 수정, 삭제

drop table emp01;
create table emp01
as
select * from emp
;
select * from emp01;

-- update 테이블이름 set 컬럼이름=값, 컬럼이름=값, ... where 행 선택 조건

-- 1. 모든 사원의 부서번호를 30번으로 수정합시다.
--    모든 사원은 where 절을 사용하지 않은 경우
update emp01
set deptno=30
;
select * from emp01;

-- 2. 이번엔 모든 사원의 급여를 10% 인상시키는 UPDATE 문을 보겠습니다.
update emp01
set sal = sal*1.1
;
select * from emp01;

-- 3. 모든 사원의 입사일을 오늘로 수정하려면 다음과 같이 합니다.
update emp01
set hiredate = sysdate
;
select * from emp01;


-- 특정 행의 데이터 수정방법
-- 1.부서번호가 10번인 사원의 부서번호를 30번으로 수정합시다.
update emp01
set deptno=30
where deptno=10
;
select * from emp01 where deptno=10;
select * from emp01 order by deptno;


-- 2. 급여가 3000 이상인 사원만 급여를 10% 인상합시다.
update emp01
set sal = sal*1.1
where sal >= 3000
;
select * from emp01 where sal>=3000;

-- 3. 1987년에 입사한 사원의 입사일이 오늘로 수정합시다. 
--    사원의 입사일을 오늘로 수정한 후에 테이블 내용을 살펴봅시다.
update emp01
set hiredate = sysdate
where substr(hiredate, 1, 2) = '87'
;
select * from emp01 where substr(hiredate, 1, 2) = '21';

-- SCOTT 사원의 부서번호는 20번으로, 직급은 MANAGER로 한꺼번에 수정하도록 합시다. 
update emp01
set deptno = 20, job = 'MANAGER'
where ename = 'SCOTT';

select * from emp01 where ename = 'SCOTT';

-- SCOTT 사원의 입사일자는 오늘로, 급여를 50 으로 커미션을 4000 으로 수정합시다. 
update emp01
set hiredate = sysdate, sal = 50, comm = 400
where ename = 'SCOTT';

select * from emp01 where ename = 'SCOTT';


-- 서브쿼리를 이용한 데이터 수정
-- 20번 부서의 지역명을 40번 부서의 지역명으로 변경하기 위해서 서브 쿼리문을 사용해 봅시다.
drop table dept01;
create table dept01
as 
select * from dept;

update dept01
set loc =
    (select loc
        from dept01
        where deptno = 40)
        where deptno = 20;


-- 서브쿼리를 이용해 한꺼번에 두 개의 컬럼 값 변경
-- 서브 쿼리를 이용해서 부서번호가 20인 부서의 부서명과 지역명을 부서 번호가 40번인 부서와 동일하게 변경하도록 해 봅시다
update dept01
set (dname, loc) = 
    (select dname, loc from dept01 where deptno = 40)
    where deptno = 20;

select * from dept01;


-- "행"을 삭제하는 delete 문
-- dept01 테이블의 모든 데이터(행)를 삭제
delete from dept01;
delete from emp01;
desc dept01;
select * from dept01;
select * from emp01;

rollback; --> 마지막 커밋된 위치로 이동, 마지막 커밋 후 작업된 DML은 사라진다.(반영이 되지 않는다)

-- 부서 테이블에서 30번 부서만 삭제
delete from dept01
where deptno = 30;  --> 이 상태에서 외부에서 다른 프로그램으로 DB를 보면 30번 부서는 아직 존재하는 것으로 보인다.

-- commit; -> 커밋완료가 되면 완전히 지워진다. 롤백 불가


-- 사원 테이블에서 부서명이 SALES인 사원을 모두 삭제
delete from emp01
where deptno = (select deptno from dept01 where dname = 'RESEARCH');

