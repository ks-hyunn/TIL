create table book (
bookNo char(10) primary key comment '도서 번호',
bookTitle varchar(30) not null comment '도서 제목',
bookAuthor varchar(20) comment '저자',
bookYear date comment '발행연도',
bookPrice int comment '가격',
bookPublisher varchar(10) comment '출판사'
);
insert into book values('B001', '자바프로그래밍', '홍길동', '2020-01-01', 30000, '멀티출판사');
insert into book values('B002', 'MYSQL이해', '나이해', '2022-01-01', 25000, '캠퍼스출판');
insert into book values('B003', 'SPRING 활용', '김고수', '2021-01-01', 45000, '디지털출판사');
select bookNo, bookTitle, bookAuthor, year(bookYear), bookPrice, bookPublisher from book;