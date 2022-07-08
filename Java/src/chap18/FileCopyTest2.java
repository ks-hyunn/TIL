package chap18;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileCopyTest2 {

	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		String inputFile = "src/chap18/FileClassTest.java";
		String outputFile = "src/chap18/c.txt";

		try {
			fr = new FileReader(inputFile);
			fw = new FileWriter(outputFile, true);
			int i = 1;

			Scanner sc = new Scanner(fr);

			while (sc.hasNextLine()) {
				String fileLine = sc.nextLine() + "\n";
				fw.write(i++ + "라인 : " + fileLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}