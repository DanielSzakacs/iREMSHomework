package codecool.danielszakacs.iremshomework.iremshomework.productTest;

import junit.framework.TestCase;
import codecool.danielszakacs.iremshomework.iremshomework.products.Product;


public class ProductTest extends TestCase {
	

	public void isProduct_nameWillBe_Coke(){
        Product product = new Product("Coke", 32);
        assertTrue(product.getName().equals("Coke"));
    }

    public void isProduct_price_35() {
        Product product = new Product("Pepsi", 35);
        assertTrue(product.getPrice() == 35);
    }

}
