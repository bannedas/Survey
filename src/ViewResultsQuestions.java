import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * The class ViewResultsQuestions shows the admin which questions are currently available to see information on from selected survey.
 *
 * @author Madeleine Blomberg, Simon Houlberg, Kedisha Charles, Paulius Astrauskas, Anders Brenøe Olesen
 * @version 1.0
 * @release 19/12/2018
 */

public class ViewResultsQuestions {
    public JPanel mainPanel;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton backButton;

    final private MainFrame owner;
    String[] question = new String[3];
    String[] answer1 = new String[3];
    String[] answer2 = new String[3];
    String[] answer3 = new String[3];

    /**
     *
     * @param surveyID internal ID of a survey
     * @throws IOException dealing with input/output, so using exception in case of failure
     */
    private void renameButtons(String surveyID) throws IOException {
        String dir = "survey/" + surveyID; //database location (right now in the same folder as an app

        FileReader fileReader = new FileReader(dir); //initialize filereader (this one opens files)
        BufferedReader bufferedReader = new BufferedReader(fileReader); //initialize bufferedreader (this one can read files)

        String line; //initialize string (later we assign it to readLine so it becomes 1 line of database
        String[] questionLines = new String[4];

        int counter = 0;
        while ((line = bufferedReader.readLine()) != null) { //while (read line is not equal empty line)
            questionLines[counter] = line;
            counter++;
        }
        bufferedReader.close();
        for(int i = 1; i < questionLines.length; i++) {
            String[] parts = questionLines[i].split(":"); //split by spaces
            question[i-1] = parts[0];
            answer1[i-1] = parts[1];
            answer2[i-1] = parts[2];
            answer3[i-1] = parts[3];
        }
        button1.setText(question[0]);
        button2.setText(question[1]);
        button3.setText(question[2]);
    }

    /**
     *
     * @param owner current owner of instance running
     * @param surveyID internal ID of a survey
     */
    public ViewResultsQuestions(MainFrame owner, int surveyID) {
        super();
        this.owner = owner;


        try {
            renameButtons(Integer.toString(surveyID));
        } catch (IOException e) {
            e.printStackTrace();
        }

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> owner.showView(new QuickChartResult(owner, surveyID, 1, question[0], answer1[0], answer2[0], answer3[0]).mainPanel));
                //SwingUtilities.invokeLater(() -> owner.showView(new ActiveSurveyPage(owner, user,surveyID,1,answerList).panel));

            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> owner.showView(new QuickChartResult(owner, surveyID, 2, question[1], answer1[1], answer2[1], answer3[1]).mainPanel));
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> owner.showView(new QuickChartResult(owner, surveyID, 3, question[2], answer1[2], answer2[2], answer3[2]).mainPanel));
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> owner.showView(new ViewResultsForm(owner).mainPanel));
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