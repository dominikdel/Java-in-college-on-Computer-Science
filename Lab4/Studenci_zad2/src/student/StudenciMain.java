package student;

import java.util.Scanner;

public class StudenciMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Wprowadzanie danych studenta ===\n");

        System.out.print("Podaj imię: ");
        String imie = sc.nextLine();

        System.out.print("Podaj nazwisko: ");
        String nazwisko = sc.nextLine();

        System.out.print("Podaj nr indeksu: ");
        int nr_indeksu = sc.nextInt();
        sc.nextLine();

        System.out.print("Podaj nazwę specjalności: ");
        String specjalnosc = sc.nextLine();

        System.out.print("Podaj rok studiów: ");
        int rok = sc.nextInt();

        // Tworzenie obiektu za pomocą konstruktora
        student.Student student = new student.Student(imie, nazwisko, nr_indeksu, specjalnosc, rok);

        System.out.println("\n--- Wprowadzone dane ---");
        student.pokazDane();

        // Przykład użycia settera - symulacja awansu na kolejny rok
        System.out.println("\n--- Symulacja: Student zdaje na kolejny rok ---");
        int aktualnyRok = student.getRok_studiow(); // Pobieramy aktualny rok getterem
        student.setRok_studiow(aktualnyRok + 1);    // Zwiększamy o 1 setterem
        student.pokazDane();

        sc.close();
    }
}