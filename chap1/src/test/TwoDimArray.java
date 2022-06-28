package test;

public class TwoDimArray {

	public static void main(String[] args) {
		// 3명학생 2,3,4과목 점수 -
		int array2[][] = new int[3][];
		String names[] = new String[args.length];
		int sum;
		double avg = 0.0;

		if (args.length >= 3) {
			for (int i = 0; i < args.length; i++) {
				names[i] = args[i];
			}
		} else {
			System.out.println("3명 이상 입력해주세요.");
			return;
		}
		// 명령행 매개변수 학생이름 3명 입력 저장 배열
		// 구현

		// 각 학생의 총점 / 평균
		// 이름 같이 출력
		// xxx 학생 : { 점수들 } : 해당학생의 총점 = xxx : 해당학생의 평균 : xxx
		for (int i = 0; i < array2.length; i++) { // 3
			array2[i] = new int[i + 2];
			sum = 0;
			System.out.print(names[i] + " 학생 : { ");
			for (int j = 0; j < array2[i].length; j++) {
				array2[i][j] = (int) (Math.random() * 100) + 1;
				System.out.print(array2[i][j] + " ");
				sum += array2[i][j];
			}
			avg = (double) sum / array2[i].length;
			System.out.println("} : 해당 학생의 총점 = " + sum + "점 : 해당 학생의 평균 :" + avg + "점");
		}

	}

}
