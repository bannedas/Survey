import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class SurveyDelete {
    public JPanel mainPanel;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton backButton;
    private JLabel infoLabel;

    final private MainFrame owner;

    private void renameButtons(File[] listOfFiles) throws IOException {

        switch (listOfFiles.length) { //Check if how many surveys there are in the survey folder. max 3
            case 0: // No survey. disable first button and set text to show "No surveys available". Remaining buttons are set to not be visible.
                button1.setText("Survey folder empty");
                button1.setEnabled(false);
                button1.setVisible(true);
                button2.setVisible(false);
                button3.setVisible(false);
                break;
            case 1: // 1 survey shown on first button. Other buttons not visible
                button1.setText(GetInfo.getInfo(Integer.valueOf(listOfFiles[0].getName()), "name"));
                button2.setVisible(false);
                button3.setVisible(false);
                break;
            case 2: // 2 surveys shown on the first 2 buttons. last button not visible.
                button1.setText(GetInfo.getInfo(Integer.valueOf(listOfFiles[0].getName()), "name"));
                button2.setText(GetInfo.getInfo(Integer.valueOf(listOfFiles[1].getName()), "name"));
                button3.setVisible(false);
                break;
            case 3: // 3 surveys shown on all buttons.
                button1.setText(GetInfo.getInfo(Integer.valueOf(listOfFiles[0].getName()), "name"));
                button2.setText(GetInfo.getInfo(Integer.valueOf(listOfFiles[1].getName()), "name"));
                button3.setText(GetInfo.getInfo(Integer.valueOf(listOfFiles[2].getName()), "name"));
                break;
            default: // too many surveys so error shown in first button which is disabled. Remaining buttons are set to not visible
                button1.setText("<html><center>Too many files in <br>survey folder<br>Please check /survey</center></html>");
                button1.setEnabled(false);
                button1.setVisible(true);
                button2.setVisible(false);
                button3.setVisible(false);
                break;
        }
    }

    public SurveyDelete(MainFrame owner) {
        super();
        this.owner = owner;
        File folder = new File("survey");
        File[] listOfFiles = folder.listFiles();

        try {
            renameButtons(listOfFiles);
        } catch (IOException e) {
            e.printStackTrace();
        }


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp = listOfFiles[0].toString();
                if(listOfFiles[0].delete()) {
                    JOptionPane.showMessageDialog(mainPanel, "Survey " + temp + " successfully deleted", "Error", JOptionPane.INFORMATION_MESSAGE); // deleted
                } else {
                    JOptionPane.showMessageDialog(mainPanel, "Error, " + temp + " not found", "Error", JOptionPane.ERROR_MESSAGE); // error message
                }
                SwingUtilities.invokeLater(() -> owner.showView(new SurveyDelete(owner).mainPanel));
        }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp = listOfFiles[1].toString();
                if(listOfFiles[1].delete()) {
                    JOptionPane.showMessageDialog(mainPanel, "Survey " + temp + " successfully deleted", "Error", JOptionPane.INFORMATION_MESSAGE); // deleted
                } else {
                    JOptionPane.showMessageDialog(mainPanel, "Error, " + temp + " not found", "Error", JOptionPane.ERROR_MESSAGE); // error message
                }
                SwingUtilities.invokeLater(() -> owner.showView(new SurveyDelete(owner).mainPanel));
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp = listOfFiles[2].toString();
                if(listOfFiles[2].delete()) {
                    JOptionPane.showMessageDialog(mainPanel, "Survey " + temp + " successfully deleted", "Error", JOptionPane.INFORMATION_MESSAGE); // deleted
                } else {
                    JOptionPane.showMessageDialog(mainPanel, "Error, " + temp + " not found", "Error", JOptionPane.ERROR_MESSAGE); // error message
                }
                SwingUtilities.invokeLater(() -> owner.showView(new SurveyDelete(owner).mainPanel));
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> owner.showView(new AdminPanel(owner).mainPanel));
            }
        });
    }
}