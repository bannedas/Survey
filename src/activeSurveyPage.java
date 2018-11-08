import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class ActiveSurveyPage {
    public JPanel panel;
    private JButton backButton;
    private JPanel backPanel;
    private JPanel panelMain;
    private JButton answer1Button;
    private JButton answer3Button;
    private JButton answer2Button;
    private JProgressBar progressBar1;
    private JPanel questionPanel;
    private JPanel answerPanel;
    private JPanel surveyPanel;
    private JLabel surveyLabel;
    private JPanel topicPanel;
    private JLabel questionLabel;

    final private MainFrame owner;
    private String user;

    private void finishSurvey() {
        questionLabel.setText("Survey complete");
        answer1Button.setText("Finish and claim points");
        answer2Button.setVisible(false);
        answer3Button.setVisible(false);
    }
    private void renameButtons(int surveyID,int questionNumber) throws IOException {
        File folder = new File("survey");
        String[] questionList = GetInfo.getInfo(surveyID,questionNumber);
        //Set the question text
        questionLabel.setText(questionList[0]);
        switch (questionList.length) { //Check the question for amount of answers to question

            case 3: // 2 answers shown on the first 2 buttons. last button not visible.

                answer1Button.setText(questionList[1]);
                answer2Button.setText(questionList[2]);
                answer3Button.setVisible(false);
                break;
            case 4: // 3 answers shown on all buttons.

                answer1Button.setText(questionList[1]);
                answer2Button.setText(questionList[2]);
                answer3Button.setText(questionList[3]);

                break;
            default: // too many or few answers; so error shown in first button which is disabled. Remaining buttons are set to not visible
                answer1Button.setText("<html><center>Too many answers in <br>question line<br>Please check /survey</center></html>");
                answer1Button.setEnabled(false);
                answer1Button.setVisible(true);
                answer2Button.setVisible(false);
                answer3Button.setVisible(false);
                break;

        }
    }
    public ActiveSurveyPage(MainFrame owner, String user, int surveyID, int currentQuestion, String[] answers) {
        super();
        this.user = user;
        this.owner = owner;
        int surveyLength = 0;
        try {
            surveyLength = Integer.valueOf(GetInfo.getInfo(surveyID, "length"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        $$$setupUI$$$();
        if (currentQuestion <= surveyLength) { //If there are more questions in survey

            try {
                //Update the progress bar
                progressBarUpdate(currentQuestion,surveyLength);
                //Rename buttons with answer text
                renameButtons(surveyID, currentQuestion);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else { //If no more questions remain finalize survey
            finishSurvey();
        }

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> owner.showView(new SurveyPage(owner, user).surveyPanel));
            }
        });
        int finalSurveyLength = surveyLength;
        answer1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentQuestion > finalSurveyLength){ //If survey is finished
                    try {
                        SurveyWriter.surveyWriter(user,answers,surveyID);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                    try {
                        PointSystem.pointSystem(user,Integer.valueOf(GetInfo.getInfo(surveyID,"points"))); //Grant user points
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    SwingUtilities.invokeLater(() -> owner.showView(new MainScreen(owner, user).panel1));//Return to MainScreen
                } else{
                    //Answer 1 pressed
                    answers[currentQuestion-1]="1";//Record answer
                    SwingUtilities.invokeLater(() -> owner.showView(new ActiveSurveyPage(owner,user,surveyID,currentQuestion+1,answers).panel));//Send to next question page
                }
            }
        });
        answer2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answers[currentQuestion-1]="2";//Answer 2 pressed
                SwingUtilities.invokeLater(() -> owner.showView(new ActiveSurveyPage(owner,user,surveyID,currentQuestion+1,answers).panel));//Send to next question page
            }
        });
        answer3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answers[currentQuestion-1]="3";//Answer 3 pressed
                SwingUtilities.invokeLater(() -> owner.showView(new ActiveSurveyPage(owner,user,surveyID,currentQuestion+1,answers).panel));//Send to next question page
            }
        });


        answer2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        answer3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void progressBarUpdate(int questionNumber, int questionCount) {
        progressBar1.setValue(questionNumber-1);
        progressBar1.setMaximum(questionCount);
        progressBar1.setStringPainted(true);
    }

    private void createUIComponents() {
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel = new JPanel();
        panel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel.setBackground(new Color(-7171438));
        panelMain = new JPanel();
        panelMain.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        panelMain.setBackground(new Color(-7171438));
        panel.add(panelMain, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        questionPanel = new JPanel();
        questionPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        questionPanel.setBackground(new Color(-7171438));
        panelMain.add(questionPanel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        surveyPanel = new JPanel();
        surveyPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        surveyPanel.setBackground(new Color(-7171438));
        questionPanel.add(surveyPanel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(-1, 50), new Dimension(-1, 50), 0, false));
        surveyLabel = new JLabel();
        surveyLabel.setText("Survey type");
        surveyPanel.add(surveyLabel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        topicPanel = new JPanel();
        topicPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        topicPanel.setBackground(new Color(-7171438));
        questionPanel.add(topicPanel, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        questionLabel = new JLabel();
        questionLabel.setText("Question");
        topicPanel.add(questionLabel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        answerPanel = new JPanel();
        answerPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        answerPanel.setBackground(new Color(-7171438));
        panelMain.add(answerPanel, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(200, -1), new Dimension(200, -1), 0, false));
        answer1Button = new JButton();
        answer1Button.setBackground(new Color(-1));
        answer1Button.setText("Answer1");
        answerPanel.add(answer1Button, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        answer3Button = new JButton();
        answer3Button.setBackground(new Color(-1));
        answer3Button.setText("Answer3");
        answerPanel.add(answer3Button, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        answer2Button = new JButton();
        answer2Button.setBackground(new Color(-1));
        answer2Button.setText("Answer2");
        answerPanel.add(answer2Button, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        backPanel = new JPanel();
        backPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        backPanel.setBackground(new Color(-7171438));
        panelMain.add(backPanel, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_SOUTH, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        progressBar1 = new JProgressBar();
        backPanel.add(progressBar1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        backButton = new JButton();
        backButton.setBackground(new Color(-9474193));
        backButton.setForeground(new Color(-16777216));
        backButton.setText("Back");
        backPanel.add(backButton, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_SOUTH, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel;
    }

    /**
     * @noinspection ALL
     */

    /**
     * @noinspection ALL
     */

}
