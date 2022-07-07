package chap15;

import java.util.HashMap;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {
//		저장,수정 put(key, value) / 삭제 remove(key) / 조회 size(), get(key)
		Employee e1 = new Employee(100, "이사원", 56000.77);

		HashMap<String, Employee> map = new HashMap(); // key 중복x, value 중복o
		map.put("사원1", e1);
		map.put("사원2", new Employee(200, "박사원", 56000.77));
		map.put("사원3", new Employee(300, "김사원", 56000.77));
		System.out.println("갯수 = " + map.size());

		map.put("사원1", new Employee(400, "최사원", 56000.77)); // key 중복x -> 같은 key값 수정
		System.out.println("갯수 = " + map.size());

		map.put("사원4", e1); // value 중복 가능
		System.out.println("갯수 = " + map.size());
		System.out.println("===============");

//		사원3의 정보 출력 / 3번째 데이터x -> 인덱스x
//		Object o = map.get("사원3");
//		if (o instanceof Employee) {
//			System.out.println(((Employee) o).name);
//		}
		Employee o = map.get("사원3");
		System.out.println(o.name);
		System.out.println("===============");

//		map 모든 데이터 조회
		Set keys = map.keySet(); // 모든 key
		for (Object k : keys) {
			System.out.println("키는 = " + k + "이고 값은 = " + map.get(k));
		}
	}

}
