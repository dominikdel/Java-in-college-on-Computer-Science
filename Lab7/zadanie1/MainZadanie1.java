/**
 * Klasa testowa dla Zadania 1.
 *
 * Demonstracja hierarchii: Osoba <-- Student, Wykladowca
 * Testuje: konstruktory, gettery, przeslonieta toString(),
 *          polimorfizm przez tablice Osoba[], operator instanceof.
 */
public class MainZadanie1 {

    public static void main(String[] args) {
        Osoba osoba = new Osoba("Jan", "Kowalski", "01-01-1990", "M");

        Student student = new Student(
            "Dominik", "Delimata", "10-11-2004", "M",
            "141319", "stacjonarne", "Informatyka", 2
        );

        Wykladowca wykladowca = new Wykladowca(
            "Piotr", "Wisniewski", "20-06-1975", "M",
            "w001", "dr hab.",
            "Katedra Informatyki", "Programowanie obiektowe", 15
        );

        System.out.println("--- Obiekt Osoba ---");
        System.out.println(osoba);

        System.out.println();
        System.out.println("--- Obiekt Student ---");
        System.out.println(student);

        System.out.println();
        System.out.println("--- Obiekt Wykladowca ---");
        System.out.println(wykladowca);

        // Polimorfizm: tablica nadklasy przechowuje obiekty roznych podklas
        System.out.println();
        System.out.println("--- Polimorfizm: tablica Osoba[] ---");
        Osoba[] osoby = { osoba, student, wykladowca };
        for (Osoba o : osoby) {
            // Wywoływana jest metoda toString() odpowiednia dla rzeczywistego typu
            System.out.println(o);
        }

        System.out.println();
        System.out.println("--- Sprawdzenie instanceof ---");
        for (Osoba o : osoby) {
            System.out.println(o.getNazwisko()
                + " -> Student? "    + (o instanceof Student)
                + " | Wykladowca? " + (o instanceof Wykladowca));
        }
    }
}
