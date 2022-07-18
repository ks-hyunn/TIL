package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class UpdateTest {

	public static void main(String[] args) {
		Connection con = null;
		Scanner sc = null;
		try {
//		0. 설치한 mysql driver 호출
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 호출 완료");
//			1. db 연결 ("jdbc:mysql://ip:port번호/db명", "계정명", "비밀번호")
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/memberdb", "emp2", "emp2");
			System.out.println("연결 성공");
//			2-1. sql 작성
			sc = new Scanner(System.in);
			System.out.print("아이디 : ");
			String id = sc.next();
			System.out.print("수정할 이름 : ");
			String name = sc.next();
			System.out.print("수정할 핸드폰 번호 : ");
			String phone = sc.next();
			System.out.print("수정할 이메일 : ");
			String email = sc.next();
			String query = "update member set name = '" + name + "', phone = '" + phone + "', email = '" + email
					+ "' where id = '" + id + "' ";
//			2-2. sql 저장 - 전송
			Statement st = con.createStatement(); // 빈 문장 생성
			int rowCount = st.executeUpdate(query); // 쿼리 실행 후 변화된 행 갯수 반환
			System.out.println("저장 행의 갯수 = " + rowCount);

		} catch (ClassNotFoundException e) {
			System.out.println("미설치이거나 classpath 미등록 또는 드라이버명 오타 확인");
		} catch (SQLException e) {
			System.out.println("db연결 정보 잘못되어있는지 확인");
			e.printStackTrace();
		} finally {
			try {
//				4. db 연결 해제
				sc.close();
				con.close();
				System.out.println("연결 해제 성공");
			} catch (SQLException e) {
			}
		}
	}

}
