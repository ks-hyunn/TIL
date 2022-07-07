package test;

import java.util.HashSet;

public class LottoSetTest {

	public static void main(String[] args) {
		HashSet<Integer> lotto = new HashSet();
		while (lotto.size() < 6) {
			int i = (int) (Math.random() * 45) + 1;
			lotto.add(i);
		}

		System.out.print("나의 로또 번호는 ( ");
		for (Integer i : lotto) {
			System.out.print(i + " ");
		}
		System.out.print(") 입니다.");
//		System.out.println("나의 로또 번호는 ( " + lotto + " ) 입니다.");
	}

}
