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
