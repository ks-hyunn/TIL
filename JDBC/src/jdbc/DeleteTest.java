package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class DeleteTest {

	public static void main(String[] args) {
		Connection con = null;
		try {
//		0. 설치한 mysql driver 호출
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 호출 완료");
//			1. db 연결 ("jdbc:mysql://ip:port번호/db명", "계정명", "비밀번호")
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/memberdb", "emp2", "emp2");
			System.out.println("연결 성공");
//			2-1. sql 작성
//			create table, drop table -> workbench에서만 수행할 것을 권고
//			2-2. sql 저장 - 전송
			Statement st = con.createStatement(); // 빈 문장 생성
			int rowCount = st.executeUpdate
//			("create table test(a int, b varchar(10))"); // 쿼리 실행 후 변화된 행 갯수 반환
//			("insert into test values(1, 'java')");
			("delete from test where a = 1"); // 조건에 맞는 데이터(레코드) 삭제 -> 테이블은 존재
//			("drop table test"); // 레코드와 테이블 둘다 삭제
			System.out.println("저장 행의 갯수 = " + rowCount);

		} catch (ClassNotFoundException e) {
			System.out.println("미설치이거나 classpath 미등록 또는 드라이버명 오타 확인");
		} catch (SQLException e) {
			System.out.println("db연결 정보 잘못되어있는지 확인");
			e.printStackTrace();
		} finally {
			try {
//				4. db 연결 해제
				con.close();
				System.out.println("연결 해제 성공");
			} catch (SQLException e) {
			}
		}
	}

}
