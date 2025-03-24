package structural.flyweight.drawing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawingClient extends JFrame {

    private static final long serialVersionUID = -1350200437285282550L;
    private static final ShapeType[] shapes = {ShapeType.LINE, ShapeType.OVAL_FILL, ShapeType.OVAL_NO_FILL};
    private static final Color[] colors = {Color.RED, Color.GREEN, Color.YELLOW};
    private final int WIDTH;
    private final int HEIGHT;

    public DrawingClient(int width, int height) {
        this.WIDTH = width;
        this.HEIGHT = height;
        Container contentPane = getContentPane();

        JButton startButton = new JButton("Draw");
        final JPanel panel = new JPanel();

        contentPane.add(panel, BorderLayout.CENTER);
        contentPane.add(startButton, BorderLayout.SOUTH);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        startButton.addActionListener(event -> {
            Graphics g = panel.getGraphics();
            for (int i = 0; i < 20; ++i) {
                Shape shape = ShapeFactory.getShape(getRandomShape());
                shape.draw(g, getRandomX(), getRandomY(), getRandomWidth(),
                    getRandomHeight(), getRandomColor());
            }
        });
    }

    public static void main(String[] args) {
        DrawingClient drawing = new DrawingClient(500, 600);
    }

    private ShapeType getRandomShape() {
        return shapes[(int) (Math.random() * shapes.length)];
    }

    private int getRandomX() {
        return (int) (Math.random() * WIDTH);
    }

    private int getRandomY() {
        return (int) (Math.random() * HEIGHT);
    }

    private int getRandomWidth() {
        return (int) (Math.random() * (WIDTH / 10.0));
    }

    private int getRandomHeight() {
        return (int) (Math.random() * (HEIGHT / 10.0));
    }

    private Color getRandomColor() {
        return colors[(int) (Math.random() * colors.length)];
    }
}