package a.main;

import java.util.Scanner;

import a.view.MemberDeleteView;
import a.view.MemberInsertView;
import a.view.MemberSelectView;
import a.view.MemberSelectView3;
import a.view.MemberUpdateView;

public class MemberMain {

	public static void main(String[] args) {
//		MemberDAO 메소드 호출
		while (true) {
			System.out.println("=== 회원 관리 프로그램을 시작합니다 ===");
			System.out.println("1. 회원가입");
			System.out.println("2. 회원정보 수정");
			System.out.println("3. 회원탈퇴");
			System.out.println("4. 내정보 조회");
			System.out.println("5. 회원 리스트 조회");
			System.out.println("6. 종료");
			System.out.print("원하는 메뉴의 번호를 입력하세요 : ");
			Scanner sc = new Scanner(System.in);
			int menu = sc.nextInt();

			if (menu == 6) {
				System.exit(0);
			} else if (menu == 1) {
				MemberInsertView view = new MemberInsertView();
				view.input();
			} else if (menu == 2) {
				MemberUpdateView view = new MemberUpdateView();
				view.input();
			} else if (menu == 3) {
				MemberDeleteView view = new MemberDeleteView();
				view.input();
			} else if (menu == 4) {
				MemberSelectView view = new MemberSelectView();
				view.input();
			} else if (menu == 5) {
				MemberSelectView3 view = new MemberSelectView3();
				view.input();
			}
		}

	}

}
