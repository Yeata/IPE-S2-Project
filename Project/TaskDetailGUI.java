// package OOP;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class TaskDetailGUI extends JFrame {
    private JTextField taskNameField;
    private JTextField activityField;
    private JTextField startDateField;
    private JTextField endDateField;
    private JTextArea taskDescriptionArea;
    private JButton saveButton;

    public TaskDetailGUI() {
        
        setTitle("Task Detail");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);

        
        getContentPane().setBackground(new Color(229, 204, 255));

        
        taskNameField = new JTextField(20);
        activityField = new JTextField(20);
        startDateField = new JTextField(10);
        endDateField = new JTextField(10);
        taskDescriptionArea = new JTextArea(5, 20);
        saveButton = new JButton("Save");

        
        GridBagLayout layout = new GridBagLayout();
        getContentPane().setLayout(layout);

        
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 5, 5);

        
        constraints.gridx = 0;
        constraints.gridy = 0;
        getContentPane().add(new JLabel("Task Name:"), constraints);

        constraints.gridx = 1;
        getContentPane().add(taskNameField, constraints);

        constraints.gridy = 1;
        constraints.gridx = 0;
        getContentPane().add(new JLabel("Activity:"), constraints);

        constraints.gridx = 1;
        getContentPane().add(activityField, constraints);

        constraints.gridy = 2;
        constraints.gridx = 0;
        getContentPane().add(new JLabel("Start Date:"), constraints);

        constraints.gridx = 1;
        getContentPane().add(startDateField, constraints);

        constraints.gridy = 3;
        constraints.gridx = 0;
        getContentPane().add(new JLabel("End Date:"), constraints);

        constraints.gridx = 1;
        getContentPane().add(endDateField, constraints);

        constraints.gridy = 4;
        constraints.gridx = 0;
        constraints.gridwidth = 2;
        getContentPane().add(new JLabel("Task Description:"), constraints);

        constraints.gridy = 5;
        constraints.gridx = 0;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.BOTH;
        JScrollPane scrollPane = new JScrollPane(taskDescriptionArea);
        getContentPane().add(scrollPane, constraints);

        constraints.gridy = 6;
        constraints.gridx = 0;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.NONE;
        getContentPane().add(saveButton, constraints);

        
        Font font = new Font("Arial", Font.PLAIN, 12);
        taskNameField.setFont(font);
        activityField.setFont(font);
        startDateField.setFont(font);
        endDateField.setFont(font);
        taskDescriptionArea.setFont(font);
        saveButton.setFont(font);

        
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                
                JOptionPane.showMessageDialog(null, "Task saved!");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TaskDetailGUI taskDetailGUI = new TaskDetailGUI();
            taskDetailGUI.setVisible(true);
        });
    }
}