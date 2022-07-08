package chap18;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyTest {
//	2byte씩
	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		String inputFile = "src/chap18/FileClassTest.java";
		String outputFile = "src/chap18/b.txt";

		try {
			fr = new FileReader(inputFile);
			fw = new FileWriter(outputFile, true);
			while (true) {
				int result = fr.read();
				if (result == -1) {
					break;
				}
				fw.write(result);
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