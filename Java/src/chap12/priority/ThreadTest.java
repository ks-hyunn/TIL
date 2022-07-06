package chap12.priority;

class A extends Thread {
	A(String name) {
		super(name);
	}

//	우선순위 - 먼저 마칠 가능성이 있다(실행시간 비동일).무조건 순차적 실행x
	public void run() {
		System.out.println(getName() + "우선순위 = " + getPriority()); // 우선순위 1(낮음)-10(높음) 기본값 5
		for (int i = 1; i <= 10; i++) {
			try {
				Thread.sleep(500); // 스레드 실행 잠시 멈춤 -> 지정 시간 경과 후 다시 실행 / 1000 -> 1초
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(getName() + " 스레드 = " + i);
		}
	}
}

public class ThreadTest {

	public static void main(String[] args) {
		A a1 = new A("one");
		A a2 = new A("two");

//		a1.setPriority(Thread.MIN_PRIORITY); // 1
//		a2.setPriority(Thread.MAX_PRIORITY); // 10

		a1.start();
		a2.start();

		System.out.println("main 종료");
	}

}
