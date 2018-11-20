import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class quickChartResult {

    final private MainFrame owner;
    private JButton backButton;
    public JPanel mainPanel;
    private JPanel backPanel;
    private JPanel resultPanel;
    private JPanel result3;
    private JPanel result2;
    private JPanel result1;

    private String question1;
    private String q1answer1;
    private String q1answer2;
    private String q1answer3;
    private int q1size1 = 1;
    private int q1size2 = 1;
    private int q1size3 = 1;



    public quickChartResult(MainFrame owner) {

        super();
        this.owner = owner;

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> owner.showView(new viewResultsForm(owner).mainPanel));
            }
        });
    }

    private void setCharInfo() throws IOException {
        File userFolder = new File("userdatabase"); // path to folder
        File surveyFolder = new File("survey");
        File f;
        FileReader fr;
        BufferedReader br;
        String[] userFilesPresent = userFolder.list(); // make a list of files in folder
        String[] surveyFilesPresent = surveyFolder.list();
//        for(int i = 0; i < surveyFilesPresent.length; i++) {
//            System.out.println(surveyFilesPresent[i]);
//        }
        int counter = 0;
        for(String fileName : userFilesPresent){  // looping through files in the directory
            f = new File("userdatabase/" + fileName);
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) { //while (read line is not equal empty line)
                String[] parts = line.split(" "); //split by spaces
                for(int i = 0; i < surveyFilesPresent.length; i++) {
                    if(parts[0].equals(surveyFilesPresent[i])) {
                        System.out.println(parts[0] + " " + parts[1] + " " + parts[2] + " " + parts[3]);
                    }
                }
            }
            counter++;
        }

        question1 = "1";
        q1answer1 = "1";
        q1answer2 = "2";
        q1answer3 = "3";

    }

    private void createUIComponents() {
        try {
            setCharInfo();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Create Chart
        PieChart question1Chart = new PieChartBuilder().width(250).height(400).title(question1).build();

        result1 = new XChartPanel<>(question1Chart);

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
        question1Chart.addSeries(q1answer1, q1size1); // answer 1 and its size
        question1Chart.addSeries(q1answer2, q1size2); // answer 2 and its size
        question1Chart.addSeries(q1answer3, q1size3); // answer 3 and its size

    }
}
