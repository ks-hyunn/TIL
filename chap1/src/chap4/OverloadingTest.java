package chap4;

class C {
	int add(int i, int j) {
		return i + j;
	}

	String add(String i, String j) {
		return i + j;
	}

	double add(double i, double j, double k) {
		return i + j + k;
	}
}

public class OverloadingTest {

	public static void main(String[] args) {
		C c1 = new C();
		String r1 = c1.add("java", "과정");
		int r2 = c1.add(10, 20);
		double r3 = c1.add(2, 3.3, 1.1);
		System.out.println(r1 + "\n" + r2 + "\n" + r3);

		int decimal = Integer.parseInt("100");
		int bin = Integer.parseInt("100", 2);
		int decimal2 = Integer.parseInt("12345678", 5, 7, 10);
		System.out.println(decimal + "\n" + bin + "\n" + decimal2);
	}

}
