package chap3;

public class SwitchTest {

	public static void main(String[] args) {
		// 1-12월 중에서 각 월의 마지막 날짜 출력
		int month = (int) (Math.random() * 12) + 1;
		int day = 0;
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			day = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			day = 30;
			break;
		default:
			day = 28;
		}
		System.out.println(month + "월의 마지막 날짜는 " + day + "일 입니다.");
	}

}
