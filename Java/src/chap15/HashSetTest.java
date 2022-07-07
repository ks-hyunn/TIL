package chap15;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {

	public static void main(String[] args) {
//		추가 add(), 삭제 remove(), 검색 contains() 포함여부, size() 전체 수, isEmpty() 데이터(하나라도)여부
		HashSet set = new HashSet();

		set.add(100);
		set.add(3.14);
		set.add("SetTest");
		set.add(new Employee(100, "이사원", 56000.11));
		System.out.println("갯수 = " + set.size());
		System.out.println("===========");

		set.add(100); // 중복값 저장x -> 무시
//		set.set(1, "변경"); // Set 변경 없음 -> 중복값, 인덱스 없기 때문에 삭제 후 저장해야 함
		boolean b = set.remove(1); // 값 1 데이터 삭제 -> 인덱스x / 삭제하면 true 없으면 false
		boolean c = set.remove(100);
		System.out.println(b);
		System.out.println(c);
		System.out.println("갯수 = " + set.size());
		System.out.println("===========");

		System.out.println("set 안에 데이터 존재 여부 = " + set.isEmpty());
		System.out.println("100 존재 여부 = " + set.contains(3.14));
		System.out.println("===========");

//		set 내부 모든 데이터 조회 -> iterator() / 향상된 for문
		Iterator it = set.iterator(); // 반복자
		while (it.hasNext()) {
			System.out.println(it.next()); // 저장 순서 != 출력 순서
		}
		System.out.println("===========");
		for (Object o : set) {
			System.out.println(o);
		}
	}

}
