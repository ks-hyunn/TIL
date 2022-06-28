package chap3;

public class Pay {

	public static void main(String[] args) {
		String product[] = { "라면", "음료수", "계란", "사과" };
		int price[] = { 500, 2500, 8000, 1000 };
		int sum = 0;

		for (int i = 0; i < product.length; i++) {
			sum += price[i] * Integer.parseInt(args[i]);
			System.out.println(product[i] + " : " + price[i] + "원 " + args[i] + "개의 가격은 총 "
					+ price[i] * Integer.parseInt(args[i]) + "원 입니다.");
		}

		System.out.println("총 지불 가격은 " + sum + "원 입니다.");
		System.out.println("선택하신 지불 수단은 " + args[4] + "입니다.");
		if (args.length == 6) {
			System.out.println("현금영수증 처리 번호는 " + args[5] + " 입니다.");
		}
//		if (args[4].equals("현금")) {
//			System.out.println("현금영수증 처리 번호는 " + args[5] + " 입니다.");
//		}
	}

}