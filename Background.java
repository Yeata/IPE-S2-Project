import static java.awt.Color.*;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Paint;
import java.awt.RenderingHints;

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
    int borderX = getInsets().left;
    int borderY = getInsets().top;
    int borderW = getWidth() - getInsets().left - getInsets().right;
    int borderH = getHeight() - getInsets().top - getInsets().bottom;
    g2d.drawRoundRect(1, 0, getWidth() -1, getHeight() -1, borderRadius, borderRadius);
    g2d.dispose();
}

}

public class Background extends Component {
    public static JPanel BackgroundPanel() {
        JPanel background = new JPanel() {
            protected void paintComponent(Graphics g) {
                Paint p = new GradientPaint(0.0f, -100.0f, new Color(158, 160, 210, 255),
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

        JButton search = new JButton();
        search.setBounds(20, 100, 200, 40);
        search.setBackground(black);
        search.setVisible(false);
        background.add(search);
        ImageIcon SearchButtonIcon = new ImageIcon("IPE-S2-Project/assets/ion--search.png");
        search.setIcon(SearchButtonIcon);

        PlaceholderTextField searchField = new PlaceholderTextField("Search", 40, 10);
        searchField.setFont(new Font("Itim", Font.PLAIN, 15));
        searchField.setBounds(20, 100, 200, 40);
        searchField.setOpaque(false);
        searchField.setMargin(new Insets(0, 10, 0, 0));
        searchField.setVisible(true);
        background.add(searchField);

        JLabel dashboard = new JLabel("Dashboard");
        dashboard.setBounds(50, 150, 150, 50);
        dashboard.setFont(font);
        dashboard.setForeground(white);
        background.add(dashboard);
        ImageIcon DashButtonIcon = new ImageIcon("IPE-S2-Project/assets/ri--dashboard-fill.png");
        dashboard.setIcon(DashButtonIcon);

        JLabel task = new JLabel("Tasks");
        task.setBounds(50, 200, 150, 50);
        task.setFont(font);
        task.setForeground(white);
        background.add(task);

        JLabel important = new JLabel("Important");
        important.setBounds(50, 250, 200, 50);
        important.setFont(font);
        important.setForeground(white);
        background.add(important);

        JLabel reminder = new JLabel("Reminders");
        reminder.setBounds(50, 300, 200, 50);
        reminder.setFont(font);
        reminder.setForeground(white);
        background.add(reminder);

        JLabel list = new JLabel("+ New List");
        list.setBounds(50, 700, 200, 50);
        list.setFont(font);
        list.setForeground(white);
        background.add(list);

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