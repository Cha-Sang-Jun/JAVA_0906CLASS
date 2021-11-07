
-- 2021.11.06

-- join_exam05

-- 1. 마당서점의고객이요구하는다음질문에대해SQL 문을작성하시오.
-- (5) 박지성이구매한도서의출판사수
select count(b.publisher)
from customer c, orders o, book b
where c.custid = o.custid and o.bookid = b.bookid and name = '박지성';

--(6) 박지성이구매한도서의이름, 가격, 정가와판매가격의차이
select bookname, price, (price - saleprice) as pricegap
from book b, orders o, customer c
where c.custid = o.custid and o.bookid = b.bookid and name = '박지성';

--(7) 박지성이구매하지않은도서의이름
select b.bookname
from book b
where not exists
    (select b.bookid from customer c, orders o where c.custid = o.custid and o.bookid = b.bookid and name = '박지성');
    
-- 2. 마당서점의운영자와경영자가요구하는다음질문에대해SQL 문을작성하시오.
--(8) 주문하지않은고객의이름(부속질의사용)
select name
from customer c
where not exists
    (select c.custid from orders o where c.custid = o.custid);
    
--(9) 주문금액의총액과주문의평균금액
select sum(saleprice) as total, avg(saleprice)
from orders;

--(11) 고객의이름과고객이구매한도서목록
select c.name, b.bookname
from book b, customer c, orders o
where c.custid = o.custid and o.bookid = b.bookid;

--(12) 도서의가격(Book 테이블)과 판매가격(Orders 테이블)의 차이가 가장 많은 주문


--3. 마당서점에서 다음의 심화된 질문에 대해 SQL 문을 작성하시오.
--(1) 박지성이 구매한 도서의 출판사와 같은 출판사에서 도서를 구매한 고객의 이름
    
--(2) 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름

