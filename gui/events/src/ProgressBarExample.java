import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Creating a progress bar and updating its value
public class ProgressBarExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Progress Bar Example");
        JProgressBar progressBar = new JProgressBar();
        JButton startButton = new JButton("Start");

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startProgressBar(progressBar);
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.getContentPane().add(progressBar);
        frame.getContentPane().add(startButton);
        frame.setVisible(true);
    }

    public static void startProgressBar(final JProgressBar progressBar) {
        ActionListener actionListener = new ActionListener() {
            private int progress = 0;

            public void actionPerformed(ActionEvent e) {
                progress += 10;
                progressBar.setValue(progress);

                if (progress >= 100) {
                    ((Timer) e.getSource()).stop();
                }
            }
        };

        Timer timer = new Timer(1000, actionListener);
        timer.start();
    }
}
