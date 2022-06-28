package test;

public class Ex4 {

	public static void main(String[] args) {
		int input = 76;
		boolean multiple = input % 3 == 0 && input % 7 == 0;
		
		System.out.println(multiple ? "input 변수는 3의 배수이면서 7의 배수이다." : "input 변수는 3의 배수이면서 7의 배수가 아니다.");
	}

}
