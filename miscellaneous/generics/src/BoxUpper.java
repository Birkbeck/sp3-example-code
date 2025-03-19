//We can rewrite copyFrom() so that it can take a box
//that contains data that is a subclass of E and
//store it to a Box<E> object

public class BoxUpper<E> {
    E data;

    public void copyFrom(Box<? extends E> b) {
        this.data = b.getData();
    }
}
