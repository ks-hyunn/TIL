package a.view;

import java.util.Scanner;

import a.dao.MemberDAO;
import a.dto.MemberDTO;

public class MemberUpdateView implements View {
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.println("수정 항목 : 암호 이름 번호 이메일");
		String change = sc.next();

		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		if (change.equals("암호")) {
			System.out.print("변경 후 암호 : ");
			int password = sc.nextInt();
			dto.setPassword(password);
		} else if (change.equals("이름")) {
			System.out.print("변경 후 이름 : ");
			String name = sc.next();
			dto.setName(name);
		} else if (change.equals("번호")) {
			System.out.print("변경 후 번호 : ");
			String phone = sc.next();
			dto.setPhone(phone);
		} else if (change.equals("이메일")) {
			System.out.print("변경 후 이메일 : ");
			String email = sc.next();
			dto.setEmail(email);
		}

		MemberDAO dao = new MemberDAO();
		dao.updatetMember(dto);
	}

}
