package org.cdi.advocacy;

import java.math.BigDecimal;

import org.cdisource.beancontainer.BeanContainer;
import org.cdisource.beancontainer.BeanContainerManager;


public class AtmMain {

	static BeanContainer beanContainer =  BeanContainerManager.getInstance();

	public static void main(String[] args) throws Exception {
		
		// Get a bean through bean name
		AutomatedTellerMachine atm = (AutomatedTellerMachine) beanContainer
				.getBeanByName("atm");

		// Get a bean through bean type
		//AutomatedTellerMachine atm = beanContainer.getBeanByType(AutomatedTellerMachine.class);
		
		// Perform an operation
		atm.deposit(new BigDecimal("1.00"));

	}

}
