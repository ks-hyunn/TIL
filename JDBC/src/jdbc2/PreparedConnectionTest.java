package jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class PreparedConnectionTest {

	public static void main(String[] args) {
		Connection con = null;
		try {
//		0. 설치한 mysql driver 호출
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 호출 완료");
//			1. db 연결 ("jdbc:mysql://ip:port번호/db명", "계정명", "비밀번호")
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/memberdb", "emp2", "emp2");
			System.out.println("연결 성공");

			String query = "insert into c_member values(?, ?, ?, ?, ?, now())";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, "id_jdbc"); // ? 위치에 값 대입
			ps.setInt(2, 2222);
			ps.setString(3, "김강산");
			ps.setString(4, "010-4321-4321");
			ps.setString(5, "kang@tech.com");

			int rows = ps.executeUpdate();
			System.out.println("변화행의 갯수 = " + rows);

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
