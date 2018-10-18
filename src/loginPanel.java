import java.awt.*;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class loginPanel {

    public loginPanel() {

        //JFrame is a window that has title, - o x buttons and etc
        //JPanel is panel that can be placed in JFrame
        //So we use only one JFrame in app, and multiple JPanels inside

        JPanel panel = new JPanel(); //creating JPanel named panel

        JLabel labelemail = new JLabel("AAU email:"); //that is how you write text in java swing
        JLabel labelpass = new JLabel("Password:");

        panel.setLayout(null); //set mode of layout, we do not use any layout manager and want to place stuff by setBounds command

        JPasswordField passwordField = new JPasswordField("", 10); //text field for passwords (hides symbols with ****)

        JButton buttonLogin = new JButton("Login"); //button
        JButton buttonSignUp = new JButton("Sign Up");

        JTextField mail = new JTextField("", 10); //normal text field input

        mail.setBounds(100, 150, 160, 30); //set location and size of item
        passwordField.setBounds(100, 200, 160, 30);//X, Y, WIDTH, HEIGHT
        labelemail.setBounds(30, 150, 80, 30);
        labelpass.setBounds(30, 200, 80, 30);
        buttonLogin.setBounds(50, 250, 80, 30);
        buttonSignUp.setBounds(170, 250, 80, 30);

        labelemail.setForeground(Color.black); //text color
        labelpass.setForeground(Color.black);

        panel.add(labelemail); //add items to the panel
        panel.add(mail);
        panel.add(labelpass);
        panel.add(passwordField);
        panel.add(buttonLogin);
        panel.add(buttonSignUp);

        panel.setPreferredSize(new Dimension(300, 600)); //set panel size

        panel.setBackground(Color.pink); //set panel color


        //function that writes in file
        Writer writer = null;
        //file creator/editor
        File check = new File("userPass.txt");

    }
}
