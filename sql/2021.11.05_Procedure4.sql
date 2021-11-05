
-- 2021.11.05

-- Procedure

-- Orders 테이블의 판매 도서에 대한 이익을 계산하는 프로시저 (Interest)
create or replace procedure Interest
as
    -- 변수 선언
    myInterest numeric;
    price numeric;
    -- 1. 커서 생성(정의)
    cursor interestCursor is select saleprice from orders;
begin
    myInterest := 0.0;
    -- 2. 커서 오픈
    open interestCursor;
    -- 반복하면서 각 행의 값을 처리
    loop
        -- 3. 커서 패치
        fetch interestCursor into price;
        
        -- 반복문의 탈출
        exit when interestCursor%notfound;  --> 반복하면서 데이터가 더이상 없을때 벗어난다.
        
        -- price 값을 비교
        if price >= 30000 then
            myInterest := myInterest + price *0.1;
        else
            myInterest := myInterest + price *0.05;
        end if;
        
    end loop;    
    -- 4. 커서 종료
    close interestCursor;
    dbms_output.put_line('전체 수익금 : ' || myInterest);
end;










