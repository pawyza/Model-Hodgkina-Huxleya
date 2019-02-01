package ModelCalculator;

public class CalculateAB {
    private double u;

    public CalculateAB(double u) {
        this.u = u;
    }

    public void setU(double u) {
        this.u = u;
    }

    public double getAm(){
        return (0.1*(25-u))/(Math.exp((25-u)/10)-1);
    }
    public double getAn(){
        return (0.01*(10-u))/(Math.exp((10-u)/10)-1);
    }
    public double getAh(){
        return (0.07*Math.exp((-u)/20));
    }
    public double getBm(){
        return (4*(Math.exp((-u)/18)));
    }
    public double getBn(){
        return (0.125*(Math.exp((-u)/80)));
    }
    public double getBh(){
        return (1/(Math.exp((30-u)/10)+1));
    }
}
