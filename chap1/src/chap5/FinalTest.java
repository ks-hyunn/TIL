package chap5;

final class Math {
	/* final */ int abs(int i) {
		if (i >= 0) {
			return i;
		} else {
			return i * -1;
		}
	}
}

class MyMath /* extends Math */ {
//	int abs(int i) {
//		if (i < 0) {
//			return i;
//		} else {
//			return i * -1;
//		}
//	}
	Math i = new Math();
}

public class FinalTest {

	public static void main(String[] args) {
		MyMath m = new MyMath();
		int r1 = m.i.abs(10);
		System.out.println("10 의 절대값은 " + r1);
	}

}
