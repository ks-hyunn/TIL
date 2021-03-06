package a.view;

import java.util.ArrayList;
import java.util.Scanner;

import a.dao.MemberDAO;
import a.dto.MemberDTO;

public class MemberSelectView3 implements View {
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("검색 : ");
		String search = sc.next();

		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> dtos = dao.selectSearchMember(search);
		if (dtos.size() == 0) {
			System.out.println("검색 결과가 없습니다.");
		} else {
			for (MemberDTO dto : dtos) {
				System.out.println(dto);
			}
		}
	}

}
