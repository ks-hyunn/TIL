package chap5;

abstract class Shape {
	String name;

	abstract void area();

	abstract void circum();
}

class Circle extends Shape {
	int radius;
	final double pi = 3.14;

	Circle(String name, int radius) {
		this.name = name;
		this.radius = radius;
	}

	@Override
	void area() {
		double area = radius * radius * pi;
		System.out.println("반지름이 " + radius + "인 원의 면적 = " + area);
	}

	@Override
	void circum() {
		double circum = 2 * radius * pi;
		System.out.println("반지름이 " + radius + "인 원의 둘레 = " + circum);
	}

}

class Rectangle extends Shape {
	int width;
	int height;

	Rectangle(String name, int width, int height) {
		this.name = name;
		this.width = width;
		this.height = height;
	}

	@Override
	void area() {
		int area = width * height;
		System.out.println("가로 " + width + " 세로 " + height + "인 사각형의 면적 = " + area);
	}

	@Override
	void circum() {
		int circum = 2 * (width + height);
		System.out.println("가로 " + width + " 세로 " + height + "인 사각형의 둘레 = " + circum);
	}

}

public class AbstractTest {

	public static void main(String[] args) {
		Circle c = new Circle("원", 5);
		Rectangle r = new Rectangle("사각형", 6, 8);
		c.area();
		r.area();
		c.circum();
		r.circum();
	}

}
