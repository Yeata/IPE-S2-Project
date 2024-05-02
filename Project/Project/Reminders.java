package Project;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Reminders extends JFrame implements ButtonClickListener {

    private static JPanel ReminderPanel;

    public static JPanel ReminderPanel() {
        JPanel reminderPanel = new JPanel(null) {
            protected void paintComponent(Graphics g) {
                Paint p = new GradientPaint(0.0f, 0.0f, new Color(255, 255, 255, 125),
                        getWidth(), getHeight(), new Color(255, 255, 255, 125), true);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setPaint(p);
                int radius = 20;
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
            }
        };
        reminderPanel.setBounds(250, 0, 1200, 763);

        return reminderPanel;
    }

    @Override
    public void onDashboardButtonClick() {
        ReminderPanel.setVisible(false);
    }

    @Override
    public void onTaskButtonClick() {
        ReminderPanel.setVisible(false);
    }

    @Override
    public void onImportantButtonClick() {
        ReminderPanel.setVisible(false);
    }

    @Override
    public void onRemindersButtonClick() {
        ReminderPanel.setVisible(true);
    }

    @Override
    public void onSettingsButtonClick() {
        ReminderPanel.setVisible(false);
    }

    public static void setReminderPanel(JPanel panel) {
        ReminderPanel = panel;
    }
}