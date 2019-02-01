package UI;
import ModelCalculator.Calculator;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;

import java.util.ArrayList;

public class Controller {

    @FXML
    private LineChart<Double, Double> GatingChart;

    @FXML
    private LineChart<Double, Double> UandIchart;

    @FXML
    private LineChart<Double, Double> channelsChart;


    @FXML
    void Calculate(ActionEvent event) {
        Calculator calculator = new Calculator(0.01,0,10,0,1,115,-12,10.6,120.0,36.0,0.3,0.05);
        ArrayList<ArrayList<Double>> lists = calculator.calculate();

        for (int i = 0; i < lists.get(0).size();i++) {
            System.out.println("t: " + lists.get(0).get(i) + " u: " + lists.get(1).get(i) + " m: " + lists.get(2).get(i) + " n: " + lists.get(3).get(i) + " h: " + lists.get(4).get(i)+ " I: " + lists.get(5).get(i)
            + "I Na: " + lists.get(6).get(i)+ "I K: " + lists.get(7).get(i)+ "I L: " + lists.get(8).get(i));
        }

       ChartGenerator chartGenerator = new ChartGenerator();
       chartGenerator.generateUandIChart(UandIchart,lists.get(0),lists.get(1),lists.get(5),lists.get(6),lists.get(7),lists.get(8));
       chartGenerator.generateChannelsChart(channelsChart,lists.get(0),lists.get(2),lists.get(3),lists.get(4));

    }

}
