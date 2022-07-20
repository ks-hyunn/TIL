package a.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import a.dto.MemberDTO;
import a.view.MemberDeleteView;

// data access object = jdbc 수행 코드
// member 테이블에 대한 sql 작업 메소드 구현
public class MemberDAO {
// insert, select, update, delete - crud - 기본기능
	public int insertMember(MemberDTO dto) {
		int result = 0;
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/memberdb", "emp2", "emp2");

			String query = "insert into member values(?, ?, ?, ?, ?, now())";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, dto.getId());
			ps.setInt(2, dto.getPassword());
			ps.setString(3, dto.getName());
			ps.setString(4, dto.getPhone());
			ps.setString(5, dto.getEmail());

			result = ps.executeUpdate();
			System.out.println("insertMember - 변화행의 갯수 = " + result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
			}
		}
		return result;
	}

	public int updatetMember(MemberDTO dto) {
		int result = 0;
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/memberdb", "emp2", "emp2");

//			PreparedStatement ps = null;
//			if (dto.getName() != null) {
//				String query = "update member set name = ? where id = ?";
//				ps = con.prepareStatement(query);
//				ps.setString(1, dto.getName());
//				ps.setString(2, dto.getId());
//			} else if (dto.getPassword() != 0) {
//				String query = "update member set password = ? where id = ?";
//				ps = con.prepareStatement(query);
//				ps.setInt(1, dto.getPassword());
//				ps.setString(2, dto.getId());
//			} else if (dto.getPhone() != null) {
//				String query = "update member set phone = ? where id = ?";
//				ps = con.prepareStatement(query);
//				ps.setString(1, dto.getPhone());
//				ps.setString(2, dto.getId());
//			} else if (dto.getEmail() != null) {
//				String query = "update member set email = ? where id = ?";
//				ps = con.prepareStatement(query);
//				ps.setString(1, dto.getEmail());
//				ps.setString(2, dto.getId());
//			}
			String colName = "";
			String colValue = "";
			if (dto.getName() != null) {
				colName = "name";
				colValue = dto.getName();
			} else if (dto.getPassword() != 0) {
				colName = "password";
				colValue = String.valueOf(dto.getPassword());
			} else if (dto.getPhone() != null) {
				colName = "phone";
				colValue = dto.getPhone();
			} else if (dto.getEmail() != null) {
				colName = "email";
				colValue = dto.getEmail();
			}
			String query = "update member set " + colName + " = ? where id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, colValue);
			ps.setString(2, dto.getId());

			result = ps.executeUpdate();
			System.out.println("insertMember - 변화행의 갯수 = " + result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
			}
		}
		return result;
	}

	public int deleteMember(String id, int password) {
		int result = 0;
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/memberdb", "emp2", "emp2");

			String valid = "select password, id from member where id = ?";
			PreparedStatement ps2 = con.prepareStatement(valid);
			ps2.setString(1, id);
			ResultSet rs = ps2.executeQuery();
			rs.next();
			if (rs.getInt(1) == password) {
				String query = "delete from member where id = ?";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, id);

				result = ps.executeUpdate();
				System.out.println("insertMember - 변화행의 갯수 = " + result);

			} else if (rs.getInt(1) != password) {
				System.out.println("암호를 확인해주세요");
				MemberDeleteView view = new MemberDeleteView();
				view.input();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
			}
		}
		return result;
	}

	public MemberDTO selectOneMember(String id, int password) {
		Connection con = null;
		MemberDTO dto = new MemberDTO();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/memberdb", "emp2", "emp2");

			String valid = "select password from member where id = ?";
			PreparedStatement ps2 = con.prepareStatement(valid);
			ps2.setString(1, id);
			ResultSet rs = ps2.executeQuery();

			if (rs.next() == false) {
				System.out.println("아이디를 확인해주세요");
			} else if (rs.getInt(1) != password) {
				System.out.println("암호를 확인해주세요");
			} else if (rs.getInt(1) == password) {
				String query = "select * from member where id = ?";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, id);
				ResultSet rs2 = ps.executeQuery();
				rs2.next();

				dto.setId(rs2.getString("id"));
				dto.setPassword(rs2.getInt("password"));
				dto.setName(rs2.getString("name"));
				dto.setPhone(rs2.getString("phone"));
				dto.setEmail(rs2.getString("email"));
				dto.setRegdate(rs2.getString("regdate"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
			}
		}
		return dto;
	}

	public ArrayList<MemberDTO> selectAllMember() {
		Connection con = null;
		ArrayList<MemberDTO> dtos = new ArrayList<MemberDTO>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/memberdb", "emp2", "emp2");

			String query = "select * from member";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setPhone(rs.getString("phone"));
				dto.setEmail(rs.getString("email"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setPassword(-1);
				dtos.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
			}
		}
		return dtos;
	}

	public ArrayList<MemberDTO> selectSearchMember(String search) {
		Connection con = null;
		ArrayList<MemberDTO> dtos = new ArrayList<MemberDTO>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/memberdb", "emp2", "emp2");

			String query = "select * from member where id like ? or name like ? or phone like ? or email like ? ";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, "%" + search + "%");
			ps.setString(2, "%" + search + "%");
			ps.setString(3, "%" + search + "%");
			ps.setString(4, "%" + search + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setPhone(rs.getString("phone"));
				dto.setEmail(rs.getString("email"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setPassword(-1);

				dtos.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
			}
		}
		return dtos;
	}

}
