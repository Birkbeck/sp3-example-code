import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

// Creating a checkbox and handling item events
public class CheckboxItemListenerExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Checkbox Item Listener Example");
        JCheckBox checkBox = new JCheckBox("Check me!");

        checkBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    JOptionPane.showMessageDialog(null, "Checkbox selected!");
                } else {
                    JOptionPane.showMessageDialog(null, "Checkbox deselected!");
                }
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.getContentPane().add(checkBox);
        frame.setVisible(true);
    }
}
