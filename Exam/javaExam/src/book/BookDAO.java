package book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDAO {
	public void insertBook(BookDTO bookDTO) {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bookdb", "emp2", "emp2");

			String query = "insert into book values(?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, bookDTO.getBookNo());
			ps.setString(2, bookDTO.getBookTitle());
			ps.setString(3, bookDTO.getBookAuthor());
			ps.setString(4, bookDTO.getBookYear());
			ps.setInt(5, bookDTO.getBookPrice());
			ps.setString(6, bookDTO.getBookPublisher());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
			}
		}
	}

	public void selectBook() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bookdb", "emp2", "emp2");

			String query = "select bookNo, bookTitle, bookAuthor, year(bookYear), bookPrice, bookPublisher from book";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			System.out.println("===========================================");
			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " "
						+ rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6));
			}
			System.out.println("===========================================");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
			}
		}
	}
}
