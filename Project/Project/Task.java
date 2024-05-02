package Project;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Task extends JFrame implements ButtonClickListener {

    private static JPanel taskPanel;

    public Task() {
        setTitle("Task");
        // Set the title of the JFrame to "Task"
    }

    public static JPanel createTaskPanel() {
        if (taskPanel == null) {
            taskPanel = new JPanel() {
                protected void paintComponent(Graphics g) {
                    Paint T = new GradientPaint(0.0f, 0.0f, new Color(255, 255, 255, 125),
                            getWidth(), getHeight(), new Color(255, 255, 255, 125), true);
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setPaint(T);
                    int radius = 20;
                    g2d.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
                }
            };
            taskPanel.setLayout(null);
            taskPanel.setBounds(250, 0, 500, 763);

            Font font = new Font("Itim", Font.PLAIN, 30);

            JLabel task = new JLabel("Task");
            task.setFont(font);
            task.setBounds(225, 40, 100, 50);
            task.setForeground(Color.black);
            taskPanel.add(task);

            ImageIcon arrowIcon = new ImageIcon("D:/I352/IPE/Task/IPE-S2-Project/Project/assets/icons8-arrow-right-30.png");

            // Add JButton for "Task Creation" button
            JButton taskCreationButton = new JButton("Task Creation");
            taskCreationButton.setBounds(50, 150, 300, 40);
            customizeButton(taskCreationButton, arrowIcon);
            taskCreationButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Task Creation button clicked");
                    // Add your task creation logic here
                }
            });
            taskPanel.add(taskCreationButton);

            // Add JButton for "Task Details" button
            JButton taskDetailsButton = new JButton("Task details");
            taskDetailsButton.setBounds(50, 240, 300, 40);
            customizeButton(taskDetailsButton, arrowIcon);
            taskDetailsButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Task Details button clicked");
                    // Add your task details logic here
                }
            });
            taskPanel.add(taskDetailsButton);

            // Add JButton for "Drag and Drop Function" button
            JButton dragAndDropButton = new JButton("Drag and Drop Function");
            dragAndDropButton.setBounds(50, 330, 300, 40);
            customizeButton(dragAndDropButton, arrowIcon);
            dragAndDropButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Task drag button clicked");
                    // Add your task drag and drop logic here
                }
            });
            taskPanel.add(dragAndDropButton);

        }
        return taskPanel;
    }

    private static void customizeButton(JButton button, ImageIcon icon) {
        button.setBackground(new Color(255, 255, 255)); // Set background color
        button.setForeground(new Color(0, 0, 0)); // Set text color
        button.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 0)); // Set border
        button.setFocusPainted(false); // Remove focus border
        button.setIcon(icon); // Set icon
        button.setHorizontalAlignment(SwingConstants.LEFT); // Align text to the left
    }

    @Override
    public void onDashboardButtonClick() {
        taskPanel.setVisible(false);
    }

    @Override
    public void onTaskButtonClick() {
        taskPanel.setVisible(true);
    }

    @Override
    public void onImportantButtonClick() {
        taskPanel.setVisible(false);
    }

    @Override
    public void onRemindersButtonClick() {
        taskPanel.setVisible(false);
    }

    @Override
    public void onSettingsButtonClick() {
        taskPanel.setVisible(false);
    }

    public static void setTaskPanel(JPanel panel) {
        taskPanel = panel;
    }
}
