package chap4;

class Account {
	String number = "123-456";
	private int password = 1234;
	int balance = 0;

	void input() {
	}

	void output() {
	}
}

public class AccountTest {

	public static void main(String[] args) {
		Account a1 = new Account();
		System.out.println(a1.number);
		// System.out.println(a1.password);
	}

}
