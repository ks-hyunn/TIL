package test;

class MusicThread extends Thread {
	public MusicThread(String name) {
		super(name);
	}

	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println("음악듣는중입니다.");
		}
	}

}

class DownloadThread extends Thread {
	public DownloadThread(String name) {
		super(name);
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("다운로드중입니다.");
		}
	}
}

class NewsThread extends Thread {
	public NewsThread(String name) {
		super(name);
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("뉴스보는중입니다.");
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
