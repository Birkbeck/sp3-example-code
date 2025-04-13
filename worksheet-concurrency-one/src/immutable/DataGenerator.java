package immutable;

import java.awt.image.BufferedImage;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class DataGenerator {

    private static final StringTokenizer names = new StringTokenizer("John,Mary,Lisa", ",");
    private static final StringTokenizer dates = new StringTokenizer("23/6/1971,12/3/1985,9/8/2002", ",");

    //============================
    //  get next ID elements - USED BY OFFICERS
    public synchronized static String getNextName() {
        if (names.hasMoreElements()) {
            return (String) names.nextElement();
        }
        return "Not a name";
    }

    public synchronized static Date getNextDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String txtDate = "1/1/1970";
        if (dates.hasMoreElements()) {
            txtDate = (String) dates.nextElement();
        }
        try {
            return dateFormat.parse(txtDate);
        } catch (ParseException e) {
            return new Date();
        }
    }

    public synchronized static BufferedImage getNextPhoto() {
        return new BufferedImage(30, 30, BufferedImage.TYPE_INT_RGB);
    }
}
