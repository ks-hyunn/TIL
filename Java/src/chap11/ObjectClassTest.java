package chap11;

public class ObjectClassTest {

	public static void main(String[] args) {
		MyObject o1 = new MyObject("MyObject");
		MyObject o2 = new MyObject("MyObject");

		System.out.println(o1); // o1객체 생성전달문자열 출력내용 변경 -> toString 오버라이딩
		System.out.println(o2);

		if (o1 == o2) { // false
			System.out.println("o1 == o2 같다");
		}
		if (o1.equals(o2)) { // false 오버라이딩가능(변경가능)
//			o2 가 MyObject 타입 객체인지 체크(타입 다르다면 false)
//			타입이 일치한다면 o1.msg 와 o2.msg 동일한지 체크(변수값 다르다면 false)
//			변수값 동일하면 true
			System.out.println("o1.equals(o2) 같다");
		}
	}

}

class MyObject {
	String msg;

	MyObject(String msg) {
		this.msg = msg;
	}

//	toString() 오버라이딩
	public String toString() {
		return msg;
	}

//	equals() 오버라이딩
	public boolean equals(Object obj) {
		if (obj instanceof MyObject) {
			return msg.equals(((MyObject) obj).msg);
		} else {
			return false;
		}
	}

}