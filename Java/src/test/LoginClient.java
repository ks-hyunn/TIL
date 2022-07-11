package test;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class LoginClient {

	public static void main(String[] args) {
		try {
			Socket s = new Socket("127.0.0.1", 10000); // 내 컴퓨터의 가상 ip 127.0.0.1 or localhost
			Scanner si = new Scanner(System.in);
			System.out.print("아이디 : ");
			String id = si.next();
			System.out.print("비밀번호 : ");
			String pw = si.next();

			OutputStream o = s.getOutputStream();
			o.write((id + "," + pw + "\n").getBytes());

			Scanner sis = new Scanner(s.getInputStream());
			String result = sis.nextLine();
			System.out.println(result);
			sis.close();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
