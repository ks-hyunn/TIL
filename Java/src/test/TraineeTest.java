package test;

class Student {
	String name;
	static String affiliation = "멀티캠퍼스";
	String process;
	int expenses;
	final int charge;
	int refund;

	Student(String name, String process, String expenses, String charge) {
		this.name = name;
		this.process = process.toUpperCase();
		this.expenses = Integer.parseInt(expenses);
		this.charge = Integer.parseInt(charge);
	}
}

public class TraineeTest {

	public static void main(String[] args) {

		Student stu = new Student(args[0], args[1], args[2], args[3]);
//		stu.name = args[0];
//		stu.process = args[1].toUpperCase(); // 대문자로 변경
//		stu.expenses = Integer.parseInt(args[2]);
//		stu.charge = Integer.parseInt(args[3]);

		// equalsIgnoreCase 대소문자 동일 간주 비교
		if (stu.process.equals("자바프로그래밍")) {
			stu.refund = (int) (stu.expenses * 0.25 + stu.charge);
		} else if (stu.process.equals("JDBC프로그래밍")) {
			stu.refund = (int) (stu.expenses * 0.2 + stu.charge);
		} else if (stu.process.equalsIgnoreCase("JSP프로그래밍")) {
			stu.refund = (int) (stu.expenses * 0.15 + stu.charge);
		} else {
			System.out.println("잘못 입력되었습니다.");
			return;
		}
		System.out.println("이름 : " + stu.name + " 소속 : " + stu.affiliation + " 과정명 : " + stu.process + " 교육비 : "
				+ stu.expenses + "원 부가금 : " + stu.charge + "원 환급금 : " + stu.refund + "원");
	}

}
