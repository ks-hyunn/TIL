package chap18;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputTest {
	public static void main(String[] args) {
//		파일 없으면 자동생성
//		파일 있으면 두번째 매개변수 true -> 기존 데이터 유지 추가로 write / false,x -> 기존 데이터 삭제 후 write
		FileOutputStream fo = null;
		try {
			fo = new FileOutputStream("src/chap18/a.java", true);
			fo.write(65);
			fo.write(97);
			fo.write(13);

			fo.write('A');
			fo.write('a');
			fo.write('\n');
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}