package chap18;

import java.util.Scanner;

public class ScannerTest2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 장바구니");
			System.out.println("4. 쇼핑");
			System.out.println("5. 종료");
			System.out.print("원하는 작업의 번호를 입력하세요. : ");

			int menu = scan.nextInt();
			if (menu == 5) {
//				System.exit(0); // 프로그램 완전종료
				break; // 현재 반복문만 종료
			} else if (menu == 1) {
				System.out.println("회원가입 화면으로 이동합니다.");
			} else if (menu == 2) {
				System.out.println("로그인 화면으로 이동합니다.");
			} else if (menu == 3) {
				System.out.println("장바구니 화면으로 이동합니다.");
			} else if (menu == 4) {
				System.out.println("쇼핑 화면으로 이동합니다.");
			}

		}
	}

}
