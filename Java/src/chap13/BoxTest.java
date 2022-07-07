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

public class BoxTest {

	public static void main(String[] args) {
//		명령행 매개변수 -apple 대구 / paper a4
		Apple a2 = null;
		Paper p2 = null;

		if (args[0].equalsIgnoreCase("apple")) {
			a2 = new Apple(args[1]);
			Box<Apple> b2 = new Box();
			b2.setContents(a2);
			Apple o2 = b2.getContents();
			System.out.println(o2.origin);
		} else if (args[0].equalsIgnoreCase("paper")) {
			p2 = new Paper(args[1]);
			Box<Paper> b2 = new Box();
			b2.setContents(p2);
			Paper o2 = b2.getContents();
			System.out.println(o2.size);
		}

	}

}
