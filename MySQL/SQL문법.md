# SQL문법

---

### DDL ( 데이터 구조 정의 언어 )

- 사용자 생성 / DB 생성 / 테이블 생성 -> 데이터 저장 준비

- 테이블 생성 / 테이블 구조 변경 / 테이블 삭제

  - CREATE TABLE ~ / ALTER / DROP

  - CREATE DATABASE ~

  - CREATE USER ~ ( root계정만 사용 가능 )

### DML ( 데이터 조작 언어 )

- 데이터 저장 - 삭제 - 수정
  - INSERT INTO / DELETE / UPDATE

### DCL ( 데이터 사용 권한 제어 언어 )

- GRANT
  - 특정 사용자에게 DB -> A테이블 INSERT 권한 부여
- REVOKE
  - 권한 회수

관리자(root계정만 사용 가능)

### DQL ( 데이터 질의 언어 )

- SELECT
  - 조건에 맞는 데이터 조회