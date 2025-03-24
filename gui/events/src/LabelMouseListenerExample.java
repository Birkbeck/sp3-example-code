import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// Creating a label and handling mouse events
public class LabelMouseListenerExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Label Mouse Listener Example");
        JLabel label = new JLabel("Click me!");
        
        label.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Label clicked!");
            }
        });
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.getContentPane().add(label);
        frame.setVisible(true);
    }
}
