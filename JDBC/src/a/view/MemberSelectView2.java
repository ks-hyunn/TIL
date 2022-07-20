package a.view;

import java.util.ArrayList;
import java.util.Scanner;

import a.dao.MemberDAO;
import a.dto.MemberDTO;

public class MemberSelectView2 implements View {
	public void input() {
		MemberDAO dao = new MemberDAO();
		int totalCount = dao.getTotalMember();
		int recordPerPage = 3; // 1페이지 회원 수
		int totalPage = 0;
		if (totalCount % recordPerPage > 0) {
			totalPage = (totalCount / recordPerPage) + 1;
		} else {
			totalPage = totalCount / recordPerPage;
		}

		Scanner sc = new Scanner(System.in);
		System.out.print("페이지 번호 입력 (1 - " + totalPage + ") : ");
		String page = sc.next();

		ArrayList<MemberDTO> dtos = null;
		if (page.equals("*")) {
			dtos = dao.selectAllMember();
		} else {
			dtos = dao.selectPagingMember(Integer.parseInt(page), recordPerPage);
		}
		for (MemberDTO dto : dtos) {
			System.out.println(dto);
		}
	}

}
