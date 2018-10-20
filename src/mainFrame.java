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
        center();
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

    public void center() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); //get screen resolution
        int w = getSize().width; //assign resolution to w,h
        int h = getSize().height;
        int x = (dim.width - w) / 2; //divide by two, get middle points
        int y = (dim.height - h) / 2;
        setLocation(x, y); //set to middle
    }
}