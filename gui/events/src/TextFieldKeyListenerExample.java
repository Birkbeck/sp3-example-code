import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// Creating a text field and handling key events
public class TextFieldKeyListenerExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Text Field Key Listener Example");
        JTextField textField = new JTextField();

        textField.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
            }

            public void keyPressed(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
                JOptionPane.showMessageDialog(null, "Key released: " + e.getKeyChar());
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.getContentPane().add(textField);
        frame.setVisible(true);
    }
}
