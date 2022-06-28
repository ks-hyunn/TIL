package test;

class Calculator {
	int num1, num2;
	String operator;

	Calculator(int num1, int num2, String operator) {
		this.num1 = num1;
		this.num2 = num2;
		this.operator = operator;
	}

	void print() {
		int result = 0;
		if (operator.equals("-")) {
			result = num1 - num2;
		} else if (operator.equals("+")) {
			result = num1 + num2;
		} else if (operator.equals("*")) {
			result = num1 * num2;
		} else if (operator.equals("/")) {
			result = num1 / num2;
		} else {
			System.out.println("인식할 수 없는 연산자 입니다.");
			return;
		}
		System.out.println(num1 + " " + operator + " " + num2 + " = " + result + " 입니다.");
	}

}

public class CalculatorTest {

	public static void main(String[] args) {
		Calculator calc = new Calculator(100, 50, "-");
		calc.print();

		Calculator calc2 = new Calculator(100, 50, "+");
		calc2.print();

		Calculator calc3 = new Calculator(100, 50, "*");
		calc3.print();

		Calculator calc4 = new Calculator(100, 50, "/");
		calc4.print();

		Calculator calc5 = new Calculator(100, 50, "더하기");
		calc5.print();
	}

}
