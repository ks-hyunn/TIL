package chap4;

class Employee2 {
	int id;
	String name;
	double pay;
	String dept;
	String title;

	Employee2(int id, String name, double pay, String dept, String title) {
		System.out.println("생성자 호출");
		this.id = id;
		this.name = name;
		this.pay = pay;
		this.dept = dept;
		this.title = title;
	}

	Employee2(int id, String name, double pay) {
//		this.id = id;
//		this.name = name;
//		this.pay = pay;
//		dept = "부서이동중";
//		title = "발령이전";
		this(id, name, pay, "부서이동중", "발령이전");
	}

	Employee2() {
//		id = -1;
//		name = "없음";
//		pay = -1;
//		dept = "미정";
//		title = "미정";
		this(-1, "없음", -1, "미정", "미정");
	}
}

public class EmployeeTest2 {

	public static void main(String[] args) {

		Employee2 e1 = new Employee2(100, "이사원", 1000, "it", "사원");
		System.out.println(
				"사번=" + e1.id + " , 이름=" + e1.name + " , 급여=" + e1.pay + " , 부서명= " + e1.dept + " , 직급=" + e1.title);

		Employee2 e2 = new Employee2(200, "김대리", 1500);
		System.out.println(
				"사번=" + e2.id + " , 이름=" + e2.name + " , 급여=" + e2.pay + " , 부서명= " + e2.dept + " , 직급=" + e2.title);

		Employee2 e3 = new Employee2();
		System.out.println(
				"사번=" + e3.id + " , 이름=" + e3.name + " , 급여=" + e3.pay + " , 부서명= " + e3.dept + " , 직급=" + e3.title);

	}

}
