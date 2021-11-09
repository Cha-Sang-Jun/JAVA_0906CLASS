
-- 2021.11.08

-- NCS_SQL 활용

-- 기본 전화번호부 테이블
create table Contact (
    pIdx number(6) constraint c_pIdx_pk primary key,
    c_name varchar2(20) not null,
    c_phonenumber varchar2(20) not null,
    c_address varchar2(20) default 'Seoul' not null,
    c_email varchar2(20) default 'N' not null
);

-- Contact 테이블 pk -> pIdx 에 입력할 일련번호 시퀀스
create sequence c_pIdx_seq
start with 1 increment by 1
minvalue 1 maxvalue 999999;


-- 카테고리 별 친구정보 테이블
-- 대학동료
create table Contact_univ (
    pIdx number(6) constraint univ_pIdx_pk primary key,
    univ_major varchar2(20) default 'N' not null,
    univ_year number(1) default 1 not null,
    univ_ref number(6) not null,
    constraint chk check (univ_year between 1 and 4),
    constraint univ_ref_fk foreign key (univ_ref) references Contact (pIdx)
);

create sequence univ_seq
maxvalue 999999;

-- 회사동료
create table Contact_com (
    pIdx number(6) constraint com_pIdx_pk primary key,
    com_companyname varchar2(20) default 'N' not null,
    com_dept varchar2(20) default 'N' not null,
    com_job varchar2(2) default 'Intern' not null,
    com_ref number(6) not null,
    constraint com_ref_fk foreign key (com_ref) references Contact (pIdx)
);

create sequence com_seq
maxvalue 999999;

-- 카페동료
create table Contact_cafe (
    pIdx number(6) constraint cafe_pIdx_pk primary key,
    cafe_circle varchar2(20) default 'Study' not null,
    cafe_nickname varchar2(20) default 'Visitor' not null,
    cafe_ref number(6) not null,
    constraint cafe_ref_fk foreign key (cafe_ref) references Contact (pIdx)
);

create sequence cafe_seq
maxvalue 999999;

-------------------------------------------------------------------------

-- 2. DEPT 테이블에 데이터를 삽입하는 SQL을 작성하시오. 입력 데이터는 임의로 작성하시오.
insert into dept values (50, 'RESEARCH', 'DALLAS');
insert into dept values (25, 'ACCOUNTING', 'LA');

-- 3. DEPT 테이블에 위에서 삽입한 데이터의 dname, loc 데이터를 변경하는 SQL을 작성하시오.
update dept
set dname = 'RESEARCH'
where dname = 'ACCOUNTING' and deptno = 25;

update dept
set loc = 'NEWYORK'
where dname = 'RESEARCH' and loc = 'DALLAS';

select * from dept;

--입력 데이터는 임의로 작성하시오.
--4. DEPT 테이블에 위에서 삽입한 데이터를 deptno 컬럼의 값을 기반으로 삭제하는 SQL을 작성하시오.
delete from dept
where deptno = (select deptno from dept where dname = 'RESEARCH' and deptno = 50);

--5. 사용자가 보유한 테이블 목록을 확인하는 SQL문을 작성하시오.
select * from tab;

--6. EMP 테이블의 구조를 확인하는 SQL을 작성하시오.
desc emp;

--7. 사용자가 정의한 제약조건들을 확인하는 SQL문을 작성하시오.
select * from all_constraints;


---------------------------------------------------------------------------------

-- #2 아래 요구사항에 맞도록 고급 SQL 문을 작성하시오.
-- 1. EMP 테이블의 ename 컬럼에 인덱스를 생성하는 SQL을 작성하시오. 인덱스의 이름은 emp_index
create index emp_index on emp(ename);

-- 2. EMP 테이블과 DEPT 테이블을 조인하는 SQL을 기반으로 view 객체를 생성하는 SQL을 작성하시오.
-- view 의 이름은 emp_view 로 하시오. 
create or replace view emp_view
as
select empno, ename, deptno
from emp
where deptno = 30;

select * from emp_view;

-- 3. EMP 테이블에서 모든 사원의 부서번호를 이름이 'SCOTT'인 사원의 부서번호로 변경하는 SQL을 작성하시오.
update emp
set deptno =  
    (select deptno from emp where ename = 'SCOTT');
