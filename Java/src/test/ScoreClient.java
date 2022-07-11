package test;

import java.io.FileReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ScoreClient {

	public static void main(String[] args) {
		try {
			Socket s = new Socket("127.0.0.1", 10000);
			FileReader fr = new FileReader("src/test/input.txt");
			Scanner scan = new Scanner(fr);

			ArrayList<String> line = new ArrayList();
			String data_str = "";
			int i = 0;
			while (scan.hasNextLine()) {
				line.add(scan.nextLine());
				data_str += line.get(i) + "\n";
				i++;
			}

			OutputStream toServer = s.getOutputStream();
			toServer.write(data_str.getBytes());
			s.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
