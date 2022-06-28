package chap3;

public class ArrayTest2 {

	public static void main(String[] args) {
		// 선언 + 생성 + 초기화
		String names[] = { "가", "나", "다", "라", "마", "바", "사", "아", "자", "차" };
		// 선언 + 생성
		int scores[] = new int[10];
		System.out.println("학생수 = " + scores.length + "명");

		// 학생 점수 저장
		for (int index = 0; index < scores.length; index++) {
			scores[index] = (int) (Math.random() * 100) + 1;
			System.out.println(names[index] + " 학생의 점수 = " + scores[index] + "점");
		}

		// 총점,평균
		int sum = 0;
		int avg = 0;
		for (int index = 0; index < scores.length; index++) {
			sum += scores[index];
		}
		avg = sum / scores.length;
		System.out.println("총점 = " + sum + "점 , 평균 = " + avg + "점");

		// 1등
		int max = 0;
		String maxStu = "";
		for (int index = 0; index < scores.length; index++) {
			if (scores[index] > max) {
				max = scores[index];
				maxStu = names[index];
			}
		}
		System.out.println("1등 = " + maxStu + " 학생 " + max + "점 입니다.");

		// 꼴등
		int min = 999;
		String minStu = "";
		for (int index = 0; index < scores.length; index++) {
			if (scores[index] < min) {
				min = scores[index];
				minStu = names[index];
			}
		}
		System.out.println("꼴등 = " + minStu + " 학생 " + min + "점 입니다.");
	}

}
