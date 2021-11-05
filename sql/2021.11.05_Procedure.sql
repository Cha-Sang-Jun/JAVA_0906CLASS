
-- 2021.11.05

-- Procedure
-- 데이터를 받아서 데이터 변경처리를 프로그램 요소를 이용해서 실행하는 것


-- create or replace {프로시저 이름} (매개변수)
-- as -> 선언부
-- begin -> 프로그램 코드 시작
-- ....
-- end;

desc book;
-- BOOK 테이블에 한 개의 투플을 삽입하는 프로시저
create or replace procedure InsertBook (
    -- 매개변수 선언
    myBookId in number,
    myBookName in varchar2,
    myPublisher in varchar2,
    myPrice in number
)
as 
begin -- 코드 실행 시작
     -- 핵심처리 코드
     -- 매개변수로 받은 데이터를 이용해서 데이터 삽입.
    insert into book (bookid, bookname, publisher, price)
    values (myBookId, myBookName, myPublisher, myPrice);
end; -- 코드 실행 종료

-- 프로시저 호출 : 실행 요청
-- exec 프로시저명 (매개변수 값, ....);
exec insertbook(16, '반지의 제왕', '마당과학서적', 15000);
select * from book;

-- 같은 이름의 책을 등록해보고, 다른 이름의 책을 입력
-- 같은 이름의 책 등록
exec BookInsertOrUpdate (15, '스포츠과학', '마당과학서적', 10000);
exec BookInsertOrUpdate (15, '스포츠의 즐거움', '마당과학서적', 10000);

--------------------------------------------------------

set serveroutput on;
declare
    avgVal number;
begin
    -- 프로시저 호출
    avgPrice (avgVal);
    dbms_output.put_line('책값 평균 : ' || avgVal);
end;

-------------------------------------------------
set serveroutput on;
exec Interest;