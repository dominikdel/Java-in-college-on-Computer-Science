# Laboratorium 4 – Programowanie obiektowe w Java (klasy, enkapsulacja, konstruktory)

**Autor:** Dominik Delimata  
**Kierunek:** Informatyka, rok 1  
**Środowisko:** NetBeans IDE / IntelliJ IDEA, Java SE  

---

## Spis treści

### Projekt 1 – Dane osobowe
- [Klasa `Osoba`](#klasa-osoba)
- [Klasa `DaneOsobowe` – punkt startowy](#klasa-daneosobowe--punkt-startowy)

### Projekt 2 – Figury geometryczne
- [Klasa `Kolo`](#klasa-kolo)
- [Klasa `Kwadrat`](#klasa-kwadrat)
- [Klasa `Prostokat`](#klasa-prostokat)
- [Klasa `Szescian`](#klasa-szescian)
- [Klasa `Prostopadloscian`](#klasa-prostopadloscian)
- [Klasa `Kula`](#klasa-kula)
- [Klasa `Stozek`](#klasa-stozek)
- [Klasa `ObliczanieFigur` – punkt startowy](#klasa-obliczaniefigur--punkt-startowy)

### Projekt 3 – Studenci
- [Klasa `Student` (wersja podstawowa)](#klasa-student--wersja-podstawowa)
- [Klasa `StudenciMain`](#klasa-studencimain)
- [Klasa `Student` (wersja z getterami/setterami)](#klasa-student--wersja-z-getteramisetterami)
- [Klasa `BazaStudentow`](#klasa-bazastudentow)
- [Klasa `WprowadzDane` – punkt startowy](#klasa-wprowadzdane--punkt-startowy)

### Kluczowe pojęcia OOP
- [Słownik pojęć](#kluczowe-pojęcia-programowania-obiektowego)

---

## Projekt 1 – Dane osobowe

### Klasa `Osoba`

**Plik:** `Osoba.java` | **Pakiet:** `daneosobowe`

Klasa modeluje osobę z trzema polami prywatnymi. Demonstruje enkapsulację, trzy przeciążone konstruktory oraz walidację danych w setterze.

```java
package daneosobowe;

public class Osoba {
    // Pola prywatne – dostęp tylko przez gettery/settery
    private String imie;
    private String nazwisko;
    private int wiek;

    // Konstruktor pełny (3 parametry)
    public Osoba(String imie, String nazwisko, int wiek) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
    }

    // Konstruktor częściowy (2 parametry – bez wieku)
    public Osoba(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    // Konstruktor bezparametrowy (domyślny)
    public Osoba() { }

    // --- GETTERY ---
    public String getImie()    { return imie; }
    public String getNazwisko(){ return nazwisko; }
    public int    getWiek()    { return wiek; }

    // --- SETTERY ---
    public void setImie(String imie)       { this.imie = imie; }
    public void setNazwisko(String nazwisko){ this.nazwisko = nazwisko; }

    public void setWiek(int wiek) {
        if (wiek >= 0) {
            this.wiek = wiek;
        } else {
            System.out.println("Błąd: Wiek nie może być ujemny!");
        }
    }

    public void PokazDane() {
        System.out.println("Osoba");
        System.out.println("imię: "     + this.imie);
        System.out.println("nazwisko: " + this.nazwisko);
        System.out.println("wiek: "     + this.wiek + " lat");
    }
}
```

#### Wyjaśnienie elementów klasy `Osoba`

| Element | Opis |
|---|---|
| `private String imie` | Pole **prywatne** – niedostępne bezpośrednio z zewnątrz klasy; to jest zasada **enkapsulacji** |
| `public Osoba(...)` | **Konstruktor** – specjalna metoda wywoływana przy `new Osoba(...)`, inicjalizuje pola obiektu |
| Trzy konstruktory | **Przeciążenie konstruktora** (overloading) – ta sama nazwa, różna liczba parametrów; Java dobiera odpowiedni na podstawie argumentów |
| `this.imie = imie` | `this` odnosi się do **bieżącego obiektu** – rozróżnia pole klasy od parametru metody o tej samej nazwie |
| `public String getImie()` | **Getter** – metoda publiczna zwracająca wartość prywatnego pola; konwencja nazewnictwa: `get` + nazwa pola z wielkiej litery |
| `public void setWiek(int wiek)` | **Setter z walidacją** – kontroluje, czy podana wartość jest poprawna (wiek ≥ 0) zanim przypisze ją do pola |
| `void PokazDane()` | Metoda wypisująca wszystkie dane obiektu na konsolę |

---

### Klasa `DaneOsobowe` – punkt startowy

**Plik:** `DaneOsobowe.java` | **Pakiet:** `daneosobowe`

```java
package daneosobowe;

public class DaneOsobowe {
    public static void main(String[] args) {

        // Konstruktor pełny
        Osoba osoba1 = new Osoba("Jan", "Kowalski", 15);
        osoba1.PokazDane();

        // Konstruktor częściowy (bez wieku)
        Osoba osoba2 = new Osoba("Adam", "Nowak");
        osoba2.PokazDane();

        // Zmiana danych przez settery
        osoba2.setImie("Stefan");
        osoba2.setWiek(70);
        osoba2.PokazDane();

        // Konstruktor bezparametrowy + settery
        Osoba osoba3 = new Osoba();
        osoba3.setImie("Anna");
        osoba3.setNazwisko("Wiśniewska");
        osoba3.setWiek(45);
        osoba3.PokazDane();
    }
}
```

#### Wyjaśnienie

| Element | Opis |
|---|---|
| `new Osoba("Jan", "Kowalski", 15)` | Tworzy nowy obiekt klasy `Osoba` w pamięci; wywołuje konstruktor 3-argumentowy |
| `osoba2.setImie("Stefan")` | Modyfikacja pola przez setter – poprawna praktyka OOP zamiast `osoba2.imie = "Stefan"` (niedozwolone przy `private`) |
| `Osoba osoba3 = new Osoba()` | Konstruktor bezparametrowy – pola mają wartości domyślne (`null`, `0`); dane ustawiamy później setterami |

#### Przykładowy wynik
```
Osoba
imię: Jan
nazwisko: Kowalski
wiek: 15 lat
--------------------------------------------------
Osoba
imię: Adam
nazwisko: Nowak
wiek: 0 lat
--------------------------------------------------
Osoba
imię: Stefan
nazwisko: Nowak
wiek: 70 lat
--------------------------------------------------
Osoba
imię: Anna
nazwisko: Wiśniewska
wiek: 45 lat
```

---

## Projekt 2 – Figury geometryczne

Wszystkie klasy figur stosują ten sam wzorzec:
- Prywatne pola z wymiarami
- Konstruktor wywołujący settery (zapewnia walidację od razu)
- Settery z walidacją (`> 0`)
- Metody obliczeniowe (`pole()`, `obwod()`, `polePowierzchni()`, `objetosc()`)
- Metoda `pokazDane()` wypisująca wyniki

---

### Klasa `Kolo`

**Plik:** `Kolo.java` | **Pakiet:** `obliczaniefigur`

```java
public class Kolo {
    private double promien;

    public Kolo(double promien) {
        setPromien(promien); // konstruktor wywołuje setter – walidacja działa od razu
    }

    public void setPromien(double promien) {
        if (promien > 0) this.promien = promien;
        else System.out.println("Błąd: Promień musi być większy od 0!");
    }

    public double pole()   { return Math.PI * promien * promien; }
    public double obwod()  { return 2 * Math.PI * promien; }

    public void pokazDane() {
        System.out.println("=== Koło ===");
        System.out.printf("Promień: %.2f%n", promien);
        System.out.printf("Pole: %.2f%n", pole());
        System.out.printf("Obwód: %.2f%n", obwod());
    }
}
```

#### Wzory matematyczne

| Właściwość | Wzór | Implementacja Java |
|---|---|---|
| Pole | P = π · r² | `Math.PI * promien * promien` |
| Obwód | O = 2 · π · r | `2 * Math.PI * promien` |

---

### Klasa `Kwadrat`

**Plik:** `Kwadrat.java` | **Pakiet:** `obliczaniefigur`

```java
public class Kwadrat {
    private double bok;

    public Kwadrat(double bok) { setBok(bok); }

    public void setBok(double bok) {
        if (bok > 0) this.bok = bok;
        else System.out.println("Błąd: Bok musi być większy od 0!");
    }

    public double pole()  { return bok * bok; }
    public double obwod() { return 4 * bok; }

    public void pokazDane() {
        System.out.println("=== Kwadrat ===");
        System.out.printf("Bok: %.2f%n", bok);
        System.out.printf("Pole: %.2f%n", pole());
        System.out.printf("Obwód: %.2f%n", obwod());
    }
}
```

| Właściwość | Wzór | Implementacja Java |
|---|---|---|
| Pole | P = a² | `bok * bok` |
| Obwód | O = 4a | `4 * bok` |

---

### Klasa `Prostokat`

**Plik:** `Prostokat.java` | **Pakiet:** `obliczaniefigur`

```java
public class Prostokat {
    private double dlugosc;
    private double szerokosc;

    public Prostokat(double dlugosc, double szerokosc) {
        setDlugosc(dlugosc);
        setSzerokosc(szerokosc);
    }

    public void setDlugosc(double dlugosc) {
        if (dlugosc > 0) this.dlugosc = dlugosc;
        else System.out.println("Błąd: Długość musi być większa od 0!");
    }

    public void setSzerokosc(double szerokosc) {
        if (szerokosc > 0) this.szerokosc = szerokosc;
        else System.out.println("Błąd: Szerokość musi być większa od 0!");
    }

    public double pole()  { return dlugosc * szerokosc; }
    public double obwod() { return 2 * (dlugosc + szerokosc); }

    public void pokazDane() {
        System.out.println("=== Prostokąt ===");
        System.out.printf("Długość: %.2f%n", dlugosc);
        System.out.printf("Szerokość: %.2f%n", szerokosc);
        System.out.printf("Pole: %.2f%n", pole());
        System.out.printf("Obwód: %.2f%n", obwod());
    }
}
```

| Właściwość | Wzór | Implementacja Java |
|---|---|---|
| Pole | P = a · b | `dlugosc * szerokosc` |
| Obwód | O = 2(a + b) | `2 * (dlugosc + szerokosc)` |

---

### Klasa `Szescian`

**Plik:** `Szescian.java` | **Pakiet:** `obliczaniefigur`

```java
public class Szescian {
    private double bok;

    public Szescian(double bok) { setBok(bok); }

    public void setBok(double bok) {
        if (bok > 0) this.bok = bok;
        else System.out.println("Błąd: Bok musi być większy od 0!");
    }

    public double polePowierzchni() { return 6 * bok * bok; }
    public double objetosc()        { return bok * bok * bok; }

    public void pokazDane() {
        System.out.println("=== Sześcian ===");
        System.out.printf("Bok: %.2f%n", bok);
        System.out.printf("Pole powierzchni: %.2f%n", polePowierzchni());
        System.out.printf("Objętość: %.2f%n", objetosc());
    }
}
```

| Właściwość | Wzór | Implementacja Java |
|---|---|---|
| Pole powierzchni | P = 6a² | `6 * bok * bok` |
| Objętość | V = a³ | `bok * bok * bok` |

---

### Klasa `Prostopadloscian`

**Plik:** `Prostopadloscian.java` | **Pakiet:** `obliczaniefigur`

```java
public class Prostopadloscian {
    private double dlugosc;
    private double szerokosc;
    private double wysokosc;

    public Prostopadloscian(double dlugosc, double szerokosc, double wysokosc) {
        setDlugosc(dlugosc);
        setSzerokosc(szerokosc);
        setWysokosc(wysokosc);
    }

    // settery z walidacją dla każdego wymiaru...

    public double polePowierzchni() {
        return 2 * (dlugosc * szerokosc + szerokosc * wysokosc + dlugosc * wysokosc);
    }

    public double objetosc() { return dlugosc * szerokosc * wysokosc; }

    public void pokazDane() {
        System.out.println("=== Prostopadłościan ===");
        System.out.printf("Długość: %.2f%n", dlugosc);
        System.out.printf("Szerokość: %.2f%n", szerokosc);
        System.out.printf("Wysokość: %.2f%n", wysokosc);
        System.out.printf("Pole powierzchni: %.2f%n", polePowierzchni());
        System.out.printf("Objętość: %.2f%n", objetosc());
    }
}
```

| Właściwość | Wzór | Implementacja Java |
|---|---|---|
| Pole powierzchni | P = 2(ab + bc + ac) | `2 * (dlugosc*szerokosc + szerokosc*wysokosc + dlugosc*wysokosc)` |
| Objętość | V = a · b · c | `dlugosc * szerokosc * wysokosc` |

---

### Klasa `Kula`

**Plik:** `Kula.java` | **Pakiet:** `obliczaniefigur`

```java
public class Kula {
    private double promien;

    public Kula(double promien) { setPromien(promien); }

    public void setPromien(double promien) {
        if (promien > 0) this.promien = promien;
        else System.out.println("Błąd: Promień musi być większy od 0!");
    }

    public double polePowierzchni() { return 4 * Math.PI * promien * promien; }
    public double objetosc()        { return (4.0 / 3.0) * Math.PI * promien * promien * promien; }

    public void pokazDane() {
        System.out.println("=== Kula ===");
        System.out.printf("Promień: %.2f%n", promien);
        System.out.printf("Pole powierzchni: %.2f%n", polePowierzchni());
        System.out.printf("Objętość: %.2f%n", objetosc());
    }
}
```

| Właściwość | Wzór | Implementacja Java |
|---|---|---|
| Pole powierzchni | P = 4πr² | `4 * Math.PI * promien * promien` |
| Objętość | V = (4/3)πr³ | `(4.0 / 3.0) * Math.PI * promien * promien * promien` |

> **Uwaga:** `4.0 / 3.0` zamiast `4 / 3` – dzielenie całkowitoliczbowe `4/3` dałoby wynik `1` (obcięcie ułamka). Użycie `4.0` wymusza dzielenie zmiennoprzecinkowe, dając `1.333...`.

---

### Klasa `Stozek`

**Plik:** `Stozek.java` | **Pakiet:** `obliczaniefigur`

```java
public class Stozek {
    private double promien;
    private double wysokosc;

    public Stozek(double promien, double wysokosc) {
        setPromien(promien);
        setWysokosc(wysokosc);
    }

    // Tworząca – długość bocznej krawędzi stożka
    public double tworzaca() {
        return Math.sqrt(promien * promien + wysokosc * wysokosc);
    }

    public double polePowierzchni() {
        return Math.PI * promien * (promien + tworzaca());
    }

    public double objetosc() {
        return (1.0 / 3.0) * Math.PI * promien * promien * wysokosc;
    }

    public void pokazDane() {
        System.out.println("=== Stożek ===");
        System.out.printf("Promień: %.2f%n", promien);
        System.out.printf("Wysokość: %.2f%n", wysokosc);
        System.out.printf("Tworząca: %.2f%n", tworzaca());
        System.out.printf("Pole powierzchni: %.2f%n", polePowierzchni());
        System.out.printf("Objętość: %.2f%n", objetosc());
    }
}
```

| Właściwość | Wzór | Implementacja Java |
|---|---|---|
| Tworząca (l) | l = √(r² + h²) | `Math.sqrt(promien * promien + wysokosc * wysokosc)` |
| Pole powierzchni | P = π · r · (r + l) | `Math.PI * promien * (promien + tworzaca())` |
| Objętość | V = (1/3) · π · r² · h | `(1.0 / 3.0) * Math.PI * promien * promien * wysokosc` |

> **Tworząca** to długość odcinka od wierzchołka stożka do krawędzi podstawy – obliczana ze wzoru Pitagorasa (Twierdzenie Pitagorasa: c = √(a² + b²)).

---

### Klasa `ObliczanieFigur` – punkt startowy

**Plik:** `ObliczanieFigur.java` | **Pakiet:** `obliczaniefigur`

Klasa łączy wszystkie figury w jeden interaktywny kalkulator.

```java
public class ObliczanieFigur {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Wypisanie przykładowych obiektów (bez interakcji z użytkownikiem)
        new Kolo(5).pokazDane();
        new Kwadrat(4).pokazDane();
        new Prostokat(6, 3).pokazDane();
        new Szescian(4).pokazDane();
        new Prostopadloscian(5, 3, 2).pokazDane();
        new Kula(7).pokazDane();
        new Stozek(3, 5).pokazDane();

        // Kalkulator z menu
        int wybor;
        do {
            // wyświetlenie menu...
            wybor = sc.nextInt();
            if (wybor == 1) {
                System.out.print("Podaj promień: ");
                double r = sc.nextDouble();
                new Kolo(r).pokazDane();
            }
            // ... kolejne opcje dla innych figur
        } while (wybor != 0);
    }
}
```

#### Wyjaśnienie kluczowych elementów

| Element | Opis |
|---|---|
| `new Kolo(5).pokazDane()` | Tworzenie obiektu i wywołanie metody **w jednej linii** – obiekt anonimowy (nie przypisany do zmiennej); po wywołaniu `pokazDane()` zostanie usunięty przez Garbage Collector |
| `do { ... } while (wybor != 0)` | Pętla `do-while` – menu wyświetla się co najmniej raz; wychodzi po wpisaniu `0` |
| `sc.nextInt()` + `sc.nextDouble()` | `nextInt()` nie konsumuje znaku nowej linii – stąd brak `sc.nextLine()` po `nextDouble()` (kolejne `nextDouble()` działa poprawnie) |

---

## Projekt 3 – Studenci

### Klasa `Student` – wersja podstawowa

**Plik:** `Student.java` | **Pakiet:** `student`

Klasa z **czterema przeciążonymi konstruktorami** i walidacją w setterach.

```java
package student;

public class Student {
    private String imie;
    private String nazwisko;
    private int nr_indeksu;
    private String nazwa_specjalnosci;
    private int rok_studiow;

    // Konstruktor pełny (5 parametrów)
    public Student(String imie, String nazwisko, int nr_indeksu,
                   String nazwa_specjalnosci, int rok_studiow) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nr_indeksu = nr_indeksu;
        this.nazwa_specjalnosci = nazwa_specjalnosci;
        this.rok_studiow = rok_studiow;
    }

    // Konstruktor z 3 parametrami (bez specjalności i roku)
    public Student(String imie, String nazwisko, int nr_indeksu) { ... }

    // Konstruktor z nazwą specjalności (bez nr indeksu i roku)
    public Student(String imie, String nazwisko, String nazwa_specjalnosci) { ... }

    // Konstruktor z rokiem studiów (bez specjalności)
    public Student(String imie, String nazwisko, int nr_indeksu, int rok_studiow) { ... }

    // Setter z walidacją numeru indeksu
    public void setNr_indeksu(int nr_indeksu) {
        if (nr_indeksu > 0) {
            this.nr_indeksu = nr_indeksu;
        } else {
            System.out.println("Błąd: Numer indeksu musi być dodatni!");
        }
    }

    // Setter z walidacją roku studiów
    public void setRok_studiow(int rok_studiow) {
        if (rok_studiow > 0 && rok_studiow <= 5) {
            this.rok_studiow = rok_studiow;
        } else {
            System.out.println("Błąd: Rok studiów powinien mieścić się w przedziale od 1 do 5.");
        }
    }

    public void pokazDane() {
        System.out.println("=== Dane studenta ===");
        System.out.println("Imię: "        + this.imie);
        System.out.println("Nazwisko: "    + this.nazwisko);
        System.out.println("Nr indeksu: "  + this.nr_indeksu);
        System.out.println("Specjalność: " + this.nazwa_specjalnosci);
        System.out.println("Rok studiów: " + this.rok_studiow);
    }
}
```

#### Wyjaśnienie przeciążonych konstruktorów

Java dobiera właściwy konstruktor na podstawie **liczby i typów argumentów**:

| Wywołanie | Dopasowany konstruktor |
|---|---|
| `new Student("Jan", "Kowalski", 12345, "Informatyka", 2)` | 5-argumentowy |
| `new Student("Jan", "Kowalski", 12345)` | 3-argumentowy (int) |
| `new Student("Jan", "Kowalski", "Informatyka")` | 3-argumentowy (String) |
| `new Student("Jan", "Kowalski", 12345, 2)` | 4-argumentowy |

---

### Klasa `StudenciMain`

**Plik:** `StudenciMain.java` | **Pakiet:** `student`

```java
public class StudenciMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Podaj imię: ");
        String imie = sc.nextLine();
        System.out.print("Podaj nazwisko: ");
        String nazwisko = sc.nextLine();
        System.out.print("Podaj nr indeksu: ");
        int nr_indeksu = sc.nextInt();
        sc.nextLine();  // wyczyszczenie bufora po nextInt()
        System.out.print("Podaj nazwę specjalności: ");
        String specjalnosc = sc.nextLine();
        System.out.print("Podaj rok studiów: ");
        int rok = sc.nextInt();

        student.Student student = new student.Student(imie, nazwisko, nr_indeksu, specjalnosc, rok);
        student.pokazDane();

        // Symulacja awansu na kolejny rok za pomocą gettera i settera
        int aktualnyRok = student.getRok_studiow();   // getter pobiera wartość
        student.setRok_studiow(aktualnyRok + 1);      // setter ustawia nową wartość (z walidacją!)
        student.pokazDane();

        sc.close();
    }
}
```

#### Wyjaśnienie

| Element | Opis |
|---|---|
| `sc.nextLine()` po `sc.nextInt()` | `nextInt()` nie konsumuje znaku `\n` (Enter); wywołanie `nextLine()` bez odczytu "zjada" ten znak, zapobiegając pominięciu kolejnego `nextLine()` |
| `student.getRok_studiow()` | Odczyt wartości pola przez getter – poprawna praktyka zamiast `student.rok_studiow` |
| `student.setRok_studiow(aktualnyRok + 1)` | Setter sprawdzi, czy rok ≤ 5 – jeśli student jest na 5. roku, wypisze komunikat błędu |
| `student.Student student` | Pełna kwalifikowana nazwa klasy `student.Student` – stosowana gdy nazwa pakietu i klasy jest taka sama |

---

### Klasa `Student` – wersja z getterami/setterami

**Plik:** `Student.java` | **Pakiet:** `wprowadzdane`

Uproszczona wersja klasy `Student` przeznaczona do użycia w `BazaStudentow`. Jeden konstruktor pełny + komplet getterów i setterów.

```java
package wprowadzdane;

public class Student {
    private String imie;
    private String nazwisko;
    private int nr_indeksu;
    private String nazwa_specjalnosci;
    private int rok_studiow;

    public Student(String imie, String nazwisko, int nr_indeksu,
                   String nazwa_specjalnosci, int rok_studiow) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nr_indeksu = nr_indeksu;
        this.nazwa_specjalnosci = nazwa_specjalnosci;
        this.rok_studiow = rok_studiow;
    }

    // Gettery
    public String getImie()               { return imie; }
    public String getNazwisko()           { return nazwisko; }
    public int    getNr_indeksu()         { return nr_indeksu; }
    public String getNazwa_specjalnosci() { return nazwa_specjalnosci; }
    public int    getRok_studiow()        { return rok_studiow; }

    // Settery
    public void setImie(String imie)                           { this.imie = imie; }
    public void setNazwisko(String nazwisko)                   { this.nazwisko = nazwisko; }
    public void setNr_indeksu(int nr_indeksu)                  { this.nr_indeksu = nr_indeksu; }
    public void setNazwa_specjalnosci(String nazwa_specjalnosci){ this.nazwa_specjalnosci = nazwa_specjalnosci; }
    public void setRok_studiow(int rok_studiow)                { this.rok_studiow = rok_studiow; }

    public void pokazDane() {
        System.out.println("Imię: "          + imie);
        System.out.println("Nazwisko: "      + nazwisko);
        System.out.println("Nr indeksu: "    + nr_indeksu);
        System.out.println("Specjalność: "   + nazwa_specjalnosci);
        System.out.println("Rok studiów: "   + rok_studiow);
    }
}
```

---

### Klasa `BazaStudentow`

**Plik:** `BazaStudentow.java` | **Pakiet:** `wprowadzdane`

Klasa zarządzająca tablicą 100 obiektów `Student`. Implementuje operacje CRUD (Create, Read, Update, Delete).

```java
public class BazaStudentow {

    private static final int ROZMIAR = 100;
    private Student[] tablica = new Student[ROZMIAR];
    private Scanner sc = new Scanner(System.in);

    // Inicjalizacja tablicy pustymi obiektami
    public void inicjalizuj() {
        for (int i = 0; i < ROZMIAR; i++) {
            tablica[i] = new Student("", "", 0, "", 0);
        }
    }

    // Prywatna metoda pomocnicza – wczytuje dane studenta z klawiatury
    private Student wczytajStudenta() {
        System.out.print("Imię: ");      String imie = sc.nextLine();
        System.out.print("Nazwisko: ");  String nazwisko = sc.nextLine();
        System.out.print("Nr indeksu: "); int nr = sc.nextInt(); sc.nextLine();
        System.out.print("Specjalność: "); String spec = sc.nextLine();
        System.out.print("Rok studiów: "); int rok = sc.nextInt(); sc.nextLine();
        return new Student(imie, nazwisko, nr, spec, rok);
    }

    public void wprowadzDane() {
        System.out.print("Podaj indeks (0-99): ");
        int idx = sc.nextInt(); sc.nextLine();
        if (idx < 0 || idx >= ROZMIAR) { System.out.println("Niepoprawny indeks!"); return; }
        if (!tablica[idx].getImie().equals("")) {
            System.out.println("Pod tym indeksem już są dane! Użyj opcji Edycja.");
            return;
        }
        tablica[idx] = wczytajStudenta();
    }

    public void edytujDane() {
        // pobierz idx, wyświetl aktualne dane, wczytaj nowe
        tablica[idx].pokazDane();
        tablica[idx] = wczytajStudenta();
    }

    public void usunDane() {
        // pobierz idx, zastąp pustym obiektem
        tablica[idx] = new Student("", "", 0, "", 0);
    }

    public void wyswietlWszystkich() {
        for (int i = 0; i < ROZMIAR; i++) {
            if (!tablica[i].getImie().equals("")) {  // pomija puste rekordy
                System.out.println("--- Indeks [" + i + "] ---");
                tablica[i].pokazDane();
            }
        }
    }

    public void wyswietlZakres() {
        // pobierz od i do, wyświetl zakres [od..do]
    }
}
```

#### Wyjaśnienie kluczowych elementów

| Element | Opis |
|---|---|
| `private static final int ROZMIAR = 100` | **Stała** klasy (`final` = niemożliwa do zmiany, `static` = wspólna dla całej klasy); konwencja: nazwy stałych pisane WIELKIMI_LITERAMI |
| `private Student[] tablica = new Student[ROZMIAR]` | Tablica obiektów `Student` o rozmiarze 100; elementy to **referencje** do obiektów, nie same obiekty |
| `inicjalizuj()` | Wypełnia tablicę pustymi obiektami (`""`, `0`) zamiast `null` – zapobiega `NullPointerException` przy późniejszym wywołaniu `getImie()` |
| `private Student wczytajStudenta()` | **Prywatna metoda pomocnicza** – `private` oznacza dostęp tylko wewnątrz klasy; hermetyzuje logikę wczytywania, by nie duplikować kodu |
| `!tablica[idx].getImie().equals("")` | Sprawdza, czy slot jest zajęty; `!` neguje wynik `equals()` |
| `tablica[idx] = new Student("","",0,"",0)` | „Usunięcie" rekordu – zastąpienie obiektu studenta pustym; oryginał zostaje zwolniony przez Garbage Collector |

---

### Klasa `WprowadzDane` – punkt startowy

**Plik:** `WprowadzDane.java` | **Pakiet:** `wprowadzdane`

```java
public class WprowadzDane {
    public static void main(String[] args) {
        BazaStudentow baza = new BazaStudentow();
        Scanner sc = new Scanner(System.in);

        baza.inicjalizuj();  // WAŻNE: musi być wywołane przed użyciem bazy

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
```

#### Wyjaśnienie

| Element | Opis |
|---|---|
| `BazaStudentow baza = new BazaStudentow()` | Tworzy obiekt bazy danych; `baza` to zmienna przechowująca **referencję** do obiektu na stercie |
| `baza.inicjalizuj()` | Musi być wywołane jako pierwsze – bez inicjalizacji tablica zawiera `null`, a `getImie()` rzuciłoby `NullPointerException` |
| `sc.nextLine()` po `sc.nextInt()` | Standardowy trick – wyczyszczenie bufora wejściowego po odczytaniu liczby całkowitej |
| Delegowanie do metod bazy | `main` nie zawiera logiki biznesowej – tylko wywołuje odpowiednie metody obiektu `baza`; to wzorzec **separacji odpowiedzialności** |

---

## Kluczowe pojęcia programowania obiektowego

| Pojęcie | Opis | Przykład z laboratoriów |
|---|---|---|
| **Klasa** | Szablon/blueprint definiujący pola i metody | `class Osoba`, `class Kolo` |
| **Obiekt** | Konkretna instancja klasy w pamięci | `new Osoba("Jan", "Kowalski", 20)` |
| **Pole (atrybut)** | Zmienna należąca do klasy/obiektu | `private String imie` |
| **Metoda** | Funkcja należąca do klasy | `public double pole()` |
| **Konstruktor** | Specjalna metoda inicjalizująca obiekt; ma taką samą nazwę jak klasa | `public Kolo(double promien)` |
| **Przeciążenie** | Wiele metod/konstruktorów o tej samej nazwie, ale innych parametrach | 4 konstruktory w klasie `Student` |
| **Enkapsulacja** | Ukrywanie pól (`private`) i udostępnianie ich przez gettery/settery | `private double promien` + `getPromien()` |
| **Getter** | Publiczna metoda zwracająca wartość prywatnego pola | `public double getPromien() { return promien; }` |
| **Setter** | Publiczna metoda ustawiająca wartość prywatnego pola (z walidacją) | `public void setWiek(int wiek) { if (wiek >= 0) ... }` |
| **`this`** | Referencja do bieżącego obiektu; rozróżnia pole od parametru | `this.imie = imie` |
| **`private`** | Modyfikator dostępu – dostępne tylko wewnątrz tej samej klasy | `private int wiek` |
| **`public`** | Modyfikator dostępu – dostępne wszędzie | `public void pokazDane()` |
| **`static final`** | Stała klasy – jedna wartość wspólna dla wszystkich instancji, niemożliwa do zmiany | `private static final int ROZMIAR = 100` |
| **`Math.PI`** | Stała w Javie reprezentująca liczbę π ≈ 3.14159265... | `Math.PI * promien * promien` |
| **`Math.sqrt(x)`** | Metoda obliczająca pierwiastek kwadratowy z x | `Math.sqrt(r*r + h*h)` – tworząca stożka |
| **`System.out.printf`** | Formatowane wypisanie; `%.2f` – liczba z 2 miejscami po przecinku | `System.out.printf("Pole: %.2f%n", pole())` |
| **Garbage Collector** | Mechanizm JVM automatycznie zwalniający pamięć po obiektach bez referencji | Obiekty anonimowe `new Kolo(5).pokazDane()` |

---

## Jak uruchomić projekty

### Struktura plików

```
src/
├── daneosobowe/
│   ├── Osoba.java
│   └── DaneOsobowe.java          ← main()
├── obliczaniefigur/
│   ├── Kolo.java
│   ├── Kwadrat.java
│   ├── Prostokat.java
│   ├── Szescian.java
│   ├── Prostopadloscian.java
│   ├── Kula.java
│   ├── Stozek.java
│   └── ObliczanieFigur.java      ← main()
└── student/               └── wprowadzdane/
    ├── Student.java                ├── Student.java
    └── StudenciMain.java           ├── BazaStudentow.java
                                    └── WprowadzDane.java  ← main()
```

### Kroki w NetBeans

1. Utwórz nowy projekt **Java Application**
2. Utwórz odpowiednie pakiety w `src/` (kliknij prawym na `src` → New Package)
3. Dodaj pliki `.java` do odpowiednich pakietów
4. Uruchom klasę z metodą `main()` skrótem **`Shift + F6`**

### Kompilacja z linii poleceń

```bash
# Kompilacja całego projektu (z katalogu src/)
javac daneosobowe/*.java
java daneosobowe.DaneOsobowe

javac obliczaniefigur/*.java
java obliczaniefigur.ObliczanieFigur

javac wprowadzdane/*.java
java wprowadzdane.WprowadzDane
```
