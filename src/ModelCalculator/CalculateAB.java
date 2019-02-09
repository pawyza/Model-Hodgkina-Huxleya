package ModelCalculator;

/**
 * Klasa sluzaca do wyliczania wartosci, zawiera metody zwracajace wyniki dla podanegu u.
 */
public class CalculateAB {
    /**
     * Ustawia pole u odpowiadajace za napiecie
     */
    private double u;

    /**
     * Konstruktor obiektu ustawiajacy pole u
     * @param u napiecie uzyte we wzorach uzytych w metodach
     */
    public CalculateAB(double u) {
        this.u = u;
    }

    /**
     * Setter pola u
     * @param u napiecie uzyte we wzorach uzytych w metodach
     */
    public void setU(double u) {
        this.u = u;
    }

    /**
     * Metoda wyliczajaca wartosc Am dla aktualnej warotsci pola u
     * @return wynik rowanania na Am
     */
    public double getAm(){
        return (0.1*(25-u))/(Math.exp((25-u)/10)-1);
    }

    /**
     * Metoda wyliczajaca wartosc Aa dla aktualnej warotsci pola u
     * @return wynik rowanania na An
     */
    public double getAn(){
        return (0.01*(10-u))/(Math.exp((10-u)/10)-1);
    }

    /**
     * Metoda wyliczajaca wartosc Ah dla aktualnej warotsci pola u
     * @return wynik rowanania na Ah
     */
    public double getAh(){
        return (0.07*Math.exp((-u)/20));
    }

    /**
     * Metoda wyliczajaca wartosc Bm dla aktualnej warotsci pola u
     * @return wynik rowanania na Bm
     */
    public double getBm(){
        return (4*(Math.exp((-u)/18)));
    }

    /**
     * Metoda wyliczajaca wartosc Bn dla aktualnej warotsci pola u
     * @return wynik rowanania na Bn
     */
    public double getBn(){
        return (0.125*(Math.exp((-u)/80)));
    }

    /**
     * Metoda wyliczajaca wartosc Bh dla aktualnej warotsci pola u
     * @return wynik rowanania na Bh
     */
    public double getBh(){
        return (1/(Math.exp((30-u)/10)+1));
    }
}
