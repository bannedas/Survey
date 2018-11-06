import javax.swing.*;

public class main {
    public static void main(String[] args) { //main method required by java
        SwingUtilities.invokeLater(() -> {
            new mainFrame().setVisible(true); //create new frame and make it visible
        });
    }
}
