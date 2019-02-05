package codecool.danielszakacs.iremshomework.iremshomework.vendingMachineTest;

import java.util.List;
import java.util.Arrays;

import codecool.danielszakacs.iremshomework.iremshomework.vendingMachine.VendingMachine;
import codecool.danielszakacs.iremshomework.iremshomework.vendingMachine.coinManager.CoinManager;
import junit.framework.TestCase;

public class VendingMachineTest extends TestCase{
	
	private CoinManager cm = new CoinManager();
	
	
	public void VendingMachine_checkCoinValid_returnFalse() {
		List listOfCoin = (List) Arrays.asList(10, 20, 50, 3);
		boolean result = this.cm.checkCoinValid(listOfCoin);
		assertFalse(result);
	}
	
	
	public void VendingMachine_countRemainingChange_willbe10() {
		assertEquals(10, this.cm.countRemainingChange("Coka", 15));
	}
	
	
	public void VendingMachine_checkIfCoinEnough_returnTrue() {
		assertFalse(this.cm.checkIfCoinEnough("Coka", 10));
	}
	

}
