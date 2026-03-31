import java.util.Scanner;

public class SilniaPetla {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Podaj liczbę: ");
        int liczba = sc.nextInt();

        if (liczba < 0) {
            System.out.println("Silnia nie istnieje dla liczb ujemnych!");
            return;
        }

        long wynik = 1;

        for (int i = 1; i <= liczba; i++) {
            wynik *= i;
        }

        System.out.println(liczba + "! = " + wynik);
    }
}
