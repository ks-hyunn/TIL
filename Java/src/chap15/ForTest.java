package chap15;

import java.util.ArrayList;

public class ForTest {

	public static void main(String[] args) {
		String[] arr = { "java", "db", "web client", "web server", "ai" };
//		arr[5] = "spring"; // 고정된 크기 -> 추가 불가
		arr[4] = "spring"; // 수정
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println("=========================");

//		jdk 1.5 향상된 반복문 (for문)
		for (String s : arr) {
			System.out.println(s.toUpperCase());
		}
		System.out.println("=========================");

//		1. 여러가지 타입 저장 또는 2. String 타입만 저장 (동적 크기의 String 배열 -> <String>) 
		ArrayList<String> list = new ArrayList<String>();
		list.add("java");
		list.add("db");
		list.add("web client");
		list.add("web server");
		list.add("ai");
		list.add("spring");
//		list.add(100);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("=========================");

		for (String s : list) {
			System.out.println(s.toUpperCase());
		}
//		for (Object s : list) {
//			if (s instanceof String) {
//			System.out.println(((String) s).toUpperCase());
//			} else {
//				System.out.println(s);
//			}
//		}
	}

}
