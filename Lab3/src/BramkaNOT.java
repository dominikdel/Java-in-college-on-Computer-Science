public class BramkaNOT {
    public static void main(String[] args) {
        System.out.println("=== Bramka NOT (!) ===");
        System.out.println("Tablica prawdy:");
        System.out.println("A     | !A");
        System.out.println("------|-----");

        boolean[] wartosci = {false, true};

        for (boolean a : wartosci) {
            System.out.printf("%-5s | %-5s%n", a, !a);
        }

        System.out.println("\nPrzykłady użycia:");
        boolean deszczPada = true;

        if (!deszczPada) {
            System.out.println("Nie pada, możesz wyjść bez parasola");
        } else {
            System.out.println("Pada deszcz, weź parasol");
        }
    }
}
