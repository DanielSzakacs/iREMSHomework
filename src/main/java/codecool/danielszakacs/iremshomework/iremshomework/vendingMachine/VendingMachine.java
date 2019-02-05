package codecool.danielszakacs.iremshomework.iremshomework.vendingMachine;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class VendingMachine {
	List<Integer> listOfValidCoin = Arrays.asList(1, 5, 10, 25); 
	
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
