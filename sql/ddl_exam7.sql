
-- 2021.11.03

-- DDL_EXAM7

drop table phoneInfo_basic;
create table phoneInfo_basic (
    idx number(6) constraint phoneInfo_basic_idx primary key,
    fr_name varchar2(20) not null,
    fr_phonenumber varchar2(20) not null,
    fr_email varchar2(20),
    fr_address varchar2(20),
    fr_regdate date default sysdate
    );
desc phoneInfo_basic;
select * from phoneInfo_basic;

insert into phoneInfo_basic (idx, fr_name, fr_phonenumber, fr_email, fr_address) values (200000, 'name2', '010-0000-2222', '22@gmail.com', 'ToT');

----------------------------------

drop table phoneInfo_univ;
create table phoneInfo_univ (
    idx number(6) constraint phoneInfo_univ_idx primary key,
    fr_u_major varchar2(20) default 'N' not null,
    fr_u_year number(1) default 1 constraint phoneInfo_univ_fr_u_year check (fr_u_year between 1 and 4) not null,
    fr_ref number(7) constraint phoneInfo_univ_fr_ref references phoneInfo_basic(idx) not null
    );
desc phoneInfo_univ;
select * from phoneInfo_univ;

insert into phoneInfo_univ values (211112, 'MECHANIC', 4, 200000);

-------------------------

drop table phoneInfo_com;
create table phoneInfo_com (
    idx number(6) constraint phoneInfo_com_idx primary key,
    fr_c_company varchar2(20) default 'N' not null,
    fr_ref number(6) constraint phoneInfo_com_fr_ref references phoneInfo_basic(idx) not null
    );
desc phoneInfo_com;
select * from phoneInfo_com;

insert into phoneInfo_com values (100000, 'NAVER', 200000);
