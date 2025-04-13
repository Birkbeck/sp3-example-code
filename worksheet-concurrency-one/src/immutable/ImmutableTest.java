package immutable;

import java.awt.image.BufferedImage;
import java.util.Date;

public class ImmutableTest {
    public static void main(String[] args) {
        String name = DataGenerator.getNextName();
        Date dateOfBirth = DataGenerator.getNextDate();
        BufferedImage photo = DataGenerator.getNextPhoto();

        MutableIDCard id = new MutableIDCard(name, dateOfBirth, photo);

        //make an officer and a citizen with the same ID (John)?
        Runnable officer = new Officer(id);

        // HOW TO MAKE CITIZEN'S ID FINAL (but not officer's)
        // ..... make all IDs final, just make a new one for the officer when needed
        Runnable citizen = new Citizen(id);

        //change officer's details
        Thread t1 = new Thread(officer);
        //print citizen's details
        Thread t2 = new Thread(citizen);
        // but only one ID so does citizen change to Mary?
        t1.start();
        t2.start();
    }
}
