import java.awt.*;
import javax.swing.*;

public class loginScreen extends JPanel {

    private JTextField tfUsername;
    private JPasswordField pfPassword;
    private JLabel lbUsername;
    private JLabel lbPassword;
    private JButton btnLogin;
    private JButton btnCancel;
    private boolean succeeded;

    public loginScreen() {
        JLabel labelemail = new JLabel("AAU email:");
        JLabel labelpass = new JLabel("Password:");
        JPanel panel = new JPanel();

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        //layout.setAutoCreateGaps(true);
        //layout.setAutoCreateContainerGaps(true);

        JPasswordField passwordField = new JPasswordField("", 10);

        JButton buttonLogin = new JButton();
        buttonLogin.setText("Login");

        JButton buttonSignUp = new JButton();
        buttonSignUp.setText("Sign Up");

        JTextField mail = new JTextField("", 10);
        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();

        hGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(labelemail)
                .addComponent(labelpass)
        );
        hGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(mail)
                .addComponent(passwordField)
        );
        hGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(buttonLogin)
        );
        hGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(buttonSignUp)
        );
        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(labelemail)
                .addComponent(mail)
        );
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(labelpass)
                .addComponent(passwordField)
        );
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(buttonLogin)
                .addComponent(buttonSignUp)
        );
        layout.setVerticalGroup(vGroup);

        //this.setLayout(new SpringLayout());
//        mail.setBounds(100, 150, 160, 30);
//        passwordField.setBounds(100, 200, 160, 30);
//        labelemail.setBounds(30, 150, 80, 30);
//        labelpass.setBounds(30, 200, 80, 30);
//        buttonLogin.setBounds(110, 250, 80, 30);
//        buttonSignUp.setBounds(110, 300, 80, 30);

        labelemail.setForeground(Color.black);
        labelpass.setForeground(Color.black);


        panel.add(labelemail);
        panel.add(mail);
        panel.add(labelpass);
        panel.add(passwordField);
        panel.add(buttonLogin);
        panel.add(buttonSignUp);

        add(panel);
    }
}
