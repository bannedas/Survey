import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class loginForm {
    public JPanel panelLogin;
    private JButton loginButton;
    private JButton signUpButton;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JCheckBox showPasswordCheckBox;

    public loginForm() {
        textField1.setBorder(BorderFactory.createEmptyBorder()); //removes borders of text field
        passwordField1.setBorder(BorderFactory.createEmptyBorder()); //removes borders of password field

        //--------------------login button ---------------------
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { //what to do when button is pressed
                String username = textField1.getText(); //get username from textfield
                String password = String.valueOf(passwordField1.getPassword()); //get password from passwordfield
                if (username.equals("") || password.equals("")) {
                    JOptionPane.showMessageDialog(panelLogin, "Type in your username and password", "Error", JOptionPane.ERROR_MESSAGE); // error message
                } else {
                    try { //same as explained in loginCheck or signupWriter, but we cannot use thorws IOExcetion because only this part writes and not the whole method
                        if (loginCheck.loginCheck(username, password)) { //calling loginCheck.class method loginCheck.
                            JOptionPane.showMessageDialog(panelLogin, "Welcome " + username + "!", "Login", JOptionPane.INFORMATION_MESSAGE); //if return true popup
                        } else {
                            JOptionPane.showMessageDialog(panelLogin, "Incorrect login or password", "Error", JOptionPane.ERROR_MESSAGE); //if return false popup
                        }
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        //--------------------sign up button ---------------------
        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = textField1.getText(); //get username from textfield
                String password = String.valueOf(passwordField1.getPassword());  //get password from passwordfield
                if (username.equals("") || password.equals("")) {
                    JOptionPane.showMessageDialog(panelLogin, "Type in your preferred username and password", "Error", JOptionPane.ERROR_MESSAGE); // error message
                } else {
                    try { //java rules require to do this
                        if (loginCheck.loginCheck(username, password)) { //calling loginCheck.class method loginCheck. (checking all database lines if username exists
                            JOptionPane.showMessageDialog(panelLogin, "This username is already used!", "Error", JOptionPane.ERROR_MESSAGE); // error message
                        } else {
                            if (signupWriter.signupWriter(username, password)) { //call class signupWriter, method signupWriter
                                JOptionPane.showMessageDialog(panelLogin, "Welcome " + username + "!", "Sign Up", JOptionPane.INFORMATION_MESSAGE); //if return true popup
                            }
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

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panelLogin = new JPanel();
        panelLogin.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 2, new Insets(0, 0, 0, 0), -1, -1));
        panelLogin.setBackground(new Color(-7171951));
        panelLogin.setEnabled(true);
        panelLogin.setFocusCycleRoot(false);
        panelLogin.setFocusTraversalPolicyProvider(false);
        panelLogin.setInheritsPopupMenu(false);
        panelLogin.setPreferredSize(new Dimension(220, 108));
        panelLogin.setRequestFocusEnabled(true);
        panelLogin.setVerifyInputWhenFocusTarget(true);
        panelLogin.setVisible(true);
        textField1 = new JTextField();
        panelLogin.add(textField1, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setForeground(new Color(-16777216));
        label1.setText("AAU email");
        panelLogin.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setForeground(new Color(-16777216));
        label2.setText("Password");
        panelLogin.add(label2, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel1.setBackground(new Color(-7171951));
        panelLogin.add(panel1, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        signUpButton = new JButton();
        signUpButton.setBackground(new Color(-1));
        signUpButton.setText("Sign Up");
        panel1.add(signUpButton, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        loginButton = new JButton();
        loginButton.setBackground(new Color(-1));
        loginButton.setText("Login");
        panel1.add(loginButton, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        showPasswordCheckBox = new JCheckBox();
        showPasswordCheckBox.setBackground(new Color(-7171951));
        showPasswordCheckBox.setForeground(new Color(-16777216));
        showPasswordCheckBox.setText("Show password");
        panelLogin.add(showPasswordCheckBox, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        passwordField1 = new JPasswordField();
        panelLogin.add(passwordField1, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panelLogin;
    }
}
