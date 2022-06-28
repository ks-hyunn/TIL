package chap3;

public class DiceTest {

	public static void main(String[] args) {
		int dice1 = (int) (Math.random() * 6) + 1;
		int dice2 = (int) (Math.random() * 6) + 1;
		int sum = 0;
		while (sum != 5) {
			sum = dice1 + dice2;
			System.out.println("(" + dice1 + " + " + dice2 + ") = " + sum);
			dice1 = (int) (Math.random() * 6) + 1;
			dice2 = (int) (Math.random() * 6) + 1;
		}
		System.out.println("주사위게임 끝났습니다.");
	}

}
