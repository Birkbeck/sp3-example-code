package proxy;

// This interface will contain just those methods
// that you want the proxy to provide access to

public interface GetATMData {
    ATMState getATMState();

    int getCashInMachine();
}