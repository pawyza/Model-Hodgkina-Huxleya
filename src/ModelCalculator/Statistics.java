package ModelCalculator;

import java.util.ArrayList;
import java.util.Collections;

public class Statistics {

    private ArrayList<Double> listX;
    private ArrayList<Double> listY;
    ArrayList<Double> peakX;
    ArrayList<Double> peakY;

    public Statistics(ArrayList<Double> listX, ArrayList<Double> listY) {
        this.listX = listX;
        this.listY = listY;
    }

    public double getFrequency() {

        peakX = new ArrayList<>();
        peakY = new ArrayList<>();
        double speed1;
        double speed2;
        for (int i = 2; i < listY.size(); i++) {
            speed1 = (listY.get(i) - listY.get(i - 1));
            speed2 = (listY.get(i - 1) - listY.get(i - 2));
            if (speed1 < 0 && speed2 > 0) {
                if (listX.get(i) > 1) { // poczatkowe wartosci zbyt male do wyznaczenia czestotliwosci
                    System.out.println(listX.get(i));
                    peakX.add(listX.get(i));
                    peakY.add(listY.get(i));
                }


            }
        }


        return (1/getMean(peakX)) *1000;
    }

    public double getMaxU() {
        return Collections.max(peakY);
    }

    public double getMeanU() {
        double sum = 0;
        for (Double aListY : peakY) {
            sum += aListY;
        }
        return (sum / peakY.size());
    }

    public double getMean(ArrayList<Double> list) {
        double sum = 0;
        for (Double aList : list) {
            sum += aList;
        }
        return (sum / list.size());
    }

    public double getVarianceU() {
        double mean = getMeanU();
        double temp = 0;
        for (double a : peakY)
            temp += (a - mean) * (a - mean);
        return temp / (peakY.size() - 1);
    }

    public double getStdDev() {
        return Math.sqrt(getVarianceU());
    }


}
