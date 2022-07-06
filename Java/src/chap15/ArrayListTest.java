package chap15;

import java.util.ArrayList;

class Employee {
	int id;
	String name;
	double pay;

	Employee(int id, String name, double pay) {
		this.id = id;
		this.name = name;
		this.pay = pay;
	}

	public String toString() {
		return id + " - " + name + " - " + pay;
	}

}

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList list = new ArrayList(5); // 초기 5개 생성 이후 5개씩 자동 생성, 삭제

//		추가 add(값), insertAt(index, 값) / 수정 set(index, 값) / 삭제 remove(index or 값)
		list.add("java");
		list.add(100);
		list.add(3.14);
		list.add("jsp");
		list.add(true); // 5
		list.add('a');

		Employee e1 = new Employee(100, "김사원", 67000.88);
		list.add(e1);
		Employee e2 = new Employee(200, "박대리", 77000.88);
		list.add(e2);
		Employee e3 = new Employee(300, "최과장", 87000.88);
		list.add(e3);

//		조회 size() -> 저장된 갯수 / get(index) -> 해당 index에 저장된 값 / Object 리턴
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + " 위치의 값 = " + list.get(i)/* .toString() */);
		}
	}

}

//	컬렉션 프레임워크 기본형변수 x, 객체들만 저장 ->(jdk 1.5) int타입 Integer타입 같은 타입 간주 => autoboxing / auto unboxing
//	int i = 100;
//	Integer in = new Integer(100);
//	Integer in2 = 100; // autoboxing
//	int i2 = new Integer(100); // auto unboxing
