-- create table / alter / drop
-- create table 테이블명 (컬럼명 타입(길이))
create table member (
id varchar(30),
password int(4),
name varchar(30),
phone char(13),
email varchar(30),
regdate datetime
);
insert into member values('id1', 1111, '홍길동', '010-1234-5678', 'hong@multi.com', now());
insert into member values('id2', 2222, '박길동', '010-5678-1234', 'park@tech.net', '2022-07-15 15:18:18');
insert into member values('id3', '111111', '홍길동', '010-1234-5678', 'hong@multi.com', now()); -- password 문자열 -> int 자동형변환, int 자릿수 지정x
insert into member values('id4', 4444, '김한국', '010-1234-56781234', 'hong@multi.com', now()); -- error - phone 길이 초과
insert into member values('id4', 4444, '김한국', '010-1234-5679', 'hong@multi.com', curdate()); -- date 시간 00:00:00 자동 지정
select * from member;
select id, phone, insert(password, 1, char_length(password), repeat('-', char_length(password))) from member where phone like '%-1234-%';

-- 제약조건 추가
-- not null - null은 허용x / unique - 중복값 허용x / primary key - 중복값 + null 허용x / check - 사용자 정의(양식) check (length(password) = 4)
-- foreign key - 다른 테이블의 다른 컬럼에 존재하는 값만 저장 가능 / constraint foreign key(컬럼명) references 다른테이블명(다른테이블의 컬럼명)
create table c_member (
id varchar(30) primary key, -- 중복x, not null
password integer(4) not null,
name varchar(30),
phone char(13) unique, -- 중복x
email varchar(30) check ( email like '%@%'), -- email 형식 지정
regdate datetime
);
insert into c_member values('id1', 1111, '홍길동', '010-1234-5678', 'hong@multi.com', '2022-07-15 15:18:18');
insert into c_member values('id1', 2222, '박길동', '010-5678-1234', 'park@tech.net', now()); -- error - 같은 id값 중복 불가
insert into c_member values('id2', null, '박길동', '010-5678-1234', 'park@tech.net', now()); -- error - password null값 불가
insert into c_member values('id2', 2222, '박길동', '010-1234-5678', 'park@tech.net', now()); -- error - phone 중복값 불가
insert into c_member values('id2', 2222, '박길동', '010-5678-1234', 'park/tech.net', now()); -- error - email 형식 불가

-- 메모테이블 정의 (foreign key 연습용)
create table c_memo (
memo_id int primary key auto_increment, -- 자동증가 auto_increment
title varchar(50) not null,
contents varchar(4000),
time datetime default now(), -- 기본값 설정 default
writer varchar(30),
constraint foreign key (writer) references c_member(id) -- writer 컬럼에 foreign key 적용 c_member(id)에 있는 값만 참조, 저장 가능
);
-- alter table c_memo add constraint foreign key(writer) references c_member(id); -- c_memo 테이블에 제약조건 추가 / writer 컬럼에 foreign key 적용 참조 대상은 c_member 테이블의 id 컬럼
-- alter table 테이블명 add constraint 제약조건(컬럼명) / alter table 테이블명 modify 컬럼명 not null -> not null만 다름
insert into c_member values ('id2', 2222, '박대한', '010-1111-2222', 'id2@mul.com', now());
insert into c_memo values (1, '1번글제목', '1번글내용', default, 'id2');
insert into c_memo (title, contents, time, writer) values ('2번글제목', '2번글내용', default, 'id1'); -- auto_increment 자동증가 - 입력안해도 자동증가
insert into c_memo (title, contents, writer) values ('3번글제목', '3번글내용', 'id1'); -- default 기본값 설정 - 입력안하면 기본 설정값으로 입력
insert into c_memo (title, contents, writer) values ('4번글제목', '4번글내용', 'id3'); -- error - id3는 c_member 테이블 id 컬럼에 없는 값이라 불가
insert into c_member values ('id3', 3333, '이자바', '010-9999-0000', 'lee@java.com', now());
insert into c_memo (title, contents, writer) values ('4번글제목', '4번글내용', 'id3'); -- id3 추가 후 가능

-- 이름이 홍길동 회원의 글쓴 제목, 내용 조회
select name 회원명, title 제목, contents 내용 from c_member join c_memo on id = writer where name = '홍길동';

delete from c_member where name = '이자바'; -- error c_memo에 이자바 글이 남아있어 삭제 불가
-- foreign key - 다른 테이블 컬럼 참조 c_memo.writer(자식) <-- c_member.id(부모)
-- 부모데이터에 존재하지 않는 데이터는 자식도 사용 불가
-- 부모데이터 삭제시 자식데이터 처리 설정하지 않으면 불가능

-- 부모데이터 삭제시 자식데이터 같이 삭제 설정 추가 / foreign key 기존키 삭제 -> 새로운 foreign key 설정
show keys from c_memo;
alter table c_memo drop foreign key c_memo_ibfk_1;
alter table c_memo add constraint foreign key(writer) references c_member(id) on delete cascade on update cascade; -- 부모 삭제, 수정 시 자식 데이터도 같이 삭제, 수정
-- alter table c_memo add constraint foreign key(writer) references c_member(id) on delete no action;-- 부모 삭제 시 자식 데이터 연결 끊고 아무 액션x 설정 추가
delete from c_member where name = '이자바'; -- 삭제 가능 -> c_memo 글도 삭제
select * from c_member;
select * from c_memo;