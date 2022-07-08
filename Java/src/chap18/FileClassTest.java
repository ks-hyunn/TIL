package chap18;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class FileClassTest {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		String name = scan.next();
//		name 을 File 객체로 생성
		File f = new File(name);
		if (f.exists()) {
			System.out.println("존재합니다.");
			if (f.isFile()) { // 파일
//				크기 경로 읽기 쓰기 마지막수정
				System.out.println("파일크기(byte단위) = " + f.length());
				System.out.println("전체경로 = " + f.getCanonicalPath());
				System.out.println("파일 읽기 여부 = " + f.canRead());
				System.out.println("파일 쓰기 여부 = " + f.canWrite());
//				System.out.println("최종 수정 시각 = " + f.lastModified());
				long time = f.lastModified();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E, a hh:mm:ss");
				String timeString = sdf.format(time);
				System.out.println("최종 수정 시각 = " + timeString);

			} else { // 디렉토리
				String[] details = f.list();
				for (String d : details) {
					System.out.println(d);
				}
			}
		} else {
			System.out.println(name + " 이름의 파일이나 디렉토리는 없습니다.");
//			System.out.println(f.createNewFile()); // 파일 생성
			System.out.println(f.mkdir()); // 디렉토리 생성
		}
	}

}
// src/chap18/FileClassTest.java