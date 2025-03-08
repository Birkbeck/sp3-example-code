package org.cdi.advocacy;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;
//import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.inject.Named;

@Named("atm")
public class AutomatedTellerMachineImpl implements AutomatedTellerMachine {
	
	@Inject  
	private Instance<ATMTransport> allTransports;

	@PostConstruct
	protected void init() {
		System.out.println("Is this ambigous? " + allTransports.isAmbiguous() );
		System.out.println("Is this unsatisfied? " + allTransports.isUnsatisfied() );
	}
	
	public void deposit(BigDecimal bd) {
		System.out.println("deposit called");
		
		for (ATMTransport transport : this.allTransports) {
			transport.communicateWithBank(null);
		}
		
	}

	public void withdraw(BigDecimal bd) {
		System.out.println("withdraw called");

		for (ATMTransport transport : this.allTransports) {
			transport.communicateWithBank(null);
		}

	}

}
