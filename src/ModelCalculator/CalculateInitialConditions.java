package ModelCalculator;

public class CalculateInitialConditions {

    CalculateAB calculateAB;

    public CalculateInitialConditions(double u0) {
        calculateAB = new CalculateAB(u0);
    }

    public double calculateM0(){
        return calculateAB.getAm()/(calculateAB.getAm()+calculateAB.getBm());
    }
    public double calculateN0(){
        return calculateAB.getAn()/(calculateAB.getAn()+calculateAB.getBn());
    }
    public double calculateH0(){
        return calculateAB.getAh()/(calculateAB.getAh()+calculateAB.getBh());
    }
}
