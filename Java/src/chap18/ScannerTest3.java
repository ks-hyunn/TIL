package chap18;

import java.text.DecimalFormat;
import java.util.Scanner;

class Employee {
	int id;
	String name;
	double pay;

	public Employee(int id, String name, double pay) {
		this.id = id;
		this.name = name;
		this.pay = pay;
	}

	public String toString() {
		DecimalFormat d = new DecimalFormat("#,###.##");
		return id + " 사번 " + name + " 사원의 연봉은 " + d.format(pay * 12) + " 입니다.";
	}
}

public class ScannerTest3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.print("사원의 사번 : ");
		int id = scan.nextInt();
		System.out.print("사원의 이름 : ");
		String name = scan.next();
		System.out.print("사원의 월급여 : ");
		double pay = scan.nextDouble();

		Employee e1 = new Employee(id, name, pay);
		System.out.println(e1);

//		한 줄 입력
		System.out.println("사번 이름 월급여 순서로 입력하세요.");
		scan.nextLine();
		String line = scan.nextLine();
		String[] word = line.split(" ");
		int id2 = Integer.parseInt(word[0]);
		String name2 = word[1];
		double pay2 = Double.parseDouble(word[2]);

		Employee e2 = new Employee(id2, name2, pay2);
		System.out.println(e2);

	}

}
