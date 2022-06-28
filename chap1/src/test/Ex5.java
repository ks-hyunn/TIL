package test;

public class Ex5 {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		int c;
		
		c = a;
		a = b;
		b = c;
		
		System.out.println(a);
		System.out.println(b);
	}
}
