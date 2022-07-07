package chap13.nonGeneric;

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

class Box {
	Object contents; // Apple + Paper + 모든 객체

	public Object getContents() {
		return contents;
	}

	public void setContents(Object contents) {
		this.contents = contents;
	}

}

public class BoxTest {

	public static void main(String[] args) {
		Apple a = new Apple("대구");
		Box b1 = new Box();
		b1.setContents(a);
		/* Apple */Object o = b1.getContents();
		System.out.println(((Apple) o).origin);
		System.out.println("==========");

//		명령행 매개변수 -apple 대구 / paper a4
		Apple a2 = null;
		Paper p2 = null;

		if (args[0].equalsIgnoreCase("apple")) {
			a2 = new Apple(args[1]);
		} else if (args[0].equalsIgnoreCase("paper")) {
			p2 = new Paper(args[1]);
		}

		Box b2 = new Box();
		if (a2 != null) {
			b2.setContents(a2);
		} else if (p2 != null) {
			b2.setContents(p2);
		}

		Object o2 = b2.getContents();
		if (o2 instanceof Apple) {
			System.out.println(((Apple) o2).origin);
		} else if (o2 instanceof Paper) {
			System.out.println(((Paper) o2).size);
		}
	}

}
