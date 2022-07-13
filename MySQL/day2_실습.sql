select first_name 이름, salary *12 '월급의 12배' from employees where salary * 12 >= 170000;
select first_name, salary from employees where department_id is null;
select first_name, salary, hire_date from employees where hire_date <= '2004-12-31 23:59:59';
select department_id, department_name from departments;
select job_id, job_title from jobs;

-- 대소비교 연산자는 논리연산자 보다 먼저 수행
-- and, or는 and 먼저 수행
select first_name, salary, department_id from employees where (department_id =80 or department_id = 50) and salary >= 13000;
select first_name, salary, department_id, hire_date from employees where hire_date >= '2005-01-01 00:00:00' and salary >= 1300 and salary <= 20000;

select first_name, salary, department_id from employees where department_id in(80, 50) and salary >= 13000;
select first_name, salary, department_id, hire_date from employees where hire_date >= '2005-01-01 00:00:00' and salary between 1300 and 20000;
select first_name, salary, department_id, hire_date from employees where hire_date like '2005%';
select first_name, salary, job_id from employees where job_id like '%clerk%';
select first_name, salary, hire_date from employees where hire_date like '%-12-%'; -- '_____12%'가능 언더바 5개
select first_name, salary, hire_date from employees where first_name like '%le%';
select first_name, salary, hire_date from employees where first_name like '%m';
select first_name, salary, hire_date from employees where first_name like '__d%';
select first_name, commission_pct, salary from employees where commission_pct is not null;
select first_name, commission_pct, salary from employees where commission_pct is null;
select * from employees where department_id in (30, 50, 80) and salary between 5000 and 17000 and commission_pct is not null order by hire_date, salary desc;

select first_name, ifnull(manager_id, 'BOSS') from employees; 
select concat(employee_id, '번 사번의 사원명은 ', last_name, ' , ', first_name, ' 이고 입사월은 07월 입니다.') from employees where hire_date like '%-07-%'; -- 입사월 고정일 때
select concat(employee_id, '번 사번의 사원명은 ', last_name, ' , ', first_name, ' 이고 입사월은 ', substr(hire_date, 6, 2),'월 입니다.') 사원정보 from employees; -- 입사월 고정일 아닐 때 - substr(문자열, 시작위치, 가져올갯수)
select * from departments;
select location_id, city from locations;
select country_id, country_name from countries;
select job_id, job_title from jobs;