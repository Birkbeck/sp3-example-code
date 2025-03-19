public class BoxDriver {
    public static void main(String[] args) {
        IntBox intBox = new IntBox(42);
        int x = intBox.getData();

        StrBox strBox = new StrBox("Hello");
        String s = strBox.getData();

        int y = (Integer) strBox.getData();
        intBox = strBox;
    }
}
