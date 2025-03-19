package recursion;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import static recursion.Memoizer.callMemoized;

public class RodCutterMemoized extends RodCutterBasic {
    public RodCutterMemoized(final List<Integer> pricesForLength) {
        super(pricesForLength);
    }

    public static void main(final String[] args) {
        final RodCutterMemoized rodCutterMomoized
            = new RodCutterMemoized(RodCutterBasic.priceValues);
        //run(foo);

        System.out.println(rodCutterMomoized.maxProfit(5));
        System.out.println(rodCutterMomoized.maxProfit(22));
    }

    public int maxProfit(final int rodLength) {
        BiFunction<Function<Integer, Integer>, Integer, Integer> compute =
            (func, length) -> {
                int profit = (length <= prices.size()) ? prices.get(length - 1) : 0;
                for (int i = 1; i < length; i++) {
                    int priceWhenCut = func.apply(i) + func.apply(length - i);
                    if (profit < priceWhenCut) profit = priceWhenCut;
                }
                return profit;
            };
        return callMemoized(compute, rodLength);
    }
}
