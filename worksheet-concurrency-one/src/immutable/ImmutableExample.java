package immutable;

import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.Random;


class MutableIDCard {

    // BUT COULD ALSO MAKE THESE FINAL
    private String name;
    private Date dateOfBirth;
    private BufferedImage photo;

    //	AND COULD MAKE DEFENSIVE COPIES HERE
    public MutableIDCard(String name, Date dateOfBirth, BufferedImage photo) {
        //E.G....        this.name = new String(name);
        this.name = name;

        this.dateOfBirth = dateOfBirth;
        this.photo = photo;
    }

    //  setter - USED BY OFFICERS
    public void set(String name, Date dateOfBirth, BufferedImage photo) {
        check(name, dateOfBirth, photo);
        synchronized (this) {
            this.name = name;
            this.dateOfBirth = dateOfBirth;
            this.photo = photo;
        }
    }

    //============================
    // getters  - USED BY CITIZENS
    public synchronized String getName() {
        // and could defensive copy e.g. return new String(name);
        return name;
    }

    public synchronized Date getDateOfBirth() {
        return dateOfBirth;
    }

    public synchronized BufferedImage getPhoto() {
        return photo;
    }
    //============================

    // check everything valid
    public void check(String name, Date dateOfBirth, BufferedImage photo) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException();
        }
        if (dateOfBirth == null) {
            throw new IllegalArgumentException();
        }
        long age = getAge(dateOfBirth);
        if (dateOfBirth == null || age <= 0) {
            throw new IllegalArgumentException();
        }
        if (photo == null) {
            throw new IllegalArgumentException();
        }
    }

    // make age
    private long getAge(Date dateOfBirth) {
        long now = new Date().getTime();
        long age = now - dateOfBirth.getTime();
        return age;
    }
}


