package chap3;

public class TwoDimArray {

	public static void main(String[] args) {
		// 3명학생 2과목 점수 - {{1,2} {3,4,} {5,6}}
		int array[][] = new int[3][2];
		System.out.println("1차원 배열 갯수 = " + array.length);

		// 2차 배열 접근 코드
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = (int) (Math.random() * 100) + 1;
				System.out.println(array[i][j]);
			}
		}

		// 3명학생 2과목 점수 - {{1,2} {3,4,} {5,6}}
		int array2[][] = new int[3][2];
		System.out.println("1차원 배열 갯수 = " + array2.length);

		// 2차 배열 접근 코드
		for (int i = 0; i < array2.length; i++) {
			array2[i] = new int[i + 2];
			System.out.println(array2[i].length);
			System.out.print("{");
			for (int j = 0; j < array2[i].length; j++) {
				array2[i][j] = (int) (Math.random() * 100) + 1;
				System.out.print(array2[i][j] + " ");
			}
			System.out.println("}");
		}
	}

}
