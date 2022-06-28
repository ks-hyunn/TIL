package chap3;

public class ForTest {

	public static void main(String[] args) {
		// 1-10 정수 출력
		for (int i = 1; i <= 10; i++) {
			System.out.println("i = " + i);
		}

		// 1-10 정수 합계
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum += i;
		}
		System.out.println("sum = " + sum);
		System.out.println("====================");

		int sum2 = 0;
		int i2 = 1;
		while (i2 <= 10) {
			System.out.println("i2 = " + i2);
			sum2 += i2;
			i2++;
		}
		System.out.println("sum2 = " + sum2);
		System.out.println("====================");

		int sum3 = 0;
		int i3 = 1;
		do {
			System.out.println("i3 = " + i3);
			sum3 += i3;
			i3++;
		} while (i3 <= 10);
		System.out.println("sum3 = " + sum3);

		// 1-50 사이의 난수를 발생시켜 10의 배수가 아니면 출력. 10의 배수이면 중단
		int i4 = (int) (Math.random() * 50) + 1;
		while (i4 % 10 != 0) {
			System.out.println(i4);
			i4 = (int) (Math.random() * 50) + 1;
		}

	}

}
