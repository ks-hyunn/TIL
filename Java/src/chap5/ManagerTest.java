package chap5;

class Employee {
	/* private */ int id;
	String name = "회사원";
	double pay;

	void printInform() {
		System.out.println(id + " : " + name + " : " + "pay");
	}
}

class Manager extends Employee {
	String jobOfManage;
	String name = "관리직";

	final void test() {
		String name = "지역변수";
		System.out.println(name);
		System.out.println(this.name);
		System.out.println(super.name);
	}

	@Override
	void printInform() {
		// System.out.println(id + " : " + name + " : " + pay);
		super.printInform();
		System.out.println(jobOfManage);
	}
}

public class ManagerTest {

	public static void main(String[] args) {
		Manager m = new Manager();
		m.id = 200;
		m.name = "홍길동";
		m.pay = 34500.99;
		m.jobOfManage = "it관리";
		System.out.println("사번 = " + m.id);// Employee 상속
		System.out.println("이름 = " + m.name);
		System.out.println("급여 = " + m.pay);
		System.out.println("관리업무 = " + m.jobOfManage);// Manager 선언
		m.printInform();
		m.test();
	}

}
