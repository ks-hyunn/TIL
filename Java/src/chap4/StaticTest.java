package chap4;

class Person {
	String name;
	int age;
	static final String nation = "대한민국";

	void showPerson() {// non-static 메소드 내부에서는 non-static 변수와 static 변수 모두 가능
		System.out.println(name + ":" + age + ":" + nation);
	}

	static void showNation() {// static 메소드 내부에서는 static 변수만 가능
		System.out.println("모든 사람의 국적 = " + nation);
//		System.out.println(name);
	}
}

public class StaticTest {

	public static void main(String[] args) {

		Person.showNation();
		// System.out.println("모든 사람의 국적 = " + Person.nation);
		Person p1 = new Person();
		p1.name = "김한국";
		p1.age = 27;
		// p1.nation="미국";
		// p1.nation = "대한민국";
		p1.showPerson();
		// System.out.println("p1 객체의 이름 = " + p1.name + " 나이 = " + p1.age + " 국적 = " +
		// p1.nation);

		Person p2 = new Person();
		p2.name = "박대한";
		p2.age = 37;
		// p2.nation = "대한민국";
		p2.showPerson();
//		System.out.println("p2 객체의 이름 = " + p2.name + " 나이 = " + p2.age + " 국적 = " + p2.nation);
	}

}
