create table food(
    fid number(2) constraint food_id_pk primary key,
    fname varchar2(20) not null,
    fprice number(10) not null
    );
    
create sequence food_id_seq
start with 1
increment by 1
minvalue 1
maxvalue 999999;
    
insert into Food
values(food_id_seq.nextval, '그린 샐러드', 12000);
insert into Food
values(food_id_seq.nextval, '안심 스테이크', 24000);
insert into Food
values(food_id_seq.nextval, '갈릭 스테이크', 28000);
insert into Food
values(food_id_seq.nextval, '페퍼로니 피자', 19000);
insert into Food
values(food_id_seq.nextval, '포테이토 피자', 20000);
insert into Food
values(food_id_seq.nextval, '로제 파스타', 16000);
insert into Food
values(food_id_seq.nextval, '트러플 파스타', 18000);
insert into Food
values(food_id_seq.nextval, '자몽에이드', 7000);
insert into Food
values(food_id_seq.nextval, '탄산음료', 5000);
insert into Food
values(food_id_seq.nextval,'테라 생맥주', 8000);

select * from food;

--------------------------------------------------------------------

create table tables (
    tid number(1) constraint tables_id_pk primary key,
    constraint tables_tid_ck check (tid between 1 and 11)
);

insert into tables values (1);
insert into tables values (2);
insert into tables values (3);
insert into tables values (4);
insert into tables values (5);
insert into tables values (6);
insert into tables values (7);
insert into tables values (8);
insert into tables values (9);
insert into tables values (10);

select * from tables;

--------------------------------------------------------------------

create table orders (
    oid number(6) constraint orders_id_pk primary key,
    tid number(1) not null constraint orders_tid_ck references tables(tid),
    fid number(2) not null constraint orders_fid_ck references food(fid)
    );
    
create sequence orders_id_seq
start with 1
increment by 1
minvalue 1
maxvalue 999999;

select * from orders;

--------------------------------------------------------------------

create table reservation (
    rid number (6) constraint reservation_id_pk primary key,
    rdate varchar2 (40) not null,
    rname varchar2(20) not null,
    rphone varchar2(20) not null,
    rnum number (1) not null,
    tid number(6) unique constraint reservation_tid_fk references tables(tid)
   );
   
create sequence reservation_id_seq
start with 1
increment by 1
minvalue 1
maxvalue 999999;

insert into reservation values(reservation_id_seq.nextval, '2021.11.30', '손흥민', '010-1111-1111', 3, 1);
insert into reservation values(reservation_id_seq.nextval, '2021.11.24', '박지성', '010-2323-2323', 4, 2);
insert into reservation values(reservation_id_seq.nextval, '2021.11.30', '유재석', '010-8786-9594', 2, 3);
insert into reservation values(reservation_id_seq.nextval, '2021.11.30', '박명수', '010-5353-5444', 5, 4);
insert into reservation values(reservation_id_seq.nextval, '2021.11.30', '박보영', '010-5465-7665', 1, 5);

insert into reservation values(1, '2021.11.30', '손흥민', '010-1111-1111', 3, 1);
insert into reservation values(2, '2021.11.24', '박지성', '010-2323-2323', 4, 2);
insert into reservation values(3, '2021.11.30', '유재석', '010-8786-9594', 2, 3);
insert into reservation values(4, '2021.11.30', '박명수', '010-5353-5444', 5, 4);
insert into reservation values(5, '2021.11.30', '박보영', '010-5465-7665', 1, 5); 

drop sequence reservation_id_seq;
select * from reservation;
drop table reservation;
commit;     
--------------------------------------------------------------------

create table members(
    mid number(6) constraint members_id_pk primary key,
    mname varchar2(20) not null,
    mphone varchar2(20) not null unique,
    mcount number(6) default 0 not null,
    mrank varchar2(1) default 'N' not null
    constraint members_rank_ck check (mrank in('N','V'))
);

create sequence members_id_seq
start with 1
increment by 1
minvalue 1
maxvalue 999999;

insert into members (mid, mname, mphone) values (members_id_seq.nextval, '지수', '010-4455-4204');
insert into members (mid, mname, mphone) values (members_id_seq.nextval, '제니', '010-3928-2302');
insert into members (mid, mname, mphone) values (members_id_seq.nextval, '로제', '010-1043-9983');
insert into members (mid, mname, mphone) values (members_id_seq.nextval, '리사', '010-4577-1102');
insert into members (mid, mname, mphone) values (members_id_seq.nextval, '카리나', '010-3455-8949');
insert into members (mid, mname, mphone) values (members_id_seq.nextval, '윈터', '010-4520-0980');
insert into members (mid, mname, mphone) values (members_id_seq.nextval, '지젤', '010-7711-3452');
insert into members (mid, mname, mphone) values (members_id_seq.nextval, '닝닝', '010-8796-0754');

select * from members;

commit;
--------------------------------------------------------------------

drop table food;
drop table tables;
drop table orders;
drop table reservation;
drop table members;