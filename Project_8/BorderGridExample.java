package Project_8;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class BorderGridExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Border and Grid Layout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        frame.setLayout(new BorderLayout());

        JPanel westPanel = new JPanel();
        westPanel.setLayout(new GridLayout(8, 1, 0, 5));
        westPanel.setPreferredSize(new Dimension(50, 0)); 
        Color[] colors = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE, Color.MAGENTA, Color.GRAY};
        for (Color color : colors) {
            JPanel colorBox = new JPanel();
            colorBox.setBackground(color);
            westPanel.add(colorBox);
        }
        frame.add(westPanel, BorderLayout.WEST);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(null); 
        centerPanel.setBackground(Color.WHITE);

        Random random = new Random();
        for (int i = 0; i < 9; i++) {
            JLabel label = new JLabel(String.valueOf(i), SwingConstants.CENTER);
            label.setBounds(random.nextInt(300), random.nextInt(300), 20, 20);
            label.setFont(new Font("Arial", Font.PLAIN, 14));
            centerPanel.add(label);
        }
        frame.add(centerPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
