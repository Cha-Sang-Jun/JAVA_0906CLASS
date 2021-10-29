
-- 2021.10.29

-- desc : 테이블 구조를 살펴보기 위한 명령어
-- 단일 행 -> 각 행의 특정 컬럼(값 하나)
desc dual;
select * from dual; 


-- 단일행 함수 : 숫자, 문자, 날짜, 변환
-- 숫자 함수 
select ABS(-15.5) from dual;  -- ABS() : 절대 값으로 변환
select FLOOR(15.722) "Floor" from dual;  -- FLOOR() : 실수를 정수로 변환
select ROUND(15.924, 2) from dual;  -- ROUND(A,B) : 실수를 정수로 반올림해서 변환
select ROUND(15.234, -1) from dual;
select TRUNC(15.6789, 2) from dual;  -- TRUNC() : 원하는 자리에서 절삭해서 정수로 변환(반올림X)
select trunc(15.3366, -1) from dual;
select mod(10, 3) from dual;   -- mod(제수, 피제수) : 나눗셈의 나머지를 구함


-- 문자 함수
select lower ('MR. SCOTT MCMILLAN') "lowercase" from dual;  -- lower() : 소문자로 변환
select ename, lower(ename) from emp;
select concat('저는', '손흥민 입니다') from dual;  -- concat() : 문자열 붙이기
select ename || ' is a ' from emp;
select concat('저의 이름은', ename) from emp;
select LPAD('page 1', 15, '*') from dual;   -- lpad() : 원하는 자릿수 대로 오른쪽 정렬
select RPAD('page 1', 12, '*') from dual;   -- rpad() : 왼쪽 정렬
select rpad('001111-3', 14, '*') from dual;

select substr ('ABCDEFG', 3, 4) from dual;  -- substr(A,B) : 문자열에서 A번째부터 B개만큼 자름
select substr('001212-3001234', 1, 8) from dual;
select substr(hiredate, 1, 2) from emp;


select rpad(substr('001212-3001234', 1, 8), 14, '*') from dual;
select rpad(substr(name, 1, 2), 5, '*') from customer; -- 한글은 2Byte 씩 인식되기 때문에 자릿수 3개가 아닌 5로 해야한다.

select Ltrim('       =from=      ') from dual; -- Ltrim() : 왼쪽 공백 자름
select Rtrim('       =from=      ') from dual;  -- Rtrim() : 오른쪽 공백 자름

select trim('+' from '+++++from+++++') from dual; -- trim('A','B') : 문자열 B에서 A를 없앤다.
select trim(' ' from '  ++ from+   +  ') from dual;   -- 문자열 사이 공백은 못 없애는 듯?

select REPLACE('JACK and JUE','J','BL') from dual; -- REPLACE('A' , 'B', 'C') : A문자열에 있는 B문자를 C문자로 교체함.
select replace('000 0000 0000', ' ', '-') from dual;


-- 날짜 함수
select sysdate from dual;  -- sysdate : 시스템에 저장된 현재 날짜 반환
select sysdate -30 from dual;
select add_months(sysdate, 4) from dual;  -- 현재 날짜에 4개월 더한 날짜 반환
select last_day(sysdate+40) from dual; 

---------------------------------------------------------------------------------------------------------------

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
select to_number('100,000' , '9,999,999') + 100000 from dual;


----------------------------------------------------------------------------------------------------

-- SWITCH CASE와 유사한 DECODE 함수
-- emp 테이블에서 사원 이름, 부서 번호, 부서 이름 출력
select ename, deptno,
 decode (deptno, 10, 'ACCOUNT', 20, 'RESEARCH', 30, 'SALES', 40, 'OPERATIONS') as dname
from emp;

-- 직급에 따라 급여를 인상하도록 하자. 직급이 'ANALYST'인 사원은 5%, 
-- 'SALESMAN'인 사원은 10%,
-- 'MANAGER'인 사원은 15%, 
-- 'CLERK'인 사원은 20%인 인상한다. 
select ename, job, sal,
          decode (job, 
          'ANALYST', sal *1.05,
          'SALESMAN', sal *1.1,
          'MANAGER', sal *1.15,
          'CLERK', sal *1.2
          ) as upSal
from emp;



-- case when then : if else if 와 유사하다 -> 조건식을 ' = ' 이 외의 비교연산을 할 수 있다.
select ename, sal,
    case 
        when sal >= 3000 then sal *1.1
        when sal < 3000 then sal *2
    end as upSal
from emp;


--------------------------------------------------------------------------------------------------

-- 집합 함수(그룹 함수) : 하나의 행의 컬럼이 대상이 아니고, 행 그룹의 컬럼들(집합)이 대상이다.
select
    to_char (sum (sal) *1200, 'L999,999,999') as "월 급여 총액",
    to_char(round(avg (sal) * 1200), 'L999,999,999') as "월 급여 평균",
    count(*) as "총 사원의 수",
    count(comm) as "커미션 등록된 수",
    sum(comm) as "커미션 합",
    avg(comm) as "커미션 평균",
    max(sal) as "가장 높은 급여",
    min(sal) as "가장 낮은 급여"
from emp;

-- 사원들의 업무의 개수
select count(distinct job) as "업무의 수" from emp;

-- 각 부서별 급여의 총 합
-- Group by : 특정 컬럼으로 grouping -> 그룹내의 평균이나 합과 같은 집합 함수를 사용 할 수 있다.
-- 부서번호를 기준으로 grouping
-- > 급여의 총합, 평균, 최대, 최소, 사원의 수, 커미션을 받는 사람, 커미션 평균 및 총합 출력
select deptno,
        count(*) as "사원의 수",
        sum (sal) as "급여 총합",
        trunc (avg (sal)) as "급여 평균",
        max (sal) as "최대 급여",
        min (sal) as "최소 급여",
        count(comm) as "커미션 대상자 수",
        nvl(avg (comm), 0) as "커미션 평균",
        nvl(sum (comm), 0) as "커미션 총합"
from emp
-- where deptno != 20  -> grouping 되기 전 대상들을 기준으로 조건으로 걸러낸다 -> group by 앞에 위치
group by deptno
-- having avg (sal) >= 2000  -- 출력하는 컬럼의 집합함수를 조건으로 잡을 때 having 함수를 사용 -> grouping이 된 후 그룹을 대상으로 조건으로 걸어낸다 -> group by 뒤에 위치
having max (sal) >= 2900
order by deptno;





























