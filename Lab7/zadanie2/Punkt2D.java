import java.util.Random;

/**
 * Zadanie 2 – Dziedziczenie i polimorfizm: klasy Punkt2D i Punkt3D
 *
 * Klasa Punkt2D reprezentuje punkt na plaszczyznie dwuwymiarowej.
 * Przechowuje wspolrzedne x oraz y (int, zakres -10..10).
 *
 * Konstruktory:
 *   - bezparametrowy  -> ustawia x=0, y=0
 *   - parametryczny   -> ustawia x i y zgodnie z argumentami
 *
 * Metody:
 *   - losujWspolrzedne() -> losuje x i y z zakresu [-10, 10]
 *   - toString()          -> opis tekstowy punktu
 */
public class Punkt2D {

    // protected – dostepne w podklasie Punkt3D bezposrednio
    protected int x;
    protected int y;
    private static final Random RAND = new Random();

    /** Konstruktor bezparametrowy – ustawia obie wspolrzedne na 0. */
    public Punkt2D() {
        this.x = 0;
        this.y = 0;
    }

    /** Konstruktor parametryczny. */
    public Punkt2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    /**
     * Losuje wspolrzedne x i y w zakresie od -10 do 10 (wlacznie).
     * nextInt(21) -> [0..20], odjecie 10 -> [-10..10]
     */
    public void losujWspolrzedne() {
        this.x = RAND.nextInt(21) - 10;
        this.y = RAND.nextInt(21) - 10;
    }

    @Override
    public String toString() {
        return "Punkt2D(" + x + ", " + y + ")";
    }
}
