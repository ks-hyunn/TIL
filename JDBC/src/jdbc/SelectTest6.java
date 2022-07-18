package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class SelectTest6 {

	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 호출 완료");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/empdb", "emp2", "emp2");
			System.out.println("연결 성공");
//			william 사원보다 급여를 더 많이 받는 사원의 사번, 이름, 급여조회(subquery)
//			서브쿼리 결과 2개 리턴 -> 서브쿼리 앞에 any -> 결과 둘중 하나 보다 크면된다 / all -> 결과 둘 전부보다 커야된다
			String query = "select employee_id, first_name, salary from employees where salary > any(select salary from employees where first_name = 'william')";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			int count = 0;
			while (rs.next()) {
				count++;
				System.out.println(rs.getInt(1) + " - " + rs.getString(2) + " - " + rs.getDouble(3));
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
