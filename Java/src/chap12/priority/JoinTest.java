package chap12.priority;

class C extends Thread {
	int data = 10;

	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		data = data * 2;
		System.out.println("run메소드 = " + data);
	}
}

public class JoinTest {

	public static void main(String[] args) {
		System.out.println("main시작");
		C c1 = new C(); // 멀티스레드 객체 생성 c1.data -> 10
		c1.start(); // run() 실행 준비 / (실행전)c1.data -> 10 (실행후)c1.data -> 20

		try {
			c1.join(); // run()실행/스레드 실행 잠시멈춤->지정 스레드 완료 후 다시실행(현재(main)스레드 중단 후 join()앞에 있는 스레드 우선실행)
		} catch (InterruptedException e) {
		}

		System.out.println(c1.data);
		System.out.println("main종료");
	}

}
