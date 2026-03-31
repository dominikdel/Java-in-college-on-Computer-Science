import java.util.Random;

/**
 * Klasa Punkt3D reprezentuje punkt w przestrzeni trojwymiarowej.
 * Dziedziczy z klasy Punkt2D – dodaje pole z (trzeci wymiar).
 *
 * Przeslania:
 *   - losujWspolrzedne() -> wywoluje super, nastepnie losuje z
 *   - toString()          -> wyswietla x, y, z
 */
public class Punkt3D extends Punkt2D {

    private int z;
    private static final Random RAND = new Random();

    /** Konstruktor bezparametrowy – x=0, y=0, z=0. */
    public Punkt3D() {
        super();
        this.z = 0;
    }

    /** Konstruktor parametryczny. */
    public Punkt3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public int getZ() { return z; }

    /**
     * Przesloniecie metody losujacej.
     * Wywoluje super.losujWspolrzedne() (losuje x i y z nadklasy),
     * nastepnie losuje niezaleznie wartosc z.
     */
    @Override
    public void losujWspolrzedne() {
        super.losujWspolrzedne();        // losowanie x i y przez nadklase
        this.z = RAND.nextInt(21) - 10; // losowanie z
    }

    @Override
    public String toString() {
        return "Punkt3D(" + x + ", " + y + ", " + z + ")";
    }
}
