
-- 2021.11.05

-- INDEX : 검색의 성능을 높이기 위해 사용하는 객체
-- 물리적인 저장공간을 가진다 -> 저장공간 확보 필요
-- 데이터의 변경시에는 성능이 떨어질 수 있다.
-- 인덱스는 필수가 아니라 선택사항

-- 검색이 오래걸리는 환경
drop table emp01;

create table emp01
as
select * from emp
;
select count(*) from emp01;

insert into emp01 (empno, ename) values (1000, 'test1');


select * from emp01 where ename='test1';
select * from emp01;

delete from emp01 where ename='SCOTT';
commit;

-- 많은 데이터 입력
insert into emp01 select * from emp01 ;

create index emp01_index on emp01(ename);



select * from book;
delete from book where bookid>10;

drop table book_log;





