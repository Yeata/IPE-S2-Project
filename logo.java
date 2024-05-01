import javax.swing.*;
import java.awt.*;

public class logo extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public logo() {
        setTitle("Logo Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        headerPanel.add(new JLabel("Logo")); // Replace with actual logo image
        headerPanel.add(new JTextField(15)); // Search bar
        headerPanel.add(new JLabel("Q"));

        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.add(headerPanel, BorderLayout.NORTH);

        JPanel jPanel = new JPanel();
        jPanel.add(createSidePanel());
        contentPanel.add(jPanel, BorderLayout.WEST);

        contentPanel.add(new JPanel(), BorderLayout.CENTER); 

        add(contentPanel);
        setSize(800, 600);
        setVisible(true);
    }

    private JPanel createSidePanel() {
        JPanel panel = new JPanel(new GridLayout(6, 1));
        panel.add(new JButton("Dashboard"));
        panel.add(new JButton("Tasks"));
        JButton importantButton = new JButton("Important");
        importantButton.setFont(new Font("Sans-serif", Font.BOLD, 14));
        panel.add(importantButton);
        panel.add(new JButton("Reminders"));
        panel.add(new JButton("Settings"));
        panel.add(new JButton("New List"));
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new logo();
        });
    }
}