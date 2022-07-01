package chap10;

import java.io.FileNotFoundException;
import java.io.FileReader;

class Test {
	void m1(int i) throws ArithmeticException { // 예외 던지다. 예외처리권한 포기
		System.out.println(100 / i);
	}

	void m2() {
		try { // m1을 호출하는 m2에서 예외처리한다.(메인에서도 가능)
			m1(0);
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		}
	}

	void m3() {
		try { // 다른 방식으로 예외처리 가능
			m1(0);
		} catch (ArithmeticException e) {
			m1(100);
		}
	}

	void m4() {
		try {
			m1(0);
		} catch (ArithmeticException e) { // m1 내부 어떤 문장 어떤 이유로 예외발생 했는지 모르겠다 가정
			e.printStackTrace();
		}
	}

	void m5() {
		try {
			FileReader fr = new FileReader("a.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

public class ThrowsTest {

	public static void main(String[] args) {
		Test t1 = new Test();
		t1.m2();
		t1.m3();
		t1.m4();
		t1.m5();
	}

}
