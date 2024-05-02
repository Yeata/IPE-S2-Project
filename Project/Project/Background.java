package Project;
import static java.awt.Color.*;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class PlaceholderTextField extends JTextField {
    private String placeholder;
    private int borderRadius;
    private int padding;

    public PlaceholderTextField(String placeholder, int borderRadius, int padding) {
        this.placeholder = placeholder;
        this.borderRadius = borderRadius;
        this.padding = padding;
        setForeground(Color.WHITE);
        setBorder(null);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (getText().isEmpty() && !isFocusOwner()) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Color.WHITE);
            g2.setFont(getFont().deriveFont(Font.PLAIN));
            int x = getInsets().left + padding;
            int y = (getHeight() - g2.getFontMetrics().getHeight()) / 2 + g2.getFontMetrics().getAscent();
            g2.drawString(placeholder, x, y);
            g2.dispose();
        }
    }    
    @Override
    protected void paintBorder(Graphics g) {
    Graphics2D g2d = (Graphics2D) g.create();
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2d.setColor(Color.WHITE);
    g2d.drawRoundRect(1, 0, getWidth() -1, getHeight() -1, borderRadius, borderRadius);
    g2d.dispose();
}
}

interface ButtonClickListener {
    void onDashboardButtonClick();
    void onTaskButtonClick();
    void onImportantButtonClick();
    void onRemindersButtonClick();
    void onSettingsButtonClick();
}

class RoundedButton extends JButton {
    private static RoundedButton currentButton = null; 
    private boolean pressed;

    public RoundedButton(String text) {
        super(text);
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currentButton != null && currentButton != RoundedButton.this) {
                    currentButton.setPressed(false);
                }
                currentButton = RoundedButton.this;
                setPressed(true);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.isPressed()) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            float opacity = 0.5f;
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
            int width = 200;
            int height = 40;
            int x = 70;
            int y = (getHeight() - height) / 2;
            g2d.setColor(Color.WHITE);
            g2d.fillRoundRect(x, y, width, height, getBorderRadius(), getBorderRadius());
            g2d.drawRoundRect(x, y, width, height, getBorderRadius(), getBorderRadius());
            g2d.dispose();
        }
    }

    private void setPressed(boolean pressed) {
        this.pressed = pressed;
        repaint();
    }
    private boolean isPressed() {
        return this.pressed;
    }

    private int getBorderRadius() {
        return 40;
    }
}

public class Background extends Component {
    private static JPanel background;
    private static Dashboard dashboardInstance;
    private static Task taskInstance;
    private static Important importantInstance;


    public static void setBackgroundDashboardInstance(Dashboard dashboard) {
        dashboardInstance = dashboard;
    }
    // task_field
    
    public static void setBackgroundtaskInstance(Task Task) {
        taskInstance = Task;
    }

    public static void setBackgroundImportantInstance(Important important) {
        importantInstance = important;
    }

//item in main menu

