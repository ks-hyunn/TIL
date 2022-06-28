package chap3;

public class ArrayTest {

	public static void main(String[] args) {
		// 선언 + 생성
		int scores[] = new int[10];
		System.out.println("학생수 = " + scores.length);

		// 배열 기본값 출력
		for (int index = 0; index < scores.length; index++) {
			System.out.println(scores[index]);
		}

		// 학생 점수 저장
		for (int index = 0; index < scores.length; index++) {
			scores[index] = (int) (Math.random() * 100) + 1;
			System.out.println(scores[index]);
		}

		// 총점,평균
		int sum = 0;
		int avg = 0;
		for (int index = 0; index < scores.length; index++) {
			sum += scores[index];
		}
		avg = sum / scores.length;
		System.out.println("총점 = " + sum + " , 평균 = " + avg);

		// 1등
		int max = 0;
		for (int index = 0; index < scores.length; index++) {
			if (scores[index] > max) {
				max = scores[index];
			}
		}
		System.out.println("1등 = " + max);

		// 꼴등
		int min = 999;
		for (int index = 0; index < scores.length; index++) {
			if (scores[index] < min) {
				min = scores[index];
			}
		}
		System.out.println("꼴등 = " + min);
	}

}
