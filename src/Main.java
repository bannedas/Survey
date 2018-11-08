/**
 *
 * DESCRIPTION
 *
 * @author Madeleine Blomberg, Simon Houlberg, Kedisha Charles, Paulius Astrauskas, Anders Brenøe Olesen
 * @version 1.0
 * @release 19/12/2018
 *
 */

import javax.swing.*;

public class Main {
    public static void main(String[] args) { //Main method required by java
        SwingUtilities.invokeLater(() -> {
            new MainFrame().setVisible(true); //create new frame and make it visible

        });
    }
}
