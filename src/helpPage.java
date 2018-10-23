import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class helpPage {
    private JPanel panel1;
    private JButton backButton;

    final private mainFrame owner;
    private String user;

    public helpPage(mainFrame owner, String user) {
        super();
        this.user = user;
        this.owner = owner;
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> owner.showView(new mainScreen(owner,user).panel1));
            }
        });
    }
}
