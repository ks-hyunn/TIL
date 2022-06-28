package chap4;

public class ProductData {
	private int code;
	private String name;
	private double price;
	private int amount;
	private String memo;

	public int getCode() {
		return code * 10;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
}

class MemberData {
	String id;
	private int password;
	String name;
	private String address;
	private String phone;

	void changepassword(int newPassword) {
		password = newPassword;
	}
}
