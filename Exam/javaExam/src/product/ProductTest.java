package product;

import java.util.ArrayList;

public class ProductTest {

	public static void main(String[] args) {
		ArrayList<ProductDTO> list = new ArrayList<ProductDTO>();
		list.add(new ProductDTO(100, "노트북", 1200000, 2021, "삼성"));
		list.add(new ProductDTO(200, "아이패드", 500000, 2022, "애플"));
		list.add(new ProductDTO(200, "마우스", 15000, 2021, "LG"));

		System.out.println("상품번호 상품명 가격 제조년도 제조사");
		System.out.println("============================");
		for (ProductDTO dto : list) {
			System.out.println(dto);
		}
		System.out.println("============================");
	}

}
