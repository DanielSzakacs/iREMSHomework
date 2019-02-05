package codecool.danielszakacs.iremshomework.iremshomework.products;

public class Product {
	private int price;
	private String name;
	
	public Product(String name, int price) {
		this.name = name; 
		this.price = price; 
	}

	public String getName() {
		return this.name;
	}
	
	public int getPrice() {
		return this.price;
	}
}
