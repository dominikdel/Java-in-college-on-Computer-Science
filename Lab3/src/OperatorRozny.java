public class OperatorRozny {
    public static void main(String[] args) {

        // Liczby
        int a = 5;
        int b = 10;
        int c = 5;

        System.out.println("=== Porównanie liczb ===");
        System.out.println("a = " + a + ", b = " + b + ", c = " + c);
        System.out.println("a != b : " + (a != b));
        System.out.println("a != c : " + (a != c));
        System.out.println("a == c : " + (a == c));

        // Znaki
        char litera1 = 'A';
        char litera2 = 'B';

        System.out.println("\n=== Porównanie znaków ===");
        System.out.println("litera1 = " + litera1 + ", litera2 = " + litera2);
        System.out.println("litera1 != litera2 : " + (litera1 != litera2));

        // Boolean
        boolean x = true;
        boolean y = false;

        System.out.println("\n=== Porównanie boolean ===");
        System.out.println("x = " + x + ", y = " + y);
        System.out.println("x != y : " + (x != y));

        // Użycie w if
        System.out.println("\n=== Użycie w instrukcji if ===");
        int wynik = 100;
        int oczekiwany = 99;

        if (wynik != oczekiwany) {
            System.out.println("Wynik (" + wynik + ") różni się od oczekiwanego (" + oczekiwany + ")");
        } else {
            System.out.println("Wynik jest zgodny z oczekiwanym");
        }

        // Pętla działająca dopóki a != 0
        System.out.println("\n=== != w pętli while ===");
        int licznik = 5;
        while (licznik != 0) {
            System.out.print(licznik + " ");
            licznik--;
        }
        System.out.println("\nKoniec odliczania!");
    }
}
