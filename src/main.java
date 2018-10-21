import javax.swing.*;

public class main {
    public static void main(String[] args) { //main method required by java
        SwingUtilities.invokeLater(() -> {
            /* this line above makes sure that thing inside of it will be held in queue
            and will be executed when there is space in memory, i think its too complicated
            to explain, but this is the only thing that worked for me to switch panels
            (ex. when changing from loginPanel to mainPanel) maybe Sokol has some explanation
            or examples how to simplify and avoid these methods */
            new mainFrame().setVisible(true); //create new frame and make it visible
        });
    }
}
