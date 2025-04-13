package immutable;

import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.Random;

class Officer implements Runnable {
    private MutableIDCard id;

    public Officer(MutableIDCard id) {
        this.id = id;
    }

    @Override
    public void run() {
        // sleep a bit, then (re)set this Officer's MutableIDCard with new ID
        var r = new Random();
        try {
            Thread.sleep(r.nextInt(2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String name = DataGenerator.getNextName();
        Date dateOfBirth = DataGenerator.getNextDate();
        BufferedImage photo = DataGenerator.getNextPhoto();
        // USES: setter of MutableIDCard
//      id.set(name, dateOfBirth, photo);
        id = new MutableIDCard(name, dateOfBirth, photo);
        System.out.println("OFFICER IS: " + this.id.getName());
    }
}
