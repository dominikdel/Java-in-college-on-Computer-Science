public class DataMain {

    // Tutaj zaczyna się działanie pierwszego programu
    public static void main(String[] args) {

        System.out.println("=== URUCHAMIAM ZADANIE 4 (DATA) ===\n");

        // 1. Tworzymy nasz obiekt daty - wpisujemy np. dzisiejszą datę
        MojaData testowaData = new MojaData(2026, 3, 26);

        // 2. Odczytujemy i wyświetlamy datę początkową (używamy gettera!)
        System.out.println("Data na start: " + testowaData.getBiezacaData());

        // 3. Testujemy przesuwanie o tydzień do przodu
        testowaData.przesunTydzienWPrzod();
        System.out.println("Data po dodaniu 7 dni: " + testowaData.getBiezacaData());

        // 4. Testujemy przesuwanie o tydzień do tyłu
        testowaData.przesunTydzienWTyl();
        System.out.println("Data po cofnięciu 7 dni: " + testowaData.getBiezacaData());
    }
}