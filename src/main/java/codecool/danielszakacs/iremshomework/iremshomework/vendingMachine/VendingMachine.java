package codecool.danielszakacs.iremshomework.iremshomework.vendingMachine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


import codecool.danielszakacs.iremshomework.iremshomework.vendingMachine.coinManager.CoinManager;

public class VendingMachine {
	private Map<String, Integer> listOfProduct = new HashMap<String, Integer>(){
		{
			put("Coke", 20);
			put("Pepsi", 20);
			put("Soda", 20);
		}
	};
	
	//TODO only for test methods
	private Map<String, Integer> listOfProductPrice = new HashMap<String, Integer>() {
		{
			put("Coke", 25);
			put("Pepsi", 35);
			put("Soda", 45);
		}
	};
			
	private CoinManager coinManager = new CoinManager();
	
	
	public Map<String, Integer> getListOfProduct(){
		return this.listOfProduct;
	}
	
	
	public Map<String, Integer> getListOfProductPrice(){
		return this.listOfProductPrice;
	}
	
	
	public void runVendingMachine() {
		String userinput = this.getUserInput("Please add your coin (For instance 1,5,10,25)");
		List<Integer> usrCoin = this.coinManager.createListOfInt(userinput);
		if(this.coinManager.checkCoinValid(usrCoin)) {
			int userSumCoinAmount = usrCoin.stream().mapToInt(t -> t.intValue()).sum();
			this.offerProducts(userSumCoinAmount);
		}else {
			System.out.println("Sorry but you don't have enough coin");
			this.finishOpperation();
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
	
	
	public void offerProducts(int usercoin) {
		System.out.println("Please select a product");
		int counter = 0;
		for(String productName: this.listOfProduct.keySet()) {
			System.out.println(productName + "  press: (" + counter + ")");
			counter++;
		}
		this.manageUserOrder(usercoin);
	}
	
	
	public void manageUserOrder(int usercoin){
		String userDecision = null; 
		String userInput = this.getUserInput("Please select a product.");
		
		if(!this.cancelOperation()) {
			this.finishOpperation();
		}
		else if(userInput.equalsIgnoreCase("0")) {
			userDecision = "Coke";
		}else if(userInput.equalsIgnoreCase("1")) {
			userDecision = "Pepsi";
		}else if(userInput.equalsIgnoreCase("2")) {
			userDecision = "Soda";
		}
		try {
			if(this.coinManager.checkIfCoinEnough(this.listOfProductPrice.get(userDecision), usercoin)) {
				this.giveProductToUser(userDecision);
			}
		}catch(NullPointerException e) {
			System.out.println("Sorry but your input is wrong, try it again ");
			this.finishOpperation();
		}
	}
	
	
	public void giveProductToUser(String productName) {
		this.listOfProduct.put(productName, this.listOfProduct.get(productName)-1);
		System.out.println("Here is your " + productName);	
	}
	
	
	public void finishOpperation() {
		System.out.println("See you soon!");
	}

}
