
-- 2021.11.05

-- Procedure
-- 데이터를 받아서 데이터 변경처리를 프로그램 요소를 이용해서 실행하는 것


-- create or replace {프로시저 이름} (매개변수)
-- as -> 선언부
-- begin -> 프로그램 코드 시작
-- ....
-- end;

desc book;

create or replace procedure InsertBook (
    myBookId in number,
    myBookName in varchar2,
    myPublisher in varchar2,
    myPrice in number
)
as 
begin 
    insert into book (bookid, bookname, publisher, price)
    values (myBookId, myBookName, myPublisher, myPrice);
end; 

