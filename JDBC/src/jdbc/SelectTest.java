package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class SelectTest {

	public static void main(String[] args) {
		Connection con = null;
		try {
//			0. 설치한 mysql driver 호출
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 호출 완료");
//			1. db 연결 ("jdbc:mysql://ip:port번호/db명", "계정명", "비밀번호")
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/memberdb", "emp2", "emp2");
			System.out.println("연결 성공");

//			String query = "select * from member";
//			String query = "select id, name, phone, email, date_format(regdate, '%y/%m/%d %h시%i분%s초') from member";
//			String query = "select id, name, phone, email, date_format(regdate, '%y/%m/%d %h시%i분%s초') 가입일 from member";
			String query = "select password, insert(password, 1, length(password), repeat('*', length(password))) 암호 from member where id = 'id1'";
			Statement st = con.createStatement(); // sql 저장 가능한 객체 생성
			ResultSet rs = st.executeQuery(query); // 결과 ResultSet 타입 반환
			while (rs.next()) { // 다음 데이터가 있는 동안 -> t/f 반환
//				1 ~ 6번 컬럼(각 데이터 타입별 해당 타입 or 모두 문자열로)
				System.out.println("====================");
//				System.out.println(rs.getString(1) + " : " + rs.getString("id")); // 컬럼 인덱스 or 컬럼 이름 / 문자열 or 해당 타입
//				System.out.println(rs.getString(2) + " : " + rs.getInt("password"));
//				System.out.println(rs.getString(3) + " : " + rs.getString("name"));
//				System.out.println(rs.getString(4) + " : " + rs.getString("phone"));
//				System.out.println(rs.getString(5) + " : " + rs.getString("email"));
//				System.out.println(rs.getString(6) + " : " + rs.getDate("regdate"));

//				System.out.println(rs.getString("id") + " : " + rs.getString("name") + " : " + rs.getString("phone")
//						+ " : " + rs.getString("email") + " : "
//						+ rs.getString("date_format(regdate, '%y/%m/%d %h시%i분%s초')")); // date_format 사용하면 String

//				System.out.println(rs.getString("id") + " : " + rs.getString("name") + " : " + rs.getString("phone")
//						+ " : " + rs.getString("email") + " : " + rs.getString("가입일")); // alias사용

				System.out.println(rs.getString("password") + " : " + rs.getString("암호")); // sql 함수사용, where절 사용

			}
			rs.close();
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
