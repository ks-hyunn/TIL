package chap11;

import java.io.IOException;

public class KeyboardTest {

	public static void main(String[] args) {
		try {
//			a-97 A-65 0-48 ㄱ-234 엔터키-13 문자키의 코드표
			System.out.println((char) System.in.read()); // 영문, 숫자, 키도드특수문자들 O, 한글 완성값X -> 키보드 입력 한개
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			while (true) {
				int result = System.in.read();
				if (result == 48) { // 0
					break;
				}
				System.out.println((char) result);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
