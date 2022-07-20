package a.view;

import java.util.ArrayList;
import java.util.Scanner;

import a.dao.MemberDAO;
import a.dto.MemberDTO;

public class MemberSelectView2 implements View {
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("페이지 번호 입력 : ");
		String page = sc.next();

		if (page.equals("*")) {
			MemberDAO dao = new MemberDAO();
			ArrayList<MemberDTO> dtos = dao.selectAllMember();
			for (MemberDTO dto : dtos) {
				System.out.println(dto);
			}
		}

	}

}
