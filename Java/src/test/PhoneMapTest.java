package test;

import java.util.HashMap;
import java.util.Set;

public class PhoneMapTest {

	public static void main(String[] args) {
		String names[] = { "우리엄마", "내친구", "회사동료", "내동생" };
		String phone1[] = { "010-1234-5678", "02-111-222", "umma@multi.com" };
		String phone2[] = { "010-9876-5432", "02-123-4567", "031-3333-4444", "myfriend@multi.com" };
		String phone3[] = { "010-1212-4444", "02-6775-5656", "company@multi.com" };
		String phone4[] = { "010-1111-5678" };

		HashMap<String, String[]> phone = new HashMap();
		phone.put(names[0], phone1);
		phone.put(names[1], phone2);
		phone.put(names[2], phone3);
		phone.put(names[3], phone4);

		Set<String> keys = phone.keySet();
		for (String s : keys) {
			System.out.print(s + " = ");
			String[] p = phone.get(s);
			for (String sp : p) { // 2중 향상된 for문
				System.out.print(sp + " ");
			}
			System.out.println("");
		}
//		for (String k : keys) {
//			System.out.print(k + " = ");
//			for (int i = 0; i < phone.get(k).length; i++) {
//				System.out.print(phone.get(k)[i] + " ");
//			}
//			System.out.println("");
//		}

//		명령행 매개변수로 우리엄마 입력시 우리엄마 정보만 출력
//		if (phone.containsKey(args[0])) {
//			String[] result = phone.get(args[0]);
//			System.out.print(args[0] + " - ");
//			for (String r : result) {
//				System.out.print(r + " ");
//			}
//		} else {
//			System.out.println("해당 정보는 입력된 적이 없습니다.");
//		}
		String[] result = phone.get(args[0]);
		if (result != null) {
			System.out.print(args[0] + " - ");
			for (String r : result) {
				System.out.print(r + " ");
			}
		} else {
			System.out.println("해당 정보는 입력된 적이 없습니다.");
		}
	}

}