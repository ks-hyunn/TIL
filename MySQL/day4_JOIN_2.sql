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

-- outer join
select first_name, e.department_id, department_name from employees e inner join departments d on e.department_id = d.department_id;
select count(*) from employees;
select count(department_id) from employees; -- 컬럼 안에 not null 갯수
select first_name, department_id from employees where department_id is null;
-- inner join - join 하는 2개 테이블 모두에 존재하고 조건 일치하는 데이터만 합침(department_id 가 null인 값은 제외)
-- outer join - join 하는 2개 테이블 모두에 존재하고 조건 일치하지 않아도 데이터 합침
-- left outer join / right outer join - 왼쪽(오른쪽) 테이블의 모든 데이터 조회(null 값도 출력) - 조회하려는 기준 테이블
select first_name, e.department_id, department_name from employees e left outer join departments d on e.department_id = d.department_id; -- 부서 소속되지 않은 사원도 조회
select first_name, e.department_id, department_name from employees e right outer join departments d on e.department_id = d.department_id; -- 근무 부서원이 없는 부서명도 조회
select first_name, d.department_id, department_name from employees e right outer join departments d on e.department_id = d.department_id; -- 근무 부서원이 없는 부서명, 부서코드도 조회
-- 106개 조회 - employees + departments 조인 조건 / - 107개 조회 - employees + departments 조인 조건 + employees 존재하는 모든 데이터 / - 122개 조회 - employees + departments 조인 조건 + departments 존재하는 모든 데이터
select first_name, ifnull(e.department_id, '-'), ifnull(department_name, '소속부서없음') from employees e left outer join departments d on e.department_id = d.department_id;
select ifnull(first_name, '부서원없음'), d.department_id, department_name from employees e right outer join departments d on e.department_id = d.department_id;

-- self join - alias 필수
-- 사원 본인 사번(employee_id), 사원의 사수 사번(manager_id)
-- 모두 employees 테이블에 존재. manager_id 사번들은 모두 employee_id에 있다.
select employee_id, first_name, manager_id from employees where first_name = 'kelly'; -- 켈리 사번, 사수 사번 조회
select employee_id, first_name, manager_id from employees where employee_id = 122; -- 켈리 사수의 사번, 이름 조회
-- 사원명, 상사명 조회
select me.first_name 사원명, manager.first_name 상사명 from employees me inner join employees manager on me.manager_id = manager.employee_id; -- 내 상사의 사번과 상사의 자신 사번이 동일
select me.first_name 사원명, ifnull(manager.first_name, 'BOSS') 상사명 from employees me left outer join employees manager on me.manager_id = manager.employee_id; -- 상사없는 사원 포함
select ifnull(me.first_name, '신입사원') 사원명, manager.first_name 상사명 from employees me right outer join employees manager on me.manager_id = manager.employee_id; -- 부하직원 없는 사원 포함
-- inner, outer 생략 가능 - 기본 join은 inner join
select me.first_name 사원명, manager.first_name 상사명 from employees me join employees manager on me.manager_id = manager.employee_id;
select me.first_name 사원명, ifnull(manager.first_name, 'BOSS') 상사명 from employees me left join employees manager on me.manager_id = manager.employee_id;