package chap12;

class A extends Thread {
//	String name;
//	A(String name) {
//		this.name = name;
//	}

	A(String name) { // super클래스인 Thread 생성자에 name 전달하여 setName()
		super(name);
	}

	public void run() { // run() 오버라이딩 -> 멀티스레드 구현 내용 정의
		for (int i = 1; i <= 10; i++) {
			System.out.println(getName() + " 스레드 = " + i);
		}
	}
}

public class ThreadTest {

	public static void main(String[] args) {
//		A a1 = new A(); // Thread-0 ~
//		A a2 = new A();
		A a1 = new A("one");
		A a2 = new A("two");

//		a1.run(); // run() -> 멀티스레드x 동기
//		a2.run();

		a1.start(); // run() 아닌 start() 호출해서 실행
		a2.start();

		System.out.println("main 종료");
	}

}
