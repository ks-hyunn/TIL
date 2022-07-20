package a.dto;

// data transfer object - 데이터 중간 저장 전달 목적 객체
public class MemberDTO {
	String id;
	int password;
	String name;
	String phone;
	String email;
	String regdate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String toString() {
		return "아이디 : " + id + " 비밀번호 : " + password + " 이름 : " + name + " 핸드폰 번호 : " + phone + " 이메일 : " + email
				+ " 가입한 날짜 : " + regdate;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
}
