public class Stos {

    // 1. POLA PRYWATNE (Enkapsulacja)
    // Tworzę tablicę, która będzie moim "pudełkiem" na liczby.
    private int[] tablica;

    // To jest nasz "Top" z obrazka. Pokazuje, gdzie jest sam szczyt stosu.
    private int wskaznik;

    // 2. KONSTRUKTOR
    // Odpala się, kiedy tworzymy nowy stos. Podajemy mu rozmiar 'n'.
    public Stos(int rozmiar) {
        // Inicjalizujemy (tworzymy) pustą tablicę o zadanym rozmiarze
        tablica = new int[rozmiar];

        // Zaczynamy od -1, bo w programowaniu tablice liczymy od 0.
        // Skoro stos jest na start pusty, to wskaźnik musi być poniżej 0.
        wskaznik = -1;
    }

    // 3. METODA PUSH (wstawianie na szczyt)
    // Działa trochę jak "set", bo ustawia nową wartość
    public void push(int element) {
        // Najpierw sprawdzam, czy stos nie jest pełny!
        // Tablica.length to maksymalna pojemność. Odejmuję 1, bo liczymy od zera.
        if (wskaznik == tablica.length - 1) {
            System.out.println("BŁĄD: Stos pełny! Nie mogę wcisnąć elementu: " + element);
        } else {
            // Jeśli jest miejsce, najpierw przesuwam strzałkę (wskaźnik) o piętro wyżej
            wskaznik++;
            // Wrzucam element w to puste miejsce, na które teraz patrzy wskaźnik
            tablica[wskaznik] = element;
            System.out.println("Push: umieszczono na stosie element " + element);
        }
    }

    // 4. METODA POP (ściąganie ze szczytu)
    // Działa trochę jak "get", bo pobiera wartość i nam ją daje
    public int pop() {
        // Sprawdzam, czy stos nie jest pusty (czy wskaźnik nie spadł do -1)
        if (wskaznik == -1) {
            System.out.println("BŁĄD: Stos jest pusty! Nie ma czego zdjąć.");
            return -1; // Zwracam -1 jako symbol błędu (tak najprościej dla początkującego)
        } else {
            // Pobieram element, na który aktualnie wskazuje strzałka
            int pobranyElement = tablica[wskaznik];
            // Przesuwam strzałkę piętro w dół, bo element "znika" ze szczytu
            wskaznik--;
            System.out.println("Pop: ściągnięto ze stosu element " + pobranyElement);
            return pobranyElement; // Zwracam pobraną liczbę
        }
    }

    // 5. METODA MAIN - do przetestowania mojego kodu
    public static void main(String[] args) {
        System.out.println("=== Mój testowy stos ===");

        // Tworzę stos na maksymalnie 3 elementy
        Stos mojStos = new Stos(3);

        // Dokładam elementy
        mojStos.push(10); // Element 1
        mojStos.push(20); // Element 2
        mojStos.push(30); // Element 3

        // Próba przepełnienia (zabezpieczenie zadziała!)
        mojStos.push(40);

        System.out.println("--------------------");

        // Ściągam elementy (LIFO - zaczną schodzić od końca: 30, 20, 10)
        mojStos.pop();
        mojStos.pop();
        mojStos.pop();

        // Próba ściągnięcia z pustego (zabezpieczenie zadziała!)
        mojStos.pop();
    }
}