package jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class SelectTest5 {

	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 호출 완료");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/empdb", "emp2", "emp2");
			System.out.println("연결 성공");

			String query = "select first_name, ifnull(department_name, ?), ifnull(city, ?) from employees e left join departments d on e.department_id = d.department_id left join locations l on d.location_id = l.location_id where e.department_id = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, "부서없음");
			st.setString(2, "이사중");
			st.setInt(3, 80);
			ResultSet rs = st.executeQuery();

			int count = 0;
			while (rs.next()) {
				count++;
				System.out.println(rs.getString(1) + " - " + rs.getString(2) + " - " + rs.getString(3));
			}
			System.out.println("=== 총 레코드갯수 - " + count);
			rs.close();
		} catch (ClassNotFoundException e) {
			System.out.println("미설치이거나 classpath 미등록 또는 드라이버명 오타 확인");
		} catch (SQLException e) {
			System.out.println("db연결 정보 잘못되어있는지 확인");
			e.printStackTrace();
		} finally {
			try {
				con.close();
				System.out.println("연결 해제 성공");
			} catch (SQLException e) {
			}
		}
	}

}
