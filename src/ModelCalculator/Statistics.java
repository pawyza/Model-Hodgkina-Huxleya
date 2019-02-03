package ModelCalculator;

import java.util.ArrayList;
import java.util.Collections;

public class Statistics {

    private ArrayList<Double> listX;
    private ArrayList<Double> listY;

    public Statistics(ArrayList<Double> listX, ArrayList<Double> listY) {
        this.listX = listX;
        this.listY = listY;
    }

    public double getFrequency() {

        ArrayList<Double> peak = new ArrayList<>();
        double speed1;
        double speed2;
        for (int i = 2; i < listY.size(); i++) {
            speed1 = (listY.get(i) - listY.get(i - 1));
            speed2 = (listY.get(i - 1) - listY.get(i - 2));
            if (speed1 < 0 && speed2 > 0) {
                if (listX.get(i) > 1) { // poczatkowe wartosci zbyt male do wyznaczenia czestotliwosci
                    peak.add(listX.get(i));
                }


            }
        }


        return getMean(peak);
    }

    public double getMaxU() {
        return Collections.max(listY);
    }

    public double getMeanU() {
        double sum = 0;
        for (Double aListY : listY) {
            sum += aListY;
        }
        return (sum / listY.size());
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
        for (double a : listY)
            temp += (a - mean) * (a - mean);
        return temp / (listY.size() - 1);
    }

    public double getStdDev() {
        return Math.sqrt(getVarianceU());
    }


}
