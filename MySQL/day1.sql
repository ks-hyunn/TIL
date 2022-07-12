SHOW databases; /* DB 종류 보여주는 결과화면 */
USE MYSQL; /* mysql db 사용 */ 
SELECT HOST , USER FROM USER;

CREATE TABLE EMPLOYEES( /* mysql 안에 employees 테이블 생성 */
EMPLOYEE_ID INTEGER(10), /* 컬럼 - 사번 정수 10자리 */
EMPLOYEE_NAME VARCHAR(20), /* 컬럼 - 이름 문자열 20바이트 */
SALARY DECIMAL(10,2), /* 컬럼 - 급여 실수(전체 10자리 중 소수점 2자리) */
HIRE_DATE DATE, /* 컬럼 - 날짜 (년도 월 일 요일) */
DEPARTMENT_ID INT(5) /* 컬럼 - 부서번호 정수 5자리 */
);

select * FROM EMPLOYEES;

INSERT INTO EMPLOYEES VALUES(100, "이사원", 45000.99, now(), 10);
INSERT INTO EMPLOYEES VALUES(101, "김사원", 45000.99, now(), 10);
INSERT INTO EMPLOYEES VALUES(102, "최사원", 45000.99, now(), 10);
INSERT INTO EMPLOYEES VALUES(200, "박대리", 55000.99, '2020-12-12', 10);
INSERT INTO EMPLOYEES VALUES(201, "홍대리", 55000.99, '2020-07-12', 10);
INSERT INTO EMPLOYEES VALUES(202, "최대리", 55000.99, '2021-07-12', 10);
INSERT INTO EMPLOYEES VALUES(300, "김과장", 65000.99, '2010-12-12', 10);
INSERT INTO EMPLOYEES VALUES(301, "이과장", 65000.99, '2010-06-12', 10);
INSERT INTO EMPLOYEES VALUES(302, "최부장", 75000.99, '2009-06-12', 10);
INSERT INTO EMPLOYEES VALUES(303, "박이사", 85000.99, '2008-12-12', 10);

select * from mysql.employees;

select employee_id, employee_name from employees; -- 사번 이름
select employee_id, employee_name, phone_number from employees; -- error 없는 컬럼

-- 중복값 제외 distinct
select distinct department_id from employees; -- employees 테이블의 사원들이 속한 부서 코드 종류만 나열

-- >=, >, <=, <, =, !=, +, -, *, / 연산자 사용 가능
select employee_name, salary * 12 from employees;-- 이름, 연봉 조회 단 연봉은 급여의 12배로 출력
select employee_name, salary from employees where salary >= 50000 ;-- 이름, 급여 조회하되 급여 50000 이상인 사원만 조회

-- 조건 여러개 and연산자, or연산자
select employee_name, salary from employees where employee_name = '이사원' and salary = 40000;-- 이름이 이사원이고 급여가 40000 사원 조회
select employee_name, salary, hire_date from employees where hire_date = '2008-12-12' or salary >= 100000;-- 입사일이 2008-12-12 이거나 급여가 100000 이상인 사원의 입사일, 급여, 이름 조회

-- 유사한 형태 조회 like 문자열의 패턴 유사, % 값의 자릿수 무관, 모든 문자 무관, _ 값의 자릿수 고정(1개 = 1자리), 모든 문자 무관
select employee_name, salary * 0.05 from employees where employee_name like '최%'; -- 이름이 최씨인 사원의 이름과 보너스 조회. 보너스는 급여의 5% 계산
select employee_name, salary * 0.05 from employees where employee_name like '최__'; -- 이름이 최씨인 사원의 이름과 보너스 조회. 보너스는 급여의 5% 계산

-- 날짜 대소비교 (숫자처럼) 크다-최근, 작다-오래 / 패턴비교 (문자처럼)
select employee_name, hire_date from employees where hire_date like '2020-%'; -- 입사일이 2020년도 입사한 사원의 이름과 입사일 조회
select employee_name, hire_date from employees where hire_date >= '2020-01-01' and hire_date <= '2020-12-31';
select employee_name, hire_date from employees where hire_date like '2020%';
select employee_name, hire_date from employees where hire_date like '2020______'; -- -월2-일2 -> 6자리
select employee_name, hire_date from employees where hire_date like '%12'; -- 12일에 입사한 사람

