import java.util.Scanner;

public class SzybkiePotegowanie {

    // =============================================
    // WERSJA REKURENCYJNA
    // =============================================
    public static long potegowanieRekurencyjne(long podstawa, int wykladnik) {
        // warunek stopu: x^0 = 1
        if (wykladnik == 0) return 1;

        if (wykladnik % 2 == 0) {
            long polowa = potegowanieRekurencyjne(podstawa, wykladnik / 2);
            return polowa * polowa;
        }

        long polowa = potegowanieRekurencyjne(podstawa, (wykladnik - 1) / 2);
        return podstawa * polowa * polowa;
    }

    // =============================================
    // WERSJA ITERACYJNA
    // =============================================
    public static long potegowanieIteracyjne(long podstawa, int wykladnik) {
        long wynik = 1;
        long baza = podstawa;
        int n = wykladnik;

        while (n > 0) {
            if (n % 2 == 1) {
                wynik *= baza;
            }

            baza *= baza;
            n /= 2;
        }
        return wynik;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Podaj podstawę: ");
        long podstawa = sc.nextLong();

        System.out.print("Podaj wykładnik: ");
        int wykladnik = sc.nextInt();

        System.out.println("\nWersja rekurencyjna:");
        System.out.println(podstawa + "^" + wykladnik + " = "
                + potegowanieRekurencyjne(podstawa, wykladnik));

        System.out.println("\nWersja iteracyjna:");
        System.out.println(podstawa + "^" + wykladnik + " = "
                + potegowanieIteracyjne(podstawa, wykladnik));

        // Weryfikacja z Math.pow()
        System.out.println("\nWeryfikacja (Math.pow): "
                + (long) Math.pow(podstawa, wykladnik));
    }
}
