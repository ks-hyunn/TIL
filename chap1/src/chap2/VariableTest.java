package chap2;

public class VariableTest {

	public static void main(String[] args) {
		boolean b1 = true;
		boolean b2 = false;
		boolean b3 = 10 > 0;
		System.out.println("b1의 값 = " + b1);
		System.out.println("b2의 값 = " + b2);
		System.out.println("b3의 값 = " + b3);
		System.out.println(b1 + "," + b2 + "," + b3);
		
		System.out.println("--------------");
		
		int i1 = 100;
		int i2 = 200;
		System.out.println(i1 + i2);
		System.out.println("i1 + i2 = " + i1 + i2);
		System.out.println("i1 + i2 = " + (i1 + i2));
		
		System.out.println("--------------");
		
		System.out.println("int의 최대값 = " + Integer.MAX_VALUE);
		System.out.println("int의 최소값 = " + Integer.MIN_VALUE);
		
		System.out.println("--------------");
		
		char c1 = '다';
		char c2 = '\n';
		System.out.println("c1 = " + c1);
		System.out.println("c2 = " + c2);
		
		System.out.println("--------------");
		
		int i4 = 65;
		char c4 = 'A';//아스키코드로 변환 계산(65)
		System.out.println(i4 + c4);
		System.out.println((char)i4);
		System.out.println((int)c4);
	}

}
