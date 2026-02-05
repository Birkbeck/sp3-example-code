package singletonreflectionbreaker.versions;

import singletonreflectionbreaker.PremiumVault;

public class PremiumVaultThrows implements PremiumVault{
    private static PremiumVault instance;

    // Private constructor to prevent instantiation
    private PremiumVaultThrows() {
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to create");
        }
    }

    public static PremiumVault getInstance() {
        if (instance == null) {
            instance = new PremiumVaultThrows();
        }
        return instance;
    }
}