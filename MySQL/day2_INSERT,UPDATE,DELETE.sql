-- 테이블 생성하며(정의하며) 데이터 복사
create table emp_copy (select employee_id, first_name, last_name, salary, hire_date from employees);

-- 테이블은 정의되어 있고 데이터만 복사
-- insert into emp_copy select * from employees;

select count(*) from emp_copy;
select count(*) from employees;
describe emp_copy; -- 컬럼 정보

-- INSERT - insert into 테이블명 values(값,...,값);
-- insert into emp_copy(employee_id, hire_date, ...) values(1, '2000-12-10 00:00:00', ...); -- 컬럼, 값 순서 지정 가능
insert into emp_copy values(1, '사원', '이', 15000, '2000-12-10 00:00:00'); -- 지정 안하면 처음 만든 순서대로 입력
insert into emp_copy values(2, '길동', '홍', 25000, '2022-12-10'); -- 시간 안주면 자동 00:00:00
insert into emp_copy values(3, '대리', '홍', 26000, now()); -- 현재 시간까지 입력
insert into emp_copy values(4, '신입', '홍', 10000, current_date()); -- 현재 날짜까지 입력
insert into emp_copy(employee_id, hire_date, last_name) values(5, now(), '김'); -- 나열되지 않는 컬럼 자동 null
insert into emp_copy values(6, null, '박', null, now()); -- null 명시
select * from emp_copy where employee_id <= 10;

-- UPDATE - update 테이블명 set 변경할컬럼명 = 변경할값 where 조건; - where 필수(안쓰면 모든 값 변경)
update emp_copy set salary =15000, first_name = '수정' where employee_id = 6;

-- DELETE - delete from 테이블명 where 조건; - where 필수(안쓰면 모든 값 삭제)
delete from emp_copy where employee_id = 6;

-- IGNORE - 강제 INSERT
insert ignore into emp_copy values (6, '부장', '심', 50000, '2020');
select * from emp_copy where employee_id <= 10;
-- employee_id 컬럼 정의시(create table) unique
-- employee_id int(5) unique 전제조건
-- insert into emp_copy values (6, '부장', '심', 50000, now()) on duplicate key update hire_date = now(); -- 키값 중복되면 insert 대신 update해라

select * from emp_copy order by salary desc limit 10;
select * from emp_copy where first_name = '부장' order by 1 desc;

update emp_copy set salary = salary * 1.2 where first_name = '부장' order by salary asc limit 2; -- update, delete 절에서 limit 사용