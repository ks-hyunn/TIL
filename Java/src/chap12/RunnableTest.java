package chap12;

class B implements Runnable {
	String name;

	B(String name) {
		this.name = name;
	}

	public void run() { // run() 오버라이딩 -> 멀티스레드 구현 내용 정의
		for (int i = 1; i <= 10; i++) {
			System.out.println(name + " 스레드 = " + i);
		}
	}
}

public class RunnableTest {

	public static void main(String[] args) {
		B b1 = new B("one");
		Thread ta1 = new Thread(b1); // Thread 타입의 객체 생성 -> Runnable 타입의 객체 전달

		B b2 = new B("two");
		Thread ta2 = new Thread(b2);

//		ta1.run(); // run() -> 멀티스레드x 동기
//		ta2.run();

		ta1.start(); // run() 아닌 start() 호출해서 실행
		ta2.start();

		System.out.println("main 종료");
	}

}
