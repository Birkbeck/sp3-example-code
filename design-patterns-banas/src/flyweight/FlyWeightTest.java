package flyweight;

// The Flyweight design pattern is used when you need to
// create a large number of similar objects

// To reduce memory this pattern shares Objects that are
// the same rather than creating new ones

import javax.swing.*;
import java.awt.*;
import java.io.Serial;
import java.util.Random;

public class FlyWeightTest extends JFrame {

    @Serial private static final long serialVersionUID = 1L;

    JButton startDrawing;

    int windowWidth = 1750;
    int windowHeight = 1000;

    // A new rectangle is created only if a new color is needed

    Color[] shapeColor = {Color.orange, Color.red, Color.yellow,
            Color.blue, Color.pink, Color.cyan, Color.magenta,
            Color.black, Color.gray};

    public FlyWeightTest() {

        // Create the frame, position it and handle closing it

        this.setSize(windowWidth, windowHeight);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Flyweight Test");

        final JPanel contentPane = new JPanel();

        contentPane.setLayout(new BorderLayout());

        final JPanel drawingPanel = new JPanel();

        startDrawing = new JButton("Button 1");

        contentPane.add(drawingPanel, BorderLayout.CENTER);

        contentPane.add(startDrawing, BorderLayout.SOUTH);

        startDrawing.addActionListener(event -> {
            final Graphics g = drawingPanel.getGraphics();


            final long startTime = System.currentTimeMillis();


            for (int i = 0; i < 100000; ++i) {

                //
                // Uses rectangles stored in the HashMap to
                // speed up the program

                final MyRect rect = RectFactory.getRect(getRandColor());
                rect.draw(g, getRandX(), getRandY(), getRandX(), getRandY());
            }

            final long endTime = System.currentTimeMillis();

            System.out.println("That took " + (endTime - startTime) + " milliseconds");

        });

        this.add(contentPane);

        this.setVisible(true);

    }

    public static void main(String[] args) {

        new FlyWeightTest();

    }

    // Picks random x & y coordinates

    private int getRandX() {
        return (int) (Math.random() * windowWidth);
    }

    private int getRandY() {
        return (int) (Math.random() * windowHeight);
    }

    // Picks a random Color from the 9 available

    private Color getRandColor() {
        final Random randomGenerator = new Random();

        final int randInt = randomGenerator.nextInt(9);

        return shapeColor[randInt];

    }

}