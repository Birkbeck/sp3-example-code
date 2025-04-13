package proxy;

public class ATMMachine implements GetATMData, ATMState {
    private ATMState hasCard;
    private ATMState noCard;
    private ATMState hasCorrectPin;
    private ATMState atmOutOfMoney;
    private ATMState atmState;
    private int cashInMachine;

    public ATMState getYesCardState() {
        return hasCard;
    }

    public ATMState getNoCardState() {
        return noCard;
    }

    public ATMState getHasPin() {
        return hasCorrectPin;
    }

    public ATMState getNoCashState() {
        return atmOutOfMoney;
    }

    // NEW STUFF

    @Override
    public ATMState getATMState() {
        return atmState;
    }

    @Override
    public int getCashInMachine() {
        return cashInMachine;
    }

    @Override
    public void insertCard() {

    }

    @Override
    public void ejectCard() {

    }

    @Override
    public void insertPin(int pinEntered) {

    }

    @Override
    public void requestCash(int cashToWithdraw) {

    }
}