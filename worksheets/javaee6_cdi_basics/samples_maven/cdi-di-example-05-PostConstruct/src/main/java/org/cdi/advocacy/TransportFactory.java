package org.cdi.advocacy;

import javax.enterprise.inject.Produces;

public class TransportFactory {

    @Produces ATMTransport createTransport() {
        System.out.println("ATMTransport created with producer");
        return new StandardAtmTransport();
    }

}
	