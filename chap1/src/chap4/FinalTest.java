package chap4;

class Circle {
	int radius;
	final double pi = 3.14;
	int x = 100;
	int y = 200;
}

public class FinalTest {

	public static void main(String[] args) {
		Circle c = new Circle();
		// c.pi = c.pi + 1;
		c.radius = 5;
		c.x = c.x * 2;
		double area = c.radius * c.radius * c.pi;
		System.out.println("원의 중심(x,y) = " + c.x + ", " + c.y + " 인 원의 반지름은 " + c.radius + " 이고 ");
		System.out.println("원의 면적은 " + area + " 입니다.");
	}

}
