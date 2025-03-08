package org.cdi.advocacy;

import java.math.BigDecimal;

import javax.inject.Inject;
import javax.inject.Named;

@Named("atm")
public class AutomatedTellerMachineImpl implements AutomatedTellerMachine {
	
	@Inject
	private ATMTransport transport;
	
	public void deposit(BigDecimal bd) {
		System.out.println("deposit called");	
		transport.communicateWithBank(null);
	}

	public void withdraw(BigDecimal bd) {
		System.out.println("withdraw called");
		transport.communicateWithBank(null);
	}

}
