import javax.swing.*;
import java.awt.*;

public class mainFrame extends JFrame {
    private JPanel viewPanel;

    public mainFrame(String title) {
        super(title);
        createGUI();
    }

    private void createGUI() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 600);
        setResizable(false);
        getContentPane().setBackground(new Color(146, 144, 145)); //aet frame color

        viewPanel = new JPanel(new BorderLayout());
        add(viewPanel, BorderLayout.CENTER);

        showView(new loginForm(this).panelLogin);
    }

    public void showView(JPanel panel) {
        viewPanel.removeAll();
        viewPanel.add(panel, BorderLayout.CENTER);
        viewPanel.revalidate();
        viewPanel.repaint();
    }
}