// Nazwałem klasę Ksiazka, bo to po prostu opisuje jedną książkę w księgarni.
public class Ksiazka {

    // 1. POLA KLASY (Zmienne)
    // Słowo "private" to jest właśnie ta enkapsulacja.
    // Znaczy to, że nikt z zewnątrz nie może bezpośrednio dotknąć tych danych.
    private String tytul;
    private String autor;
    private int liczbaStron;
    private int rokWydania;
    private double cena;

    // 2. KONSTRUKTOR
    // To jest specjalna metoda, która odpala się tylko raz, kiedy "tworzymy" nową książkę.
    // Tutaj ustawiamy początkowe wartości dla wszystkich naszych prywatnych zmiennych.
    public Ksiazka(String tytul, String autor, int liczbaStron, int rokWydania, double cena) {
        this.tytul = tytul;
        this.autor = autor;
        this.liczbaStron = liczbaStron;
        this.rokWydania = rokWydania;
        this.cena = cena;
    }

    // 3. GETTERY (Metody do odczytu)
    // Ponieważ pola są "private", musimy stworzyć publiczne "furtki", żeby móc je tylko przeczytać.
    // Zrobiłem gettery dla WSZYSTKICH pól, bo zadanie mówi, że można je odczytać.

    public String getTytul() {
        return tytul; // po prostu zwraca tytuł
    }

    public String getAutor() {
        return autor;
    }

    public int getLiczbaStron() {
        return liczbaStron;
    }

    public int getRokWydania() {
        return rokWydania;
    }

    public double getCena() {
        return cena;
    }

    // 4. SETTERY (Metody do zmiany wartości)
    // UWAGA: W zadaniu było napisane, że TYLKO cena może się zmieniać!
    // Dlatego robię settera tylko dla ceny. Dla reszty (tytuł, autor) NIE MA setterów.
    // Dzięki temu nikt nie zmieni nam tytułu po wydaniu książki!

    public void setCena(double nowaCena) {
        // Tu jako początkujący dodałem mały bonus - sprawdzam czy ktoś nie wpisał ujemnej ceny
        if (nowaCena > 0) {
            this.cena = nowaCena;
        } else {
            System.out.println("Błąd! Cena nie może być ujemna ani zerowa.");
        }
    }

    // 5. METODA MAIN - tutaj testuję czy mój kod działa
    public static void main(String[] args) {

        System.out.println("=== Witaj w mojej Księgarni! ===\n");

        // Tworzymy dwie przykładowe książki używając konstruktora
        Ksiazka ksiazka1 = new Ksiazka("Władca Pierścieni", "J.R.R. Tolkien", 1200, 1954, 89.99);
        Ksiazka ksiazka2 = new Ksiazka("Harry Potter", "J.K. Rowling", 320, 1997, 45.50);

        // Wyświetlamy dane pierwszej książki używając GETTERÓW (bo nie mamy bezpośredniego dostępu)
        System.out.println("Dane pierwszej książki:");
        System.out.println("Tytuł: " + ksiazka1.getTytul());
        System.out.println("Autor: " + ksiazka1.getAutor());
        System.out.println("Rok wydania: " + ksiazka1.getRokWydania());
        System.out.println("Cena początkowa: " + ksiazka1.getCena() + " zł\n");

        // Symulacja: Przyszła inflacja, musimy podnieść cenę Harry'ego Pottera!
        System.out.println("Zmieniamy cenę książki nr 2...");

        // ksiazka2.cena = 55.00; // <- TO BY WYWALIŁO BŁĄD! Pole jest 'private'
        ksiazka2.setCena(55.00); // Używamy naszego publicznego settera

        // Próba oszukania systemu (zmiana tytułu)
        // ksiazka2.setTytul("Władca Pottera"); // <- TO BY WYWALIŁO BŁĄD! Nie napisaliśmy takiej metody!

        System.out.println("Nowa cena za '" + ksiazka2.getTytul() + "' to: " + ksiazka2.getCena() + " zł");
    }
}