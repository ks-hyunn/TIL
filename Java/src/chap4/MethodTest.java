package chap4;

class A {
	int m1() {
		int i = 10;
		return i * i;
	}

	double m2() {
		return 3.14;
	}

	String m3() {
		String s1 = "m3";
		return s1 + "메소드";
	}

	int[] m4() {
		int[] i = { 1, 2, 3 };
		return i;
	}

	void m5() {
		int j = 10;
		System.out.println(j * j);
	}

	Person m6() {
		Person p1 = new Person();
		p1.name = "홍길동";
		p1.age = 30;
		return p1;
	}

	void m7() {
		System.out.println("m7 시작");
		if (true) {
			return;
		}
		System.out.println("m7 종료");
		// return 0;
	}
}

public class MethodTest {

	public static void main(String[] args) {
		A a1 = new A();

		int result1 = a1.m1();
		System.out.println(result1);

		double result2 = a1.m2();
		System.out.println(result2);

		System.out.println(a1.m3());

		// System.out.println(a1.m4());
		int[] result3 = a1.m4();
		for (int i = 0; i < result3.length; i++) {
			System.out.println(result3[i]);
		}

		a1.m5();

		Person result4 = a1.m6();
		System.out.println(result4.nation);

		a1.m7();
	}

}
