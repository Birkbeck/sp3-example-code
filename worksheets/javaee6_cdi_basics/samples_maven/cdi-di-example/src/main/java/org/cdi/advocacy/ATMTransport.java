package org.cdi.advocacy;

public interface ATMTransport {
	public void communicateWithBank(byte[] datapacket);
	public void setRetries(int retries);
}
