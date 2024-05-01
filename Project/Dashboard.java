package Project;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.time.LocalDate;
import java.time.YearMonth;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Dashboard extends JFrame implements ButtonClickListener {

    private static JPanel dashboardPanel;
    private static JLabel monthYearLabel;
    private static LocalDate currentDate = LocalDate.now(); // New variable to hold the current date


    public static JPanel DashboardPanel() {
        JPanel dashPanel = new JPanel(null) {
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

        JLabel task = new JLabel("<html><u>Upcoming Tasks</u></html>");
        Font font = new Font("Itim", Font.PLAIN, 22);
        task.setFont(font);
        task.setBounds(50, 50, 200, 30);
        dashPanel.add(task);

        Font font1  = new Font("Itim", Font.PLAIN, 16);

        JPanel calendar = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Paint p = new GradientPaint(0.0f, 0.0f, new Color(255, 255, 255, 155),
                                            getWidth(), getHeight(), new Color(255, 255, 255, 155), true);
                Graphics2D g2d = (Graphics2D) g;
                int cellWidth = getWidth() / 7;
                int cellHeight = getHeight() / 6;
                g2d.setPaint(p);
                int radius = 20;
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
                String[] daysOfWeek = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
                g2d.setFont(font1);
                g2d.setColor(Color.BLACK);
                for (int i = 0; i < daysOfWeek.length; i++) {
                    g2d.drawString(daysOfWeek[i], i * cellWidth + 15, cellHeight - 5);
                }
                g2d.setColor(Color.BLACK);
                g2d.setFont(font1);
                YearMonth currentYearMonth = YearMonth.from(currentDate); // get the current year and month from the currentDate variable
                int daysInMonth = currentYearMonth.lengthOfMonth();
                LocalDate firstOfMonth = currentYearMonth.atDay(1);
                int dayOfWeekStart = firstOfMonth.getDayOfWeek().getValue(); 
                for (int i = 1; i <= daysInMonth; i++) {
                    LocalDate date = firstOfMonth.plusDays(i - 1);
                    int x = (dayOfWeekStart + i - 2) % 7 * cellWidth + 20;
                    int y = (dayOfWeekStart + i - 2) / 7 * cellHeight + cellHeight + 25;
                    g2d.drawString(String.valueOf(i), x, y);
                }
            }
        };
        calendar.setBounds(700, 480, 420, 250);
        dashPanel.add(calendar);

        monthYearLabel = new JLabel();
        updateMonthYearLabel();
        monthYearLabel.setBounds(720, 480, 200, 20);
        monthYearLabel.setFont(font1);
        dashPanel.add(monthYearLabel);
        dashPanel.setComponentZOrder(monthYearLabel, 0);
        
        return dashPanel;
    }
    private static void updateMonthYearLabel() {
        YearMonth currentYearMonth = YearMonth.from(currentDate);
        String monthYearText = currentYearMonth.getMonth().toString() + " " + currentYearMonth.getYear();
        monthYearLabel.setText(monthYearText);
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