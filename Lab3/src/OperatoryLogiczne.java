// Zadanie 1.2
/*
public class Main {
    public static void main(String[] args) {
        int a = 5;
        int b = 0;

        // && : true tylko gdy oba warunki są true
        if (a > 0 && a < 10) {
            System.out.println("a jest w przedziale (0, 10)");
        } else {
            System.out.println("a nie jest w przedziale (0, 10)");
        }

        // || : true gdy przynajmniej jeden warunek jest true
        if (a < 0 || a == 5) {
            System.out.println("a jest ujemne LUB równe 5");
        } else {
            System.out.println("a nie jest ujemne i nie jest równe 5");
        }

        if (b != 0 && (a / b) > 1) {
            System.out.println("To się nie wykona");
        } else {
            System.out.println("Bezpiecznie: nie dzielimy przez 0");
        }

        if (a == 5 || (a / b) > 1) {
            System.out.println("Pierwszy warunek true, więc drugi nie jest liczony");
        }
    }
}
*/

// Zadanie 2.2
// Roznice miedzy operatorami && , & , || , |

public class OperatoryLogiczne {

    static int licznik = 0;

    static boolean sprawdz(boolean wynik) {
        licznik++;
        System.out.println("  -> sprawdz() wywołane, zwraca: " + wynik);
        return wynik;
    }

    public static void main(String[] args) {

        // --- && (short-circuit AND) ---
        System.out.println("=== false && sprawdz(true) ===");
        licznik = 0;
        if (false && sprawdz(true)) { }
        System.out.println("Ile razy wywołano sprawdz(): " + licznik);
        // Wynik: 0 - prawa strona w ogóle nie jest sprawdzana!

        // --- & (bez short-circuit) ---
        System.out.println("\n=== false & sprawdz(true) ===");
        licznik = 0;
        if (false & sprawdz(true)) { }
        System.out.println("Ile razy wywołano sprawdz(): " + licznik);
        // Wynik: 1 - prawa strona ZAWSZE jest sprawdzana

        // --- || (short-circuit OR) ---
        System.out.println("\n=== true || sprawdz(false) ===");
        licznik = 0;
        if (true || sprawdz(false)) { }
        System.out.println("Ile razy wywołano sprawdz(): " + licznik);
        // Wynik: 0 - prawa strona nie jest sprawdzana!

        // --- | (bez short-circuit) ---
        System.out.println("\n=== true | sprawdz(false) ===");
        licznik = 0;
        if (true | sprawdz(false)) { }
        System.out.println("Ile razy wywołano sprawdz(): " + licznik);
        // Wynik: 1 - prawa strona ZAWSZE jest sprawdzana
    }
}

