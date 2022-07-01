package chap9;

class A {
	int v = 10;
	B b1 = new B(); // 중첩 클래스 객체 B 생성 가능 위치 A 내부

	class B {
		int x = 20;

		void bMethod() {
			System.out.println(x);
			System.out.println("v=" + v); // 외부클래스 선언된 멤버변수 사용 가능
		}
	}

	static class C {
		int y = 30;

		void cMethod() {
			System.out.println(y);
		}
	}

	void aMethod() {
		B b2 = new B(); // 중첩 클래스 타입의 객체
		System.out.println(b2.x);
//		System.out.println(x); error 내부클래스 선언된 변수 바로 사용 x
	}
}

public class NestedTest {

	public static void main(String[] args) {
//		지역변수
		A a2 = new A();
		a2.aMethod();

//		non-static
//		B b2 = new B(); error
		A a1 = new A();
		System.out.println(a1.b1.x);
		a1.b1.bMethod();

		A.B b2 = a1.new B(); // new A().new B(); 가능
		System.out.println(b2.x);
		b2.bMethod();

//		A.B b3 = new A.B(); error A 생성 후 B 생성

//		static
		A.C c2 = new A.C();
		System.out.println(c2.y);
		c2.cMethod();

	}

}
