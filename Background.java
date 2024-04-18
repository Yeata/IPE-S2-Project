import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Background extends Component {
    public static JPanel BackgroundPanel() {
        JPanel background = new JPanel() {
            protected void paintComponent(Graphics g) {
                Paint p = new GradientPaint(0.0f, -100.0f, new Color(158, 160, 210, 155),
                        0.0f, getHeight(), new Color(176, 107, 209, 155), true);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setPaint(p);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        background.setBounds(0, 0, 1400, 800);
        return background;
    }

    public static JPanel DashboardPanel() {
        JPanel dashPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                Paint p = new GradientPaint(0.0f, 0.0f, new Color(255, 255, 255, 125), 
                       getWidth(), getHeight(), new Color(255, 255, 255, 125), true);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setPaint(p);
                int radius = 20; 
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
            }
        };
        dashPanel.setBounds(250, 0, 1200, 763);
        return dashPanel;
    }

    public static void main(String args[]) {
        JFrame frame = new JFrame();
        JPanel background = BackgroundPanel();
        JPanel dashboard = DashboardPanel();

        frame.setSize(1400, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(dashboard);
        frame.add(background);
    }
}
