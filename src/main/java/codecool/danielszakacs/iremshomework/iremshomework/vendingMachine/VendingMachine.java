package codecool.danielszakacs.iremshomework.iremshomework.vendingMachine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


import codecool.danielszakacs.iremshomework.iremshomework.vendingMachine.coinManager.CoinManager;

public class VendingMachine {
//	private List<Integer> listOfValidCoin = Arrays.asList(1, 5, 10, 25); 
	private Map<String, Integer> listOfProduct = new HashMap();
	private Map<String, Integer> listOfProductPrice = new HashMap();
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
	
	public String getUserInput(String output) {
		Scanner userInput = new Scanner(System.in);
		System.out.println(output);
		return userInput.next();
	}
	
	public boolean cancelOperation() {
		String text = "Are you sure you want to continue the operation? Press y ";
		if(this.getUserInput(text).equalsIgnoreCase("y")) {
			return true;
		}
		return false;
	}
	
	public void offerProducts() {
		System.out.println("Please select a product");
		int counter = 0;
		for(String productName: this.listOfProduct.keySet()) {
			System.out.println(productName + "  press: (" + counter + ")");
			counter++;
		}
		this.manageUserOrder();
	}
	
	public void manageUserOrder(){
		String userDecision; 
		String userInput = this.getUserInput("Please select a product. Or cancel with 'c' ");
		if(userInput.equalsIgnoreCase("c")){
			this.cancelOperation(); // TODO returnning a boolean 
		}
		else if(userInput.equalsIgnoreCase("0")) {
			userDecision = "Coka";
		}else if(userInput.equalsIgnoreCase("1")) {
			userDecision = "Pepsi";
		}else if(userInput.equalsIgnoreCase("2")) {
			userDecision = "Soda";
		}
		if(this.cancelOperation()){
			
		}
	}
	
	public void finishOpperation() {
		System.out.println("See you soon!");
	}
	
	public void giveProductToUser(String productName) {
		this.listOfProduct.put(productName, this.listOfProduct.get(productName)-1);
		System.out.println("Here is your " + productName);
	}

}
