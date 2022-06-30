package chap5;

class Parent {
	int su = 10;

	void pr() {
		System.out.println(su);// 10
	}

	void pMethod() {
		System.out.println("Parent 클래스");
	}
}

class Child1 extends Parent {
	int su = 20;

	void pr() {
		System.out.println(su);// 20
	}

	void cMethod() {
		System.out.println("Child1 클래스");
	}
}

public class CastingTest {

	public static void main(String[] args) {
		Parent p = new Parent();// 형변환필요x
		System.out.println(p.su);
		p.pr();
		p.pMethod();
//		p.cMethod(); 메모리 존재 x

		Child1 c1 = new Child1();// 형변환필요x
		System.out.println(c1.su);
		c1.pr();
		c1.pMethod();
		c1.cMethod();

		Parent p2 = new Child1();// 자동형변환
		System.out.println(p2.su);// Parent의 su
		p2.pr();// 오버라이딩된 Child1의 pr()
		p2.pMethod();
//		p2.cMethod(); 메모리 존재 o, 하위클래스객체영역

		Child1 c2 = (Child1) p2;// 명시적형변환 (하위객체 변수나 메소드 사용 위해)
		c2.cMethod();

		((Child1) p2).cMethod();

	}

}
