package chap18.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class TCPThreadServer extends Thread {
	Socket s;

	TCPThreadServer(Socket s) {
		this.s = s;
	}

	public void run() {
		try {
//			6. 클라이언트 요청 처리 - 적당 응답 전달
			for (int index = 1; index <= 3; index++) {
				InputStream i = s.getInputStream(); // 클라이언트 요청 받음
				Scanner si = new Scanner(i);
				int fromClient = si.nextInt();
				System.out.println(++fromClient);

				String reply = "네 안녕합니다.  잘 지내시죠\n";
				OutputStream o = s.getOutputStream(); // 서버 입력
				o.write(reply.getBytes());
			}
//			8. 클라이언트 접속 해제
			s.close();
			System.out.println("==" + s.getInetAddress().getHostAddress() + " 클라이언트와 연결해제되었습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

public class TCPThreadServerTest {

	public static void main(String[] args) {
		try {
//			1. 서버 시작
			ServerSocket ss = new ServerSocket(20000);
			System.out.println("==서버는 20000 번 포트에서 동작중입니다==");
			while (true) {
//				2. 클라이언트 접속 대기 4. 클라이언트의 접속 허용
				Socket s = ss.accept();
				System.out.println("==" + s.getInetAddress().getHostAddress() + " 클라이언트와 연결되었습니다.");
				TCPThreadServer tcp = new TCPThreadServer(s);
				tcp.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
//		9. 서버 종료
	}

}
