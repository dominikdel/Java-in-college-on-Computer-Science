public class Pracownik {
    // Pola prywatne - enkapsulacja!
    private String imie;
    private String nazwisko;
    private String stanowisko;

    // Konstruktor
    public Pracownik(String imie, String nazwisko, String stanowisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.stanowisko = stanowisko;
    }

    // Rozdział odpowiedzialności: Pracownik SAM zajmuje się wypisywaniem swoich danych.
    // Firma tylko wywołuje tę metodę.
    public void wypiszDanePracownika() {
        System.out.println("Pracownik: " + imie + " " + nazwisko + " | Stanowisko: " + stanowisko);
    }
}