import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSlider;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

// Creating a slider and handling change events
public class SliderChangeListenerExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Slider Change Listener Example");
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);

        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int value = slider.getValue();
                JOptionPane.showMessageDialog(null, "Slider value: " + value);
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.getContentPane().add(slider);
        frame.setVisible(true);
    }
}
