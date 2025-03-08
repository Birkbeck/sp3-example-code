package org.cdi.advocacy;

import java.math.BigDecimal;

public interface AutomatedTellerMachine {

	public abstract void deposit(BigDecimal bd);
	public abstract void withdraw(BigDecimal bd);

}