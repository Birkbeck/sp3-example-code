package immutable;

import immutable.MutableIDCard;

import java.util.Random;

public class Citizen implements Runnable {
    private MutableIDCard id;

    public Citizen(MutableIDCard id) {
        this.id = id;
    }

    @Override
    public void run() {
        // sleep a bit, then print this Citizen's MutableIDCard...
        // USES: MutableIDCard's getters.
        var r = new Random();
        try {
            Thread.sleep(r.nextInt(2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String message = "";
        message += "the name on this id is " + id.getName() + "\n";
        message += "and the date of birth is " + id.getDateOfBirth();
        System.out.println(message);
    }
}
