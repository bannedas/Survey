import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
/**
 *
 * The class ViewResultsForm shows the admin which surveys are currently available to see information on.
 *
 * @author Madeleine Blomberg, Simon Houlberg, Kedisha Charles, Paulius Astrauskas, Anders Brenøe Olesen
 * @version 1.0
 * @release 19/12/2018
 */
public class ViewResultsForm {
    public JPanel mainPanel;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton backButton;

    final private MainFrame owner;

    /**
     *
     * @param listOfFiles is the list of files in the survey folder. The names of the surveys are their ID number.
     * @throws IOException dealing with input/output, so using exception in case of failure
     */
    private void renameButtons(File[] listOfFiles) throws IOException {

        switch (listOfFiles.length) { //Check if how many surveys there are in the survey folder. max 3
            case 0: // No survey. disable first button and set text to show "No surveys available". Remaining buttons are set to not be visible.
                button1.setText("No questions in survey available");
                button1.setEnabled(false);
                button1.setVisible(true);
                button2.setVisible(false);
                button3.setVisible(false);
                break;
            case 1: // 1 survey shown on first button. Other buttons not visible
                button1.setText(GetInfo.getInfo(Integer.valueOf(listOfFiles[0].getName()),"name"));
                button2.setVisible(false);
                button3.setVisible(false);
                break;
            case 2: // 2 surveys shown on the first 2 buttons. last button not visible.
                button1.setText(GetInfo.getInfo(Integer.valueOf(listOfFiles[0].getName()),"name"));
                button2.setText(GetInfo.getInfo(Integer.valueOf(listOfFiles[1].getName()),"name"));
                button3.setVisible(false);
                break;
            case 3: // 3 surveys shown on all buttons.
                button1.setText(GetInfo.getInfo(Integer.valueOf(listOfFiles[0].getName()),"name"));
                button2.setText(GetInfo.getInfo(Integer.valueOf(listOfFiles[1].getName()),"name"));
                button3.setText(GetInfo.getInfo(Integer.valueOf(listOfFiles[2].getName()),"name"));
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

    /**
     *
     * @param owner current owner of instance running
     */
    public ViewResultsForm(MainFrame owner) {
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
                int surveyID = Integer.valueOf(listOfFiles[0].getName());
                SwingUtilities.invokeLater(() -> owner.showView(new ViewResultsQuestions(owner, surveyID).mainPanel));
                //SwingUtilities.invokeLater(() -> owner.showView(new ActiveSurveyPage(owner, user,surveyID,1,answerList).panel));

            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int surveyID = Integer.valueOf(listOfFiles[1].getName());
                SwingUtilities.invokeLater(() -> owner.showView(new ViewResultsQuestions(owner, surveyID).mainPanel));
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int surveyID = Integer.valueOf(listOfFiles[2].getName());
                SwingUtilities.invokeLater(() -> owner.showView(new ViewResultsQuestions(owner, surveyID).mainPanel));
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> owner.showView(new AdminPanel(owner).mainPanel));
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 1, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel.setBackground(new Color(-7171951));
        button1 = new JButton();
        button1.setBackground(new Color(-1));
        button1.setForeground(new Color(-16777216));
        button1.setText("Gym");
        mainPanel.add(button1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(200, 50), new Dimension(200, 50), 0, false));
        button2 = new JButton();
        button2.setBackground(new Color(-1));
        button2.setForeground(new Color(-16777216));
        button2.setText("Canteen");
        mainPanel.add(button2, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(200, 50), new Dimension(200, 50), 0, false));
        button3 = new JButton();
        button3.setBackground(new Color(-1));
        button3.setForeground(new Color(-16777216));
        button3.setText("Library");
        mainPanel.add(button3, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(200, 50), new Dimension(200, 50), 0, false));
        backButton = new JButton();
        backButton.setBackground(new Color(-9343120));
        backButton.setEnabled(true);
        backButton.setText("Back");
        mainPanel.add(backButton, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_SOUTH, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }
}