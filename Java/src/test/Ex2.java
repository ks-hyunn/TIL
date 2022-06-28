package test;

public class Ex2 {

	public static void main(String[] args) {
		int cntOfBooks = 97;
		int cntOfStu = 12;
		
		System.out.println(cntOfBooks>=cntOfStu ? "1명의 학생당 : " + cntOfBooks/cntOfStu + "권씩 가질 수 있습니다.\n남아있는 책은 " + cntOfBooks%cntOfStu + "권 입니다." : "나눠줄 수 없습니다.");
		//나누기, 나머지 각각 변수로/ 출력문 String 타입 변수로
	}
}
