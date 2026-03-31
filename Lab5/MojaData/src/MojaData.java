import java.time.LocalDate;

public class MojaData {

    // 1. REPREZENTACJA WEWNĘTRZNA
    // Używam gotowej klasy LocalDate. Ukrywam ją (private), żeby
    // nikt nie zmienił jej bez użycia moich metod.
    private LocalDate aktualnaData;

    // 2. KONSTRUKTOR
    // Kiedy tworzymy nowy obiekt, ustawiamy konkretną datę.
    public MojaData(int rok, int miesiac, int dzien) {
        this.aktualnaData = LocalDate.of(rok, miesiac, dzien);
    }

    // 3. METODA DO ODCZYTYWANIA DATY (Getter)
    // Pozwala tylko na podgląd, bez możliwości modyfikacji z zewnątrz.
    public LocalDate getBiezacaData() {
        return aktualnaData;
    }

    // 4. METODA: PRZESTAWIANIE O TYDZIEŃ W PRZÓD
    public void przesunTydzienWPrzod() {
        // LocalDate ma super wygodną metodę plusWeeks(). 
        // Sama ogarnia, czy przeskakujemy na nowy miesiąc!
        this.aktualnaData = this.aktualnaData.plusWeeks(1);
        System.out.println("Przesunięto datę o 7 dni do przodu.");
    }

    // 5. METODA: PRZESTAWIANIE O TYDZIEŃ W TYŁ
    public void przesunTydzienWTyl() {
        // Analogicznie, używamy minusWeeks()
        this.aktualnaData = this.aktualnaData.minusWeeks(1);
        System.out.println("Cofnięto datę o 7 dni.");
    }
}