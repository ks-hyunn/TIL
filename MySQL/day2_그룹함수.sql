select * from employees;
select salary from employees;

-- 그룹 함수(집계 함수,다중행 함수) -1개 결과값
select sum(salary) from employees; -- 모든 사원 급여 총합
select avg(salary) from employees; -- 모든 사원 급여 평균
select sum(salary), avg(salary), count(salary), min(salary), max(salary) from employees; -- 총합, 평균, 행의 개수, 최소값, 최대값

-- sum(), avg() 은 숫자데이터 -> 날짜,문자데이터 의미없음
select sum(hire_date) from employees;
select avg(hire_date) from employees;
select sum(first_name) from employees;
select avg(first_name) from employees;

-- 숫자 대문자 소문자 ... 한글 순서 - 문자 사전 순서 앞(작다) 뒤(크다)
select max(first_name), min(first_name) from employees;

-- 날짜 오래됨(작다) 최근(크다)
select max(hire_date), min(hire_date) from employees;

-- count() - 컬럼 not null 갯수
select count(hire_date), count(department_id), count(commission_pct), count(*) from employees; -- count(*) -모든 행 개수
select first_name, department_id from employees where department_id is null;
select first_name, commission_pct from employees where commission_pct is null;
select first_name, commission_pct from employees where commission_pct is not null;

-- 집계 함수 - 1개 결과값 - 집계 함수 조회하는 select 절에서 다른 컬럼 같이 조회 x
select salary, sum(salary) from employees; -- salary도 1개 결과값만 보여준다 - 의미없음
select salary from employees;

select first_name, department_id, salary from employees;
select sum(salary) from employees where department_id = 90; -- 90번 부서 사원 급여 합