package structural.decorator.decoratoralt;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipOutputStream;

public class Example {
    public static void main(String[] args) throws Exception {
        OutputStream out = Files.newOutputStream(Paths.get("somefile"));
        out = new BufferedOutputStream(out); // buffer before writing
        out = new CipherOutputStream(out,        // encrypt all data
            Cipher.getInstance("DES/CBC/PKCS5Padding"));
        out = new ZipOutputStream(out);      // compress all data


        final ByteCounterOutputStream bout = new ByteCounterOutputStream(out);
//        for (int b = in.read(); b != -1; b = in.read()) {
//            bout.write(b);
//        }
        System.out.println("Written " + bout.getCounter() + " bytes");

    }
}
