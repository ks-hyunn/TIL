package a.view;

import java.util.Scanner;

import a.dao.MemberDAO;
import a.dto.MemberDTO;

public class MemberInsertView implements View {
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("암호 : ");
		int password = sc.nextInt();
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("핸드폰 번호 : ");
		String phone = sc.next();
		System.out.print("이메일 : ");
		String email = sc.next();

		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setPassword(password);
		dto.setName(name);
		dto.setPhone(phone);
		dto.setEmail(email);

		MemberDAO dao = new MemberDAO();
		dao.insertMember(dto);
	}
}
