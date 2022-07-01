package chap9;

class A2 {

	interface I {
		void m1();

		void m2();
	}

//	I i1 = new I(); 인터페이스 객체 생성 불가

	I i1 = new I() {
		public void m1() {
			System.out.println("m1");
		}

		public void m2() {
			System.out.println("m2");
		}
	};// 인터페이스 I 상속받은 익명(ANONYMOUS)클래스 정의 동시에 객체 생성
}

public class NestedTest2 {

	public static void main(String[] args) {
		A2 a1 = new A2();
		a1.i1.m1();
		a1.i1.m2();
	}

}
