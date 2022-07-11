package chap18.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServerTest {

	public static void main(String[] args) {
		try {
//		1. 서버 시작
			ServerSocket ss = new ServerSocket(10000);
			System.out.println("==서버는 10000 번 포트에서 동작중입니다==");
			while (true) {
//			2. 클라이언트 접속 대기 4. 클라이언트의 접속 허용
				Socket s = ss.accept();
				System.out.println("==" + s.getInetAddress().getHostAddress() + " 클라이언트와 연결되었습니다.");
//			6. 클라이언트 요청 처리 - 적당 응답 전달
				for (int index = 1; index <= 3; index++) {
					InputStream i = s.getInputStream(); // 클라이언트 요청 받음
					Scanner si = new Scanner(i);
					int fromClient = si.nextInt();
					System.out.println(++fromClient);
//				while (si.hasNextLine()) { // 여러줄 입력받을때
//					String fromClient = si.nextLine();
//					System.out.println("==" + fromClient + " 라는 인사말을 전달받았습니다.");
//				}
					String reply = "네 안녕합니다.  잘 지내시죠\n";
					OutputStream o = s.getOutputStream(); // 서버 입력
					o.write(reply.getBytes());
				}
//			8. 클라이언트 접속 해제
				s.close();
				System.out.println("==" + s.getInetAddress().getHostAddress() + " 클라이언트와 연결해제되었습니다.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
//		9. 서버 종료
	}

}
