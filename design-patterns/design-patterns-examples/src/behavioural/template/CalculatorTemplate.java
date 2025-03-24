package behavioural.template;

public abstract class CalculatorTemplate implements Calculator {
    private double result;
    private boolean initialized;

    @Override
    public final void calculate(double operand) {
        if (this.initialized) {
            this.result = this.doCalculate(this.result, operand);
        } else {
            this.result = operand;
            this.initialized = true;
        }
    }

    @Override
    public final double getResult() {
        return result; // throw exception if !initialized
    }

    protected abstract double doCalculate(double o1, double o2);
}