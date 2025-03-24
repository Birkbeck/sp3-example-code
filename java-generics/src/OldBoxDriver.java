public class OldBoxDriver {
    public static void main(String[] args) {
        OldBox intBox = new OldBox(42);
        int x = (Integer) intBox.getData();

        OldBox strBox = new OldBox("Hello");
        String s = (String) strBox.getData();

        int y = (Integer) strBox.getData();
        intBox = strBox;
    }
}
