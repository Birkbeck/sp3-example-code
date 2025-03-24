import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Adding an action listener to a button
public class ButtonClickListenerExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Button Click Listener Example");
        JButton button = new JButton("Click me!");

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Button clicked!");
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.getContentPane().add(button);
        frame.setVisible(true);
    }
}
