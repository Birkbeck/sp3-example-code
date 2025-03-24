package collections;

public class GtStudent extends Person {

    private final int year;
    private final Major major;

    public GtStudent(String aname, int ayear, Major amajor) {
        super(aname);
        year = ayear;
        major = amajor;
    }

    @Override
    public String toString() {
        return getName() + ", " + year + "-year " + major;
    }

    public enum Major {
        CS, CM, CMPE, EE, IE, ME, AE, ARCH, BME, STAC, MGT, EIA
    }
}
