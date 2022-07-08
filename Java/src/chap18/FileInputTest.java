package chap18;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputTest {
//	1byte 씩 읽어오기 -> 영어, 이미지, 음악 / 한글x
	public static void main(String[] args) {
		FileInputStream fi = null;
		try {
			fi = new FileInputStream("src/chap18/FileInputTest.java");
			while (true) {
				int result = fi.read();
				System.out.print((char) result);
				if (result == -1) { // -1 -> end of file
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fi.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}