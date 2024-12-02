package Project_8;

import javax.swing.*;
import java.awt.*;


public class GridColorExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GridLayout 색상 예제");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        frame.setLayout(new GridLayout(4, 4));

        Color[] colors = {
            Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN,
            Color.CYAN, Color.BLUE, Color.MAGENTA, Color.PINK,
            Color.GRAY, Color.LIGHT_GRAY, Color.DARK_GRAY, Color.BLACK,
            Color.WHITE, new Color(255, 87, 51),
            new Color(155, 89, 182), 
            new Color(22, 160, 133)  
        };

        for (int i = 0; i < 16; i++) {
            JLabel label = new JLabel(String.valueOf(i + 1), SwingConstants.CENTER);
            label.setOpaque(true); 
            label.setBackground(colors[i]); 
            label.setForeground(Color.WHITE); 
            frame.add(label); 
        }

        frame.setVisible(true);
    }
}
