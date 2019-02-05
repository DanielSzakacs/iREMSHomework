package codecool.danielszakacs.iremshomework.iremshomework.vendingMachine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

import codecool.danielszakacs.iremshomework.iremshomework.products.Product;
import codecool.danielszakacs.iremshomework.iremshomework.vendingMachine.coinManager.CoinManager;

public class VendingMachine {
//	private List<Integer> listOfValidCoin = Arrays.asList(1, 5, 10, 25); 
	private Map<String, Product> listOfProduct = new HashMap();
	private CoinManager coinManager = new CoinManager();
	
	public void runVendingMachine() {
		String userinput = this.getUserInput("Please add your coin (For instance 10,25,1,5)");
		List<Integer> usrCoin = this.createListOfInt(userinput);
		if(this.checkCoinValid(usrCoin)) {
			int userSumCoinAmount = usrCoin.stream().mapToInt(t -> t.intValue()).sum();
			String productName = "Coka";
			this.checkIfCoinEnough(productName, userSumCoinAmount); //TODO this is a boolean
		}
		
	}
	
	public String getUserInput(String output) {
		Scanner userInput = new Scanner(System.in);
		System.out.println(output);
		return userInput.next();
	}
//	
//	
//	public List<Integer> createListOfInt(String userInput){
//		List<String> userInputInList = Arrays.asList(userInput.split(","));
//        List<Integer> listOfCoins = userInputInList.stream()
//                .map(Integer::valueOf)
//                .collect(Collectors.toList());
//        return listOfCoins;
//	}
//	
//	
//	public boolean checkCoinValid (List<Integer> listOfCoin) {
//        AtomicBoolean result = new AtomicBoolean(true);
//        listOfCoin.stream().forEach(t -> {
//            if(!this.listOfValidCoin.contains(t)) {
//                result.set(false);
//            }
//        });
//        return result.get();
//    }
//	
//	
//	public int countRemainingChange(String productName, int coin) {
//		int result = coin - this.listOfProduct.get(productName).getPrice();
//		return result;
//	}
//	
//
//	
//	public boolean checkIfCoinEnough(String productName, int coin) {
//		if(coin >= this.listOfProduct.get(productName).getPrice()) {
//			int result = this.countRemainingChange(productName, coin);
//			System.out.println("Your Remaining change is " + result);
//			return true;
//		}else {
//			System.out.println("Please try again, not enought coin.");
//			return false;
//		}
//	}
	

}
