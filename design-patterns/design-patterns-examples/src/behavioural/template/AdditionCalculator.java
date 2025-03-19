package behavioural.template;

public class AdditionCalculator extends CalculatorTemplate {

    @Override
    protected double doCalculate(double o1, double o2) {

        return o1 + o2;
    }
}
