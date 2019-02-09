package ModelCalculator;

/**
 * Klasa wyznaczajaca wartosci poczatkowe
 */
public class CalculateInitialConditions {

    CalculateAB calculateAB;

    /**
     * Metoda ustawiajaca pole typu CalculateAB przy uzyciu wartosci podanego anpiecia
     * @param u0 Napiecie poczatkowe
     */
    public CalculateInitialConditions(double u0) {
        calculateAB = new CalculateAB(u0);
    }

    /**
     * Metoda zwracajaca wartosc poczatkowa M0
     * @return wartosc poczatkowa M0
     */
    public double calculateM0(){
        return calculateAB.getAm()/(calculateAB.getAm()+calculateAB.getBm());
    }

    /**
     * Metoda zwracajaca wartosc poczatkowa N0
     * @return wartosc poczatkowa N0
     */
    public double calculateN0(){
        return calculateAB.getAn()/(calculateAB.getAn()+calculateAB.getBn());
    }

    /**
     * Metoda zwracajaca wartosc poczatkowa H0
     * @return wartosc poczatkowa H0
     */
    public double calculateH0(){
        return calculateAB.getAh()/(calculateAB.getAh()+calculateAB.getBh());
    }
}
