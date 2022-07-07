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
		for (String k : keys) {
			System.out.print(k + " = ");
			for (int i = 0; i < phone.get(k).length; i++) {
				System.out.print(phone.get(k)[i] + " ");
			}
			System.out.println("");
		}
	}

}