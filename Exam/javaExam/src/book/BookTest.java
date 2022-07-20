package book;

import java.util.Scanner;

public class BookTest {

	public static void main(String[] args) {
		BookDAO bookDAO = new BookDAO();
		BookDTO bookDTO = new BookDTO();

//		키보드입력
		Scanner sc = new Scanner(System.in);
		System.out.print("도서 번호 : ");
		bookDTO.setBookNo(sc.next());
		System.out.print("도서 제목 : ");
		bookDTO.setBookTitle(sc.next());
		System.out.print("저자 : ");
		bookDTO.setBookAuthor(sc.next());
		System.out.print("발행연도 : ");
		bookDTO.setBookYear(sc.next() + "-01-01");
		System.out.print("가격 : ");
		bookDTO.setBookPrice(sc.nextInt());
		System.out.print("출판사 : ");
		bookDTO.setBookPublisher(sc.next());

//		데이터직접 전달
//		bookDTO.setBookNo("B004");
//		bookDTO.setBookTitle("HTML/CSS");
//		bookDTO.setBookAuthor("고길동");
//		bookDTO.setBookYear("2021-01-01");
//		bookDTO.setBookPrice(38000);
//		bookDTO.setBookPublisher("서울출판사");

		bookDAO.insertBook(bookDTO);
		bookDAO.selectBook();
	}

}
