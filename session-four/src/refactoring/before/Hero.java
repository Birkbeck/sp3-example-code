package refactoring.before;

/*
    This code is hard to maintain and violates the Open/Closed Principle—every time you add a weapon,
    you have to modify this class.
 */
public class Hero {

    public void attack(String weapon) {
        if (weapon.equals("Sword")) {
            System.out.println("Swinging the sword for 10 damage!");
        } else if (weapon.equals("Bow")) {
            System.out.println("Shooting an arrow for 8 damage!");
        } else if (weapon.equals("Magic Staff")) {
            System.out.println("Casting a fireball for 15 damage!");
        }
    }
}
