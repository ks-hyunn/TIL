package chap3;

public class PrimeNumberTest {

	public static void main(String[] args) {

		int begin = Integer.parseInt(args[0]);
		int end = Integer.parseInt(args[1]);

		for (int su = begin; su <= end; su++) {
			int count = 0;

			for (int i = 1; i <= su; i++) {
				if (su % i == 0) {
					count++;
				}
			}

			if (count == 2) {
				System.out.println(su + " : 소수입니다.");
			} else {
				System.out.println(su + " : 소수가 아닙니다.");
			}

		}
	}

}
