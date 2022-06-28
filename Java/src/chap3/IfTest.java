package chap3;

public class IfTest {

	public static void main(String[] args) {
		String name = "김학생";
		int kor = (int) (Math.random() * 100) + 1;
		int eng = (int) (Math.random() * 100) + 1;
		int mat = (int) (Math.random() * 100) + 1;

		int sum = kor + mat + eng;
		int avg = sum / 3;
		System.out.println("학생명 : " + name);
		System.out.println("국어 : " + kor);
		System.out.println("영어 : " + eng);
		System.out.println("수학 : " + mat);
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + avg);

		// 평균 80 이상이면 "수료" 아니면 "미수료" 출력

		String result;
		if (avg >= 80) {
			result = "수료";
		} else {
			result = "미수료";
		}
		System.out.println(result);

		// 평균 90 이상이면 "A" / 70 이상이면 "B" / 50 이상이면 "C" / 나머지 "F"

		/*
		 * String grade; if (avg >= 90) { grade = "A등급"; } else if (avg >= 70) { grade =
		 * "B등급"; } else if (avg >= 50) { grade = "C등급"; } else { grade = "F등급"; }
		 * System.out.println(grade);
		 */

		// switch-case문으로

		String grade;
		switch (avg / 10) {
		case 10:
		case 9:
			grade = "A";
			break;
		case 8:
		case 7:
			grade = "B";
			break;
		case 6:
		case 5:
			grade = "C";
			break;
		default:
			grade = "F";
		}
		System.out.println(grade);
	}
}
