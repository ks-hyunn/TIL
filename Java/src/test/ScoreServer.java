package test;

import java.io.FileWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DecimalFormat;
import java.util.Scanner;

public class ScoreServer {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(10000);
			while (true) {
				Socket s = ss.accept();
				Scanner scan = new Scanner(s.getInputStream());
				DecimalFormat df = new DecimalFormat("#.00");
				FileWriter fw = new FileWriter("src/test/output.txt", true);

				while (scan.hasNextLine()) {
					String fromClient = scan.nextLine();
					String[] dataLine = fromClient.split("\n");
					for (int i = 0; i < dataLine.length; i++) {
						String[] data = dataLine[i].split(" ");
						int sum = (Integer.parseInt(data[1]) + Integer.parseInt(data[2]) + Integer.parseInt(data[3]));
						Double avg = (double) sum / 3;
						fw.write(data[0] + " " + data[1] + " " + data[2] + " " + data[3] + " " + sum + " "
								+ df.format(avg) + "\n");
					}
				}
				fw.close();
				s.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
