public class BramkaXOR {
    public static void main(String[] args) {
        System.out.println("=== Bramka XOR (^) ===");
        System.out.println("Tablica prawdy:");
        System.out.println("A     | B     | A ^ B");
        System.out.println("------|-------|------");

        boolean[] wartosci = {false, true};

        for (boolean a : wartosci) {
            for (boolean b : wartosci) {
                System.out.printf("%-5s | %-5s | %-5s%n", a, b, a ^ b);
            }
        }

        System.out.println("\nPrzykłady użycia:");

        // Przykład 1: Drzwi z dwoma przełącznikami
        boolean przelacznik1 = true;
        boolean przelacznik2 = false;
        boolean swiatloWlaczone = przelacznik1 ^ przelacznik2;

        System.out.println("\nPrzełącznik 1: " + przelacznik1);
        System.out.println("Przełącznik 2: " + przelacznik2);
        System.out.println("Światło włączone: " + swiatloWlaczone);
    }
}
