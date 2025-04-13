package immutable;

public class Main {
    public static void main(String... args) {
        var imData = new ImmutableData(4);
        var imData2 = new ImmutableData(3);
        if (imData.equals(imData2)) {
            System.out.println("equal");
        }
        System.out.println(imData);
    }
}
