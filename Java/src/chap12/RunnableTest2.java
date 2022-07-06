package chap12;

// 중첩 인터페이스
// 다른 클래스 내부 사용 인터페이스
// 인터페이스 상속 무명 클래스 정의 + 객체 생성

public class RunnableTest2 {

	public static void main(String[] args) {

		Runnable r1 = new Runnable() {
			public void run() {
				for (int i = 1; i <= 10; i++) {
					System.out.println("스레드 = " + i);
				}
			}
		};

		Thread ta1 = new Thread(r1);
		ta1.start();

		System.out.println("main 종료");
	}

}
