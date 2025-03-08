package org.cdi.advocacy;

import javax.enterprise.inject.Produces;

public class TransportFactory {

	private boolean useJSON = true;
	private boolean behindFireWall = true;

	// change from previous version
	@Produces
	ATMTransport createTransport() {
		// Look up config parameters in some config file or LDAP server or
		// database

		System.out
				.println("ATMTransport created with producer makes decisions");

		if (behindFireWall) {
			if (useJSON) {
				System.out.println("Created JSON transport");
				return new JsonRestAtmTransport();
			} else {
				System.out.println("Created SOAP transport");
				return new SoapAtmTransport();
			}
		} else {
			System.out.println("Created Standard transport");
			return new StandardAtmTransport();
		}
	}

}
