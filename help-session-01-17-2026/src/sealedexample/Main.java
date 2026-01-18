package sealedexample;

import java.util.List;

import static sealedexample.InsuranceProcessor.processClaim;

public class Main {
    public static void main(String[] args) {
        List<InsuranceProcessor.Claim> claims = List.of(
                new InsuranceProcessor.AutoClaim("A100", 25000.0, true),
                new InsuranceProcessor.HealthClaim("H500", List.of("X-Ray", "Consultation"), 500.0),
                new InsuranceProcessor.LifeClaim("L900", "Jane Doe", 45)
        );

        System.out.println("--- Insurance Claim Audit ---");
        claims.forEach(c -> System.out.println(processClaim(c)));
    }
}
