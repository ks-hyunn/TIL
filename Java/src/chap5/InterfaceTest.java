package chap5;

// 오버라이딩 규칙 - 하위클래스 modifire 같거나 더 넓어야 한다
//	interface 변수 - public final static 자동정의
//	interface 메소드 - abstract public 자동정의
// 인터페이스 상속 구현 클래스 메소드 오버라이딩 public

interface Student {
	String name = "학생";

	void study();

	void lunch();
}

interface Worker {
	String name = "교직원";

	void work();

	void lunch();
}

// 인터페이스의 하위클래스 = 인터페이스를 구현하는 클래스

class StudentWorker implements Student, Worker {
//	String name = "학생" 자동포함(static)
//	String name = "교직원" 자동포함(static)

	public void study() {
		System.out.println("조교는 오전에 공부하다");
	}

	public void work() {
		System.out.println("조교는 오후에 행정업무하다");
	}

	public void lunch() {
		System.out.println("조교는 점심먹다");
	}
}

public class InterfaceTest {

	public static void main(String[] args) {
		StudentWorker sw = new StudentWorker();
		sw.study();
		sw.lunch();
		sw.work();

//		System.out.println(sw.name);
		System.out.println(Student.name);
		System.out.println(Worker.name);

//		상위인터페이스명 변수명 = new 하위클래스객체(); -> 객체형변환

		Student sw2 = new StudentWorker();
		sw2.study();
		sw2.lunch();
//		sw2.work();

		Worker sw3 = new StudentWorker();
//		sw3.study();
		sw3.lunch();
		sw3.work();
	}

//	jdk 1.8 이상(default, static)
//
//	interface I1 {
//		void ma(); 필수 재정의
//
//		default void mb() {
//			System.out.println("모든 하위클래스들은 공통 구현 / 선택적 재정의");
//		}
//
//		static void mc() {
//			System.out.println("모든 하위클래스들은 공통 구현");
//		}
//	}
}
