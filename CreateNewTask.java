import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class CreateNewTask {
    private static JFrame f1;
    private static JFrame f2;
    private static DefaultTableModel model;
    private static JTable table;

    private static Border createRoundedBorder(int radius) {
        return BorderFactory.createEmptyBorder(radius, radius, radius, radius);
    }

    public static void main(String[] args) {
        Task_List();
    }

    public static void Task_List() {
        f1 = new JFrame("Task List");
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("Task List");
        title.setBounds(15, 15, 200, 50);
        title.setFont(new Font("Itim", Font.BOLD, 23));
        f1.add(title);

        JButton btn = new JButton("Create New Task");
        btn.setBounds(500, 18, 158, 47);
        btn.setPreferredSize(new Dimension(150, 40));
        btn.setBackground(new Color(139, 148, 252));
        btn.setFocusPainted(false);
        btn.setBorder(createRoundedBorder(30));
        f1.add(btn);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Create_New_Task();
                f1.setVisible(false);
            }
        });

        model = new DefaultTableModel();
        model.addColumn("Title");
        model.addColumn("Assignee");
        model.addColumn("Deadline");
        model.addColumn("Description");

        model.addRow(new Object[] { "Task", "Yung Nita", "06/01/2024 23:59", "Create tasklist" });
        model.addRow(new Object[] { "Dashboard", "Yon Samphorslita", "06/01/2024 23:59", "Create Dashborad" });
        model.addRow(new Object[] { "Task", "Yous Yeata", "06/01/2024 23:59", "Task Drag and drop" });
        model.addRow(new Object[] { "Dasboard", "Thorn SreyNeth", "06/01/2024 23:59", "Create Dashoard" });
        model.addRow(new Object[] { "Task", "Sounngy Hanny", "06/01/2024 23:59", "Create task detail" });

        table = new JTable(model);

        table.getTableHeader().setFont(new Font("Itim", Font.PLAIN, 13));
        table.getTableHeader().setPreferredSize(new Dimension(table.getColumnModel().getTotalColumnWidth(), 35));
        table.setRowHeight(40);

        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            private static final long serialVersionUID = 1L;

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
                Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
                        column);
                if (row % 2 == 0) {
                    component.setBackground(new Color(172, 179, 250));
                } else {
                    component.setBackground(new Color(227, 229, 250));
                }
                return component;
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(-5, 100, 690, 700);
        scrollPane.setBorder(createRoundedBorder(30));
        f1.add(scrollPane);

        f1.setSize(700, 900);
        f1.setLayout(null);
        f1.setVisible(true);
        f1.setResizable(false);
    }

    public static void Create_New_Task() {
        f2 = new JFrame("Create New Task");
        f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel createNewTask = new JLabel("Create New Task");
        createNewTask.setBounds(20, 10, 300, 50);
        createNewTask.setFont(new Font("Itim", Font.BOLD, 23));
        f2.add(createNewTask);

        JLabel titleLabel = new JLabel("Title:");
        titleLabel.setBounds(35, 80, 100, 45);
        f2.add(titleLabel);

        JLabel assigneeLabel = new JLabel("Assignee:");
        assigneeLabel.setBounds(35, 190, 100, 50);
        f2.add(assigneeLabel);

        JLabel deadlineLabel = new JLabel("Deadline:");
        deadlineLabel.setBounds(35, 300, 100, 50);
        f2.add(deadlineLabel);

        JLabel descriptionLabel = new JLabel("Description:");
        descriptionLabel.setBounds(35, 520, 100, 50);
        f2.add(descriptionLabel);

        JTextField titleField = new JTextField(15);
        titleField.setBounds(35, 120, 390, 50);
        titleField.setBorder(createRoundedBorder(20));
        f2.add(titleField);

        JTextField assigneeField = new JTextField();
        assigneeField.setBounds(35, 230, 390, 50);
        assigneeField.setBorder(createRoundedBorder(20));
        f2.add(assigneeField);

        JDateChooser deadlineField = new JDateChooser();
        deadlineField.setBounds(90, 335, 350, 90);
        deadlineField.setBorder(createRoundedBorder(20));
        f2.add(deadlineField);

        JLabel dateLabel = new JLabel("Date:");
        dateLabel.setBounds(65, 355, 100, 45);
        f2.add(dateLabel);

        SpinnerDateModel spinnerModel = new SpinnerDateModel();
        spinnerModel.setCalendarField(Calendar.MINUTE);
        JSpinner timeSpinner = new JSpinner(spinnerModel);

        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm");
        timeSpinner.setEditor(timeEditor);

        JLabel timeLabel = new JLabel("Time:");
        timeLabel.setBounds(65, 450, 100, 45);
        f2.add(timeLabel);

        timeSpinner.setBounds(90, 430, 95, 80);
        timeSpinner.setBorder(createRoundedBorder(20));
        f2.add(timeSpinner);

        JTextField descriptionField = new JTextField();
        descriptionField.setBounds(35, 560, 390, 60);
        descriptionField.setBorder(createRoundedBorder(20));
        f2.add(descriptionField);

        JButton saveButton = new JButton("Save");
        saveButton.setBounds(340, 675, 90, 30);
        saveButton.setBackground(new Color(139, 148, 252));
        saveButton.setFocusPainted(false);
        saveButton.setBorder(createRoundedBorder(30));
        f2.add(saveButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(30, 675, 90, 30);
        backButton.setBackground(new Color(139, 148, 252));
        backButton.setFocusPainted(false);
        backButton.setBorder(createRoundedBorder(30));
        f2.add(backButton);

        saveButton.addActionListener(e -> {
            String title = titleField.getText();
            String assignee = assigneeField.getText();

            Date date = deadlineField.getDate();
            Date time = (Date) timeSpinner.getValue();

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            Calendar timeCalendar = Calendar.getInstance();
            timeCalendar.setTime(time);
            calendar.set(Calendar.HOUR_OF_DAY, timeCalendar.get(Calendar.HOUR_OF_DAY));
            calendar.set(Calendar.MINUTE, timeCalendar.get(Calendar.MINUTE));

            Date deadline = calendar.getTime();

            String description = descriptionField.getText();

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            String formattedDeadline = dateFormat.format(deadline);

            model.addRow(new Object[] { title, assignee, formattedDeadline, description });

            titleField.setText("");
            assigneeField.setText("");
            deadlineField.setDate(null);
            descriptionField.setText("");
            timeSpinner.setValue(new Date());

            f2.setVisible(false);
            f1.setVisible(true);
        });

        backButton.addActionListener(e -> {
            f2.setVisible(false);
            f1.setVisible(true);
        });

        f2.setSize(490, 900);
        f2.setLayout(null);
        f2.setVisible(true);
        f2.setResizable(false);
    }
}