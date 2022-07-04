package test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

class MySum {
	int first;
	int second;

	MySum(int first, int second) {
		this.first = first;
		this.second = second;
	}

	public boolean equals(Object obj) {
		if (obj instanceof MySum) {
			return toString().equals(((MySum) obj).toString());
		} else {
			return false;
		}
	}

	public String toString() {
		return String.valueOf(first + second);
	}

	String createTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년도 MM월 dd일 HH시 mm분 ss초");
		Calendar cal = Calendar.getInstance();
		String result = sdf.format(cal.getTime());
		return result;
	}
}

public class OverridingTest {

	public static void main(String[] args) {
		int i = 10;
		int j = 20;

		MySum ms1 = new MySum(i, j);
		MySum ms2 = new MySum(j, i);

		System.out.println(ms1);// 30
		System.out.println(ms2);// 30

		if (ms1.equals(ms2)) {
			System.out.println("ms1과 ms2의 합계는 동일합니다.");
		}

		String s1 = new String("30");
		if (ms1.equals(s1)) {
			System.out.println("ms1과 s1은  동일합니다.");
		}

		System.out.println("ms1 객체를 출력한 시각은 " + ms1.createTime() + " 입니다.");
	}

}
