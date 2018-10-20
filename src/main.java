import javax.swing.*;

public class main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new mainFrame("Survey").setVisible(true);
        });
    }
}
