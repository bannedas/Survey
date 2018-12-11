import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 *
 * The class QuickChartResult is where an admin can see a visual overview of answers for a specific question.
 *
 * @author Madeleine Blomberg, Simon Houlberg, Kedisha Charles, Paulius Astrauskas, Anders Bren&oslash;e Olesen
 * @version 1.0
 * @release 19/12/2018
 */

public class QuickChartResult {

    final private MainFrame owner;
    private JButton backButton;
    public JPanel mainPanel;
    private JPanel backPanel;
    private JPanel resultPanel;
    private JPanel chartResult;
    private JLabel chartQuestion;

    private String chartTitle;
    private String chartAnswer1;
    private String chartAnswer2;
    private String chartAnswer3;
    private int answer1Size = 0;
    private int answer2Size = 0;
    private int answer3Size = 0;
    private int sID;
    private int questionNum;

    /**
     *
     * @param surveyID          internal ID of a survey
     * @param questionNumber    which line of survey file to get possible answers for buttons
     * @param owner             owner of current instance running
     * @param question          the question the current chart summarizes
     * @param answer1           ID for first answer for current question
     * @param answer2           ID for second answer for current question
     * @param answer3           ID for third answer for current question
     */
    public QuickChartResult(MainFrame owner, int surveyID, int questionNumber, String question, String answer1, String answer2, String answer3) {
        super();
        this.owner = owner;

        sID = surveyID;
        questionNum = questionNumber;

        chartTitle = question;
        chartAnswer1 = answer1;
        chartAnswer2 = answer2;
        chartAnswer3 = answer3;
        chartQuestion.setText(chartTitle);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> owner.showView(new ViewResultsQuestions(owner, surveyID).mainPanel));
            }
        });
    }

    /**
     * Method reads userdatabase folder and displays all user answers graphically using PIE graph
     * Xchart library is used to create custom charts
     *
     * @throws IOException dealing with input/output, so using exception in case of failure
     */
    private void createUIComponents() throws IOException {
        File userFolder = new File("userdatabase"); // path to folder
        //File surveyFolder = new File("survey");
        File f;
        FileReader fr;
        BufferedReader br;
        String[] userFilesPresent = userFolder.list(); // make a list of files in folder
        //String[] surveyFilesPresent = surveyFolder.list();

        for(String fileName : userFilesPresent){  // looping through files in the directory
            f = new File("userdatabase/" + fileName);
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) { //while (read line is not equal empty line)
                String[] parts = line.split(" "); //split by spaces
                if(parts[0].equals(Integer.toString(sID))) {
                    //System.out.println(parts[0] + " " + parts[1] + " " + parts[2] + " " + parts[3]);
                    if (parts[questionNum].equals("1")) answer1Size++;
                    if (parts[questionNum].equals("2")) answer2Size++;
                    if (parts[questionNum].equals("3")) answer3Size++;
                }
            }
            br.close(); // close stream
        }

        PieChart question1Chart = new PieChartBuilder().width(250).height(400).title("").build();
        chartResult = new XChartPanel<>(question1Chart);
        Color[] question1Colors = new Color[]{
                new Color(220, 53, 34),
                new Color(217, 203, 158),
                new Color(55, 65, 64),
        }; // set colors

        question1Chart.getStyler().setSeriesColors(question1Colors); // assign colors
        question1Chart.getStyler().setPlotBackgroundColor(new Color(146, 144, 145, 255));
        question1Chart.getStyler().setChartBackgroundColor(new Color(146, 144, 145, 255));

        question1Chart.getStyler().setPlotBorderVisible(false);
        question1Chart.getStyler().setLegendPosition(Styler.LegendPosition.OutsideS);
        question1Chart.getStyler().setChartPadding(0);
        question1Chart.getStyler().setChartTitlePadding(0);
        //System.out.println(answer1Size + " " + answer2Size + " " + answer3Size);

        question1Chart.addSeries(chartAnswer1, answer1Size); // answer 1 and its size
        question1Chart.addSeries(chartAnswer2, answer2Size); // answer 2 and its size
        question1Chart.addSeries(chartAnswer3, answer3Size); // answer 3 and its size
    }
}
