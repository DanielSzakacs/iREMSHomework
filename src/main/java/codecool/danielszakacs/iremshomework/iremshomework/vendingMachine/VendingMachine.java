package codecool.danielszakacs.iremshomework.iremshomework.vendingMachine;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class VendingMachine {
	private List<Integer> listOfValidCoin = Arrays.asList(1, 5, 10, 25); 
	
	
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
	
	

}
