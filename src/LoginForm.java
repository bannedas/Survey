import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
/**
 *
 * LoginForm handles actions on fields and buttons. It also contains LoginForm GUIForm generated code.
 *
 * @author Madeleine Blomberg, Simon Houlberg, Kedisha Charles, Paulius Astrauskas, Anders Brenøe Olesen
 * @version 1.0
 * @release 19/12/2018
 */
public class LoginForm {
    public JPanel panelLogin;
    private JButton loginButton;
    private JButton signUpButton;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JCheckBox showPasswordCheckBox;
    private JPanel panelLogin2;

    final private MainFrame owner;
    private String user;

    /**
     *
     * @param owner current owner of instance running
     */
    public LoginForm(MainFrame owner) {
        this.owner = owner;

        textField1.setBorder(BorderFactory.createEmptyBorder()); //removes borders of text field
        passwordField1.setBorder(BorderFactory.createEmptyBorder()); //removes borders of password field

        //--------------------login button ---------------------
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { //what to do when button is pressed
                String username = textField1.getText(); //get username from textfield
                String password = String.valueOf(passwordField1.getPassword()); //get password from passwordfield
                if (username.equals("") || password.equals("")) {
                    JOptionPane.showMessageDialog(panelLogin, "Type in your username and password", "Error", JOptionPane.ERROR_MESSAGE); // error message if no username and/or password found in fields
                } else {
                    try { //same as explained in LoginCheck or SignUpWriter, but we cannot use thorws IOExcetion because only this part writes and not the whole method
                        if (LoginCheck.loginCheck(username, password) == 2) { //calling LoginCheck.class method LoginCheck.
                            SwingUtilities.invokeLater(() -> owner.showView(new AdminPanel(owner).mainPanel));
                        } else if (LoginCheck.loginCheck(username, password) == 1) { //calling LoginCheck.class method LoginCheck.
                            SwingUtilities.invokeLater(() -> owner.showView(new MainScreen(owner, username).panel1));
                        } else if (LoginCheck.loginCheck(username, password) == 0) {
                            JOptionPane.showMessageDialog(panelLogin, "Incorrect e-mail or password", "Error", JOptionPane.ERROR_MESSAGE); //if return false popup
                            textField1.requestFocus();
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
                SwingUtilities.invokeLater(() -> owner.showView(new SignUpPage(owner).panelSignUp)); //go to SignUpPage
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
        passwordField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String username = textField1.getText(); //get username from textfield
                    String password = String.valueOf(passwordField1.getPassword()); //get password from passwordfield
                    if (username.equals("") || password.equals("")) {
                        JOptionPane.showMessageDialog(panelLogin, "Type in your AAu mail and password", "Error", JOptionPane.ERROR_MESSAGE); // error message if no username and/or password found in fields
                        textField1.requestFocus();
                    } else {
                        try { //same as explained in LoginCheck or SignUpWriter, but we cannot use thorws IOExcetion because only this part writes and not the whole method
                            if (LoginCheck.loginCheck(username, password) == 2) { //calling LoginCheck.class method LoginCheck.
                                SwingUtilities.invokeLater(() -> owner.showView(new AdminPanel(owner).mainPanel));
                            } else if (LoginCheck.loginCheck(username, password) == 1) { //calling LoginCheck.class method LoginCheck.
                                SwingUtilities.invokeLater(() -> owner.showView(new MainScreen(owner, username).panel1));
                            } else if (LoginCheck.loginCheck(username, password) == 0) {
                                JOptionPane.showMessageDialog(panelLogin, "Incorrect e-mail or password", "Error", JOptionPane.ERROR_MESSAGE); //if return false popup
                                textField1.requestFocus();
                            }
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
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
        panelLogin.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panelLogin.setBackground(new Color(-7171951));
        panelLogin.setEnabled(true);
        panelLogin.setFocusCycleRoot(false);
        panelLogin.setFocusTraversalPolicyProvider(false);
        panelLogin.setInheritsPopupMenu(false);
        panelLogin.setPreferredSize(new Dimension(-1, -1));
        panelLogin.setRequestFocusEnabled(true);
        panelLogin.setVerifyInputWhenFocusTarget(true);
        panelLogin.setVisible(true);
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel1.setBackground(new Color(-7171951));
        panelLogin.add(panel1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setHorizontalAlignment(0);
        label1.setHorizontalTextPosition(0);
        label1.setIcon(new ImageIcon(getClass().getResource("/aau_logo.png")));
        label1.setText("");
        panel1.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        panelLogin2 = new JPanel();
        panelLogin2.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 2, new Insets(0, 0, 0, 0), -1, -1));
        panelLogin2.setBackground(new Color(-7171951));
        panel1.add(panelLogin2, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(250, 100), new Dimension(250, 200), 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel2.setBackground(new Color(-7171951));
        panelLogin2.add(panel2, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        signUpButton = new JButton();
        signUpButton.setBackground(new Color(-1));
        signUpButton.setText("Sign Up");
        panel2.add(signUpButton, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        loginButton = new JButton();
        loginButton.setBackground(new Color(-1));
        loginButton.setText("Login");
        panel2.add(loginButton, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setForeground(new Color(-16777216));
        label2.setText("Password");
        panelLogin2.add(label2, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setForeground(new Color(-16777216));
        label3.setText("AAU mail");
        panelLogin2.add(label3, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        passwordField1 = new JPasswordField();
        panelLogin2.add(passwordField1, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(180, -1), new Dimension(180, -1), 0, false));
        showPasswordCheckBox = new JCheckBox();
        showPasswordCheckBox.setBackground(new Color(-7171951));
        showPasswordCheckBox.setForeground(new Color(-16777216));
        showPasswordCheckBox.setText("Show password");
        panelLogin2.add(showPasswordCheckBox, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textField1 = new JTextField();
        panelLogin2.add(textField1, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(180, -1), new Dimension(180, -1), 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        panel1.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(-1, 50), new Dimension(-1, 50), 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panelLogin;
    }
}
