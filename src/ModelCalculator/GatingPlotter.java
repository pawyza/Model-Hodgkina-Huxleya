package ModelCalculator;

import java.util.ArrayList;

public class GatingPlotter {
    private ArrayList<ArrayList<Double>> list = new ArrayList<>();
    private double u0 = -50;

    /**
     * Konstruktor klasy do wykreślenia aktywacji bramek
     */
    public GatingPlotter() {
        ArrayList<Double> u = new ArrayList<>();
        list.add(u);
        ArrayList<Double> m0 = new ArrayList<>();
        list.add(m0);
        ArrayList<Double> n0 = new ArrayList<>();
        list.add(n0);
        ArrayList<Double> h0 = new ArrayList<>();
        list.add(h0);
        getGatingPlotterData();
    }

    /**
     *  Metoda uzupełniająca listę warunków początkowych dla kanałów, w zależności od u.
     */
    public void getGatingPlotterData(){

        for(int i = 0; i <100; i++){
            CalculateInitialConditions initialConditions = new CalculateInitialConditions(u0);
            u0++;
            list.get(0).add(u0);
            list.get(1).add(initialConditions.calculateM0());
            list.get(2).add(initialConditions.calculateN0());
            list.get(3).add(initialConditions.calculateH0());


        }
    }

    /**
     *  Metoda zwracająca listę z parametrami do wykresu bramkowania
     * @return lista z parametrami do wykresu bramkowania
     */
    public ArrayList<ArrayList<Double>> getList() {
        return list;
    }
}
