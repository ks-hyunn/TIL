package chap11;

public class ClassTest {

	public static void main(String[] args) {
//		객체 동적 생성
//		입력 문자열 클래스명 해석해서 실제 클래스타입 변환
		try {
			Class c = Class.forName(args[0]); // 문자열을 클래스타입 변환
			Object p = c.newInstance(); // 클래스타입의 객체 생성
			System.out.println(p.getClass().getName()); // 생성 객체 타입 출력
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
