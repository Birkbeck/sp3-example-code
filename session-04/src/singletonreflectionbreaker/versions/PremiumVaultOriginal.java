package singletonreflectionbreaker.versions;

import singletonreflectionbreaker.PremiumVault;

public class PremiumVaultOriginal implements PremiumVault {
    private static PremiumVault instance;

    // Private constructor to prevent instantiation
    private PremiumVaultOriginal() {
        System.out.println("Vault Created! (Original)");
    }

    public static PremiumVault getInstance() {
        if (instance == null) {
            instance = new PremiumVaultOriginal();
        }
        return instance;
    }
}