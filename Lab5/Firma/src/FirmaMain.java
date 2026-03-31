public class FirmaMain {

    // Tutaj zaczyna się działanie drugiego programu
    public static void main(String[] args) {

        System.out.println("=== URUCHAMIAM ZADANIE 5 (FIRMA) ===\n");

        // 1. "Otwieramy" nową firmę
        Firma mojaFirma = new Firma();

        // 2. Wypisujemy listę pracowników (żeby udowodnić, że na starcie firma jest pusta)
        mojaFirma.wypiszSpis();

        // 3. Tworzymy kilku pracowników w pamięci programu
        Pracownik pracownik1 = new Pracownik("Jan", "Kowalski", "Kierownik");
        Pracownik pracownik2 = new Pracownik("Anna", "Nowak", "Główna Księgowa");
        Pracownik pracownik3 = new Pracownik("Piotr", "Zieliński", "Młodszy Programista");

        // 4. Zatrudniamy ich - wysyłamy nasze obiekty pracowników do wnętrza obiektu firmy
        System.out.println("Zatrudniamy ludzi...");
        mojaFirma.dodajPracownika(pracownik1);
        mojaFirma.dodajPracownika(pracownik2);
        mojaFirma.dodajPracownika(pracownik3);

        // 5. Wypisujemy zaktualizowaną listę pracowników
        mojaFirma.wypiszSpis();

        // 6. Próba zatrudnienia kogoś jeszcze, żeby pokazać, że to działa
        Pracownik pracownik4 = new Pracownik("Krzysztof", "Krawczyk", "Stażysta");
        mojaFirma.dodajPracownika(pracownik4);

        // Wypisujemy ostateczny stan
        mojaFirma.wypiszSpis();
    }
}