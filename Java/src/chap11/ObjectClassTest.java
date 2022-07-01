package chap11;

public class ObjectClassTest {

	public static void main(String[] args) {
		Object o1 = new Object();
		Object o2 = new Object();

		System.out.println(o1/* .toString() 호출결과출력 */); // java.lang.Object@3d012ddd
		System.out.println(o1.toString()); // java.lang.Object@3d012ddd
//		getClass().getName() + '@' + Integer.toHexString(hashCode())
//		패키지명.클래스명@16진수변경(주소-10진수)

		System.out.println(o2);
		System.out.println(o2.toString());
		if (o1 == o2) { // false
			System.out.println("o1 == o2 같다");
		}
		if (o1.equals(o2)) { // false
			System.out.println("o1.equals(o2) 같다");
		}
	}

}
