    package obliczaniefigur;

    import java.util.Scanner;

    public class ObliczanieFigur {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            // Przykładowe obiekty - wyniki bez menu
            System.out.println("========== PRZYKŁADOWE OBIEKTY ==========");
            new Kolo(5).pokazDane();            System.out.println();
            new Kwadrat(4).pokazDane();         System.out.println();
            new Prostokat(6, 3).pokazDane();    System.out.println();
            new Szescian(4).pokazDane();        System.out.println();
            new Prostopadloscian(5, 3, 2).pokazDane(); System.out.println();
            new Kula(7).pokazDane();            System.out.println();
            new Stozek(3, 5).pokazDane();      System.out.println();

            // Kalkulator z menu
            System.out.println("========== KALKULATOR FIGUR ==========");
            int wybor;

            do {
                System.out.println("\nWybierz figurę:");
                System.out.println("[1] Koło");
                System.out.println("[2] Kwadrat");
                System.out.println("[3] Prostokąt");
                System.out.println("[4] Sześcian");
                System.out.println("[5] Prostopadłościan");
                System.out.println("[6] Kula");
                System.out.println("[7] Stożek");
                System.out.println("[0] Wyjście");
                System.out.print("Twój wybór: ");
                wybor = sc.nextInt();
                System.out.println();

                if (wybor == 1) {
                    System.out.print("Podaj promień: ");
                    double r = sc.nextDouble();
                    new Kolo(r).pokazDane();

                } else if (wybor == 2) {
                    System.out.print("Podaj bok: ");
                    double b = sc.nextDouble();
                    new Kwadrat(b).pokazDane();

                } else if (wybor == 3) {
                    System.out.print("Podaj długość: ");
                    double d = sc.nextDouble();
                    System.out.print("Podaj szerokość: ");
                    double s = sc.nextDouble();
                    new Prostokat(d, s).pokazDane();

                } else if (wybor == 4) {
                    System.out.print("Podaj bok: ");
                    double b = sc.nextDouble();
                    new Szescian(b).pokazDane();

                } else if (wybor == 5) {
                    System.out.print("Podaj długość: ");
                    double d = sc.nextDouble();
                    System.out.print("Podaj szerokość: ");
                    double s = sc.nextDouble();
                    System.out.print("Podaj wysokość: ");
                    double h = sc.nextDouble();
                    new Prostopadloscian(d, s, h).pokazDane();

                } else if (wybor == 6) {
                    System.out.print("Podaj promień: ");
                    double r = sc.nextDouble();
                    new Kula(r).pokazDane();

                } else if (wybor == 7) {
                    System.out.print("Podaj promień podstawy: ");
                    double r = sc.nextDouble();
                    System.out.print("Podaj wysokość: ");
                    double h = sc.nextDouble();
                    new Stozek(r, h).pokazDane();

                } else if (wybor == 0) {
                    System.out.println("Koniec programu.");
                } else {
                    System.out.println("Niepoprawny wybór.");
                }

            } while (wybor != 0);

            sc.close();
        }
    }
