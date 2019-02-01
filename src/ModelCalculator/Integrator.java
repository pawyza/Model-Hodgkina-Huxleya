package ModelCalculator;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;

import java.util.ArrayList;

public class Integrator implements FirstOrderDifferentialEquations {

    private final double c;
    private final double eNa;
    private final double eK;
    private final double eL;
    private final double gNa;
    private final double gK;
    private final double gL;
    private double current;
    private double jump;
    private int state = 0;

    private CalculateAB calculateAB = new CalculateAB(0);;

    private ArrayList<Double> currentValues = new ArrayList<>();
    private ArrayList<Double> iNaValues = new ArrayList<>();
    private ArrayList<Double> iKValues = new ArrayList<>();
    private ArrayList<Double> iLValues = new ArrayList<>();


    public ArrayList<Double> getCurrentValues() {
        return currentValues;
    }

    public ArrayList<Double> getiNaValues() {
        return iNaValues;
    }
    public ArrayList<Double> getiKValues() {
        return iKValues;
    }
    public ArrayList<Double> getiLValues() {
        return iLValues;
    }

    public Integrator(double c, double eNa, double eK, double eL, double gNa, double gK, double gL, double current, double jump) {
        this.c = c;
        this.eNa = eNa;
        this.eK = eK;
        this.eL = eL;
        this.gNa = gNa;
        this.gK = gK;
        this.gL = gL;
        this.current = current;
        this.jump = jump;
    }

    @Override
    public int getDimension() {
        return 4;
    }

    @Override
    public void computeDerivatives(double t, double[] x, double[] dxdt) throws MaxCountExceededException, DimensionMismatchException {
        // x[0] = u / x[1] = m / x[2] = n / x[3] = h
        calculateAB.setU(x[0]);
        if(t > jump) state = 1;

        double iNa = gNa*Math.pow(x[1],3)*x[3]*(x[0]-eNa);
        double iK = gK*Math.pow(x[2],4)*(x[0]-eK);
        double iL = gL*(x[0]-eL);


        double Ik = iNa + iK + iL;
        dxdt[0] = (-Ik + (current * state))/c; // u
        dxdt[1] = calculateAB.getAm() * (1 - x[1]) - calculateAB.getBm()*x[1]; //m
        dxdt[2] = calculateAB.getAn() * (1 - x[2]) - calculateAB.getBn()*x[2]; //n
        dxdt[3] = calculateAB.getAh() * (1 - x[3]) - calculateAB.getBh()*x[3]; //h
        currentValues.add(current*state);
        iNaValues.add(iNa);
        iKValues.add(iK);
        iLValues.add(iL);
    }
}