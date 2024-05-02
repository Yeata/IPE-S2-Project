package Project;

// import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Important extends JFrame implements ButtonClickListener {

    private static JPanel ImportantPanel;

    public static JPanel ImportantPanel() {
        JPanel important = new JPanel(null) {
            protected void paintComponent(Graphics g) {
                Paint p = new GradientPaint(0.0f, 0.0f, new Color(255, 255, 255, 125),
                        getWidth(), getHeight(), new Color(255, 255, 255, 125), true);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setPaint(p);
                int radius = 20;
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
            }
        };
        important.setBounds(250, 0, 1200, 763);

        return important;
    }

    @Override
    public void onDashboardButtonClick() {
        ImportantPanel.setVisible(false);
    }

    @Override
    public void onTaskButtonClick() {
        ImportantPanel.setVisible(false);
    }

    @Override
    public void onImportantButtonClick() {
        ImportantPanel.setVisible(true);
    }

    @Override
    public void onRemindersButtonClick() {
        ImportantPanel.setVisible(false);
    }

    @Override
    public void onSettingsButtonClick() {
        ImportantPanel.setVisible(false);
    }

    public static void setImportantPanel(JPanel panel) {
        ImportantPanel = panel;
        // System.out.println("bbbbbbbbbbbbbbbb");
    }
}