package refactoring.after;

/* Approach:

    1. Create an interface called CombatStrategy.
    2.Create concrete classes for SwordAttack, BowAttack, and MagicAttack.
    3. Refactor the Hero class to use a CombatStrategy field instead of a String.
 */

// 1. The Interface
interface CombatStrategy {
    void executeAttack();
}

// 2. Concrete Strategies
class SwordAttack implements CombatStrategy {
    public void executeAttack() {
        System.out.println("Swinging the sword for 10 damage!");
    }
}

class BowAttack implements CombatStrategy {
    public void executeAttack() {
        System.out.println("Shooting an arrow for 8 damage!");
    }
}

// 3. The Refactored Context
public class Hero {
    private CombatStrategy strategy;

    public void setWeapon(CombatStrategy strategy) {
        this.strategy = strategy;
    }

    public void performAttack() {
        if (strategy == null) {
            System.out.println("The hero punches with bare fists!");
        } else {
            strategy.executeAttack();
        }
    }
}