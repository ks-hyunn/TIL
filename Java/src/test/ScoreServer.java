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
//				DecimalFormat df = new DecimalFormat("#.00");
				FileWriter fw = new FileWriter("src/test/output.txt", true);

				while (scan.hasNextLine()) {
//					String fromClient = scan.nextLine();
//					String[] data = fromClient.split(" ");
//					int sum = (Integer.parseInt(data[1]) + Integer.parseInt(data[2]) + Integer.parseInt(data[3]));
//					Double avg = (double) sum / 3;
//					fw.write(data[0] + " " + data[1] + " " + data[2] + " " + data[3] + " " + sum + " " + df.format(avg)
//							+ "\n");
					String name = scan.next();
					int score1 = scan.nextInt();
					int score2 = scan.nextInt();
					int score3 = scan.nextInt();
					int sum = score1 + score2 + score3;
					String avg = new DecimalFormat("#.##").format(sum / 3.0);
					fw.write(name + " " + score1 + " " + score2 + " " + score3 + " " + sum + " " + avg + "\n");
				}
				fw.close();
				s.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
