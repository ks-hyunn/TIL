package chap3;

public class GugudanTest {

	public static void main(String[] args) {
		// int dan = 2;
		for (int i = 1; i <= 9; i++) {
			for (int dan = 2; dan <= 9; dan++) {
				if (dan == 6) {
					break;
					// continue;
					// return;
				}
				System.out.print(dan + " * " + i + " = " + dan * i + "\t");
			}
			System.out.println();
		}
	}

}
