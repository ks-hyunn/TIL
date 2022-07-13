select first_name 이름, salary *12 '월급의 12배' from employees where salary * 12 >= 170000;
select first_name, salary from employees where department_id is null;
select first_name, salary, hire_date from employees where hire_date <= '2004-01-01 00:00:00';
select department_id, department_name from departments;
select job_id, job_title from jobs;

select first_name, salary, department_id from employees where department_id in(80, 50) and salary >= 13000;
select first_name, salary, department_id, hire_date from employees where hire_date >= '2005-01-01 00:00:00' and salary between 1300 and 20000;
select first_name, salary, department_id, hire_date from employees where hire_date like '2005%';
select first_name, salary, job_id from employees where job_id like '%clerk%';
select first_name, salary, hire_date from employees where hire_date like '%-12-%';
select first_name, salary, hire_date from employees where first_name like '%le%';
select first_name, salary, hire_date from employees where first_name like '%m';
select first_name, salary, hire_date from employees where first_name like '__d%';
select first_name, commission_pct, salary from employees where commission_pct is not null;
select first_name, commission_pct, salary from employees where commission_pct is null;
select * from employees where department_id in (30, 50, 80) and salary between 5000 and 17000 and commission_pct is not null order by hire_date, salary desc;

select first_name, ifnull(manager_id, 'boss') from employees; 
select concat(employee_id, '번 사번의 사원명은 ', last_name, ' , ', first_name, ' 이고 입사월은 07월 입니다.') from employees where hire_date like '%-07-%'; -- 입사월 고정일 때
select concat(employee_id, '번 사번의 사원명은 ', last_name, ' , ', first_name, ' 이고 입사월은 ', hire_date,'월 입니다.') from employees; -- 입사월 고정일 아닐 때 - 수정필요
select * from departments;
select location_id, city from locations;
select country_id, country_name from countries;
select job_id, job_title from jobs;