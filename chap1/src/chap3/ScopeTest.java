package chap3;

public class ScopeTest {

	public static void main(String[] args) {
		String a = "메인메소드에서 선언";
		int i = 1;
		if (i == 1) {
			System.out.println(a);
			a = "if블록에서 사용";
		}
		System.out.println(a);
	}

}
