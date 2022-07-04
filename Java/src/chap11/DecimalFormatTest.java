package chap11;

import java.text.DecimalFormat;

public class DecimalFormatTest {

	public static void main(String[] args) {
		double num = 1234567.89;
//		# 정수부분 - 표현 숫자가 더 커도 잘 표현
//		# 소수점이하부분 - 정확 자릿수 표현(반올림)
		DecimalFormat dcf = new DecimalFormat("###,###.#"); // 6자리정수.1자리소수
		System.out.println(dcf.format(num));

		double num2 = 34567.89;
		DecimalFormat dcf2 = new DecimalFormat("000,000.#"); // 6자리고정정수.1자리소수
		System.out.println(dcf2.format(num2));

		double num3 = 4567.8;
		DecimalFormat dcf3 = new DecimalFormat("000,000.00"); // 6자리고정정수.2자리고정소수
		System.out.println(dcf3.format(num3));

		double num4 = -4567.8;
		DecimalFormat dcf4 = new DecimalFormat("+000,000.00;-000,000.00"); // 양수, 음수
		System.out.println(dcf4.format(num4));

		DecimalFormat dcf5 = new DecimalFormat("#.00"); // 정수자리수만큼.2자리고정소수
		System.out.println(dcf5.format(10 / (double) 3));
	}

}
