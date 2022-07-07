package chap13;

class Apple {
	String origin;

	Apple(String origin) {
		this.origin = origin;
	}
}

class Paper {
	String size;

	Paper(String size) {
		this.size = size;
	}
}

class Box<T> { // type parameter = 클래스타입 전달
	T contents; // Apple + Paper + 모든 객체

	public T getContents() {
		return contents;
	}

	public void setContents(T contents) {
		this.contents = contents;
	}

}

class TwoBox<T1, T2> {
	T1 o1;
	T2 o2;

	TwoBox(T1 o1, T2 o2) {
		this.o1 = o1;
		this.o2 = o2;
	}

}

class ThreeBox<T extends Number> { // Number 하위클래스만 가능
	T num;

	ThreeBox(T num) {
		this.num = num;
	}
}

public class BoxTest {

	public static void main(String[] args) {
//		하위클래스 타입 파라미터 전달
		ThreeBox<Integer> threeBox = new ThreeBox(100); // autoboxing / auto-unboxing -> int = Integer
		ThreeBox<Double> threeBox2 = new ThreeBox(567.89);
		System.out.println(threeBox.num.getClass().getName());
		System.out.println(threeBox2.num.getClass().getName());

//		ThreeBox<String> threeBox3 = new ThreeBox("100"); // String -> Number 하위클래스x -> error

//		멀티 타입 파라미터 전달
//		TwoBox<Apple, Paper> twoBox = new TwoBox(new Apple("경북 영주"), new Paper("B5"));
//		System.out.println(twoBox.o1.getClass().getName());
//		System.out.println(twoBox.o2.getClass().getName());
//
//		TwoBox<String, Integer> twoBox2 = new TwoBox("경북 영주", 100);
//		System.out.println(twoBox2.o1.getClass().getName());
//		System.out.println(twoBox2.o2.getClass().getName());

//		명령행 매개변수 -apple 대구 / paper a4
//		Apple a2 = null;
//		Paper p2 = null;
//
//		if (args[0].equalsIgnoreCase("apple")) {
//			a2 = new Apple(args[1]);
//			Box<Apple> b2 = new Box();
//			b2.setContents(a2);
//			Apple o2 = b2.getContents();
//			System.out.println(o2.origin);
//		} else if (args[0].equalsIgnoreCase("paper")) {
//			p2 = new Paper(args[1]);
//			Box<Paper> b2 = new Box();
//			b2.setContents(p2);
//			Paper o2 = b2.getContents();
//			System.out.println(o2.size);
//		}

	}

}
