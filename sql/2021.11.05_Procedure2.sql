
-- 2021.11.05

-- Procedure
-- 데이터를 받아서 데이터 변경처리를 프로그램 요소를 이용해서 실행하는 것

desc book;
-- 동일한 도서가 있는지 점검한 후 삽입하는 프로시저 (BookInsertOrUpdate)

create or replace procedure BookInsertOrUpdate (
    -- 매개변수
    myBookId number,
    myBookName varchar2,
    myPublisher varchar2,
    myPrice number
    )
as
    -- 변수 선언 (begin 안쪽에서 사용할 변수들)
    mycount number;
begin 
    -- 입력받은 책 이름으로 같은 일므의 책을 보유하고 있는지 확인 숫자
    select count(*) into mycount from book where bookname like myBookName;
    -- 책의 개수로 분기 : 수정 또는 입력
    if mycount != 0 then
        -- 가격 수정
        update book set price = myPrice where bookname like mybookname;        
    else 
        -- 데이터(행) 입력
        insert into book values (myBookId, myBookName, myPublisher, myPrice);
    end if;
end;

