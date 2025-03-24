package defaults;

import java.math.BigDecimal;

public interface BonusCalculator {
    BigDecimal getSalary();

    BigDecimal getBonusPercent();

    default BigDecimal getBonus() {
        return getSalary().multiply(getBonusPercent())
                .divide(new BigDecimal(100));
    }
}
