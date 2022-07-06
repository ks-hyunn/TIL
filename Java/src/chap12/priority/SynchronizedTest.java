package chap12.priority;

class Data {
	int value;

	public synchronized void saveValue(int value) {
		this.value = value;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		System.out.println(Thread.currentThread().getName() + " : " + this.value); // Thread.currentThread() -> 스레드를 실행하고 있는 객체
	}
}

class DataThread1 extends Thread {
	Data d;

	DataThread1(String name, Data d) {
		super(name);
		this.d = d;
	}

	public void run() {
		d.saveValue(10);
	}
}

class DataThread2 extends Thread {
	Data d;

	DataThread2(String name, Data d) {
		super(name);
		this.d = d;
	}

	public void run() {
		d.saveValue(20);
	}
}

public class SynchronizedTest {

	public static void main(String[] args) {
		Data d = new Data();
		DataThread1 t1 = new DataThread1("스레드1", d);
		DataThread2 t2 = new DataThread2("스레드2", d);
//		if (t1.d == t2.d) { // 같은 객체 공유하는 2개 스레드
//			System.out.println("같다");
//		}
		t1.start();
		t2.start();
//		비동기적 실행 -> 순서 미정	
//		synchronized -> 동기화 블럭 -> 같은 객체 공유, 같은 값을 참조할 때 먼저 사용하는 스레드가 사용 끝날때 까지 공유x
//		(동기화 메소드 정의. 2개 이상 스레드 동시 동기화 메소드 수행x. 1개 수행동안 1개 스레드 대기)
	}

}
