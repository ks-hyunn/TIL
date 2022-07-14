-- 변수 선언
set @var1 = '문자열';
set @var2 = 100;
set @var3 = 10 / 3; -- 정수 연산도 실수타입 반환
set @var4 = '2003-06-17 00:00:00';
select @var1, @var2, @var3, @var4;
select hire_date, first_name from employees where hire_date = @var4;

-- 시스템 함수
select database(), user(), current_user(), version();

-- 내장함수
-- 형변환 - cast(변경할값 as 타입), convert(변경할값, 타입), format(변경할값, 실수자리수) - 반올림
-- 정수, 실수
select 10, cast(10 as decimal(10, 5)), convert(10, decimal(10, 5)), format(10, 5);
select avg(salary), cast(avg(salary) as signed integer), convert(avg(salary), signed integer), format(avg(salary), 0) from employees;
-- date
select cast('2022$07$14' as date);
select cast('2022$07$14' as time);
select cast('2022:09:11 12:23:45' as time);
select cast('20221212' as date);

-- 자동형변환 = 암시적형변환 ('문자열' - '4자리-2자리-2자리숫자' -> 자동날짜, '문자열' - '숫자구성' -> 자동숫자) / 문자열 산술연산x
select '8818.5678' + 1;
select '100' + '200';
select '100가나다' + '가나다200'; -- 숫자까지만 인식 문자나오면 0 - 100 + 0
select 0 = 0; -- 같으면 1, 다르면 0
select 0 = 'mysql0';
select concat('100','200'); -- 문자열 합치기

-- 조건
-- ifnull(데이터, 변환값) - null이면 변환값, not null이면 원래의 데이터값
select commission_pct, ifnull(commission_pct, '보너스없음') from employees;
-- nullif(데이터1, 데이터2) - 데이터1과 데이터2 동일하면 null, 다르면 데이터1
select nullif(100, 100), nullif(100, 200);
-- if(조건, 참결과, 거짓결과)
select if(10>0, '크다', '작거나 같다');
select first_name, if(commission_pct is null, '못받는다', '받는다') from employees;
select first_name 사원명, salary 급여, if(salary >= 15000, '임원', if(salary between 10000 and 15000, '부장', if(salary between 5000 and 10000, '과장', '대리나 사원'))) 직급 from employees order by 급여 desc;
select first_name 사원명, salary 급여, if(salary >= 15000, '임원', if(salary >= 10000, '부장', if(salary >= 5000, '과장', '대리나 사원'))) 직급 from employees order by 급여 desc;
-- case (java case문 비슷)
set @casevar = 200;
select case @casevar when 1 then '1이다' when 10 then '10이다' when 100 then '100이다' else '모른다' end;
select first_name 사원명, salary 급여, case salary when salary >= 15000 then '임원' when salary >= 10000 then '부장' when salary >= 5000 then '과장' else '대리나 사원' end 직급 from employees;
select first_name 사원명, salary 급여, case when salary >= 15000 then '임원' when salary >= 10000 then '부장' when salary >= 5000 then '과장' else '대리나 사원' end 직급 from employees order by 급여 desc; -- case값과 when값 비교가 아니라 case값 생략

-- 문자
select ascii('a'), char(65); -- ascii(문자) - 아스키코드 반환 / char(아스키코드) - 문자반환
set @charvar1 = 'java';
set @charvar2 = '자바';
select bit_length(@charvar1), length(@charvar1), char_length(@charvar1); -- bit_length() - 비트 수 / length() - 바이트 수 / char_length() - 글자 수
select bit_length(@charvar2), length(@charvar2), char_length(@charvar2);
select first_name from employees where char_length(first_name) = 3;
-- concat - 문자열 합침
select concat('a','b','cc'), concat_ws('a','b','cc'); -- concat_ws(분리자,합칠문자1,합칠문자2) - 문자사이 분리자
select concat_ws(':','b','cc','ddd');
-- 문자열 검색
select elt(2, '일', '둘', '3'); -- elt(찾을위치, 문자, 문자);
select substring('일이삼사', 1, 2); -- substring(문자, 시작위치, 가져올갯수)
select field('둘', '일', '둘', '3'); -- field(찾을문자, 문자, 문자); - 위치 반환
select find_in_set('이', '일,이,삼,사'); -- find_in_set(찾을문자, 콤마로 연결된 문자) - 위치 반환
select instr('일이삼사', '이'); -- instr(문자, 찾을문자) - 위치 반환
select locate('삼사', '일이삼사'); -- locate(찾을문자, 문자) - 위치 반환

-- 연습
select * from employees where hire_date like '2006%';
select * from employees where hire_date >= '2006-01-01 00:00:00' and hire_date <= '2006-12-31 23:59:59';
select * from employees where locate('2006',hire_date) = 1; -- instr(hire_date, '2006') = 1
select * from employees where substring(hire_date, 1, 4) = '2006';

select * from employees where hire_date like '%-06-%';
select * from employees where locate('-06',hire_date) = 5; -- instr(hire_date, '2006') = 1
select * from employees where substring(hire_date, 6, 2) = '06';

-- bin, hex, oct - 2, 16, 8진수 변환
-- insert(문자, 시작위치, 지울갯수, 바꿀문자) - 지정 숫자 갯수만큼 삭제하고 새로운 문자 추가
select 'ABCDEF', insert('ABCDEF', 3, 2, '-');
-- replace(문자, 바꿀문자, 대체문자)
select 'ABCDEF', replace('ABCDEF', 'CD' , '-');
-- repeat(문자, 반복횟수)
select repeat('abc', 10);
select first_name 이름, insert(phone_number, 1, 12, repeat('*', 12)) 핸드폰번호 from employees;
select first_name 이름, insert(phone_number, 9, 4, repeat('*', 4)) 핸드폰번호 from employees;
select insert(first_name, 2, char_length(first_name)-1, repeat('*', char_length(first_name)-1)) 이름 from employees;
