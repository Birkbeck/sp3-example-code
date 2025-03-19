import javax.swing.JButton;
import javax.swing.JFrame;

// Creating a basic window with a button
public class BasicWindowExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Basic Window Example");
        JButton button = new JButton("Click me!");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.getContentPane().add(button);
        frame.setVisible(true);
    }
}
    