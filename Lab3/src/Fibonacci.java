import java.util.Scanner;

public class Fibonacci {

    // =============================================
    // WERSJA REKURENCYJNA
    // Złożoność: O(2^n) — bardzo wolna dla dużych n!
    // =============================================
    public static long fibRekurencyjny(int n) {
        // warunki stopu (base case)
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibRekurencyjny(n - 1) + fibRekurencyjny(n - 2);
    }

    // =============================================
    // WERSJA ITERACYJNA
    // Złożoność: O(n) — szybka nawet dla dużych n
    // =============================================
    public static long fibIteracyjny(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        long poprzedni = 0;
        long obecny   = 1;

        for (int i = 2; i <= n; i++) {
            long nastepny = poprzedni + obecny;
            poprzedni = obecny;
            obecny    = nastepny;
        }
        return obecny;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Podaj n: ");
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("n musi być >= 0");
            return;
        }
        // Wyniki
        System.out.println("\nF(" + n + ") rekurencyjnie = " + fibRekurencyjny(n));
        System.out.println("F(" + n + ") iteracyjnie   = " + fibIteracyjny(n));

        // Wypisanie ciagu
        System.out.println("\nCiąg Fibonacciego od F(0) do F(" + n + "):");
        for (int i = 0; i <= n; i++) {
            System.out.print("F(" + i + ")=" + fibIteracyjny(i));
            if (i < n) System.out.print(", ");
        }
        System.out.println();
    }
}
