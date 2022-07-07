package test;

import java.util.HashSet;
import java.util.Iterator;

public class LottoSetTest {

	public static void main(String[] args) {
		HashSet<Integer> lotto = new HashSet();
		while (lotto.size() < 6) { // for문을 사용하면 중복된 난수값이 나올 경우 6개 저장이 안될 수 있다
			int i = (int) (Math.random() * 45) + 1;
			lotto.add(i);
		}

		System.out.print("나의 로또 번호는 ( ");
//		for (Integer i : lotto) {
//			System.out.print(i + " ");
//		}

		Iterator<Integer> it = lotto.iterator(); // iterator 사용 시
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.print(") 입니다.");
	}

}
