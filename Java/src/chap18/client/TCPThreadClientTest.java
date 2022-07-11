package chap18.client;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TCPThreadClientTest {

	public static void main(String[] args) {
		try {
//		3. 서버로 접속
			Socket s = new Socket("172.30.1.48", 20000); // 서버ip, 서버port
			System.out.println("==" + s.getInetAddress().getHostAddress() + " 서버와 연결되었습니다.");
//		5. 회원가입, 로그인, 쇼핑, 게시판 등 요청 전달
			for (int index = 1; index <= 3; index++) { // 3번 반복
				Thread.sleep(3000);
				String message = "100\n";
				byte[] message_byte = message.getBytes();

				OutputStream o = s.getOutputStream(); // 클라이언트 출력
				o.write(message_byte);

				System.out.println(message_byte.length);
				System.out.println("==" + message + " 인사말을 서버로 전송했습니다.");
//			서버로부터 응답 대기
				InputStream i = s.getInputStream();
				Scanner si = new Scanner(i);
				String fromServer = si.nextLine();
				System.out.println("==" + fromServer + " 인사말을 서버로부터 받았습니다.");
			}
//		7. 서버 접속 해제
			s.close();
			System.out.println("==" + s.getInetAddress().getHostAddress() + " 서버와 연결해제되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
