package org.cdi.advocacy;

import javax.enterprise.inject.Alternative;


@Alternative
public class SoapAtmTransport implements ATMTransport {
	
	public void communicateWithBank(byte[] datapacket) {
		System.out.println("communicating with bank via Soap transport");
	}

}
