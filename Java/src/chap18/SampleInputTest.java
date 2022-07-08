package chap18;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SampleInputTest {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("src/chap18/sample.dat");
		Scanner sc = new Scanner(fr);
		String name = sc.next();
		int id = sc.nextInt();
		double pay = sc.nextDouble();
		fr.close();
		sc.close();

		String line = name + " 사원의 사번은 " + id + " 이고 연봉은 " + pay * 12 + " 입니다.";
		System.out.println(line);

		FileWriter fw = new FileWriter("src/chap18/sample.dat", true);
		fw.write('\n' + line);
		fw.close();
	}

}
