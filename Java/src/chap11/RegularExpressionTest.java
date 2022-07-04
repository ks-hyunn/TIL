package chap11;

public class RegularExpressionTest {

	public static void main(String[] args) {
		String phones[] = { "010-1234-5678", "011-1234-5678", "010-12345-6789", "010-^^^2-" };
//		010- 시작 / 숫자3,4자리 / -4자리 숫자 종료
		for (int i = 0; i < phones.length; i++) {

//			[A-z] [가-힣] [0-9] .(아무문자) \\d(숫자) \\w(문자+숫자)
//			+(1개이상) *(0개부터 전부) ?(0개or1개)

//			System.out.println(phones[i].matches("010-[0-9]{3,4}-[0-9]{4}"));
//			System.out.println(phones[i].matches("(010|011)-[0-9]{3,4}-[0-9]{4}"));
//			System.out.println(phones[i].matches("(010|011)-.{3,4}-[0-9]{4}"));
//			System.out.println(phones[i].matches("(010|011)-.{3,4}-[0-9]+"));

//			System.out.println(phones[i].matches("(010|011)-.{3,5}-[0-9]*"));
//			010이나 011- 시작 / 알파벳한글숫자특수문자들 3~5자리 / -0개이상숫자

//			System.out.println(phones[i].contains("1234"));
//			System.out.println(phones[i].equals("1234"));
		}

//		String address = "서울시.서초구.서초동.테크부루.아카데미.3층";
//		String[] result = address.split("."); // 정규식 . -> 아무 문자 1개
//		String[] result = address.split("\\."); // 특수문자 '.' 형태
//		String[] result = address.split("[.]"); // 특수문자 '.' 형태
//		System.out.println(result.length);
//		for (int i = 0; i < result.length; i++) {
//			System.out.println(result[i]);
//		}

		String address = "서울시-서초구/서초동 테크부루:아카데미 3층";
		String[] result = address.split("(-|/|:| )"); // or연산자
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

}
