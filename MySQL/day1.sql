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
select employee_name, hire_date from employees where hire_date like '2020-%';-- 입사일이 2020년도 입사한 사원의 이름과 입사일 조회
-- 