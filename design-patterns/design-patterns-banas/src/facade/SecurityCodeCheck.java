package facade;

public class SecurityCodeCheck {

    private final int securityCode = 1234;

    public int getSecurityCode() {
        return securityCode;
    }

    public boolean isCodeCorrect(int secCodeToCheck) {

        return secCodeToCheck == getSecurityCode();

    }

}
