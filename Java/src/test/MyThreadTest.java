package test;

class MusicThread extends Thread {
	MusicThread(String name) {
		super(name);
	}

	public void run() {
		for (int i = 1; i <= 3; i++) {
			System.out.println(getName() + "듣는중입니다." + i);
		}
	}

}

class DownloadThread extends Thread {
	DownloadThread(String name) {
		super(name);
	}

	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(getName() + "중입니다." + i);
		}
	}
}

class NewsThread extends Thread {
	NewsThread(String name) {
		super(name);
	}

	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println(getName() + "보는중입니다." + i);
		}
	}
}

public class MyThreadTest {

	public static void main(String[] args) {
		Thread arr[] = new Thread[3]; // class A extends Thread
		arr[0] = new MusicThread("음악");
		arr[1] = new NewsThread("뉴스");
		arr[2] = new DownloadThread("다운로드");

		for (int i = 0; i < arr.length; i++) {
			arr[i].start();
		}
	}

}
