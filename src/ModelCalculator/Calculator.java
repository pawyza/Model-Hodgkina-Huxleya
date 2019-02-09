package ModelCalculator;
import org.apache.commons.math3.ode.FirstOrderIntegrator;
import org.apache.commons.math3.ode.nonstiff.EulerIntegrator;

import java.util.ArrayList;

/**
 * Klasa przygotowujaca pola integratora oraz obiekty, a nastepnie tworzaca obiekty tych klas ktorych zadaniem jest wyznaczenie poszukiwanych wartosci.
 */
public class Calculator {
    //Stale, wartosci poczatkowe, czas poczatkowy oraz koncowy, krok calkowania
    private final double step; //Krok calkowania
    private final double tp;
    private final double tk;
    private final double u0;
    private final double c;
    private final double eNa;
    private final double eK;
    private final double eL;
    private final double gNa;
    private final double gK;
    private final double gL;
    private final double current;

    /**
     * Kontrukor klasy calculator
     * @param step krok calkowania
     * @param tp czas poczatkowy
     * @param tk czas koncowy
     * @param u0 napiecie poczatkowe
     * @param c pojemnosc
     * @param eNa parametr eNa
     * @param eK parametr eK
     * @param eL parametr eL
     * @param gNa parametr gNa
     * @param gK parametr gK
     * @param gL parametr gl
     * @param current prad
     */
    //Konstruktor dostajacy te wartosci
    public Calculator(double step, double tp, double tk, double u0, double c, double eNa, double eK, double eL, double gNa, double gK, double gL, double current) {
        this.step = step;
        this.tk = tk;
        this.tp = tp;
        this.u0 = u0;
        this.c = c;
        this.eNa = eNa;
        this.eK = eK;
        this.eL = eL;
        this.gNa = gNa;
        this.gK = gK;
        this.gL = gL;
        this.current = current;
    }

    /**
     * Tworzy obiekty integratora, ustawia ich pola.
     * @return zwraca liste tablicowa list tablicowych wynikow calkowania
     */
    public ArrayList<ArrayList<Double>> calculate() {

        ArrayList<ArrayList<Double>> arrayLists = new ArrayList<>();

        CalculateInitialConditions calculateInitialConditions = new CalculateInitialConditions(u0);

        FirstOrderIntegrator integrator = new EulerIntegrator(step);
        Integrator ourIntegrator = new Integrator(c, eNa, eK, eL, gNa, gK, gL, current, 0.15 * tk);
        IntegratorPath integratorPath = new IntegratorPath();

        double[] xStart = new double[]{u0, calculateInitialConditions.calculateM0(), calculateInitialConditions.calculateN0(), calculateInitialConditions.calculateH0()};
        double[] xStop = new double[]{0, 0, 0, 0};
        integrator.addStepHandler(integratorPath);
        integrator.integrate(ourIntegrator, tp, xStart, tk, xStop);
        arrayLists.add(integratorPath.gettValues());
        arrayLists.add(integratorPath.getuValues());
        arrayLists.add(integratorPath.getmValues());
        arrayLists.add(integratorPath.getnValues());
        arrayLists.add(integratorPath.gethValues());
        arrayLists.add(ourIntegrator.getCurrentValues());
        arrayLists.add(ourIntegrator.getiNaValues());
        arrayLists.add(ourIntegrator.getiKValues());
        arrayLists.add(ourIntegrator.getiLValues());
        return arrayLists;
    }
}
