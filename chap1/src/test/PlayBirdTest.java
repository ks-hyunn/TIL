package test;

abstract class Bird {
	String name;
	int legs;
	int lenght;

	abstract void fly();

	abstract void sing();

	abstract void setName(String name);

	abstract void print();
}

class Duck extends Bird {
	int web;

	void swim(int web) {
		this.web = web;
		System.out.println("오리(" + name + ")가 " + web + "개의 물갈퀴로 수영합니다.");
	}

	@Override
	void fly() {
		System.out.println("오리(" + name + ")는 날지 않습니다. ");
	}

	@Override
	void sing() {
		System.out.println("오리(" + name + ")가 소리내어 웁니다.");
	}

	@Override
	void setName(String name) {
		this.name = name;
	}

	@Override
	void print() {
		System.out.println("오리의 이름은 " + name + " 입니다.");
	}
}

class Sparrow extends Bird {
	String friend;

	void makeFriend(String friend) {
		this.friend = friend;
		System.out.println("참새의 친구는 " + friend + " 입니다.");
	}

	@Override
	void fly() {
		System.out.println("참새(" + name + ")가 날아다닙니다");
	}

	@Override
	void sing() {
		System.out.println("참새(" + name + ")가 소리내어 웁니다. ");
	}

	@Override
	void setName(String name) {
		this.name = name;
	}

	@Override
	void print() {
		System.out.println("참새의 이름은 " + name + " 입니다.");
	}
}

public class PlayBirdTest {

	public static void main(String[] args) {
		Duck d = new Duck();
		Sparrow s = new Sparrow();

		d.setName("꽥꽥이");
		d.fly();
		d.sing();
		d.swim(2);
		d.print();

		s.setName("짹짹");
		s.fly();
		s.sing();
		s.makeFriend("허수아비");
		s.print();
	}

}
