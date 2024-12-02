package Project_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class MovableRectangles extends JPanel {
    private final ArrayList<Rectangle> rectangles = new ArrayList<>(); 
    private final ArrayList<Color> colors = new ArrayList<>();
    private Rectangle selectedRectangle = null; 
    private int offsetX, offsetY; 

    public MovableRectangles() {
        setFocusable(true);
        setBackground(Color.WHITE);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == 'm') {
                    Random random = new Random();
                    int x = random.nextInt(320);
                    int y = random.nextInt(320); 
                    rectangles.add(new Rectangle(x, y, 80, 80)); 
                    colors.add(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
                    repaint();
                }
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                for (int i = rectangles.size() - 1; i >= 0; i--) { 
                    Rectangle rect = rectangles.get(i);
                    if (rect.contains(e.getPoint())) {
                        selectedRectangle = rect;
                        offsetX = e.getX() - rect.x;
                        offsetY = e.getY() - rect.y;
                        break;
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                selectedRectangle = null; // 선택 해제
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (selectedRectangle != null) {
                    selectedRectangle.setLocation(e.getX() - offsetX, e.getY() - offsetY); 
                    repaint(); 
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < rectangles.size(); i++) {
            g.setColor(colors.get(i));
            Rectangle rect = rectangles.get(i);
            g.fillRect(rect.x, rect.y, rect.width, rect.height);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Movable Rectangles");
        MovableRectangles panel = new MovableRectangles();
        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        panel.requestFocusInWindow(); 
    }
}
