package Project_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class LabelMoveExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("C 클릭해서 움직이기");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        JLabel label = new JLabel("C");
        label.setBounds(150, 150, 20, 20); 
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label);

        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Random random = new Random();
                int x = random.nextInt(360); 
                int y = random.nextInt(360); 
                label.setLocation(x, y); 
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
