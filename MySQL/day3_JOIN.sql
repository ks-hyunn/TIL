-- join
select first_name 사원명, department_id 부서코드 from employees order by 1;
select department_id 부서코드, department_name 부서명 from departments order by 1;
select first_name 사원명, department_name 부서명 from employees, departments order by 1;

select first_name 사원명, department_name 부서명 
from employees, departments 
where employees.department_id = departments.department_id 
order by 1;
-- 중복 컬럼은 테이블명 붙혀서
select first_name 사원명, employees.department_id 부서코드, department_name 부서명 
from employees, departments 
where employees.department_id = departments.department_id 
order by 1;
-- 테이블도 alias 가능
select first_name 사원명, e.department_id 부서코드, department_name 부서명 
from employees e, departments d 
where e.department_id = d.department_id 
order by 1;
-- where 절에 조건 추가
select first_name 사원명, e.department_id 부서코드, department_name 부서명 
from employees e, departments d 
where e.department_id = d.department_id and first_name like '%le%' 
order by 1;
-- 테이블명 사이에 inner join 중복값 앞에 on
select first_name 사원명, e.department_id 부서코드, department_name 부서명 
from employees e inner join departments d on e.department_id = d.department_id 
where first_name like '%le%' 
order by 1;
