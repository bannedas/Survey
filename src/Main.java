import javax.swing.*;
/**
 *
 * the Main class starts the application by the main method, which opens a new MainFrame class.
 *
 * @author Madeleine Blomberg, Simon Houlberg, Kedisha Charles, Paulius Astrauskas, Anders Brenøe Olesen
 * @version 1.0
 * @release 19/12/2018
 *
 */
public class Main {
    /**
     *
     * @param args main method required to run application
     */
    public static void main(String[] args) { //Main method required by java
        SwingUtilities.invokeLater(() -> {
            new MainFrame().setVisible(true); //create new frame and make it visible

        });
    }
}
