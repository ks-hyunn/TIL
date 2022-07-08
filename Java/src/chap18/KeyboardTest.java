package chap18;

import java.io.IOException;

public class KeyboardTest {

	public static void main(String[] args) {
		try {
			while (true) {
				int result = System.in.read(); // 키 1개 입력(한글 - 2개이상 ->불가)한 내용의 unicode 해당 숫자 리턴
				System.out.println(result + " : " + (char) result);
				if (result == /* '\n' */13) { // int로 자동형변환 / 13 =\n엔터
					break;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
