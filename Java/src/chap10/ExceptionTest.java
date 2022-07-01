package chap10;

public class ExceptionTest {

	public static void main(String[] args) {
//		2개 이상 입력. 정수변경 가능. 0은 아니어야 한다
//		예외 발생 가능성 있다 - 미리 예측 예외 제거 -> 예외 처리 -> 예외처리구문 수행, main 끝까지 완료
		try {
			int i = Integer.parseInt(args[0]);
			int j = Integer.parseInt(args[1]);
			System.out.println(i / j); // 오류발생 try 중단 -> catch 이동

		} catch (ArithmeticException e) {
//			ArithmeticException 발생시 실행
			System.out.println("0은 입력하지 마세요");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("2개 이상의 값을 입력하세요");
		} catch (NumberFormatException e) {
			System.out.println("정수 변환 가능 값을  입력하세요");
		} catch (Exception e) {
			System.out.println("모든 종류 예외");
		} finally { // 예외발생유무, 예외타입, 처리유무 무관하게 항상 실행 블록
			System.out.println("메인완료");
		}

	}

}
