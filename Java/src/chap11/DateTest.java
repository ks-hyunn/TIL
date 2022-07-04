package chap11;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		long mill = System.currentTimeMillis(); // 현재시각 1/100초

		Date now = new Date(); // 현재시각 년도.월....
		Date now2 = new Date(mill);

		System.out.println(mill);
		System.out.println(now);
		System.out.println(now2);

		now.getDate();
//		deprecated method - jdk 변화되면서 사용 자제 표시(초록색원에 빗금)
//		사용해도 컴파일 오류 발생x
//		새 프로젝트 사용 자제 권고

//		Calendar cal = new Calendar();
		Calendar cal = Calendar.getInstance(); // abstract -> new X
		System.out.println(cal);
		now.getYear(); // 년도 사용 자제
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1; // 0부터 시작
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);

		System.out.println(
				"현재시각은 " + year + "년 " + month + "월 " + day + "일 " + hour + "시 " + minute + "분 " + second + "초 입니다.");

		cal.get(Calendar.DAY_OF_WEEK); // 일요일부터 1 시작
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		if (cal.get(Calendar.DAY_OF_WEEK) == 2) {
			System.out.println("월요일-MONDAY");
		}

//		22-07-04 13:23:24 요일 날짜 형식 미리 지정
//		SimpleDateFormat - 간결하게 날짜 시각 형식 - 날짜 시간 정보는 Date객체나 Calendar객체 생성하여 정보 형식을 지정
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd a hh:mm:ss E"); // d(이달중) D(1년중) H(24시간) h(12시간)
		String result = sdf.format(now); // now2, cal.getTime()
		System.out.println(result);
	}

}
