-- GROUP BY - group by 컬럼명을 기준으로 그룹 함수 적용
select sum(salary) from employees group by department_id; -- 모든 부서에 대해 각 부서별 급여 총합 조회
select department_id, sum(salary) from employees group by department_id; -- group by 절에서는 집계 함수와 다른 컬럼 같이 조회 가능(그룹 함수 적용한 컬럼)
select department_id, sum(salary) from employees group by department_id order by department_id;
select department_id, sum(salary) from employees group by department_id order by sum(salary) desc limit 3;

-- 모든 부서에 대해 각 부서별 급여 총합 조회하되 급여 총합이 100,000 이상인 결과만 조회
-- where 절에는 집계 함수 사용 불가(group by 이전 where 먼저 실행)
-- having 절 집계 함수 조건식 (group by 와 같이 사용)
select department_id, sum(salary) from employees where sum(salary) >= 100000 group by department_id; -- error
select department_id, sum(salary) from employees group by department_id having sum(salary) >= 100000; -- where 절에 집계 함수 들어가야하면 having 절에 작성

-- 직종별로 사원의 급여 평균을 구하되 IT_PROG 직종은 제외하고 조회
-- 조회 컬럼은 직종코드, 직종평균급여 조회
-- 직종평균급여가 많은 직종부터 보여주도록 조회
select job_id 직종코드, avg(salary) 직종평균급여 from employees where job_id != it_prog group by job_id order by avg(salary) desc;
select job_id 직종코드, avg(salary) 직종평균급여 from employees where job_id != 'it_prog' group by job_id order by avg(salary) desc; -- order by 2 desc, 직종평균급여 desc

-- 2006년 이후 입사 사원에 대해서 부서별 보너스 평균 조회
-- 보너스 = salary + salary * commission_pct
-- 보너스를 받지 못하는 사원 제외, 부서 없는 사원도 제외
select department_id, avg(salary + salary * commission_pct) from employees where commission_pct is not null and department_id is not null and hire_date >= '2006-01-01' group by department_id;