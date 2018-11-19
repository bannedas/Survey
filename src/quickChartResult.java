import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

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
    private int q1size1;
    private int q1size2;
    private int q1size3;

    private String question2;
    private String q2answer1;
    private String q2answer2;
    private String q2answer3;
    private int q2size1;
    private int q2size2;
    private int q2size3;

    private String question3;
    private String q3answer1;
    private String q3answer2;
    private String q3answer3;
    private int q3size1;
    private int q3size2;
    private int q3size3;



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

    private void setCharInfo () {
        //get surveyid and read files
        question1 = "1";
        q1answer1 = "1";
        q1answer2 = "2";
        q1answer3 = "3";
        q1size1 = 10;
        q1size2 = 30;
        q1size3 = 60;

        question2 = "2";
        q2answer1 = "1";
        q2answer2 = "2";
        q2answer3 = "3";
        q2size1 = 10;
        q2size2 = 30;
        q2size3 = 60;

        question3 = "3";
        q3answer1 = "1";
        q3answer2 = "2";
        q3answer3 = "3";
        q3size1 = 10;
        q3size2 = 30;
        q3size3 = 60;

    }

    private void createUIComponents() {
        setCharInfo();
        // Create Chart
        PieChart question1Chart = new PieChartBuilder().width(150).height(150).title(question1).build();
        PieChart question2Chart = new PieChartBuilder().width(150).height(150).title(question2).build();
        PieChart question3Chart = new PieChartBuilder().width(150).height(150).title(question3).build();

        result1 = new XChartPanel<>(question1Chart);
        result2 = new XChartPanel<>(question2Chart);
        result3 = new XChartPanel<>(question3Chart);

        Color[] question1Colors = new Color[]{
                new Color(220, 53, 34),
                new Color(217, 203, 158),
                new Color(55, 65, 64),
        }; // set colors

        Color[] question2Colors = new Color[]{
                new Color(224, 228, 204),
                new Color(243, 134, 48),
                new Color(250, 105, 0),
        }; // set colors

        Color[] question3Colors = new Color[]{
                new Color(121, 189, 154),
                new Color(59, 134, 134),
                new Color(11, 72, 107),
        }; // set colors

        question1Chart.getStyler().setSeriesColors(question1Colors); // assign colors
        question2Chart.getStyler().setSeriesColors(question2Colors); // assign colors
        question3Chart.getStyler().setSeriesColors(question3Colors); // assign colors

        question1Chart.getStyler().setPlotBackgroundColor(new Color(146, 144, 145, 255));
        question1Chart.getStyler().setChartBackgroundColor(new Color(146, 144, 145, 255));

        question2Chart.getStyler().setPlotBackgroundColor(new Color(146, 144, 145, 255));
        question2Chart.getStyler().setChartBackgroundColor(new Color(146, 144, 145, 255));

        question3Chart.getStyler().setPlotBackgroundColor(new Color(146, 144, 145, 255));
        question3Chart.getStyler().setChartBackgroundColor(new Color(146, 144, 145, 255));

        question1Chart.getStyler().setPlotBorderVisible(false);
        question2Chart.getStyler().setPlotBorderVisible(false);
        question3Chart.getStyler().setPlotBorderVisible(false);

        question1Chart.getStyler().setLegendPosition(Styler.LegendPosition.OutsideE);
        question2Chart.getStyler().setLegendPosition(Styler.LegendPosition.OutsideE);
        question3Chart.getStyler().setLegendPosition(Styler.LegendPosition.OutsideE);

        question1Chart.getStyler().setChartPadding(0);
        question2Chart.getStyler().setChartPadding(0);
        question3Chart.getStyler().setChartPadding(0);

        question1Chart.getStyler().setChartTitlePadding(0);
        question2Chart.getStyler().setChartTitlePadding(0);
        question3Chart.getStyler().setChartTitlePadding(0);

        question1Chart.addSeries(q1answer1, q1size1); // answer 1 and its size
        question1Chart.addSeries(q1answer2, q1size2); // answer 2 and its size
        question1Chart.addSeries(q1answer3, q1size3); // answer 3 and its size

        question2Chart.addSeries(q2answer1, q2size1); // answer 1 and its size
        question2Chart.addSeries(q2answer2, q2size2); // answer 2 and its size
        question2Chart.addSeries(q2answer3, q2size3); // answer 3 and its size

        question3Chart.addSeries(q3answer1, q3size1); // answer 1 and its size
        question3Chart.addSeries(q3answer2, q3size2); // answer 2 and its size
        question3Chart.addSeries(q3answer3, q3size3); // answer 3 and its size
    }
}
