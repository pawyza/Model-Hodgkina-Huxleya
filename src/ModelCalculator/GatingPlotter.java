package ModelCalculator;

import java.util.ArrayList;

public class GatingPlotter {
    private ArrayList<ArrayList<Double>> list = new ArrayList<>();
    private ArrayList<Double> u = new ArrayList<>();
    private ArrayList<Double> m0 = new ArrayList<>();
    private ArrayList<Double> n0 = new ArrayList<>();
    private ArrayList<Double> h0 = new ArrayList<>();
    private double u0 = -50;

    public GatingPlotter() {
        list.add(u);
        list.add(m0);
        list.add(n0);
        list.add(h0);
        getGatingPlotterData();
    }

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

    public ArrayList<ArrayList<Double>> getList() {
        return list;
    }
}
