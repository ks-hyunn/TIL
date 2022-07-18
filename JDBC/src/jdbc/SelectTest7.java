package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class SelectTest7 {

	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 호출 완료");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/empdb", "emp2", "emp2");
			System.out.println("연결 성공");
//			키보드 입력
//			제외할 월 : 01 - 12 사이 값 입력
//			입사월별 급여 총합 구하되 제외할 월 빼고
			Scanner sc = new Scanner(System.in);
			System.out.print("제외할 월 01 - 12 사이 값 입력해주세요 : ");
			String month = sc.next();
//			String query = "select date_format(hire_date, '%m'), sum(salary) from employees where date_format(hire_date, '%m') != '"
//					+ month + "' group by date_format(hire_date, '%m') order by 1";
			String query = "select month(hire_date), sum(salary) from employees where month(hire_date) != '" + month
					+ "' group by month(hire_date) order by 1";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				System.out.println(rs.getString(1) + "월 : " + rs.getDouble(2));
			}
			sc.close();
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
