package test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class LoginServer {

	public static void main(String[] args) {
		HashMap<String, String> users = new HashMap();
		users.put("multi", "campus");
		users.put("java", "program");
		users.put("oracle", "db");
		Set<String> keys = users.keySet();
		try {
			ServerSocket ss = new ServerSocket(10000);
			while (true) {
				Socket s = ss.accept();
				Scanner si = new Scanner(s.getInputStream());
				String fromClient = si.nextLine();
				String id = fromClient.split(",")[0];
				String pw = fromClient.split(",")[1];

				String reply = null;
				boolean exists = false;
				for (String key : keys) {
					if (id.equals(key)) {
						exists = true;
						if (pw.equals(users.get(key))) {
							reply = "정상 로그인 사용자입니다.\n";
						} else {
							reply = "암호를 확인하세요.\n";
						}
					}
				}
				if (exists == false) {
					reply = "회원가입 해주세요.\n";
				}
				OutputStream o = s.getOutputStream();
				o.write(reply.getBytes());
				o.close();
				s.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
