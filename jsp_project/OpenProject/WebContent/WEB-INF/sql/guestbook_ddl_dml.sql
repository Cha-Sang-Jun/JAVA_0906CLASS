-- 방명록
DROP TABLE IF EXISTS `project`.`GuestBook` RESTRICT;

-- 방명록
ALTER TABLE `project`.`GuestBook`
	DROP FOREIGN KEY `FK_Member_TO_GuestBook`; -- 회원 -> 방명록

-- 방명록
ALTER TABLE `project`.`GuestBook`
	DROP PRIMARY KEY; -- 방명록 기본키


-- 방명록
CREATE TABLE `project`.`GuestBook` (
	`idx`       INT         NOT NULL, -- 게시물고유번호
	`subject`   VARCHAR(50) NOT NULL, -- 제목
	`content`   TEXT        NOT NULL, -- 내용
	`regdate`   TIMESTAMP   NULL,     -- 작성일시
	`memberidx` INT         NOT NULL  -- 회원고유번호
);

-- 방명록
ALTER TABLE `project`.`GuestBook`
	ADD CONSTRAINT `PK_GuestBook` -- 방명록 기본키
		PRIMARY KEY (
			`idx` -- 게시물고유번호
		);

-- 방명록
ALTER TABLE `project`.`GuestBook`
	ADD CONSTRAINT `FK_Member_TO_GuestBook` -- 회원 -> 방명록
		FOREIGN KEY (
			`memberidx` -- 회원고유번호
		)
		REFERENCES `project`.`Member` ( -- 회원
			`idx` -- 회원고유번호
		);