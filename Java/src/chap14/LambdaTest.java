package chap14;

@FunctionalInterface
interface I1 {
	/* public abstract */ void m1();
//	void m2(); // 추가시 람다식 오류
}

interface I2 {
	void m1(int x);
}

interface I3 {
	void m1(int x, int y);
}

interface I4 {
	int m1(int x, int y);
}

//	1개 메소드만 정의 인터페이스일 때 가능 = functional interface
public class LambdaTest {

	public static void main(String[] args) {
//		람다식 정의
//		타입 생략 가능, 매개변수 1개일 때 괄호 생략 가능
//		{}내부 1문장일 때 {} 생략 가능 

		I1 i1 = () -> System.out.println("람다 테스트");
		i1.m1(); // 람다식 호출 실행

		I2 i2 = x -> System.out.println(x);
		i2.m1(10);

		I3 i3 = (x, y) -> { // 타입 생략 가능, 매개변수 2개 -> 괄호 생략x / {}내부 2문장 -> 생략x
			System.out.println(x + y);
			System.out.println(x * y);
		};
		i3.m1(5, 8);

		I4 i4 = (x, y) -> x + y; // return타입 있는 메소드에서 return문장 1개만 구현할 때 {}, return 생략 가능

		int result = i4.m1(10, 20);
		System.out.println(result);
	}

}
