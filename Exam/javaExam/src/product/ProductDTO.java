package product;

public class ProductDTO {
	int prdNo;
	String prdName;
	int prdPrice;
	int prdYear;
	String prdMaker;

	public String toString() {
		return prdNo + " " + prdName + " " + prdPrice + " " + prdYear + " " + prdMaker;
	}

	public ProductDTO(int prdNo, String prdName, int prdPrice, int prdYear, String prdMaker) {
		this.prdNo = prdNo;
		this.prdName = prdName;
		this.prdPrice = prdPrice;
		this.prdYear = prdYear;
		this.prdMaker = prdMaker;
	}

}
