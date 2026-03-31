public class Firma {
    // Tablica na maksymalnie 100 pracowników (wymóg z zadania)
    private Pracownik[] listaPracownikow = new Pracownik[100];

    // Licznik, który mówi nam, ilu pracowników już zatrudniliśmy
    // Dzięki temu nie musimy przeszukiwać całej tablicy 100 miejsc za każdym razem
    private int liczbaZatrudnionych = 0;

    // Metoda do dodawania nowego pracownika
    public void dodajPracownika(Pracownik nowyPracownik) {
        // Najpierw sprawdzamy, czy w ogóle mamy miejsca (czyli czy licznik jest mniejszy niż 100)
        if (liczbaZatrudnionych < 100) {
            // Wrzucamy pracownika na pierwsze wolne miejsce i zwiększamy licznik
            listaPracownikow[liczbaZatrudnionych] = nowyPracownik;
            liczbaZatrudnionych++;
            System.out.println("Zatrudniono nową osobę!");
        } else {
            System.out.println("Brak miejsc w firmie! Limit 100 pracowników osiągnięty.");
        }
    }

    // Metoda wypisująca spisy
    public void wypiszSpis() {
        System.out.println("\n=== SPIS PRACOWNIKÓW FIRMY ===");
        if (liczbaZatrudnionych == 0) {
            System.out.println("Firma jeszcze nikogo nie zatrudnia.");
        } else {
            // Rozdział odpowiedzialności: Firma zarządza pętlą...
            for (int i = 0; i < liczbaZatrudnionych; i++) {
                // ...ale o wypisanie danych prosi samego pracownika!
                listaPracownikow[i].wypiszDanePracownika();
            }
        }
    }
}