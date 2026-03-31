/**
 * Klasa Student dziedziczy po klasie Osoba (extends Osoba).
 *
 * Rozszerza klase Osoba o pola charakterystyczne dla studenta:
 *   - numer indeksu
 *   - typ studiow (np. stacjonarne / niestacjonarne)
 *   - kierunek studiow
 *   - rok studiow
 *
 * Przeslania metode getInfo() oraz toString().
 */
public class Student extends Osoba {

    private String nrIndeksu;
    private String typStudiow;
    private String kierunek;
    private int    rokStudiow;

    public Student(String imie, String nazwisko, String dataUrodzenia, String plec,
                   String nrIndeksu, String typStudiow, String kierunek, int rokStudiow) {
        // Wywolanie konstruktora klasy nadrzednej
        super(imie, nazwisko, dataUrodzenia, plec);
        this.nrIndeksu  = nrIndeksu;
        this.typStudiow = typStudiow;
        this.kierunek   = kierunek;
        this.rokStudiow = rokStudiow;
    }

    public String getNrIndeksu()  { return nrIndeksu; }
    public String getTypStudiow() { return typStudiow; }
    public String getKierunek()   { return kierunek; }
    public int    getRokStudiow() { return rokStudiow; }

    /** Przesloniecie getInfo() z klasy Osoba. */
    @Override
    public String getInfo() {
        return super.getInfo()
             + " | Nr indeksu: " + nrIndeksu
             + ", Typ studiow: " + typStudiow
             + ", Kierunek: "    + kierunek
             + ", Rok studiow: " + rokStudiow;
    }

    @Override
    public String toString() {
        return "[STUDENT] " + getInfo();
    }
}
