package wprowadzdane;

import java.util.Scanner;

public class BazaStudentow {

    // Zmienne bazy są teraz prywatne
    private static final int ROZMIAR = 100;
    private Student[] tablica = new Student[ROZMIAR];
    private Scanner sc = new Scanner(System.in);

    public void inicjalizuj() {
        for (int i = 0; i < ROZMIAR; i++) {
            tablica[i] = new Student("", "", 0, "", 0);
        }
        System.out.println("Tablica zainicjalizowana wartościami domyślnymi.");
    }

    private Student wczytajStudenta() {
        System.out.print("Imię: ");
        String imie = sc.nextLine();

        System.out.print("Nazwisko: ");
        String nazwisko = sc.nextLine();

        System.out.print("Nr indeksu: ");
        int nr = sc.nextInt();
        sc.nextLine();

        System.out.print("Specjalność: ");
        String spec = sc.nextLine();

        System.out.print("Rok studiów: ");
        int rok = sc.nextInt();
        sc.nextLine();

        return new Student(imie, nazwisko, nr, spec, rok);
    }

    public void wprowadzDane() {
        System.out.print("Podaj indeks (0-" + (ROZMIAR - 1) + "): ");
        int idx = sc.nextInt();
        sc.nextLine();

        if (idx < 0 || idx >= ROZMIAR) {
            System.out.println("Niepoprawny indeks!");
            return;
        }

        // .imie -> getImie
        if (!tablica[idx].getImie().equals("")) {
            System.out.println("Pod tym indeksem już są dane! Użyj opcji Edycja.");
            return;
        }

        tablica[idx] = wczytajStudenta();
        System.out.println("Dane zapisane pod indeksem " + idx);
    }

    public void edytujDane() {
        System.out.print("Podaj indeks do edycji (0-" + (ROZMIAR - 1) + "): ");
        int idx = sc.nextInt();
        sc.nextLine();

        if (idx < 0 || idx >= ROZMIAR) {
            System.out.println("Niepoprawny indeks!");
            return;
        }

        System.out.println("Aktualne dane:");
        tablica[idx].pokazDane();
        System.out.println("Wprowadź nowe dane:");
        tablica[idx] = wczytajStudenta();
        System.out.println("Dane zaktualizowane pod indeksem " + idx);
    }

    public void usunDane() {
        System.out.print("Podaj indeks do usunięcia (0-" + (ROZMIAR - 1) + "): ");
        int idx = sc.nextInt();
        sc.nextLine();

        if (idx < 0 || idx >= ROZMIAR) {
            System.out.println("Niepoprawny indeks!");
            return;
        }

        tablica[idx] = new Student("", "", 0, "", 0);
        System.out.println("Dane pod indeksem " + idx + " zostały usunięte.");
    }

    public void wyswietlJeden() {
        System.out.print("Podaj indeks (0-" + (ROZMIAR - 1) + "): ");
        int idx = sc.nextInt();
        sc.nextLine();

        if (idx < 0 || idx >= ROZMIAR) {
            System.out.println("Niepoprawny indeks!");
            return;
        }

        System.out.println("=== Student [" + idx + "] ===");
        tablica[idx].pokazDane();
    }

    public void wyswietlWszystkich() {
        System.out.println("=== Wszyscy studenci ===");
        for (int i = 0; i < ROZMIAR; i++) {
            // ZMIANA: Zamiast .imie używamy .getImie()
            if (!tablica[i].getImie().equals("")) {
                System.out.println("--- Indeks [" + i + "] ---");
                tablica[i].pokazDane();
                System.out.println();
            }
        }
    }

    public void wyswietlZakres() {
        System.out.print("Podaj indeks początkowy: ");
        int od = sc.nextInt();
        System.out.print("Podaj indeks końcowy: ");
        int do_ = sc.nextInt();
        sc.nextLine();

        if (od < 0 || do_ >= ROZMIAR || od > do_) {
            System.out.println("Niepoprawny zakres!");
            return;
        }

        System.out.println("=== Studenci od [" + od + "] do [" + do_ + "] ===");
        for (int i = od; i <= do_; i++) {
            System.out.println("--- Indeks [" + i + "] ---");
            tablica[i].pokazDane();
            System.out.println();
        }
    }
}