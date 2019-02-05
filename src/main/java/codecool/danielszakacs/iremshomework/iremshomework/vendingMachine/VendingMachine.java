package codecool.danielszakacs.iremshomework.iremshomework.vendingMachine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

import codecool.danielszakacs.iremshomework.iremshomework.products.Product;

public class VendingMachine {
	private List<Integer> listOfValidCoin = Arrays.asList(1, 5, 10, 25); 
	private Map<Product, Integer> listOfProduct = new HashMap();
	
	
	public void listOfCoinHandler(String userInput){
		List<String> userInputInList = Arrays.asList(userInput.split(","));
        List<Integer> listOfCoins = userInputInList.stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
	}
	
	
	public boolean checkCoinValid (List<Integer> listOfCoin) {
        AtomicBoolean result = new AtomicBoolean(true);
        listOfCoin.stream().forEach(t -> {
            if(!this.listOfValidCoin.contains(t)) {
                result.set(false);
            }
        });
        return result.get();
    }
	
	
	public int countRemainingChange(String productName, int coin) {
		int result = coin - this.listOfProduct.get(productName);
		return result;
	}
	
	

}
