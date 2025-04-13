package state;

import java.util.Objects;

public class ATMMachine {

    ATMState hasCard;
    ATMState noCard;
    ATMState hasCorrectPin;
    ATMState atmOutOfMoney;

    ATMState atmState;

    int cashInMachine;
    boolean correctPinEntered;

    {
        correctPinEntered = false;
        cashInMachine = 2000;
        hasCard = new HasCard(this);
        noCard = new NoCard(this);
        hasCorrectPin = new HasPin(this);
        atmOutOfMoney = new NoCash(this);

        atmState = noCard;

    }

    public ATMMachine() {
        if (cashInMachine < 0) {
            atmState = atmOutOfMoney;
        }
    }

    void setATMState(ATMState newATMState) {

        atmState = newATMState;

    }

    public void insertCard() {

        atmState.insertCard();

    }

    public void ejectCard() {

        atmState.ejectCard();

    }

    public void requestCash(int cashToWithdraw) {

        atmState.requestCash(cashToWithdraw);

    }

    public void insertPin(int pinEntered) {

        atmState.insertPin(pinEntered);

    }

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

    public ATMState getHasCard() {
        return this.hasCard;
    }

    public void setHasCard(ATMState hasCard) {
        this.hasCard = hasCard;
    }

    public ATMState getNoCard() {
        return this.noCard;
    }

    public void setNoCard(ATMState noCard) {
        this.noCard = noCard;
    }

    public ATMState getHasCorrectPin() {
        return this.hasCorrectPin;
    }

    public void setHasCorrectPin(ATMState hasCorrectPin) {
        this.hasCorrectPin = hasCorrectPin;
    }

    public ATMState getAtmOutOfMoney() {
        return this.atmOutOfMoney;
    }

    public void setAtmOutOfMoney(ATMState atmOutOfMoney) {
        this.atmOutOfMoney = atmOutOfMoney;
    }

    public ATMState getAtmState() {
        return this.atmState;
    }

    public int getCashInMachine() {
        return this.cashInMachine;
    }

    public void setCashInMachine(int newCashInMachine) {

        cashInMachine = newCashInMachine;

    }

    public boolean isCorrectPinEntered() {
        return this.correctPinEntered;
    }

    public void setCorrectPinEntered(boolean correctPinEntered) {
        this.correctPinEntered = correctPinEntered;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof final ATMMachine other)) return false;
        if (!other.canEqual(this)) return false;
        final Object this$hasCard = this.getHasCard();
        final Object other$hasCard = other.getHasCard();
        if (!Objects.equals(this$hasCard, other$hasCard)) return false;
        final Object this$noCard = this.getNoCard();
        final Object other$noCard = other.getNoCard();
        if (!Objects.equals(this$noCard, other$noCard)) return false;
        final Object this$hasCorrectPin = this.getHasCorrectPin();
        final Object other$hasCorrectPin = other.getHasCorrectPin();
        if (!Objects.equals(this$hasCorrectPin, other$hasCorrectPin))
            return false;
        final Object this$atmOutOfMoney = this.getAtmOutOfMoney();
        final Object other$atmOutOfMoney = other.getAtmOutOfMoney();
        if (!Objects.equals(this$atmOutOfMoney, other$atmOutOfMoney))
            return false;
        final Object this$atmState = this.getAtmState();
        final Object other$atmState = other.getAtmState();
        if (!Objects.equals(this$atmState, other$atmState)) return false;
        if (this.getCashInMachine() != other.getCashInMachine()) return false;
        return this.isCorrectPinEntered() == other.isCorrectPinEntered();
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ATMMachine;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $hasCard = this.getHasCard();
        result = result * PRIME + ($hasCard == null ? 43 : $hasCard.hashCode());
        final Object $noCard = this.getNoCard();
        result = result * PRIME + ($noCard == null ? 43 : $noCard.hashCode());
        final Object $hasCorrectPin = this.getHasCorrectPin();
        result = result * PRIME + ($hasCorrectPin == null ? 43 : $hasCorrectPin.hashCode());
        final Object $atmOutOfMoney = this.getAtmOutOfMoney();
        result = result * PRIME + ($atmOutOfMoney == null ? 43 : $atmOutOfMoney.hashCode());
        final Object $atmState = this.getAtmState();
        result = result * PRIME + ($atmState == null ? 43 : $atmState.hashCode());
        result = result * PRIME + this.getCashInMachine();
        result = result * PRIME + (this.isCorrectPinEntered() ? 79 : 97);
        return result;
    }

    public String toString() {
        return "ATMMachine(hasCard=" + this.getHasCard() + ", noCard=" + this.getNoCard() + ", hasCorrectPin=" + this.getHasCorrectPin() + ", atmOutOfMoney=" + this.getAtmOutOfMoney() + ", atmState=" + this.getAtmState() + ", cashInMachine=" + this.getCashInMachine() + ", correctPinEntered=" + this.isCorrectPinEntered() + ")";
    }
}