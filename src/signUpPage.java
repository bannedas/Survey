import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class signUpPage {
    public JPanel panelSignUp;
    private JPanel logoPanel;
    private JPanel panelLogin2;
    private JButton signUpButton;
    private JPasswordField passwordField1;
    private JTextField textField1;
    private JCheckBox showPasswordCheckBox;
    private JComboBox genderDropdown;
    private JLabel genderLabel;
    private JTextField firstNameField;
    private JLabel firstNameLabel;

    final private mainFrame owner;

    public signUpPage(mainFrame owner) {
        super();
        this.owner = owner;


        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> owner.showView(new signUpPage(owner).panelSignUp));
                String username = textField1.getText(); //get username from textfield
                String password = String.valueOf(passwordField1.getPassword());  //get password from passwordfield
                if (username.equals("") || password.equals("")) {
                    JOptionPane.showMessageDialog(panelSignUp, "Type in your preferred username and password", "Error", JOptionPane.ERROR_MESSAGE); // error message
                } else {
                    try { //java rules require to do this
                        if (username.matches("[a-zA-Z]+") && password.matches("[a-zA-Z]+")) {
                            if (loginCheck.loginCheck(username, password)) { //calling loginCheck.class method loginCheck. (checking all database lines if username exists
                                JOptionPane.showMessageDialog(panelSignUp, "This username is already used!", "Error", JOptionPane.ERROR_MESSAGE); // error message
                            } else {
                                if (signupWriter.signupWriter(username, password)) { //call class signupWriter, method signupWriter
                                    JOptionPane.showMessageDialog(panelSignUp, "Welcome " + username + "!\nYou can Login now", "Sign Up", JOptionPane.INFORMATION_MESSAGE); //if return true popup
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(panelSignUp, "Username and Password can only contain letters!", "Error", JOptionPane.ERROR_MESSAGE); // error message
                        }
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        });

        //-----------------show password check box----------------
        showPasswordCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showPasswordCheckBox.isSelected()) {
                    passwordField1.setEchoChar((char) 0); //show input symbols
                } else {
                    passwordField1.setEchoChar('*'); //hide input with *
                }
            }
        });
    }
    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

}



