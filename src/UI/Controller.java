package UI;

import ModelCalculator.Calculator;
import ModelCalculator.GatingPlotter;
import ModelCalculator.Statistics;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        GatingPlotter gp = new GatingPlotter();
        gp.getGatingPlotterData();
        ChartGenerator chartGenerator = new ChartGenerator();
        chartGenerator.generateGatingChart(GatingChart,gp.getList());


    }
    private DecimalFormat df = new DecimalFormat("#.###");
    private double step;
    private double tStart;
    private double tEnd;
    private double u0;
    private double c;
    private double eNa;
    private double eK;
    private double eL;
    private double gNa;
    private double gK;
    private double gL;
    private double current;



    @FXML
    private Text text_Frequency;

    @FXML
    private Text text_MaxU;

    @FXML
    private Text text_MeanU;

    @FXML
    private Text text_DeviationU;

    @FXML
    private LineChart<Double, Double> GatingChart;
    @FXML
    private LineChart<Double, Double> currentChart;

    @FXML
    private LineChart<Double, Double> UandIchart;

    @FXML
    private LineChart<Double, Double> channelsChart;


    @FXML
    private TextField edit_step;

    @FXML
    private TextField edit_tStart;

    @FXML
    private TextField edit_tEnd;

    @FXML
    private TextField edit_u0;

    @FXML
    private TextField edit_c;

    @FXML
    private TextField edit_eNa;

    @FXML
    private TextField edit_eK;

    @FXML
    private TextField edit_eL;

    @FXML
    private TextField edit_gNa;

    @FXML
    private TextField edit_gK;

    @FXML
    private TextField edit_gL;

    @FXML
    private TextField edit_current;


    /**
     * Metoda wywolywana po nacisnieciu przycisuku calculate
     */
    @FXML
    void Calculate() {
        getData();
        Calculator calculator = new Calculator(step, tStart, tEnd, u0, c, eNa, eK, eL, gNa, gK, gL, current);
        ArrayList<ArrayList<Double>> lists = calculator.calculate();

        GatingPlotter gp = new GatingPlotter();
        gp.getGatingPlotterData();
        ChartGenerator chartGenerator = new ChartGenerator();
        chartGenerator.generateUandIChart(UandIchart, lists.get(0), lists.get(1), lists.get(5), lists.get(6), lists.get(7), lists.get(8));
        chartGenerator.generateChannelsChart(channelsChart, lists.get(0), lists.get(2), lists.get(3), lists.get(4));
        chartGenerator.generateGatingChart(GatingChart,gp.getList());
        chartGenerator.generateCurrentChart(currentChart,lists.get(0),lists.get(1));
        Statistics s = new Statistics(lists.get(0),lists.get(1));
        text_Frequency.setText(df.format(s.getFrequency()));
        text_MaxU.setText(df.format(s.getMaxU()));
        text_MeanU.setText(df.format(s.getMeanU()));
        text_DeviationU.setText(df.format(s.getStdDev()));

    }


    /**
     * Metoda ustawiajaca wartosci poczatkowe na podstawie wpisanych do okien tekstowych
     */
    private void getData() {
        double stepNew;
        double tStartNew;
        double tEndNew;
        double u0New;
        double cNew;
        double eNaNew;
        double eKNew;
        double eLNew;
        double gNaNew;
        double gKNew;
        double gLNew;
        double currentNew;

        try {

            stepNew = Double.parseDouble(edit_step.getText());
            tStartNew = Double.parseDouble(edit_tStart.getText());
            tEndNew = Double.parseDouble(edit_tEnd.getText());
            u0New = Double.parseDouble(edit_u0.getText());
            cNew = Double.parseDouble(edit_c.getText());
            eNaNew = Double.parseDouble(edit_eNa.getText());
            eKNew = Double.parseDouble(edit_eK.getText());
            eLNew = Double.parseDouble(edit_eL.getText());
            gNaNew = Double.parseDouble(edit_gNa.getText());
            gKNew = Double.parseDouble(edit_gK.getText());
            gLNew = Double.parseDouble(edit_gL.getText());
            currentNew = Double.parseDouble(edit_current.getText());

            if (
                    (cNew <= 1.5 && cNew >= 0.8) &&
                            (eNaNew <= 119 && eNaNew >= 100) &&
                            (eKNew <= 12 && eKNew >= -12) &&
                            (eLNew <= 22 && eLNew >= 4) &&
                            (gNaNew <= 260 && gNaNew >= 120) &&
                            (gKNew <= 40 && gKNew >= 26) &&
                            (gLNew <= 0.50 && gLNew >= 0.13)

            ) {
                step = stepNew;
                tStart = tStartNew;
                tEnd = tEndNew;
                u0 = u0New;
                c = cNew;
                eNa = eNaNew;
                eK = eKNew;
                eL = eLNew;
                gNa = gNaNew;
                gK = gKNew;
                gL = gLNew;
                current = currentNew;
            } else throw new IllegalArgumentException();
        } catch (NumberFormatException e) {
            System.out.println("Please enter number values");
        }

    }

}
