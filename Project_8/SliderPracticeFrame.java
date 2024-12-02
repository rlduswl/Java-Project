package Project_8;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SliderPracticeFrame extends JFrame {
    public SliderPracticeFrame() {
        setTitle("Slider Practice Frame");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JSlider slider = new JSlider(100, 200, 150);
        slider.setMajorTickSpacing(20); 
        slider.setMinorTickSpacing(5); 
        slider.setPaintTicks(true); 
        slider.setPaintLabels(true); 

        JLabel label = new JLabel("현재 값: " + slider.getValue());
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 16));

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = slider.getValue();
                label.setText("현재 값: " + value); 
            }
        });

        add(slider, BorderLayout.CENTER); 
        add(label, BorderLayout.SOUTH);  

        setVisible(true);
    }

    public static void main(String[] args) {
        new SliderPracticeFrame();
    }
}
