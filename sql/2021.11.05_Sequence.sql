
-- 2021.11.05

-- Sequence : 숫자를 생성해주는 객체
-- 설정을 통해서 일련 번호를 생성 -> 기본키가 대리키인 경우 입력 값으로 사용한다.

-- sequence의 생성
-- create sequence {시퀀스이름} 설정...

-- 시퀀스 생성
create sequence test_seq;

-- 부서번호를 자동으로 부여해주는 시퀀스 객체를 생성하는 문장
-- 시작 값은 10, 증가 값은 10, 10 ~ 99
create sequence dept_deptno_seq
start with 10 increment by 10
maxvalue 90;

-- sequence 삭제
drop sequence dept_deptno_seq;

-- 시작 값이 1이고 1씩 증가하는 시퀀스 EMP_SEQ을 생성
create sequence emp_seq
start with 1 increment by 1
minvalue 1 maxvalue 9999;

-- 시퀀스의 값을 확인
-- 현재 값
select emp_seq.currval from dual;
select dept_deptno_seq.currval from dual;

-- 다음(새로운 값)
select emp_Seq.nextval from dual;
select dept_deptno_seq.nextval from dual;

















