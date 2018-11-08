import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JPanel viewPanel; //makes panel inside JFrame
    /* simple explanation
    a car - JFrame
    car seat - viewPanel
    driver - sits inside viewPanel and can easily be replaced with a command
    driver is the one that we will be changing and it is the one that you see when you open app
     */

    public MainFrame() {
        setTitle("Survey"); //set app title
        createGUI(); //call method createGUI
    }

    private void createGUI() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //what to do when X pressed
        setSize(300, 600); //app size
        setResizable(false); //make app not resizable
        center(); //call method center
        viewPanel = new JPanel(new BorderLayout()); //set layout mode for viewPanel
        add(viewPanel, BorderLayout.CENTER); //add viewPanel to center of app
        showView(new LoginForm(this).panelLogin); //call method showView
    }

    public void showView(JPanel panel) {
        viewPanel.removeAll(); //remove all panels
        viewPanel.add(panel, BorderLayout.CENTER); //add panel that is called ex. showView(loginPanel)
        viewPanel.revalidate(); //tell java to clean up the screen
        viewPanel.repaint(); //paint new panel on the screen
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