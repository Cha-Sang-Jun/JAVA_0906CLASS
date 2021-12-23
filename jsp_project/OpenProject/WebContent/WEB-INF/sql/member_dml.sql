-- select
select * from project.member;
select * from member where userid = ? and password = ?;
select * from project.member where userid = '1234' and password = '1234';

-- limit index, count
select * from project.member limit 0, 3; -- 1page
select * from project.member limit 2, 2; -- 2page

select * from member order by regdate desc limit ?, ?;
-- index : (page-1) * count

select count(*) from project.member;

select count(*) from member;

select * from project.member where idx = 8;
select * from member where idx = ?

