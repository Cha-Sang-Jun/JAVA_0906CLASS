
-- 2021.10.29

-- desc : 테이블 구조를 살펴보기 위한 명령어
-- 단일 행 -> 각 행의 특정 컬럼(값 하나)
desc dual;
select * from dual; 


-- 함수 : 단일행 함수, 집함 함수

-- 단일행 함수 : 숫자, 문자, 날짜, 변환

-- 숫자 함수 
select ABS(-15.5) from dual;  -- ABS() : 절대 값으로 변환
select FLOOR(15.722) "Floor" from dual;  --FLOOR() : 실수를 정수로 변환
select ROUND(15.924, 2) from dual;  -- ROUND(A,B) : 실수를 정수로 반올림해서 변환
select ROUND(15.234, -1) from dual;
select TRUNC(15.6789, 2) from dual;  -- TRUNC() : 원하는 자리에서 절삭해서 정수로 변환(반올림X)
select trunc(15.3366, -1) from dual;
select mod(10, 3) from dual; -- mod(제수, 피제수) : 나눗셈의 나머지를 구함


-- 문자 함수
select lower ('MR. SCOTT MCMILLAN') "lowercase" from dual;  -- lower() : 소문자로 변환
select ename, lower(ename) from emp;
select concat('저는', '손흥민 입니다') from dual;  -- concat() : 문자열 붙이기
select ename || ' is a ' from emp;
select concat('저의 이름은', ename) from emp;
select LPAD('page 1', 15, '*') from dual;  -- lpad() : 원하는 자릿수 대로 오른쪽 정렬
select RPAD('page 1', 12, '*') from dual; -- rpad() : 왼쪽 정렬
select rpad('001111-3', 14, '*') from dual;

select substr ('ABCDEFG', 3, 4) from dual; -- substr(A,B) : 문자열에서 A번째부터 B개만큼 자름
select substr('001212-3001234', 1, 8) from dual;
select substr(hiredate, 1, 2) from emp;


select rpad(substr('001212-3001234', 1, 8), 14, '*') from dual;
select rpad(substr(name, 1, 2), 5, '*') from customer; -- 한글은 2Byte 씩 인식되기 때문에 자릿수 3개가 아닌 5로 해야한다.

select Ltrim('       =from=      ') from dual; -- Ltrim() : 왼쪽 공백 자름
select Rtrim('       =from=      ') from dual;  -- Rtrim() : 오른쪽 공백 자름

select trim('+' from '+++++from+++++') from dual; --trim('A','B') : 문자열 B에서 A를 없앤다.
select trim(' ' from '  ++ from+   +  ') from dual;   -- 문자열 사이 공백은 못 없애는 듯?

select REPLACE('JACK and JUE','J','BL') from dual; -- REPLACE('A' , 'B', 'C') : A문자열에 있는 B문자를 C문자로 교체함.
select replace('000 0000 0000', ' ', '-') from dual;


-- 날짜 함수
select sysdate from dual;  -- sysdate : 시스템에 저장된 현재 날짜 반환
select sysdate -30 from dual;
select add_months(sysdate, 4) from dual;  -- 현재 날짜에 4개월 더한 날짜 반환
select last_day(sysdate+40) from dual; 


-- 변환 함수 : 
-- 날짜 -> 문자 : to_char (원본, 패턴)
select to_char (sysdate, 'YYYY.MM.DD. day dy AM PM HH HH24: MI: SS') from dual;
select hiredate, to_char(hiredate, 'yyyy.mm.dd') from emp;

-- 2021.10.29. 13:00 표현
select to_char(sysdate, 'yyyy.mm.dd am hh:mi') from dual;

-- 숫자 -> 문자 : to_char (원본, 패턴)
select to_char(100000.12, '0,000,000.000') from dual;  -- 원본 숫자의 자리수가 패턴 자릿수보다 더 커지면 표현을 못한다.(에러발생)
select to_char(10000, '9,999,999') from dual;  -- 일반적으로 0패턴보다는 9패턴 사용
select to_char(100000.123, '9,999,999.999') from dual;
select to_char(100000, 'L9,999,999') from dual;
select sal, to_char(sal * 1200, 'l9,999,999') from emp;

-- 문자 -> 날짜 : to_date (원본, 패턴)
select to_date ('2021-10-29' , 'yyyy-mm-dd') from dual;

-- 2021.01.01 ~ 오늘
select trunc (sysdate - to_date('2021-01-01' , 'yyyy-mm-dd')) from dual;


-- 문자 -> 숫자 : to_number (원본, 패턴)

































