package daneosobowe;

public class DaneOsobowe {
    public static void main(String[] args) {
        Osoba osoba1 = new Osoba("Jan", "Kowalski", 15);
        osoba1.PokazDane();

        System.out.println("--------------------------------------------------");
        Osoba osoba2 = new Osoba("Adam", "Nowak");
        osoba2.PokazDane();

        System.out.println("--------------------------------------------------");
        // Używamy setterów zamiast bezpośredniego dostępu do pól
        osoba2.setImie("Stefan");
        osoba2.setWiek(70);
        osoba2.PokazDane();

        System.out.println("--------------------------------------------------");
        Osoba osoba3 = new Osoba();
        // Ustawiamy dane za pomocą setterów
        osoba3.setImie("Anna");
        osoba3.setNazwisko("Wiśniewska");
        osoba3.setWiek(45);
        osoba3.PokazDane();
    }
}