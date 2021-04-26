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
