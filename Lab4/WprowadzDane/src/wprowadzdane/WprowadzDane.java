package wprowadzdane;

import java.util.Scanner;

public class WprowadzDane {

    public static void main(String[] args) {
        BazaStudentow baza = new BazaStudentow();
        Scanner sc = new Scanner(System.in);

        baza.inicjalizuj();

        int wybor;
        do {
            System.out.println("========== MENU ==========");
                    System.out.println("[1] Wprowadź dane studenta");
            System.out.println("[2] Edytuj dane studenta");
            System.out.println("[3] Usuń dane studenta");
            System.out.println("[4] Wyświetl studenta po indeksie");
            System.out.println("[5] Wyświetl wszystkich studentów");
            System.out.println("[6] Wyświetl zakres studentów");
            System.out.println("[0] Wyjście");
            System.out.print("Twój wybór: ");
            wybor = sc.nextInt();
            sc.nextLine();
            System.out.println();

            if      (wybor == 1) baza.wprowadzDane();
            else if (wybor == 2) baza.edytujDane();
            else if (wybor == 3) baza.usunDane();
            else if (wybor == 4) baza.wyswietlJeden();
            else if (wybor == 5) baza.wyswietlWszystkich();
            else if (wybor == 6) baza.wyswietlZakres();
            else if (wybor == 0) System.out.println("Koniec programu.");
            else                 System.out.println("Niepoprawny wybór.");

        } while (wybor != 0);
    }
}