package codecool.danielszakacs.iremshomework.iremshomework.vendingMachine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


import codecool.danielszakacs.iremshomework.iremshomework.vendingMachine.coinManager.CoinManager;

public class VendingMachine {
//	private List<Integer> listOfValidCoin = Arrays.asList(1, 5, 10, 25); 
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
		String userinput = this.getUserInput("Please add your coin (For instance 10,25,1,5)");
		List<Integer> usrCoin = this.coinManager.createListOfInt(userinput);
		if(this.coinManager.checkCoinValid(usrCoin)) {
			int userSumCoinAmount = usrCoin.stream().mapToInt(t -> t.intValue()).sum();
			
			this.offerProducts();
			//this.coinManager.checkIfCoinEnough(productName, userSumCoinAmount); //TODO this is a boolean
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
		String userDecision = null; 
		String userInput = this.getUserInput("Please select a product.");
		
		if(!this.cancelOperation()) {
			this.finishOpperation();
		}
		else if(userInput.equalsIgnoreCase("0")) {
			userDecision = "Coka";
		}else if(userInput.equalsIgnoreCase("1")) {
			userDecision = "Pepsi";
		}else if(userInput.equalsIgnoreCase("2")) {
			userDecision = "Soda";
		}
		this.giveProductToUser(userDecision);
	}
	
	
	public void giveProductToUser(String productName) {
		try {
			this.listOfProduct.put(productName, this.listOfProduct.get(productName)-1);
			System.out.println("Here is your " + productName);
		}catch(NullPointerException e) {
			System.out.println("Sorry but your input is wrong, try it again ");
		}finally {
			this.finishOpperation();
		}
	}
	
	public void finishOpperation() {
		System.out.println("See you soon!");
	}

}
