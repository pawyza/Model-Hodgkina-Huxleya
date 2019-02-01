package ModelCalculator;

import javafx.event.Event;
import javafx.event.EventHandler;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.ode.sampling.StepHandler;
import org.apache.commons.math3.ode.sampling.StepInterpolator;

import java.util.ArrayList;

public class IntegratorPath implements StepHandler, EventHandler {

    private final ArrayList<Double> tValues = new ArrayList<>();
    private final ArrayList<Double> uValues = new ArrayList<>();
    private final ArrayList<Double> mValues = new ArrayList<>();
    private final ArrayList<Double> nValues = new ArrayList<>();
    private final ArrayList<Double> hValues = new ArrayList<>();

    public ArrayList<Double> gettValues() {
        return tValues;
    }

    public ArrayList<Double> getuValues() {
        return uValues;
    }

    public ArrayList<Double> getmValues() {
        return mValues;
    }

    public ArrayList<Double> getnValues() {
        return nValues;
    }

    public ArrayList<Double> gethValues() {
        return hValues;
    }

    @Override
    public void init(double v, double[] doubles, double v1) {

    }

    @Override
    public void handleStep(StepInterpolator stepInterpolator, boolean b) throws MaxCountExceededException {

        double t = stepInterpolator.getCurrentTime(); // czas dla ktorego obliczono wart x i v
        double[] x = stepInterpolator.getInterpolatedState(); // wartosci x i v
        tValues.add(t);
        uValues.add(x[0]);
        mValues.add(x[1]);
        nValues.add(x[2]);
        hValues.add(x[3]);
    }

    @Override
    public void handle(Event event) {


    }
}