-- between ~ and -구간 연산자 (숫자, 날짜, 문자 - 작다-사전앞, 크다-사전뒤 -> 숫자<대문자<소문자<...<한글)
select employee_name, salary from employees where salary >= 50000 and salary <= 70000; -- 급여가 5만 이상이고 7만 이하의 사원 이름과 급여 조회
select employee_name, salary from employees where salary between 50000 and 70000;

-- in(같은 타입, 같은 타입) - 목록 연산자
select employee_id, employee_name from employees where employee_id = 100 or employee_id = 300 or employee_id = 250 or employee_id = 204; -- 사번이 100, 300, 250, 204 사원의 사번과 이름 조회
select employee_id, employee_name from employees where employee_id in (100, 300, 250, 204);

INSERT INTO EMPLOYEES VALUES(400, "최신입", 40000.0, null, null);
INSERT INTO EMPLOYEES VALUES(401, "김신입", 40000.0, now(), 20);
INSERT INTO EMPLOYEES VALUES(402, "오신입", 40000.0, now(), 30);
INSERT INTO EMPLOYEES VALUES(403, "강신입", 40000.0, now(), 40);
INSERT INTO EMPLOYEES VALUES(404, "최신입", 40000.0, null, null);
select * from employees;

-- is null, is not null - null값 비교 연산자
select * from employees where hire_date = null; -- 입사일이 없는 사원 조회
select * from employees where hire_date is null;
select * from employees where department_id is null; -- 부서 배정받지 못한 사원 조회
select * from employees where department_id is not null; -- 부서 배정받은 사원 조회

-- 조회시 별명(alias) -> 조회시 임시 사용하는 다른 컬럼명
select employee_name, salary * 12 from employees;
select employee_name, salary * 12 as 연봉 from employees;
select employee_name 사원명, salary * 12 '사원의 연봉' from employees;
select employee_name 사원명, salary 월급, salary * 12 '사원의 연봉' from employees;

-- ifnull(컬럼명, 임시값) 컬럼명의 값이 null이면 임시값으로 치환
insert into employees values(405, '김경력', null, now(), 30);
select employee_name 사원명, salary 월급, salary * 12 '사원의 연봉' from employees;
select employee_name 사원명, salary 월급, ifnull(salary, 1000) * 12 '사원의 연봉' from employees;

-- 조회시 두개 이상의 컬럼 연결 -> concat()
select concat(employee_name, ' 사원은 ', salary, '의 월급을 받습니다.') 급여정보 from employees; -- xxx 사원은 xxx의 월급을 받습니다.
select concat(employee_name, ' 사원은 ', ifnull(salary, 0), '의 월급을 받습니다.') '급여 정보' from employees;

-- order by 컬럼명 asc(오름차순)/desc(내림차순)
select * from employees order by employee_id; -- asc 기본값
select * from employees order by employee_id desc;
select * from employees order by salary desc, employee_id desc; -- 급여 많은 사원부터 조회. 동일 급여 사원은 사번 큰 사원부터
select employee_id, salary from employees order by 2 desc, 1 desc; -- order by 뒤에 컬럼 순서로 대체 가능
select employee_id 사번, salary from employees order by 2 desc, 사번 desc; -- alias도 가능
select employee_id, salary from employees order by salary desc; -- null값은 가장 작은 값으로 계산

-- limit -> 조회 갯수 제한 (limit 시작인덱스, 조회갯수)
select employee_name, salary from employees order by salary desc limit 3; -- 급여 많은 사원부터 상위 3명만 조회 -> limit 0, 3 동일 (0 생략가능)
select employee_name, salary from employees order by salary desc limit 3, 4;-- 급여 많은 사원부터 정렬하되 4, 5, 6, 7번째 많은 사원만 조회 -> 3번 인덱스부터 4개

show databases; -- 데이터베이스 전체 조회
select database(); -- 사용중인 데이터베이스 조회
show tables; -- 사용중인 데이터베이스 내부의 테이블 조회

-- 테이블 복사
create table emp_copy (select employee_name, salary, hire_date from employees);
show tables;
select * from emp_copy;

/*
mysql -u 계정명 -p;
create database DB명;
create user '유저명'@'% or *' identified by '비밀번호';
grant all privileges on DB명.*(모든권한) to 계정명@'%';
select user(); -- 접속 계정 조회
*/

use empdb;
select * from test;