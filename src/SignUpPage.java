/**
 *
 * The class SignUpPage gives the user the option of creating a user by entering an unused aau e-mail, password, name and gender.
 *
 * @author Madeleine Blomberg, Simon Houlberg, Kedisha Charles, Paulius Astrauskas, Anders Brenøe Olesen
 * @version 1.0
 * @release 19/12/2018
 *
 * @param owner current owner of instance running
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SignUpPage {
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
    private JButton backButton;

    final private MainFrame owner;

    public SignUpPage(MainFrame owner) {
        this.owner = owner;


        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> owner.showView(new SignUpPage(owner).panelSignUp));
                String username = textField1.getText(); //get username from textfield
                String password = String.valueOf(passwordField1.getPassword());  //get password from passwordfield
                String firstName = firstNameField.getText(); // get first name from firstNameField
                String gender = (String) genderDropdown.getSelectedItem(); // get gender from dropdown list


                if (username.equals("") || password.equals("") || firstName.equals("")) {
                    JOptionPane.showMessageDialog(panelSignUp, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE); //Shows an error message to the user if the fields are not filled in.
                } else {
                    try { //java rules require to do this
                        if (!username.contains(" ") && !password.contains(" ") && !firstName.contains(" ")) {
                            if (username.length() > 15) {
                                System.out.println(username.substring(username.length() - 15).toLowerCase());

                                if ((username.substring(username.length() - 15).toLowerCase().equals("@student.aau.dk"))) {
                                    if (LoginCheck.loginCheck(username, password) == 1) { //calling LoginCheck.class method LoginCheck. (checking all database lines if username exists
                                        JOptionPane.showMessageDialog(panelSignUp, "An account already exists with this email!", "Error", JOptionPane.ERROR_MESSAGE); // error message
                                    } else {
                                        if (SignupWriter.signupWriter(username, password, firstName, gender)) { //call class SignupWriter, method SignupWriter
                                            JOptionPane.showMessageDialog(panelSignUp, "Welcome " + username + "!\nYou can Login now", "Sign Up", JOptionPane.INFORMATION_MESSAGE); //if return true popup
                                            SwingUtilities.invokeLater(() -> owner.showView(new LoginForm(owner).panelLogin));
                                        }
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(panelSignUp, "You must use an AAU e-mail address!", "Error", JOptionPane.ERROR_MESSAGE); // error message
                                }
                            } else {
                                JOptionPane.showMessageDialog(panelSignUp, "You must use an AAU e-mail address!", "Error", JOptionPane.ERROR_MESSAGE); // error message
                            }
                        } else {
                            JOptionPane.showMessageDialog(panelSignUp, "Fields can not contain spaces!", "Error", JOptionPane.ERROR_MESSAGE); // error message
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
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> owner.showView(new LoginForm(owner).panelLogin));
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
        panelSignUp = new JPanel();
        panelSignUp.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        panelSignUp.setBackground(new Color(-7171951));
        logoPanel = new JPanel();
        logoPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        logoPanel.setBackground(new Color(-7171951));
        logoPanel.setForeground(new Color(-7171951));
        panelSignUp.add(logoPanel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, new Dimension(-1, 100), 0, false));
        final JLabel label1 = new JLabel();
        label1.setHorizontalAlignment(0);
        label1.setHorizontalTextPosition(0);
        label1.setIcon(new ImageIcon(getClass().getResource("/aau_logo.png")));
        label1.setText("");
        logoPanel.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        panelLogin2 = new JPanel();
        panelLogin2.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(6, 2, new Insets(0, 0, 0, 0), -1, -1));
        panelLogin2.setBackground(new Color(-7171951));
        panelSignUp.add(panelLogin2, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, new Dimension(200, 200), 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel1.setBackground(new Color(-7171951));
        panelLogin2.add(panel1, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        signUpButton = new JButton();
        signUpButton.setBackground(new Color(-1));
        signUpButton.setText("Sign Up");
        panel1.add(signUpButton, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setForeground(new Color(-16777216));
        label2.setText("Password");
        panelLogin2.add(label2, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setForeground(new Color(-16777216));
        label3.setText("AAU mail");
        panelLogin2.add(label3, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        passwordField1 = new JPasswordField();
        panelLogin2.add(passwordField1, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        textField1 = new JTextField();
        panelLogin2.add(textField1, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        showPasswordCheckBox = new JCheckBox();
        showPasswordCheckBox.setBackground(new Color(-7171951));
        showPasswordCheckBox.setForeground(new Color(-16777216));
        showPasswordCheckBox.setText("Show password");
        panelLogin2.add(showPasswordCheckBox, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        genderDropdown = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("Male");
        defaultComboBoxModel1.addElement("Female");
        defaultComboBoxModel1.addElement("Truck");
        defaultComboBoxModel1.addElement("Other");
        genderDropdown.setModel(defaultComboBoxModel1);
        panelLogin2.add(genderDropdown, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        genderLabel = new JLabel();
        genderLabel.setForeground(new Color(-16777216));
        genderLabel.setText("Gender");
        panelLogin2.add(genderLabel, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        firstNameField = new JTextField();
        panelLogin2.add(firstNameField, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        firstNameLabel = new JLabel();
        firstNameLabel.setForeground(new Color(-16777216));
        firstNameLabel.setText("First Name");
        panelLogin2.add(firstNameLabel, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        genderLabel.setLabelFor(genderDropdown);
        firstNameLabel.setLabelFor(firstNameField);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panelSignUp;
    }
}



