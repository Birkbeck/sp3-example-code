package decorator;

public class DecoratorGof {

    public static void main(String[] args) {
        System.out.println(
            new HealthInsuranceDecorator(
                new RegionalTaxDecorator(
                    new GeneralTaxDecorator(
                        new DefaultSalaryCalculator()
                    )
                )
            ).calculate(30000.00));
    }

    interface SalaryCalculator {
        double calculate(double grossAnnual);
    }

    public static class DefaultSalaryCalculator implements SalaryCalculator {

        @Override
        public double calculate(double grossAnnual) {
            return grossAnnual / 12;
        }
    }

    public static abstract class AbstractTaxDecorator implements SalaryCalculator {
        private final SalaryCalculator salaryCalculator;

        public AbstractTaxDecorator(SalaryCalculator salaryCalculator) {
            this.salaryCalculator = salaryCalculator;
        }

        protected abstract double applyTax(double salary);

        @Override
        public final double calculate(double grossAnnual) {
            double salary = salaryCalculator.calculate(grossAnnual);
            return applyTax(salary);
        }
    }

    public static class GeneralTaxDecorator extends AbstractTaxDecorator {
        public GeneralTaxDecorator(SalaryCalculator salaryCalculator) {
            super(salaryCalculator);
        }

        @Override
        protected double applyTax(double salary) {
            return Taxes.generalTax(salary);
        }
    }

    public static class RegionalTaxDecorator extends AbstractTaxDecorator {
        public RegionalTaxDecorator(SalaryCalculator salaryCalculator) {
            super(salaryCalculator);
        }

        @Override
        protected double applyTax(double salary) {
            return Taxes.regionalTax(salary);
        }
    }

    public static class HealthInsuranceDecorator extends AbstractTaxDecorator {
        public HealthInsuranceDecorator(SalaryCalculator salaryCalculator) {
            super(salaryCalculator);
        }

        @Override
        protected double applyTax(double salary) {
            return Taxes.healthInsurance(salary);
        }
    }
}
