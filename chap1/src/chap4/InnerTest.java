package chap4;

class Outer {
	int i = 10;

	class Inner {// 멤버변수 느낌
		int j = 20;

		void innerMethod() {
			System.out.println(j);
		}
	}

	static class Inner2 {// 내부클래스 static가능
		int k = 30;
	}

//	Inner3 i3 = new Inner3();error
	void outerMethod() {
		class Inner3 {// 지역변수 느낌
			int n = 40;
		}
		Inner3 i3 = new Inner3();
	}
}

public class InnerTest {

	public static void main(String[] args) {
		Outer o = new Outer();
		System.out.println(o.i);

		Outer.Inner oi = o.new Inner();
		System.out.println(oi.j);
		oi.innerMethod();
		// Inner i = new Inner();error

	}

}
