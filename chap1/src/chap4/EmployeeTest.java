package chap4;

public class EmployeeTest {

	public static void main(String[] args) {
		Employee e1 = new Employee();
		e1.id = 100;
		e1.name = "김사원";
		e1.pay = 1000;
		e1.title = "사원";
		e1.dept = "it";

		System.out.println("사번 = " + e1.id + ", 이름 = " + e1.name + ", 급여 = " + e1.pay);

	}

}
