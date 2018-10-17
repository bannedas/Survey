import javax.swing.*;
import java.awt.*;

public class mainActivity {
    public static void main(String s[]) {
        JFrame frame = new JFrame("Survey App");

        JPanel panel = new JPanel();
        //panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        //panel.setLayout(new FlowLayout());
        panel.setLayout(null);
        Color darkBlue = new Color(23, 10, 114);
        panel.setBackground(darkBlue);

        JLabel labelemail = new JLabel("AAU email:");
        JLabel labelpass = new JLabel("Password:");

        JPasswordField passwordField = new JPasswordField(20);

        JButton buttonLogin = new JButton();
        buttonLogin.setText("Login");

        JButton buttonSignUp = new JButton();
        buttonSignUp.setText("Sign Up");


        JTextField mail = new JTextField(20);

        mail.setBounds(100, 150, 160, 30);
        passwordField.setBounds(100, 200, 160, 30);
        labelemail.setBounds(30, 150, 80, 30);
        labelpass.setBounds(30, 200, 80, 30);
        buttonLogin.setBounds(110, 250, 80, 30);
        buttonSignUp.setBounds(110, 300, 80, 30);

        labelemail.setForeground(Color.WHITE);
        labelpass.setForeground(Color.WHITE);

        panel.add(labelemail);
        panel.add(mail);
        panel.add(labelpass);
        panel.add(passwordField);
        panel.add(buttonLogin);
        panel.add(buttonSignUp);

        frame.add(panel);
        frame.setSize(300, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
