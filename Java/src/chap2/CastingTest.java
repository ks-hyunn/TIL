package chap2;

public class CastingTest {

	public static void main(String[] args) {
		//자동형변환,묵시적형변환
		byte b = 127;
		int i = b;
		System.out.println("i = " + i);
		double d = i;
		System.out.println("d = " + d);
		
		System.out.println("--------------");
		//강제형변환,명시적형변환
		double d2 = 3.14;
		int i2 = (int)d2;
		System.out.println("i2 = " + i2);//일부값 손실
		
		int i3 = 128;
		byte b3 = (byte)i3;
		System.out.println("b3 = " + b3);//값의 손실
		
		System.out.println("--------------");
		
		char c4 = 'a'; 
		int i4 = (int)c4;
		System.out.println("c4 = " + c4 + " , i4 = " + i4);
		
		char c5 = 'A';
		int i5 = c5;
		System.out.println("c5 = " + c5 + " , i5 = " + i5);
		
		//소문자(97)를 대문자(65)로 변경
		System.out.println((char)(i4 - 32));
	}

}
