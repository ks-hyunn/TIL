package chap4;

class Data {
	int num = 10;

}

class B {
	void addInt(int i) {
		System.out.println("addInt 메소드 내부 = " + i++);
	}

	void addData(Data d) {
		System.out.println("addData 내부 = " + d.num++);
	}
}

public class CallByValueTest {

	public static void main(String[] args) {
		B b1 = new B();
		// 기본형 매개변수 전달
//		int j = 10;
//		b1.addInt(j);
//		System.out.println("addInt 메소드 호출 후 j = " + j);

		// 참조형 매개변수 전달
		Data d2 = new Data();
		b1.addData(d2);
		System.out.println("addData 메소드 호출 후 d2.num = " + d2.num);
	}

}
