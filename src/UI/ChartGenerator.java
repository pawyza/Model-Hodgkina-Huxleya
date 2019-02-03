package UI;

import javafx.scene.chart.Axis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.util.ArrayList;

public class ChartGenerator {

    public void generateUandIChart(LineChart chart, ArrayList<Double> timeArray, ArrayList<Double> uArray, ArrayList<Double> iArray,
                                      ArrayList<Double> iNaArray, ArrayList<Double> iKArray, ArrayList<Double> iLArray){
        chart.getData().clear();
        chart.setCreateSymbols(false);
        XYChart.Series u = new XYChart.Series();
        u.setName("Voltage U");
        XYChart.Series i = new XYChart.Series();
        i.setName("Used current I");
        XYChart.Series iNa = new XYChart.Series();
        iNa.setName("Sodium channel current INa");
        XYChart.Series iK = new XYChart.Series();
        iK.setName("Potasium channel current IK");
        XYChart.Series iL = new XYChart.Series();
        iL.setName("(uplywu) current IL");
        for (int index =0;index<timeArray.size();index=index+10){
            u.getData().add(new XYChart.Data<>(timeArray.get(index),uArray.get(index)));
            i.getData().add(new XYChart.Data<>(timeArray.get(index),iArray.get(index)));
            iNa.getData().add(new XYChart.Data<>(timeArray.get(index),iNaArray.get(index)));
            iK.getData().add(new XYChart.Data<>(timeArray.get(index),iKArray.get(index)));
            iL.getData().add(new XYChart.Data<>(timeArray.get(index),iLArray.get(index)));
        }
        chart.getData().addAll(u,i,iNa,iK,iL);
    }

    public void generateChannelsChart(LineChart chart, ArrayList<Double> timeArray , ArrayList<Double> mArray, ArrayList<Double> nArray, ArrayList<Double> hArray){
        chart.getData().clear();
        chart.setCreateSymbols(false);
        XYChart.Series m = new XYChart.Series();
        m.setName("M");
        XYChart.Series n = new XYChart.Series();
        n.setName("N");
        XYChart.Series h = new XYChart.Series();
        h.setName("H");


        for (int index =0;index<timeArray.size();index=index+10){
            m.getData().add(new XYChart.Data<>(timeArray.get(index),mArray.get(index)));
            n.getData().add(new XYChart.Data<>(timeArray.get(index),nArray.get(index)));
            h.getData().add(new XYChart.Data<>(timeArray.get(index),hArray.get(index)));
        }
        chart.getData().addAll(m,n,h);
    }


    public void generateGatingChart(LineChart chart, ArrayList<ArrayList<Double>> list){
        chart.getData().clear();
        chart.setCreateSymbols(false);
        chart.getYAxis().setAutoRanging(false);
        XYChart.Series m = new XYChart.Series();
        m.setName("M");
        XYChart.Series n = new XYChart.Series();
        n.setName("N");
        XYChart.Series h = new XYChart.Series();
        h.setName("H");

        for (int i =0; i<list.get(0).size();i++) {
            /* // do sprawdzania wartosci
            System.out.println(list.get(0).get(i));
            System.out.println(list.get(1).get(i));
            System.out.println(list.get(2).get(i));
            System.out.println(list.get(3).get(i));
            */
            m.getData().add(new XYChart.Data<>(list.get(0).get(i), list.get(1).get(i)));
            n.getData().add(new XYChart.Data<>(list.get(0).get(i), list.get(2).get(i)));
            h.getData().add(new XYChart.Data<>(list.get(0).get(i), list.get(3).get(i)));
        }

        chart.getData().addAll(m,n,h);
    }
    public void generateCurrentChart(LineChart chart,ArrayList<Double> timeArray,ArrayList<Double> uArray){
        chart.getData().clear();
        chart.setCreateSymbols(false);
        XYChart.Series u = new XYChart.Series();
        u.setName("Voltage U");
        for (int index =0;index<timeArray.size();index=index+10){
            u.getData().add(new XYChart.Data<>(timeArray.get(index),uArray.get(index)));
        }
        chart.getData().addAll(u);
    }

    }

