-- join
select first_name, department_name from employees inner join departments on employees.department_id = departments.department_id;
select first_name, e.department_id, department_name from employees e inner join departments d on e.department_id = d.department_id;
-- 급여 총합
select sum(salary) from employees e inner join departments d on e.department_id = d.department_id;
-- 부서별 급여 총합 - group by 등 다른절 사용은 동일
select department_name 부서이름, sum(salary) 부서별급여총합 from employees e inner join departments d on e.department_id = d.department_id group by department_name;
select department_name 부서이름, sum(salary) 부서별급여총합 from employees e inner join departments d on e.department_id = d.department_id group by department_name having sum(salary) >= 100000;
select department_name 부서이름, sum(salary) 부서별급여총합 from employees e inner join departments d on e.department_id = d.department_id group by department_name having sum(salary) >= 100000 order by 부서이름;
select department_id 부서코드, sum(salary) 부서별급여총합 from employees group by department_id; -- 부서 코드별 급여 총합
select department_id 부서코드, sum(salary) 부서별급여총합 from employees group by department_id having sum(salary) >= 100000; -- 부서 코드별 급여 총합
select department_id 부서코드, sum(salary) 부서별급여총합 from employees group by department_id having sum(salary) >= 100000 order by 부서코드; -- 부서 코드별 급여 총합

-- 세개의 테이블 join - 테이블1 inner join 테이블2 on 테이블1, 2 중복값 inner join 테이블3 on 테이블2, 3 중복값 -> 두번째 inner join 앞에 테이블2 생략
select first_name 사원명, city 도시명
from employees e inner join departments d on e.department_id = d.department_id
inner join locations l on d.location_id = l.location_id; -- 사원명과 도시명 직접연결 중복값 없으므로 부서코드 이용해서 연결
-- 네개의 테이블 join
select first_name 사원명, city 도시명, country_name 국가명
from employees e inner join departments d on e.department_id = d.department_id
inner join locations l on d.location_id = l.location_id
inner join countries c on l.country_id = c.country_id;
-- 사원명, 부서명, 도시명, 국가명 조회 / 50, 80, 100 부서만 조회, 급여 5000 이상인 사원만 조회
select first_name 사원명, department_name 부서명, d.department_id 부서코드, salary 급여, city 도시명, country_name 국가명
from employees e inner join departments d on e.department_id = d.department_id
inner join locations l on d.location_id = l.location_id
inner join countries c on l.country_id = c.country_id
where e.department_id in(50, 80, 100) and salary >= 5000;