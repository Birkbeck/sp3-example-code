package org.cdi.advocacy;

//@Transport(type=TransportType.STANDARD, priorityLevel=1, name="super")
//@SuperFast @StandardFrameRelaySwitchingFlubber 
public class SuperFastAtmTransport implements ATMTransport {
	//private int retries=0;

	public void setRetries(int retries) {
		//this.retries=retries;
	}


	public void communicateWithBank(byte[] datapacket) {
		System.out.println("communicating with bank via the Super Fast transport " );
	}

}
