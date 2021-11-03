
-- 2021.11.03

-- DDL : 데이터 정의어, 객체 생성, 수정, 삭제 명령어

-- 테이블 생성 : Create table
-- 테이블 수정 : Alter table
-- 테이블 삭제 : Drop table

-- 테이블 생성 양식
-- create table 테이블명 (
--     컬럼이름 데이터_타입(size),  => 도메인 정의
--     .....
-- )

-- 또는

-- create table 테이블명 (
--     컬럼이름 데이터_타입(size) 제약조건 정의(컬럼 레벨 정의),
--     .....,
--     제약조건정의(테이블 레벨 정의)
-- );

-- 부서테이블과 유사한 테이블을 정의
create table dept_test (
    deptno number(2),
    dname varchar2(20),
    loc varchar2(20)
    );
    
-- 테이블 삭제
drop table dept_test;


-- 사원 테이블과 유사한 구조의 사원번호, 사원이름, 급여 3개의 컬럼으로 구성된 테이블 생성
desc emp;
-- EMPNO    NOT NULL NUMBER(4)    
-- ENAME             VARCHAR2(10) 
-- SAL               NUMBER(7,2)

create table emp01 (
    empno number(4),
    ename varchar2(10),
    sal number(7,2)
    );
drop table emp01;

-- 서브쿼리를 이용해 기존 테이블의 구조를 복사하고, 투플을 복사
create table emp02
as
select * from emp;

desc emp02; --> 확인해보면 컬럼의 정의만 복사하고, 제약조건은 복사되지 않는다는 걸 알 수 있음.
drop table emp02;

select * from emp02;

-- 원하는 컬럼만 복사
create table emp03
as
select empno, ename from emp;

desc emp03;
select * from emp03;

-- 원하는 데이터만 복사
create table emp04
as
select * from emp where deptno = 10;

desc emp04;
select * from emp04;

-- 구조만 복사
select * from emp where 1=0;  --> 무조건 false가 나오므로 출력X
create table emp05
as
select * from emp where 1=0;

desc emp05;
select * from emp05;


-- 테이블 구조의 변경 : alter table
-- 컬럼 추가 : alter table {테이블 이름} add (컬럼정의);

-- EMP01 테이블에 문자 타입의 직급(JOB) 칼럼을 추가해 보자
alter table emp01
add (job varchar2(9));

desc emp01;

alter table emp01
add (  
    hiredate date,
    dempno number(2)
    );
    
-- 컬럼의 변경 : alter table {테이블 이름} modify (컬럼정의);

-- 직급(JOB) 칼럼을 최대 30글자까지 저장 할 수 있게 해보자.
alter table emp01
modify (job varchar2(30) not null);

desc emp01;

-- 컬럼의 삭제 : alter table {테이블 이름} drop coulmn 컬럼이름;

-- EMP01 테이블의 직급 칼럼을 삭제해 보도록 합시다.
alter table emp01 drop column job;
desc emp01;

-- 테이블의 모든 투플을 삭제 : truncate
-- 삭제와 동시에 commit : 바로 물리적인 반역 즉 상태저장이 바로 이루어짐.

-- emp02 테이블의 모든 데이터를 삭제
truncate table emp02;
select * from emp02;
    

-- 테이블 이름 변경 : rename {old_name} to {new_name}
-- emp02 테이블의 이름을 test 로 변경
rename emp02 to test;
desc test;

--------------------------------------------------------------------------

-- 제약 조건 확인
desc dept;

insert into dept (deptno, dname, loc) 
    values (10, 'test', 'SEOUL');









