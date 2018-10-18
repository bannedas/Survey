import javax.swing.*;
import java.awt.*;

public class mainActivity {
    public mainActivity() {

        JFrame frame = new JFrame("Survey");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new loginScreen());
        frame.setSize(500, 600);
        frame.setResizable(false);
        Color darkBlue = new Color(146, 144, 145);
        frame.setBackground(darkBlue);
        center(frame);
        frame.setVisible(true);
    }



    public static void center(JFrame obj) {
        //get screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        //assign resolution to w,h
        int w = obj.getSize().width;
        int h = obj.getSize().height;
        //divide by two, get middle points
        int x = (dim.width - w) /2;
        int y = (dim.height - h) /2;
        //set to middle
        obj.setLocation(x, y);
    }
    public static void main(String[] args) {
    	// Starts main activity method
        new mainActivity();
    }
}