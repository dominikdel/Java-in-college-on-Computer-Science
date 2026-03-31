package student;

public class Student {
    // 1. Pola zmienione na private
    private String imie;
    private String nazwisko;
    private int nr_indeksu;
    private String nazwa_specjalnosci;
    private int rok_studiow;

    public Student(String imie, String nazwisko, int nr_indeksu, String nazwa_specjalnosci, int rok_studiow) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nr_indeksu = nr_indeksu;
        this.nazwa_specjalnosci = nazwa_specjalnosci;
        this.rok_studiow = rok_studiow;
    }

    public Student(String imie, String nazwisko, int nr_indeksu) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nr_indeksu = nr_indeksu;
    }

    public Student(String imie, String nazwisko, String nazwa_specjalnosci) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nazwa_specjalnosci = nazwa_specjalnosci;
    }

    public Student(String imie, String nazwisko, int nr_indeksu, int rok_studiow) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nr_indeksu = nr_indeksu;
        this.rok_studiow = rok_studiow;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public int getNr_indeksu() {
        return nr_indeksu;
    }

    public String getNazwa_specjalnosci() {
        return nazwa_specjalnosci;
    }

    public int getRok_studiow() {
        return rok_studiow;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setNr_indeksu(int nr_indeksu) {
        if (nr_indeksu > 0) {
            this.nr_indeksu = nr_indeksu;
        } else {
            System.out.println("Błąd: Numer indeksu musi być dodatni!");
        }
    }

    public void setNazwa_specjalnosci(String nazwa_specjalnosci) {
        this.nazwa_specjalnosci = nazwa_specjalnosci;
    }

    public void setRok_studiow(int rok_studiow) {
        if (rok_studiow > 0 && rok_studiow <= 5) {
            this.rok_studiow = rok_studiow;
        } else {
            System.out.println("Błąd: Rok studiów powinien mieścić się w przedziale od 1 do 5.");
        }
    }

    public void pokazDane() {
        System.out.println("=== Dane studenta ===");
        System.out.println("Imię:               " + this.imie);
        System.out.println("Nazwisko:           " + this.nazwisko);
        System.out.println("Nr indeksu:         " + this.nr_indeksu);
        System.out.println("Specjalność:        " + this.nazwa_specjalnosci);
        System.out.println("Rok studiów:        " + this.rok_studiow);
    }
}