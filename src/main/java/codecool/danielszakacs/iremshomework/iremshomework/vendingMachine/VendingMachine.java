package codecool.danielszakacs.iremshomework.iremshomework.vendingMachine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


import codecool.danielszakacs.iremshomework.iremshomework.products.Product;
import codecool.danielszakacs.iremshomework.iremshomework.vendingMachine.coinManager.CoinManager;

public class VendingMachine {
//	private List<Integer> listOfValidCoin = Arrays.asList(1, 5, 10, 25); 
	private Map<String, Product> listOfProduct = new HashMap();
	private CoinManager coinManager = new CoinManager();
	
	public void runVendingMachine() {
		String userinput = this.getUserInput("Please add your coin (For instance 10,25,1,5)");
		List<Integer> usrCoin = this.coinManager.createListOfInt(userinput);
		if(this.coinManager.checkCoinValid(usrCoin)) {
			int userSumCoinAmount = usrCoin.stream().mapToInt(t -> t.intValue()).sum();
			String productName = "Coka";
			this.coinManager.checkIfCoinEnough(productName, userSumCoinAmount); //TODO this is a boolean
		}	
	}
	
	private String getUserInput(String output) {
		Scanner userInput = new Scanner(System.in);
		System.out.println(output);
		return userInput.next();
	}
	
	private boolean cancelOperation() {
		String text = "Are you sure you want to continue the operation? Press y ";
		if(this.getUserInput(text).equals("y")) {
			return true;
		}
		return false;
	}
	


}
