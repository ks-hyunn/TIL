package chap5;

class A /* extends java.lang.Object */ {
	int i;

	A() {
		// super(); 상위클래스 자동호출 = Object();
		i = 100;
		System.out.println("A호출");
	}
}

class B extends A {
	int j;

	B() {
		// super(); 상위클래스 자동호출 = A();
		j = 200;
		System.out.println("B호출");
	}
}

public class ConstructorTest {

	public static void main(String[] args) {
		B b1 = new B();
		System.out.println(b1.i);
		System.out.println(b1.j);
	}

}
