-- union, union all, not in, in
-- join - 2개 이상의 테이블에 나누어져있을 때 컬럼 합치기 / union - 2개 이상의 테이블에 나누어져있을 때 행 합치기(레코드 합침)
create table emp_dept_50 (select * from employees where department_id = 50); -- 50번 부서원들의 (11개) 컬럼들 저장 테이블
select * from emp_dept_50;
create table emp_job_man (select * from employees where job_id like '%man%'); -- 직종 코드에 man을 포함한 데이터의 (11개) 컬럼들 저장 테이블
select * from emp_job_man;

-- union - 합집합 - a, b 테이블 중 한개 포함 조회, 양쪽 모두 포함하면 1개만 - 중복x
-- 50번 부서이거나 manager 직종 조회(이름 사번 직종코드 부서코드 조회) 중복x
select employee_id, first_name, job_id, department_id from emp_dept_50; -- 45개
select employee_id, first_name, job_id, department_id from emp_job_man; -- 12개
select employee_id, first_name, job_id, department_id from emp_dept_50 union select employee_id, first_name, job_id, department_id from emp_job_man; -- 52개(중복 빼고)
-- union all - 중복 허용
select employee_id, first_name, job_id, department_id from emp_dept_50 union all select employee_id, first_name, job_id, department_id from emp_job_man; -- 57개(중복 포함)
-- not in, in
-- select 안에 select(subquery)
-- employees 테이블에서 이름이 kelly와 같은 부서에서 근무하는 사원의 이름 근무부서코드 조회
select department_id from employees where first_name = 'kelly'; -- kelly의 부서번호 조회
select first_name, department_id from employees where department_id = 50; -- kelly와 같은 부서에서 근무하는 사원 조회
select first_name, department_id from employees where department_id = (select department_id from employees where first_name = 'kelly'); -- 첫번째 select를 50에 입력
select first_name, department_id from employees where department_id = (select first_name, department_id from employees where first_name = 'kelly'); -- error - 메인쿼리 department_id로 서브쿼리의 first_name과 department_id값 중 어느것 사용? 갯수 종류 동일해야 함
-- employees 테이블에서 이름이 kelly와 같은 부서이면서 같은 급여받는 사원의 이름 근무부서코드 조회
select first_name, department_id from employees where department_id = (select department_id from employees where first_name = 'kelly') and salary = (select salary from employees where first_name = 'kelly');
select first_name, department_id from employees where (salary, department_id) = (select salary, department_id from employees where first_name = 'kelly');

select first_name, department_id, job_id from employees where (job_id, department_id) = (select job_id, department_id from employees where first_name = 'kelly');
select first_name, department_id, job_id from employees where (job_id, department_id) = (select job_id, department_id from employees where first_name = 'kelly') and first_name != 'kelly';
-- in - 서브쿼리 사용해서 where 절 조건을 만들때 결과가 단일행(1개) 이면 '=' / 다중행(2개이상) 이면 'in'
select first_name, department_id from employees where department_id = (select department_id from employees where first_name = 'peter'); -- error
select job_id, department_id from employees where first_name = 'peter'; -- 피터 3명(50번, 80번)
select first_name, department_id from employees where department_id in (select department_id from employees where first_name = 'peter');
-- 집계함수는 결과 1개
select first_name, department_id, salary from employees where salary = (select truncate(avg(salary), -2) from employees);
-- not in
select first_name, department_id from employees where department_id not in (select department_id from employees where first_name = 'peter'); -- 50번, 80번 제외한 부서 근무 사원










