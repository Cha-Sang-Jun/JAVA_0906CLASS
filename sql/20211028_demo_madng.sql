
-- 2021.10.28 관계형 데이터 베이스

-- 로그인한 사용자가 보유하고 있는 테이블 정보를 가지고 있는 메타데이터 테이블
select * from tab;  -- '*' => 테이블 내의 모든 컬럼 출력

-- 테이블의 구조 확인
desc dept;  -- DEPTNO, DNAME, LOC 는 컬럼이름 / NOT NULL은 null 값을 허용X / 유형은 데이터 타입

select * from emp;
select * from dept;
select loc, deptno, dname from dept; -- 컬럼 순서를 loc, deptno, dname 순서로 출력되게
select * from book;
select * from customer; -- 여기서 null 은 없다는 뜻이 아님. 값이 정해지지 않았다는 것(0일수도 무한대일수도 없을수도?)
select * from orders; -- Table간 relation 을 볼 수 있는 표. CUSTID로 어떤 회원이 BOOKID로 어떤 책을 주문했는지 알 수 있다.
select orderid, custid, saleprice from orders;

-- Select 구문에서 컬럼의 산술연산이 가능

select sal, sal + 100, sal - 100, sal * 12, sal / 2 
from emp; -- salary 컬럼에 산술연산 값만 구할 수 있는것이 아니라, sal + 100 이라는 별개의 컬럼도 만들 수 있음

select * from emp;

-- 우리 회사의 사원들의 이름과 월 급여, 연봉(월급x12) 을 리스트로 출력
select ename, sal, sal * 12
from emp;

-- 연봉에 + comm, 주의! comm의 값 중에는 null이 있음
-- null : 정해지지 않은 값. 있는것도 아니고 없는것도 아니다. 연산의 결과 또한 null
select ename, sal, sal*12, comm, sal*12+comm
from emp;

-- null 값을 치환해주는 nvl 함수
-- nvl(컬럼명, 치환 데이터) => 컬럼의 값중 null 값은 치환 값으로 출력
select comm, nvl(comm, 0)
from emp;

-- nvl 함수를 이용해서 결과 값 도출
select ename, sal, sal*12, comm, sal*12+comm, comm, nvl(comm, 0), sal *12+nvl(comm,0)
from emp;

-- 별칭을 이용해서 컬럼이름 출력
select ename as "사원이름", sal as " 월 급여", sal*12+nvl(comm,0) as 연봉
from emp;

select ename name, sal sal, sal*12+nvl(comm,0) salOfYear
from emp;

-- 문자열을 연결해주는 || 연산자
select ename || ' is a ' || job msg
from emp;

-- 사원들이 소속된 부서 번호 출력
select distinct deptno
from emp; -- distinct => 중복된 값 배제

-- 우리 서점에 입점한 출판사 리스트 출력
select distinct publisher
from book;

select distinct deptno, job
from emp; 

------------------------------------------------------

-- 연봉이 3000 이상인 사원만 출력
select *  -- 출력하고자 하는 컬럼
from emp -- 대상 테이블
where sal >= 3000; -- 조건 : 비교연산 또는 논리연산 => 행을 찾을 조건


-- 10번 부서에 소속된 -> 행을 검색할 조건
-- 사원의 리스트 출력
select *
from emp
where deptno = 10;


-- 이름이 FORD인 사원 : 행
-- 사원번호(EMPNO)와 사원이름(ENAME)과 급여(SAL)을 출력 : 컬럼
select empno, ename, sal
from emp
where ename = 'FORD';  -- 문자열 비교시 반드시 작은따옴표 사용

-- 날짜 비교 : 82년 이후 입사자
select *
from emp
where hiredate >= '82/01/01';

-- 10번 부서 소속인 사원들 중에서 -> and
-- 직급이 MANAGER 인 사람을 검색하여
-- 사원명, 부서번호, 직급을 출력
select ename, deptno, job
from emp
where deptno = 10 and job = 'MANAGER';


-- 10번 부서 소속된 사원이거나 -> or
-- 직급이 MANAGER 인 사람을 검색하여
-- 사원명, 부서번호, 직급을 출력
select ename, deptno, job
from emp
where deptno = 10 or job = 'MANAGER';


-- 부서번호가 10번이 아닌 사원의
-- 사원이름, 부서번호, 직급 출력
select *
from emp
-- where not deptno = 10;
-- where deptno <>10;
where deptno != 10;


-- 2000에서 3000사이의 급여를 받는 사원 출력
select *
from emp
-- where sal >= 2000 and sal <= 3000;
where sal between 2000 and 3000;


-- 1987년에 입사한 사원을 출력해 봅시다.
select *
from emp
where hiredate between '87/01/01' and '87/12/12';


-- 커미션이 300이거나 500 이거나 1400 인 사원을
-- 검색하기 위해서 In 연산자를 사용해 봅시다.
select *
from emp
-- where comm = 300 or comm = 500 or comm = 1400;
where comm in(300,500,1400);


-- like 패턴 검색
-- F 로 시작하는 이름을 가진 사원을 검색 - 와일드카드(%) 사용하기
select *
from emp
where ename like 'S%';


-- 이름 중 A를 포함하는 사원을 검색
select *
from emp
where ename like '%A%';



-- 이름이 N으로 끝나는 사원을 검색
select *
from emp
where ename like '%N';


-- 이름의 두 번째 글자가 A인 사원을 검색
select *
from emp
where ename like '_A%';


-- 커미션을 받지않는 사원을 검색
select *
from emp
-- where comm is null or comm = 0;
where comm is not null and comm != 0; -- 커미션을 받는 사원들


-- 정렬을 위한 order by 절
-- order by 컬럼명 {[asc] | desc} , asc(오름차순), desc(내림차순)
-- 급여 컬럼을 기준으로 오름차순으로 정렬
select *
from emp
order by sal asc;


-- 사원 이름순으로 정렬
select *
from emp
order by ename;


-- 입사일 순으로 정렬(내림차순), 입사일이 같을 경우 급여순 정렬
select *
from emp
order by hiredate, sal asc;