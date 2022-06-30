package test;

class Employee {
	int id;
	String name;
	int salary;
	int pay;
	int totalPay;

	Employee(int id, String name, int salary, int pay) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.pay = pay;
	}

	int addPay() {
		return totalPay = salary + pay;
	}
}

class Manager extends Employee {
	int managerPay;

	Manager(int id, String name, int salary, int pay, int managerPay) {
		super(id, name, salary, pay);
		this.managerPay = managerPay;
	}

	int addPay() {
		return totalPay = salary + pay + managerPay;
	}
}

class Engineer extends Employee {
	int qualityPay;
	int engineerPay;

	Engineer(int id, String name, int salary, int pay, int qualityPay, int engineerPay) {
		super(id, name, salary, pay);
		this.qualityPay = qualityPay;
		this.engineerPay = engineerPay;
	}

	int addPay() {
		return totalPay = salary + pay + qualityPay + engineerPay;
	}
}

class Secretary extends Employee {
	int secretaryPay;

	Secretary(int id, String name, int salary, int pay, int secretaryPay) {
		super(id, name, salary, pay);
		this.secretaryPay = secretaryPay;
	}

	int addPay() {
		return totalPay = salary + pay + secretaryPay;
	}
}

public class SalaryTest {

	public static void main(String[] args) {
		Employee e[] = new Employee[4];
		e[0] = new Employee(1000, "이사원", 10000, 5000);
		e[1] = new Manager(2000, "김간부", 20000, 10000, 10000);
		e[2] = new Engineer(3000, "박기술", 15000, 7500, 5000, 5000);
		e[3] = new Secretary(4000, "최비서", 15000, 7000, 10000);

		for (int i = 0; i < e.length; i++) {
			e[i].addPay();
			System.out.println(e[i].id + " : " + e[i].name + " : " + e[i].salary + " : " + e[i].totalPay);
		}
	}

}
