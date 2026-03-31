/**
 * Zadanie 1 – Dziedziczenie w języku Java
 *
 * Klasa bazowa Osoba reprezentuje ogólną osobę.
 * Przechowuje podstawowe dane: imię, nazwisko, datę urodzenia oraz płeć.
 * Stanowi nadklasę dla klas Student i Wykladowca.
 */
public class Osoba {

    private String imie;
    private String nazwisko;
    private String dataUrodzenia; // format: DD-MM-RRRR
    private String plec;          // "M" lub "K"

    public Osoba(String imie, String nazwisko, String dataUrodzenia, String plec) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = dataUrodzenia;
        this.plec = plec;
    }

    public String getImie()          { return imie; }
    public String getNazwisko()      { return nazwisko; }
    public String getDataUrodzenia() { return dataUrodzenia; }
    public String getPlec()          { return plec; }

    /**
     * Metoda zwracająca informację o osobie.
     * Zostanie przesłonięta (@Override) w klasach pochodnych.
     */
    public String getInfo() {
        return "Imie: " + imie
             + ", Nazwisko: " + nazwisko
             + ", Data urodzenia: " + dataUrodzenia
             + ", Plec: " + plec;
    }

    @Override
    public String toString() {
        return getInfo();
    }
}
