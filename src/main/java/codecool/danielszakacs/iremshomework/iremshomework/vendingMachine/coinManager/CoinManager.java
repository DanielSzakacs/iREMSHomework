package codecool.danielszakacs.iremshomework.iremshomework.vendingMachine.coinManager;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;


public class CoinManager {
	
	private List<Integer> listOfValidCoin = Arrays.asList(1, 5, 10, 25); 
	
	
	public List<Integer> createListOfInt(String userInput) throws NumberFormatException{
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
	
	
	public int countRemainingChange(int productPrice, int coin) {
		int result = coin - productPrice;
		return result;
	}
	

	
	public boolean checkIfCoinEnough(int productPrice, int coin) {
		if(coin >= productPrice){
			int result = this.countRemainingChange(productPrice, coin);
			System.out.println("Your Remaining change is " + result);
			return true;
		}else {
			System.out.println("Please try again, not enought coin.");
			return false;
		}
	}
}
