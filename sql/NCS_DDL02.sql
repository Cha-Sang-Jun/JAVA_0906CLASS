
-- 2021.11.07

-- NCS_DDL02

--아래 DDL은 책 정보를 저장하는 테이블입니다. 이 테이블을 기준으로 아래 문제를 해결하시오.
CREATE TABLE Book01 (
	bookid NUMBER(2) PRIMARY KEY,
	bookname VARCHAR2(40),
	publisher VARCHAR2(40),
	price NUMBER(8)   
);	

CREATE TABLE Book01_log(
	bookid_l NUMBER,
	bookname_l VARCHAR2(40),
	publisher_l VARCHAR2(40),
	price_l NUMBER
);


--1．동일한 도서가 있는지 점검한 후 삽입하는 프로시저(BookInsertOrUpdate)를 작성하시오.

create or replace procedure BookInsertOrUpdate (
    myBookId number,
    myBookName varchar2,
    myPublisher varchar2,
    myPrice number
    )
as
    mycount number;
begin
    select count(*) into mycount from book where bookname like myBookName;
    if mycount != 0 then
        update book set price = myPrice where bookname like mybookname;
    else
        insert into book values (myBookId, myBookName, myPublisher, myPrice);
    end if;
end;
    

--2．판매된 도서에 대한 이익을 계산하는 함수(fnc_Icom)를 작성하시오.
--（이익금 계산 조건 :　가격이 30,000원 이상이면 10%, 30,000원 미만이면 5% ）
create or replace function func_interest (
    price number
) return int
is
    -- 변수 선언
    myInterest number;
begin
    -- 30,000원 이상이면 10%, 미만 5% 값을 반환
    if price >= 30000 then
        myInterest := price *0.1;
    else
        myInterest := price *0.05;
    end if;
    
    -- 값을 반환
    return myInterest;
end;

-- Test
-- 함수 호출 후 출력
select orderid, custid, bookid, saleprice, func_Interest(saleprice)
from orders;


--3．새로운 도서를 삽입한 후 자동으로 Book_log 테이블에 삽입한 내용을 기록하는 트리거를 작성하시오.

create table book_log (
    bookid_l number,
    bookname_l varchar2(40),
    publisher_l varchar2(40),
    price_l number
    );

-- for each row : 여러개의 행이 있더라도 각 행이 하나하나 실행될때 입력해줌

-- 트리거
create or replace trigger afterInsertBook
after insert on book for each row
declare
    -- 변수선언
    average number;
begin
    insert into book_log
    values (:new.bookid, :new.bookname, :new.publisher, :new.price);
    dbms_output.put_line ('book_log 테이블의 백업');
end;

------------------------------------------------------------------

-- 트리거 실행 테스트
insert into book values (20, '스포츠 과학2', '이상미디어', 60000);
select * from book_log;













