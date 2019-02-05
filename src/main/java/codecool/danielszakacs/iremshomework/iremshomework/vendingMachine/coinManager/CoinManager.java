package codecool.danielszakacs.iremshomework.iremshomework.vendingMachine.coinManager;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

import codecool.danielszakacs.iremshomework.iremshomework.products.Product;

public class CoinManager {
	
	private List<Integer> listOfValidCoin = Arrays.asList(1, 5, 10, 25); 
	
	
	public List<Integer> createListOfInt(String userInput){
		List<String> userInputInList = Arrays.asList(userInput.split(","));
        List<Integer> listOfCoins = userInputInList.stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        return listOfCoins;
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
	
	
	public int countRemainingChange(Product product, int coin) {
		int result = coin - product.getPrice();
		return result;
	}
	

	
	public boolean checkIfCoinEnough(Product product, int coin) {
		if(coin >= product.getPrice()) {
			int result = this.countRemainingChange(product, coin);
			System.out.println("Your Remaining change is " + result);
			return true;
		}else {
			System.out.println("Please try again, not enought coin.");
			return false;
		}
	}
}
