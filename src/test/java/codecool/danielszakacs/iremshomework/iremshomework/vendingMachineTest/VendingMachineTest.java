package codecool.danielszakacs.iremshomework.iremshomework.vendingMachineTest;

import java.util.List;
import java.util.Arrays;

import codecool.danielszakacs.iremshomework.iremshomework.vendingMachine.VendingMachine;
import junit.framework.TestCase;

public class VendingMachineTest extends TestCase{
	private VendingMachine vm = new VendingMachine();
	
	public void VendingMachine_checkCoinValid_returnFalse() {
		List listOfCoin = (List) Arrays.asList(10, 20, 50, 3);
		boolean result = this.vm.checkCoinValid(listOfCoin);
		assertFalse(result);
	}
	
	public void VendingMachine_countRemainingChange_willbe10() {
		assertEquals(10, this.vm.countRemainingChange("Coka", 15));
	}
	

}
