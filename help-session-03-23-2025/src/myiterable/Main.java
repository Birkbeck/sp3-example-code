package myiterable;

public class Main {
    public static void main(String[] args) {
        MyCollection<String> myCollection = new MyCollection<>();

        for (var item : myCollection) {
            System.out.println(item);
        }
    }
}
