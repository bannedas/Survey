import javax.swing.*;
import java.awt.*;

public class appFrame { //main class method
    public static void mainFrame() { //creates JFrame
        JFrame frame = new JFrame("Survey"); //make new JFrame and set title "Survey"
        frame.add(new loginForm().panelLogin, BorderLayout.CENTER); //show login panel and set it in center of JFrame
        //frame.add(new mainScreen().panel1, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //what to do when X pressed
        frame.setSize(300, 600); //set JFrame size (app size)
        frame.setResizable(false); //make app not resizable
        frame.getContentPane().setBackground(new Color(146, 144, 145)); //aet frame color
        frame.setVisible(true);
        center(frame); //calls method center (puts app in center of the screen when opened
    }
    public static void center(JFrame obj) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); //get screen resolution
        int w = obj.getSize().width; //assign resolution to w,h
        int h = obj.getSize().height;
        int x = (dim.width - w) / 2; //divide by two, get middle points
        int y = (dim.height - h) / 2;
        obj.setLocation(x, y); //set to middle
    }
}