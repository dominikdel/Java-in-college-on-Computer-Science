/**
 * Klasa testowa dla Zadania 2.
 *
 * Kroki:
 *   1. Tworzy obiekty Punkt2D i Punkt3D, testuje konstruktory i toString().
 *   2. Tworzy dwie tablice 100-elementowe: array2D i array3D.
 *   3. Losuje wspolrzedne dla wszystkich elementow.
 *   4. Szuka par (p2D, p3D) takich, ze p2D.x == p3D.x ORAZ p2D.y == p3D.y.
 *   5. Wypisuje znalezione pary na ekranie (metoda toString()).
 */
public class MainZadanie2 {

    public static void main(String[] args) {

        System.out.println();

        // 1. Test pojedynczych obiektow
        Punkt2D p1 = new Punkt2D();         // konstruktor bezparametrowy
        Punkt2D p2 = new Punkt2D(3, -5);    // konstruktor parametryczny
        Punkt3D p3 = new Punkt3D();         // bezparametrowy
        Punkt3D p4 = new Punkt3D(1, 2, 3); // parametryczny

        System.out.println("Punkt2D (bezparametrowy): " + p1);
        System.out.println("Punkt2D (parametryczny):  " + p2);
        System.out.println("Punkt3D (bezparametrowy): " + p3);
        System.out.println("Punkt3D (parametryczny):  " + p4);

        p1.losujWspolrzedne();
        p3.losujWspolrzedne();
        System.out.println();
        System.out.println("Po losowaniu:");
        System.out.println("p1 losowy: " + p1);
        System.out.println("p3 losowy: " + p3);

        // 2. Tablice 100-elementowe
        Punkt2D[] array2D = new Punkt2D[100];
        Punkt3D[] array3D = new Punkt3D[100];

        // 3. Losowanie wspolrzednych
        for (int i = 0; i < 100; i++) {
            array2D[i] = new Punkt2D();
            array2D[i].losujWspolrzedne();
            array3D[i] = new Punkt3D();
            array3D[i].losujWspolrzedne();
        }

        // 4 & 5. Wyszukiwanie par ze wspolnymi (x, y)
        System.out.println();
        System.out.println("--- Pary punktow o wspolnych skladowych (x, y) ---");
        int licznikPar = 0;

        for (Punkt2D pkt2 : array2D) {
            for (Punkt3D pkt3 : array3D) {
                if (pkt2.getX() == pkt3.getX() && pkt2.getY() == pkt3.getY()) {
                    System.out.println("  Wspolne: " + pkt2 + "  <-->  " + pkt3);
                    licznikPar++;
                }
            }
        }

        if (licznikPar == 0) {
            System.out.println("  Nie znaleziono par o wspolnych wspolrzednych (x, y).");
        } else {
            System.out.println();
            System.out.println("Laczna liczba znalezionych par: " + licznikPar);
        }

        // Bonus: polimorfizm – tablica Punkt2D[] przechowuje Punkt3D
        System.out.println();
        System.out.println("--- Polimorfizm: Punkt2D[] przechowujacy Punkt3D ---");
        Punkt2D[] mieszana = new Punkt2D[4];
        mieszana[0] = new Punkt2D(1, 1);
        mieszana[1] = new Punkt3D(1, 1, 5);   // Punkt3D traktowany jako Punkt2D
        mieszana[2] = new Punkt2D(2, 3);
        mieszana[3] = new Punkt3D(2, 3, -7);

        for (Punkt2D p : mieszana) {
            // toString() wywoływane polimorficznie
            System.out.println("  " + p);
        }
    }
}
