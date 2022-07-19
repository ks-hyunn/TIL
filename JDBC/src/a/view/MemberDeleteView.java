package a.view;

import java.util.Scanner;

import a.dao.MemberDAO;

public class MemberDeleteView implements View {
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("암호 : ");
		int password = sc.nextInt();

		MemberDAO dao = new MemberDAO();
		dao.deleteMember(id, password);
	}

}
