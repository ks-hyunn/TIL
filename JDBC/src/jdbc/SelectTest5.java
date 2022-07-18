package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class SelectTest5 {

	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 호출 완료");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/empdb", "emp2", "emp2");
			System.out.println("연결 성공");
//			사원이름 부서이름 도시이름 조회 (join)
//			String query = "select first_name, department_name, city from employees e join departments d on e.department_id = d.department_id join locations l on d.location_id = l.location_id";
			String query = "select first_name, ifnull(department_name, '부서없음'), ifnull(city, '이사중') from employees e left join departments d on e.department_id = d.department_id left join locations l on d.location_id = l.location_id";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			int count = 0;
			while (rs.next()) {
				count++;
				System.out.println(rs.getString(1) + " - " + rs.getString(2) + " - " + rs.getString(3));
			}
			System.out.println("=== 총 레코드갯수 - " + count);

			Statement st2 = con.createStatement();
			ResultSet rs2 = st2.executeQuery("select count(*) from employees");
			rs2.next();
			System.out.println("=== 총 사원명수 - " + rs2.getInt("count(*)"));

			rs2.close();
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
