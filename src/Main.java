import javax.swing.*;

public class Main {
    public static void main(String[] args) { //Main method required by java
        SwingUtilities.invokeLater(() -> {
            new MainFrame().setVisible(true); //create new frame and make it visible

        });
    }
}
