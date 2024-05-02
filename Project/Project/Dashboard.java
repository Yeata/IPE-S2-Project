package Project;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Dashboard extends JFrame implements ButtonClickListener {

    private static JPanel dashboardPanel;

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

    @Override
    public void onDashboardButtonClick() {
        dashboardPanel.setVisible(true);
    }

    @Override
    public void onTaskButtonClick() {
        dashboardPanel.setVisible(false);
    }

    @Override
    public void onImportantButtonClick() {
        dashboardPanel.setVisible(false);
    }

    @Override
    public void onRemindersButtonClick() {
        dashboardPanel.setVisible(false);
    }

    @Override
    public void onSettingsButtonClick() {
        dashboardPanel.setVisible(false);
    }

    public static void setDashboardPanel(JPanel panel) {
        dashboardPanel = panel;
    }

}