    public static JPanel BackgroundPanel() {
        background = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Paint p = new GradientPaint(0.0f, 0.0f, new Color(158, 160, 210, 255),
                        0.0f, getHeight(), new Color(176, 107, 209, 255), true);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setPaint(p);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        background.setLayout(null);
        background.setBounds(0, 0, 1400, 800);

        Font font = new Font("Itim", Font.PLAIN, 22);

        JLabel logo = new JLabel("Logo");
        logo.setFont(font);
        logo.setBounds(100, 40, 100, 50);
        logo.setForeground(Color.WHITE);
        background.add(logo);
        
        PlaceholderTextField searchField = new PlaceholderTextField("Search", 40, 10);
        searchField.setFont(new Font("Itim", Font.PLAIN, 15));
        searchField.setBounds(20, 100, 200, 40);
        searchField.setOpaque(false);
        searchField.setMargin(new Insets(0, 10, 0, 0));
        searchField.setVisible(true);
        background.add(searchField);

        JButton searchButton = new JButton();
        searchButton.setBounds(180, 100, 40, 40);
        searchButton.setContentAreaFilled(false);
        searchButton.setBorderPainted(false);
        ImageIcon SearchIcon = new ImageIcon("assets/ion--search.png");        
        searchButton.setIcon(SearchIcon);
        searchButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String searchText = searchField.getText();
                System.out.println("Search for: " + searchText);
            }
        });
        background.add(searchButton);

        RoundedButton dashboardButton = new RoundedButton("Dashboard");
        dashboardButton.setLayout(null);
        dashboardButton.setBounds(-50, 150, 300, 50); 
        dashboardButton.setFont(font);
        dashboardButton.setForeground(Color.WHITE);
        ImageIcon dashboardIcon = new ImageIcon("assets/ri--dashboard-fill.png");
        dashboardButton.setIcon(dashboardIcon);
        dashboardButton.setContentAreaFilled(false);
        dashboardButton.setBorderPainted(false);
        background.add(dashboardButton);
        dashboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dashboardInstance != null) {
                    dashboardInstance.onDashboardButtonClick();
                }
                if (taskInstance != null) {
                    taskInstance.onDashboardButtonClick();
                }
                if (importantInstance != null) {
                    importantInstance.onDashboardButtonClick();
                }
            }
        });

        RoundedButton taskButton = new RoundedButton("Tasks           ");
        taskButton.setLayout(null);
        taskButton.setBounds(-50,200, 300, 50); 
        taskButton.setFont(font);
        taskButton.setForeground(Color.WHITE);
        ImageIcon taskIcon = new ImageIcon("assets/octicon--tasklist-24.png");
        taskButton.setIcon(taskIcon);
        
        background.add(taskButton);
        taskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dashboardInstance != null) {
                    dashboardInstance.onTaskButtonClick();
                }
                if (taskInstance != null) {
                    taskInstance.onTaskButtonClick();
                }
                if (importantInstance != null) {
                    importantInstance.onTaskButtonClick();
                }
            }
        });

        RoundedButton importantButton = new RoundedButton("Important ");
        importantButton.setLayout(null);
        importantButton.setBounds(-50,250, 300, 50); 
        importantButton.setFont(font);
        importantButton.setForeground(Color.WHITE);
        ImageIcon importantIcon = new ImageIcon("assets/material-symbols--notification-important-outline-rounded.png");
        importantButton.setIcon(importantIcon);
        background.add(importantButton);
        importantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dashboardInstance != null) {
                    dashboardInstance.onImportantButtonClick();
                }
                if (taskInstance != null) {
                    taskInstance.onImportantButtonClick();
                }
                if (importantInstance != null) {
                    importantInstance.onImportantButtonClick();
                }
            }
        });

        RoundedButton reminderButton = new RoundedButton("Reminders");
        reminderButton.setLayout(null);
        reminderButton.setBounds(-50,300, 300, 50); 
        reminderButton.setFont(font);
        reminderButton.setForeground(Color.WHITE);
        ImageIcon reminderIcon = new ImageIcon("assets/quill--remind.png");
        reminderButton.setIcon(reminderIcon);
        background.add(reminderButton);
        reminderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dashboardInstance != null) {
                    dashboardInstance.onRemindersButtonClick();
                }
                if (taskInstance != null) {
                    taskInstance.onRemindersButtonClick();
                }
                if (importantInstance != null) {
                    importantInstance.onRemindersButtonClick();
                }
            }
        });

        RoundedButton settingsButton = new RoundedButton("Settings    ");
        settingsButton.setLayout(null);
        settingsButton.setBounds(-50,350, 300, 50); 
        settingsButton.setFont(font);
        settingsButton.setForeground(Color.WHITE);
        ImageIcon settingsIcon = new ImageIcon("assets/solar--settings-linear.png");
        settingsButton.setIcon(settingsIcon);
        background.add(settingsButton);
        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dashboardInstance != null) {
                    dashboardInstance.onSettingsButtonClick();
                }
                if (taskInstance != null) {
                    taskInstance.onSettingsButtonClick();
                }
                if (importantInstance != null) {
                    importantInstance.onSettingsButtonClick();
                }
            }
        });

        JPanel linePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setColor(Color.WHITE);
                g2d.drawLine(20, 400, 320, 400); 
            }
        };
        linePanel.setBounds(0, 410, 250, 1); 
        background.add(linePanel);

        JLabel list = new JLabel("+ New List");
        list.setBounds(50, 700, 200, 50);
        list.setFont(font);
        list.setForeground(white);
        background.add(list);

        JPanel dashboardPanel = Dashboard.DashboardPanel();
        Dashboard.setDashboardPanel(dashboardPanel);
        dashboardPanel.setVisible(false); 
        background.add(dashboardPanel);

        JPanel taskPanel = Task.createTaskPanel();
        Task.setTaskPanel(taskPanel);
        taskPanel.setVisible(false); 
        background.add(taskPanel);

        JPanel importantPanel = Important.ImportantPanel();
        Important.setImportantPanel(importantPanel);
        importantPanel.setVisible(false); 
        background.add(importantPanel);

        return background;
    }

    public static void main(String args[]) {
        JFrame frame = new JFrame();
        JPanel background = BackgroundPanel();

        Dashboard dashboard = new Dashboard();
        Background.setBackgroundDashboardInstance(dashboard); 

        Task Task = new Task();
        Background.setBackgroundtaskInstance(Task); 

        Important important = new Important();
        Background.setBackgroundImportantInstance(important);

        frame.setSize(1400, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().add(background, BorderLayout.CENTER);
        frame.setVisible(true);
        frame.add(background);
    }
}