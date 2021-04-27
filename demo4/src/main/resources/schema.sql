DROP TABLE tbl_board;
CREATE TABLE tbl_board(
boardId INT(30) auto_increment,
title varchar(30) not null,
content varchar(30) not null,
name varchar(30) not null,
createDate date,
readCount INT(30),
primary key(boardId)
);

INSERT INTO tbl_board(title, content, name, createDate, readCount) VALUES ('title1', 'content1', 'name1', current_time, 0);
INSERT INTO tbl_board(title, content, name, createDate, readCount) VALUES ('title2', 'content2', 'name2', current_time, 0);
INSERT INTO tbl_board(title, content, name, createDate, readCount) VALUES ('title3', 'content3', 'name3', current_time, 0);
INSERT INTO tbl_board(title, content, name, createDate, readCount) VALUES ('title4', 'content4', 'name4', current_time, 0);
INSERT INTO tbl_board(title, content, name, createDate, readCount) VALUES ('title5', 'content5', 'name5', current_time, 0);
INSERT INTO tbl_board(title, content, name, createDate, readCount) VALUES ('title6', 'content6', 'name6', current_time, 0);
INSERT INTO tbl_board(title, content, name, createDate, readCount) VALUES ('title7', 'content7', 'name7', current_time, 0);
INSERT INTO tbl_board(title, content, name, createDate, readCount) VALUES ('title8', 'content8', 'name8', current_time, 0);
INSERT INTO tbl_board(title, content, name, createDate, readCount) VALUES ('title9', 'content9', 'name9', current_time, 0);
INSERT INTO tbl_board(title, content, name, createDate, readCount) VALUES ('title10', 'content10', 'name10', current_time, 0);
INSERT INTO tbl_board(title, content, name, createDate, readCount) VALUES ('title12', 'content12', 'name12', current_time, 0);
INSERT INTO tbl_board(title, content, name, createDate, readCount) VALUES ('title13', 'content13', 'name13', current_time, 0);
INSERT INTO tbl_board(title, content, name, createDate, readCount) VALUES ('title14', 'content14', 'name14', current_time, 0);
INSERT INTO tbl_board(title, content, name, createDate, readCount) VALUES ('title15', 'content15', 'name15', current_time, 0);
INSERT INTO tbl_board(title, content, name, createDate, readCount) VALUES ('title16', 'content16', 'name16', current_time, 0);
INSERT INTO tbl_board(title, content, name, createDate, readCount) VALUES ('title17', 'content17', 'name17', current_time, 0);
INSERT INTO tbl_board(title, content, name, createDate, readCount) VALUES ('title18', 'content18', 'name18', current_time, 0);
INSERT INTO tbl_board(title, content, name, createDate, readCount) VALUES ('title19', 'content19', 'name19', current_time, 0);
INSERT INTO tbl_board(title, content, name, createDate, readCount) VALUES ('title20', 'content20', 'name20', current_time, 0);
INSERT INTO tbl_board(title, content, name, createDate, readCount) VALUES ('title21', 'content21', 'name21', current_time, 0);
INSERT INTO tbl_board(title, content, name, createDate, readCount) VALUES ('title22', 'content22', 'name22', current_time, 0);
INSERT INTO tbl_board(title, content, name, createDate, readCount) VALUES ('title23', 'content23', 'name23', current_time, 0);
INSERT INTO tbl_board(title, content, name, createDate, readCount) VALUES ('title24', 'content24', 'name24', current_time, 0);
