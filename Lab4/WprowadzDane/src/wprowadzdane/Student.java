package wprowadzdane;

public class Student {
    // Pola są teraz prywatne
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

    // --- GETTERY ---
    public String getImie() { return imie; }
    public String getNazwisko() { return nazwisko; }
    public int getNr_indeksu() { return nr_indeksu; }
    public String getNazwa_specjalnosci() { return nazwa_specjalnosci; }
    public int getRok_studiow() { return rok_studiow; }

    // --- SETTERY ---
    public void setImie(String imie) { this.imie = imie; }
    public void setNazwisko(String nazwisko) { this.nazwisko = nazwisko; }
    public void setNr_indeksu(int nr_indeksu) { this.nr_indeksu = nr_indeksu; }
    public void setNazwa_specjalnosci(String nazwa_specjalnosci) { this.nazwa_specjalnosci = nazwa_specjalnosci; }
    public void setRok_studiow(int rok_studiow) { this.rok_studiow = rok_studiow; }

    public void pokazDane() {
        System.out.println("Imię: " + imie);
        System.out.println("Nazwisko: " + nazwisko);
        System.out.println("Nr indeksu: " + nr_indeksu);
        System.out.println("Nazwa specjalności: " + nazwa_specjalnosci);
        System.out.println("Rok studiów: " + rok_studiow);
    }
}