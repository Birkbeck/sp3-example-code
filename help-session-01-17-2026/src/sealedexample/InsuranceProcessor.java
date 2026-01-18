package sealedexample;

import java.util.List;

/**
 * Combines Sealed Classes, Records, and Pattern Matching.
 * Scenario: Processing different types of insurance claims.
 */
public class InsuranceProcessor {

    // --- 1. THE SEALED HIERARCHY (The "Sum" Type) ---
    public sealed interface Claim permits AutoClaim, HealthClaim, LifeClaim {
    }

    // --- 2. THE RECORDS (The "Product" Types) ---
    // Record deconstruction is most powerful when records have clear components.
    public record AutoClaim(String policyId, double damageAmount, boolean isTotalLoss) implements Claim {
    }

    public record HealthClaim(String policyId, List<String> procedures, double deductible) implements Claim {
    }

    public record LifeClaim(String policyId, String beneficiary, int ageOfDeceased) implements Claim {
    }

    // --- 3. PROCESSING LOGIC (The "Pattern Matching") ---
    public static String processClaim(Claim claim) {
        return switch (claim) {
            // Nuance: Using 'when' for conditional business logic inside the switch
            case AutoClaim(var id, var amt, var total) when total ->
                    "Policy " + id + ": Total loss reported. Assigning specialized adjuster for amount: $" + amt;

            case AutoClaim(var id, var amt, var total) -> "Policy " + id + ": Standard repair claim for $" + amt;

            // Nuance: Deconstructing a List-holding record
            case HealthClaim(var id, List<String> items, var ded) ->
                    "Policy " + id + ": Processing " + items.size() + " medical procedures. Deductible: $" + ded;

            // Nuance: Nested logic and specific data extraction
            case LifeClaim(var id, var name, int age) -> {
                String priority = (age < 50) ? "URGENT" : "STANDARD";
                yield "[" + priority + "] Policy " + id + ": Beneficiary is " + name;
            }

            // Exhaustiveness check: No default needed!
            // If you add 'PetClaim' to 'permits' above, this block fails to compile.
        };
    }
}