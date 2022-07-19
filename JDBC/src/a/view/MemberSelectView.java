package a.view;

import java.util.Scanner;

import a.dao.MemberDAO;
import a.dto.MemberDTO;

public class MemberSelectView implements View {
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("암호 : ");
		int password = sc.nextInt();

		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.selectOneMember(id, password);
		if (dto.getPassword() == 0) {
			input();
		} else {
			System.out.println("아이디 : " + dto.getId() + " 비밀번호 : " + dto.getPassword() + " 이름 : " + dto.getName()
					+ " 핸드폰 번호 : " + dto.getPhone() + " 이메일 : " + dto.getEmail() + " 가입한 날짜 : " + dto.getRegdate());
		}
	}

}
