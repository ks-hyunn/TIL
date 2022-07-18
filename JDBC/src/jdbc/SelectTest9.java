package jdbc;

import java.util.Scanner;

public class SelectTest9 {

	public static void main(String[] args) {
		SelectTest8 s = new SelectTest8();
		Scanner sc = new Scanner(System.in);
		System.out.print("제외할 월 01 - 12 사이 값 입력해주세요 : ");
		String month = sc.next();
		sc.close();
		System.out.println(s.test(month)); // 여러 클래스에서 호출 공유
	}

}
