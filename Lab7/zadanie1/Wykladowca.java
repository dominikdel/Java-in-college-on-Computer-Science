/**
 * Klasa Wykladowca dziedziczy po klasie Osoba.
 *
 * Zaprojektowana samodzielnie przez analogie do klasy Student.
 * Pola charakterystyczne dla wykladowcy akademickiego:
 *   - numer pracowniczy
 *   - tytul naukowy (np. mgr, dr, prof.)
 *   - katedra / zaklad
 *   - specjalizacja (prowadzone przedmioty / obszar badan)
 *   - staz pracy (w latach)
 */
public class Wykladowca extends Osoba {

    private String nrPracowniczy;
    private String tytulNaukowy;
    private String katedra;
    private String specjalizacja;
    private int    stazPracy;

    public Wykladowca(String imie, String nazwisko, String dataUrodzenia, String plec,
                      String nrPracowniczy, String tytulNaukowy,
                      String katedra, String specjalizacja, int stazPracy) {
        super(imie, nazwisko, dataUrodzenia, plec);
        this.nrPracowniczy = nrPracowniczy;
        this.tytulNaukowy  = tytulNaukowy;
        this.katedra        = katedra;
        this.specjalizacja  = specjalizacja;
        this.stazPracy      = stazPracy;
    }

    public String getNrPracowniczy()  { return nrPracowniczy; }
    public String getTytulNaukowy()   { return tytulNaukowy; }
    public String getKatedra()        { return katedra; }
    public String getSpecjalizacja()  { return specjalizacja; }
    public int    getStazPracy()      { return stazPracy; }

    /** Przesloniecie getInfo() z klasy Osoba. */
    @Override
    public String getInfo() {
        return super.getInfo()
             + " | Nr pracowniczy: " + nrPracowniczy
             + ", Tytul: "           + tytulNaukowy
             + ", Katedra: "         + katedra
             + ", Specjalizacja: "   + specjalizacja
             + ", Staz pracy: "      + stazPracy + " lat";
    }

    @Override
    public String toString() {
        return "[WYKLADOWCA] " + getInfo();
    }
}
