
-- 2021.11.03

-- DDL_EXAM7

drop table phoneInfo_basic;
create table phoneInfo_basic (
    id number(6) constraint basic_id primary key,
    name varchar2(20) not null,
    phonenum varchar2(20) not null,
    email varchar2(20),
    address varchar2(20),
    regdate date default sysdate
    );
    
desc phoneInfo_basic;
select * from phoneInfo_basic;

------------------------------------------------------------------------------------

drop table phoneInfo_univ;
create table phoneInfo_univ (
    id number(6) constraint univ_id primary key,
    major varchar2(20) default 'N' not null,
    year number(1) default 1 constraint univ_year check (year between 1 and 4) not null,
    ref number(7) constraint univ_ref references phoneInfo_basic(id) not null
    );
    
desc phoneInfo_univ;
select * from phoneInfo_univ;

---------------------------------------------------------------------------

drop table phoneInfo_com;
create table phoneInfo_com (
    id number(6) constraint com_id primary key,
    company varchar2(20) default 'N' not null,
    ref number(6) constraint com_ref references phoneInfo_basic(id) not null
    );
    
desc phoneInfo_com;
select * from phoneInfo_com;

---------------------------------------------------------------------------

-- RENEW

drop table basicinfo;

create table basicinfo (
    id number(6) constraint basicinfo_id primary key,
    name varchar2(20) not null,
    team varchar2(20) not null,
    sal varchar2(20),
    loc varchar2(20)
    );
    
create table eplteam (
    id number(6) constraint epl_id primary key,
    circle varchar2(20) default 'N' not null,
    grade number(1) default 1 constraint high_grade check (grade between 1 and 3) not null,
    ref number(7) constraint highfriend_ref references basicinfo (id) not null
    );
    

create table army (
    id number(6) constraint army_id primary key,
    rank varchar2(20) default 'N' not null,
    retire date default sysdate,
    ref number(7) constraint highfriend_ref references basicinfo (id) not null
    );

