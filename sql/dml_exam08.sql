
-- 2021.11.04

-- DML_EXAM08


-- 1. phoneInfo_basic 테이블의 SELECT, UPDATE, DELETE, INSERT 하는 SQL
-- 삽입
insert into phoneInfo_basic values (1, 'SON', '010-000-111', 'SON@GMAIL.COM', 'LONDON', SYSDATE);
insert into phoneInfo_basic values (2, 'PARK', '010-000-222', 'PARK@GMAIL.COM', 'KOREA', SYSDATE);
insert into phoneInfo_basic values (3, 'KIM', '010-000-333', 'KIM@GMAIL.COM', 'KOREA', SYSDATE);

select * from phoneInfo_basic;

-- 수정
update phoneInfo_basic
set address = 'CHINA';

-- 삭제
delete from phoneInfo_basic;


-- 2. phoneinfo_univ 테이블의 SELECT, UPDATE, DELETE, INSERT 하는 SQL
-- 삽입
insert into phoneInfo_univ values (1, 'MECHANIC', 2, 1);
insert into phoneInfo_univ values (2, 'MATERIALS', 4, 2);
insert into phoneInfo_univ values (3, 'ELECTRONIC', 1, 3);

select * from phoneInfo_univ;

-- 수정
update phoneInfo_univ
set year = 3
where year < 3;
 
-- 삭제
delete from phoneInfo_univ;


-- 3. phoneinfo_com 테이블의 SELECT, UPDATE, DELETE, INSERT 하는 SQL
-- 삽입
insert into phoneInfo_com values (1, 'HYUNDAI', 1);
insert into phoneInfo_com values (2, 'LG', 2);
insert into phoneInfo_com values (3, 'SAMSUNG', 3);

select * from phoneInfo_com;

-- 수정
update phoneInfo_com
set company = 'NAVER'
where company = 'LG';

-- 삭제
delete from phoneInfo_com;

----------------------------------------------------------------------

select b.id, name, major
from phoneInfo_basic b, phoneInfo_univ u
where b.id = u.id;

select *
from phoneInfo_basic b inner join phoneInfo_com c
on b.id = c.ref
where b.id = 2;

select u.id, name, major, company
from phoneInfo_basic b, phoneInfo_univ u, phoneInfo_com c
where u.id = c.id and b.id = c.id;

------------------------------------------------------------------------

-- RENEW



