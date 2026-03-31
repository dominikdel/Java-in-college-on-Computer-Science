# Laboratorium 2 – Typy zmiennych i instrukcje sterujące w Java

**Autor:** Dominik Delimata  
**Kierunek:** Informatyka, rok 1  
**Środowisko:** NetBeans IDE / IntelliJ IDEA, Java SE  

---

## Spis treści

1. [Zadanie 1 – Trójmian kwadratowy (delta)](#zadanie-1--trójmian-kwadratowy-delta)
2. [Zadanie 2 – Kalkulator z funkcjami trygonometrycznymi](#zadanie-2--kalkulator-z-funkcjami-trygonometrycznymi)
3. [Zadanie 3 – Operacje na tablicy 10 elementów](#zadanie-3--operacje-na-tablicy-10-elementów)
4. [Zadanie 4 – Statystyki tablicy (suma, iloczyn, min, max)](#zadanie-4--statystyki-tablicy-suma-iloczyn-min-max)
5. [Zadanie 5 – Pętla z instrukcją continue](#zadanie-5--pętla-z-instrukcją-continue)
6. [Zadanie 6 – Pętla nieskończona z instrukcją break](#zadanie-6--pętla-nieskończona-z-instrukcją-break)
7. [Zadanie 7 – Sortowanie: bąbelkowe i przez wstawianie](#zadanie-7--sortowanie-bąbelkowe-i-przez-wstawianie)
8. [Kluczowe pojęcia Java](#kluczowe-pojęcia-java)
9. [Jak uruchomić projekty](#jak-uruchomić-projekty)

---

## Zadanie 1 – Trójmian kwadratowy (delta)

### Opis zadania
Napisać program obliczający wyróżnik delta oraz pierwiastki trójmianu kwadratowego \(ax^2 + bx + c = 0\) na podstawie danych wprowadzonych przez użytkownika.

### Kod źródłowy

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanIn = new Scanner(System.in);

        System.out.print("Podaj a: ");
        double a = scanIn.nextDouble();
        System.out.print("Podaj b: ");
        double b = scanIn.nextDouble();
        System.out.print("Podaj c: ");
        double c = scanIn.nextDouble();

        if (a == 0) {
            System.out.println("To nie jest trójmian kwadratowy (a = 0).");
            scanIn.close();
            return;
        }

        double delta = b * b - 4 * a * c;
        System.out.println("Delta = " + delta);

        if (delta > 0) {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("Dwa pierwiastki rzeczywiste:");
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        } else if (delta == 0) {
            double x = (-b) / (2 * a);
            System.out.println("Jeden (podwójny) pierwiastek rzeczywisty:");
            System.out.println("x = " + x);
        } else {
            System.out.println("Brak pierwiastków rzeczywistych (delta < 0).");
        }

        scanIn.close();
    }
}
```

### Wyjaśnienie kodu

| Element | Opis |
|---|---|
| `double a, b, c` | Zmienne typu `double` przechowujące współczynniki trójmianu; `double` obsługuje liczby rzeczywiste (z przecinkiem) |
| `if (a == 0)` | Walidacja danych wejściowych – gdy `a = 0`, wyrażenie nie jest trójmianem kwadratowym; `return` kończy metodę natychmiast |
| `double delta = b*b - 4*a*c` | Obliczenie wyróżnika (delty) ze wzoru **Δ = b² − 4ac** |
| `Math.sqrt(delta)` | Metoda z klasy `Math` obliczająca pierwiastek kwadratowy z argumentu |
| `(-b + Math.sqrt(delta)) / (2 * a)` | Wzór na pierwszy pierwiastek: **x₁ = (−b + √Δ) / (2a)** |
| `(-b - Math.sqrt(delta)) / (2 * a)` | Wzór na drugi pierwiastek: **x₂ = (−b − √Δ) / (2a)** |
| `(-b) / (2 * a)` | Wzór na pierwiastek podwójny (gdy Δ = 0): **x = −b / (2a)** |

### Przypadki działania programu

| Wartość delty | Wynik |
|---|---|
| Δ > 0 | Dwa różne pierwiastki rzeczywiste: x1 i x2 |
| Δ = 0 | Jeden podwójny pierwiastek rzeczywisty: x |
| Δ < 0 | Brak pierwiastków rzeczywistych |

### Przykładowy wynik
```
Podaj a: 1
Podaj b: -5
Podaj c: 6
Delta = 1.0
Dwa pierwiastki rzeczywiste:
x1 = 3.0
x2 = 2.0
```

---

## Zadanie 2 – Kalkulator z funkcjami trygonometrycznymi

### Opis zadania
Napisać kalkulator obsługujący podstawowe działania arytmetyczne (suma, różnica, iloczyn, iloraz), potęgowanie, pierwiastkowanie oraz funkcje trygonometryczne (sin, cos, tan, ctan). Menu obsłużone za pomocą `switch-case` i pętli `do-while`.

### Kod źródłowy

```java
import java.util.Scanner;
import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanIn = new Scanner(System.in);

        int wybor;
        System.out.print("Podaj liczbe a: ");
        double a = scanIn.nextDouble();
        System.out.print("Podaj liczbe b: ");
        double b = scanIn.nextDouble();
        System.out.print("Podaj kat [w stopniach] (dla obliczen 7-10): ");
        double katWStopniach = scanIn.nextDouble();
        double rad = toRadians(katWStopniach);

        do {
            System.out.print("Podaj numer dzialania: \n[1] dodawanie \n[2] odejmowanie \n[3] mnozenie \n[4] dzielenie \n[5] potega \n[6] pierwiastkowanie \n[7] sinus \n[8] cosinus \n[9] tanges \n[10] cotanges \n[0] Wyjscie z programu \n");
            wybor = scanIn.nextInt();

            switch (wybor) {
                case 1: System.out.print("Suma = " + (a + b) + "\n\n"); break;
                case 2: System.out.print("Roznica = " + (a - b) + "\n\n"); break;
                case 3: System.out.print("Iloczyn = " + (a * b) + "\n\n"); break;
                case 4:
                    if (b == 0) { System.out.print("Nie mozna dzielic przez zero!"); }
                    else { System.out.print("Iloraz = " + (a / b)); }
                    System.out.print("\n\n"); break;
                case 5: System.out.println("Potega = " + pow(a, b) + "\n\n"); break;
                case 6:
                    double root = Math.pow(a, 1.0 / b);
                    System.out.println("Pierwiastek b-stopnia z a = " + root + "\n\n"); break;
                case 7:  System.out.print("Sin(x) = " + sin(rad) + "\n\n"); break;
                case 8:  System.out.print("Cos(x) = " + cos(rad) + "\n\n"); break;
                case 9:  System.out.print("Tan(x) = " + tan(rad) + "\n\n"); break;
                case 10:
                    if (tan(rad) == 0.0) { System.out.println("ctan(x) = nie istnieje (tan(x)=0)"); }
                    else { System.out.println("ctan(x) = " + (1.0 / tan(rad))); }
                    System.out.print("\n\n"); break;
                default: System.out.print("Koniec programu\n\n"); break;
            }
        } while (wybor != 0);
    }
}
```

### Wyjaśnienie kodu

| Element | Opis |
|---|---|
| `import static java.lang.Math.*` | Import statyczny – umożliwia używanie metod klasy `Math` bez prefixu (np. `sin()` zamiast `Math.sin()`) |
| `toRadians(katWStopniach)` | Konwertuje kąt ze stopni na radiany – funkcje trygonometryczne w Javie przyjmują kąt w radianach |
| Pętla `do-while` | Wykonuje ciało pętli **przynajmniej raz**, a następnie sprawdza warunek (`wybor != 0`) – idealna do menu |
| `switch (wybor)` | Instrukcja wielowariantowego wyboru – porównuje wartość `wybor` z kolejnymi etykietami `case` |
| `break` | Przerywa wykonanie `switch` po dopasowanym `case` – bez niego kod „przeleciałby" do następnego case |
| `pow(a, b)` | Oblicza `a` do potęgi `b` (metoda z `java.lang.Math`) |
| `Math.pow(a, 1.0/b)` | Oblicza pierwiastek b-tego stopnia z a – korzysta ze wzoru: ⁿ√a = a^(1/n) |
| `if (b == 0)` | Obsługa dzielenia przez zero – wypisuje komunikat błędu zamiast rzucać wyjątek `ArithmeticException` |
| `1.0 / tan(rad)` | Cotangens obliczany jako odwrotność tangensa: **ctan(x) = 1 / tan(x)** |

### Opcje menu kalkulatora

| Nr | Operacja | Wzór |
|---|---|---|
| 1 | Dodawanie | a + b |
| 2 | Odejmowanie | a − b |
| 3 | Mnożenie | a × b |
| 4 | Dzielenie | a / b (z obsługą dzielenia przez 0) |
| 5 | Potęgowanie | a^b |
| 6 | Pierwiastkowanie | ⁿ√a |
| 7 | Sinus | sin(x) |
| 8 | Cosinus | cos(x) |
| 9 | Tangens | tan(x) |
| 10 | Cotangens | ctan(x) = 1/tan(x) |
| 0 | Wyjście | — |

---

## Zadanie 3 – Operacje na tablicy 10 elementów

### Opis zadania
Program wczytuje 10 liczb rzeczywistych do tablicy i umożliwia wyświetlanie jej zawartości na 4 sposoby. Menu obsłużone przy użyciu `else-if` i pętli `do-while`.

### Kod źródłowy

```java
import java.util.Scanner;

void main() {
    Scanner scanIn = new Scanner(System.in);

    double[] tablica = new double[10];

    for (int i = 0; i < tablica.length; i++) {
        System.out.print("Podaj element tablicy [" + i + "]: ");
        tablica[i] = scanIn.nextDouble();
    }

    int wybor;
    do {
        System.out.println("\nWybierz opcje:");
        System.out.println("[1] Wypisanie tablicy od 0 do końca");
        System.out.println("[2] Wypisanie tablicy od końca do 0");
        System.out.println("[3] Elementy o nieparzystych indeksach");
        System.out.println("[4] Elementy o parzystych indeksach");
        System.out.println("[0] Wyjście");
        System.out.print("Odpowiedz: ");
        wybor = scanIn.nextInt();

        if (wybor == 1) {
            for (int i = 0; i < tablica.length; i++)
                System.out.print(tablica[i] + " ");
            System.out.println();

        } else if (wybor == 2) {
            for (int i = tablica.length - 1; i >= 0; i--)
                System.out.print(tablica[i] + " ");
            System.out.println();

        } else if (wybor == 3) {
            for (int i = 0; i < tablica.length; i++)
                if (i % 2 != 0) System.out.print(tablica[i] + " ");
            System.out.println();

        } else if (wybor == 4) {
            for (int i = 0; i < tablica.length; i++)
                if (i % 2 == 0) System.out.print(tablica[i] + " ");
            System.out.println();

        } else if (wybor == 0) {
            System.out.println("Koniec programu.");
        } else {
            System.out.println("Niepoprawny wybór.");
        }

    } while (wybor != 0);
}
```

### Wyjaśnienie kodu

| Element | Opis |
|---|---|
| `double[] tablica = new double[10]` | Deklaracja tablicy 10 elementów typu `double`; indeksy od 0 do 9 |
| `tablica.length` | Właściwość zwracająca liczbę elementów tablicy (tutaj: 10); lepsza niż wpisanie liczby na stałe |
| Pętla rosnąca `i = 0; i < tablica.length; i++` | Iteracja od indeksu 0 do 9 – wyświetla tablicę w normalnej kolejności |
| Pętla malejąca `i = tablica.length - 1; i >= 0; i--` | Iteracja od indeksu 9 do 0 – wyświetla tablicę w odwróconej kolejności |
| `i % 2 != 0` | Operator modulo (reszta z dzielenia); gdy różna od 0 → indeks nieparzysty (1, 3, 5, 7, 9) |
| `i % 2 == 0` | Gdy reszta = 0 → indeks parzysty (0, 2, 4, 6, 8) |
| `do-while` + `else-if` | Pętla gwarantuje wyświetlenie menu minimum raz; `else-if` obsługuje kolejne opcje |

---

## Zadanie 4 – Statystyki tablicy (suma, iloczyn, min, max)

### Opis zadania
Program wczytuje 10 liczb rzeczywistych i wykonuje operacje statystyczne: suma, iloczyn, średnia, minimum, maksimum. Menu obsłużone za pomocą `switch-case`.

### Kod źródłowy

```java
void main() {
    Scanner scanIn = new Scanner(System.in);

    double[] tablica = new double[10];
    double Suma = 0;
    double Iloczyn = 1;
    double Srednia = 0;
    int wybor;

    for (int i = 0; i < tablica.length; i++) {
        System.out.print("Podaj element tablicy [" + i + "]: ");
        tablica[i] = scanIn.nextDouble();
    }

    System.out.print("\nWybierz opcje od 1-5.\n");
    System.out.print("\n[1] Oblicz sume elementow tablicy");
    System.out.print("\n[2] Oblicz iloczyn elementow tablicy");
    System.out.print("\n[3] Wyznacz wartosc srednia");
    System.out.print("\n[4] Wyznacz wartosc minimalna");
    System.out.print("\n[5] Wyznacz wartosc maksymalna\n");
    System.out.print("Odpowiedz: ");
    wybor = scanIn.nextInt();

    switch (wybor) {
        case 1:
            for (int i = 0; i < tablica.length; i++) Suma += tablica[i];
            System.out.print("Suma = " + Suma + "\n"); break;

        case 2:
            for (int i = 0; i < tablica.length; i++) Iloczyn *= tablica[i];
            System.out.print("Iloczyn = " + Iloczyn + "\n"); break;

        case 3:
            for (int i = 0; i < tablica.length; i++) Suma += tablica[i];
            Srednia = Suma / tablica.length;
            System.out.print("Srednia = " + Srednia + "\n"); break;

        case 4:
            double Min = tablica[0];
            for (int i = 1; i < tablica.length; i++)
                if (tablica[i] < Min) Min = tablica[i];
            System.out.println("Najmniejsza liczba: " + Min); break;

        case 5:
            double Max = tablica[0];
            for (int i = 1; i < tablica.length; i++)
                if (tablica[i] > Max) Max = tablica[i];
            System.out.println("Największa liczba: " + Max); break;

        default:
            System.out.print("Koniec programu"); break;
    }
}
```

### Wyjaśnienie kodu

| Element | Opis |
|---|---|
| `double Suma = 0` | Inicjalizacja sumy na 0 – element neutralny dla dodawania |
| `double Iloczyn = 1` | Inicjalizacja iloczynu na 1 – element neutralny dla mnożenia (0 wyzerowałoby wynik) |
| `Suma += tablica[i]` | Skrót od `Suma = Suma + tablica[i]` – dodaje kolejny element do sumy |
| `Iloczyn *= tablica[i]` | Skrót od `Iloczyn = Iloczyn * tablica[i]` – mnoży kolejny element |
| `Suma / tablica.length` | Wartość średnia = suma wszystkich elementów / liczba elementów |
| `Min = tablica[0]` | Inicjalizacja minimum pierwszym elementem tablicy – poprawna praktyka (zamiast np. 0, co dałoby błędny wynik dla samych liczb ujemnych) |
| Pętla od `i = 1` | Porównywanie zaczynamy od drugiego elementu, bo pierwszy jest już przypisany jako Min/Max |

### Algorytmy w skrócie

- **Suma:** `S = a₀ + a₁ + ... + a₉`
- **Iloczyn:** `P = a₀ × a₁ × ... × a₉`
- **Średnia:** `Ā = S / n`
- **Minimum/Maksimum:** liniowe przeszukiwanie tablicy z porównaniem

---

## Zadanie 5 – Pętla z instrukcją `continue`

### Opis zadania
Napisać program wyświetlający liczby od 20 do 0, pomijając liczby `{2, 6, 9, 15, 19}` za pomocą instrukcji `continue`.

### Kod źródłowy

```java
void main() {
    for (int i = 20; i >= 0; i--) {
        if (i == 19 || i == 15 || i == 9 || i == 6 || i == 2) {
            continue;
        }
        System.out.print(i);
        System.out.print("\n");
    }
}
```

### Wyjaśnienie kodu

| Element | Opis |
|---|---|
| `for (int i = 20; i >= 0; i--)` | Pętla malejąca: startuje od 20, kończy na 0, dekrementuje o 1 przy każdej iteracji |
| `i == 19 \|\| i == 15 \|\| ...` | Operator `\|\|` (logiczne OR) – warunek jest prawdziwy, gdy `i` jest równe **którejkolwiek** z wykluczonych liczb |
| `continue` | Instrukcja pomijająca resztę ciała pętli w bieżącej iteracji i przechodząca do **następnej** – liczba nie zostaje wypisana |

### Przykładowy wynik
```
20
18
17
16
14
13
12
11
10
8
7
5
4
3
1
0
```

---

## Zadanie 6 – Pętla nieskończona z instrukcją `break`

### Opis zadania
Napisać program, który w nieskończoność pyta użytkownika o liczby całkowite i kończy działanie, gdy wprowadzona liczba jest mniejsza lub równa zero. Do wyjścia z pętli użyć instrukcji `break`.

### Kod źródłowy

```java
import java.util.Scanner;

void main() {
    Scanner scanIn = new Scanner(System.in);

    while (true) {
        System.out.print("Podaj liczbę: ");
        int x = scanIn.nextInt();

        if (x <= 0) {
            break;
        }
    }
}
```

### Wyjaśnienie kodu

| Element | Opis |
|---|---|
| `while (true)` | Pętla nieskończona – warunek zawsze jest `true`, więc bez `break` działałaby w nieskończoność |
| `int x = scanIn.nextInt()` | Odczytuje jedną liczbę całkowitą z klawiatury |
| `if (x <= 0)` | Warunek wyjścia: gdy liczba ≤ 0 (ujemna lub zero), pętla zostaje przerwana |
| `break` | Natychmiast przerywa wykonanie pętli i przechodzi do kodu za pętlą |

### Dwie równoważne formy pętli nieskończonej

```java
// Forma 1
while (true) {
    // ciało pętli
}

// Forma 2
for (;;) {
    // ciało pętli
}
```

---

## Zadanie 7 – Sortowanie: bąbelkowe i przez wstawianie

### Opis zadania
Napisać program wczytujący n liczb rzeczywistych i sortujący je jedną z dwóch metod: sortowaniem bąbelkowym (Bubble Sort) lub przez wstawianie (Insertion Sort).

### Kod źródłowy

```java
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    // Sortowanie bąbelkowe
    static void bubbleSort(double[] a) {
        int n = a.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    double tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) break; // optymalizacja: brak zamian = tablica już posortowana
        }
    }

    // Sortowanie przez wstawianie
    static void insertionSort(double[] a) {
        for (int i = 1; i < a.length; i++) {
            double key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Podaj n: ");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("n musi być > 0");
            return;
        }

        double[] tab = new double[n];
        for (int i = 0; i < tab.length; i++) {
            System.out.print("Podaj liczbę [" + i + "]: ");
            tab[i] = sc.nextDouble();
        }

        System.out.println("\nWybierz metodę sortowania:");
        System.out.println("1 - Bąbelkowe");
        System.out.println("2 - Przez wstawianie");
        System.out.print("Twój wybór: ");
        int wybor = sc.nextInt();

        System.out.println("\nPrzed sortowaniem: " + Arrays.toString(tab));

        if (wybor == 1) {
            bubbleSort(tab);
        } else if (wybor == 2) {
            insertionSort(tab);
        } else {
            System.out.println("Niepoprawny wybór.");
            return;
        }

        System.out.println("Po sortowaniu:    " + Arrays.toString(tab));
    }
}
```

### Wyjaśnienie – Bubble Sort (sortowanie bąbelkowe)

| Element | Opis |
|---|---|
| Zewnętrzna pętla `i` | Każdy przebieg „wypycha" największy nieposortowany element na koniec tablicy |
| Wewnętrzna pętla `j` | Porównuje sąsiednie pary elementów: `a[j]` z `a[j+1]` |
| Zamiana przez `tmp` | Klasyczna zamiana dwóch wartości przez zmienną tymczasową: `tmp = a[j]; a[j] = a[j+1]; a[j+1] = tmp` |
| Flaga `swapped` | Optymalizacja: jeśli w danym przebiegu nie było żadnej zamiany, tablica jest już posortowana → `break` kończy algorytm wcześniej |
| `n - 1 - i` | Każdy przebieg skraca zakres wewnętrznej pętli o 1, bo ostatnie `i` elementów jest już na właściwym miejscu |

### Wyjaśnienie – Insertion Sort (sortowanie przez wstawianie)

| Element | Opis |
|---|---|
| `double key = a[i]` | Zapamiętuje bieżący element do wstawienia |
| Pętla `while (j >= 0 && a[j] > key)` | Przesuwa elementy większe od `key` o jedną pozycję w prawo, robiąc miejsce |
| `a[j + 1] = key` | Wstawia `key` na właściwe (wolne) miejsce w posortowanej części tablicy |
| Złożoność | Średnio O(n²), ale efektywne dla małych lub prawie posortowanych tablic |

### Porównanie algorytmów sortowania

| Cecha | Bubble Sort | Insertion Sort |
|---|---|---|
| Złożoność średnia | O(n²) | O(n²) |
| Złożoność – best case | O(n) z flagą `swapped` | O(n) |
| Stabilność | Stabilny | Stabilny |
| Łatwość implementacji | Bardzo prosta | Prosta |
| Praktyczne użycie | Edukacyjnie | Małe/prawie posortowane zbiory |

### Metoda `Arrays.toString()`

```java
System.out.println(Arrays.toString(tab));
// Wynik: [3.0, 1.5, 7.2, 2.8]
```

Metoda z klasy `java.util.Arrays` – wypisuje zawartość tablicy w czytelnym formacie `[el0, el1, ..., elN]`. Bez niej `System.out.println(tab)` wypisałby adres tablicy w pamięci.

### Przykładowy wynik
```
Podaj n: 5
Podaj liczbę [0]: 4.5
Podaj liczbę [1]: 1.2
Podaj liczbę [2]: 7.8
Podaj liczbę [3]: 3.3
Podaj liczbę [4]: 5.0

Wybierz metodę sortowania:
1 - Bąbelkowe
2 - Przez wstawianie
Twój wybór: 1

Przed sortowaniem: [4.5, 1.2, 7.8, 3.3, 5.0]
Po sortowaniu:    [1.2, 3.3, 4.5, 5.0, 7.8]
```

---

## Kluczowe pojęcia Java

| Pojęcie | Opis |
|---|---|
| `double` | Typ zmiennoprzecinkowy 64-bitowy – przechowuje liczby rzeczywiste z dużą precyzją |
| `int` | Typ całkowity 32-bitowy – wartości od −2,147,483,648 do 2,147,483,647 |
| `if / else if / else` | Instrukcja warunkowa – wykonuje blok kodu zależnie od warunku |
| `switch-case` | Wielowariantowy selektor – efektywniejszy niż łańcuch `else-if` gdy porównujemy jedną zmienną |
| `for` | Pętla z licznikiem – idealna gdy z góry wiadomo ile iteracji |
| `while` | Pętla z warunkiem sprawdzanym przed każdą iteracją |
| `do-while` | Pętla z warunkiem sprawdzanym PO iteracji – ciało wykonuje się zawsze co najmniej raz |
| `break` | Natychmiast przerywa pętlę lub blok `switch` |
| `continue` | Pomija resztę ciała pętli i przechodzi do następnej iteracji |
| `Math.sqrt()` | Pierwiastek kwadratowy |
| `Math.pow(a, b)` | Potęgowanie: a^b |
| `Math.toRadians()` | Konwersja stopni na radiany |
| `Arrays.toString()` | Czytelne wypisanie zawartości tablicy |
| `static` | Metoda należy do klasy, nie do obiektu – można ją wywołać bez tworzenia instancji |

---

## Jak uruchomić projekty

### Wymagania
- **Java JDK** w wersji 21+ (zadania 3–6 używają składni `void main()` z Java 21 Preview)
- **NetBeans IDE** lub **IntelliJ IDEA**

### Kroki w NetBeans / IntelliJ

1. Utwórz nowy projekt **Java Application**
2. Wklej wybrany kod do klasy `Main`
3. Uruchom skrótem **`Shift + F6`** (NetBeans) lub **`Shift + F10`** (IntelliJ)

### Kompilacja z linii poleceń

```bash
# Dla standardowej składni (Java 8+)
javac Main.java
java Main

# Dla składni void main() (Java 21+)
javac --enable-preview --release 21 Main.java
java --enable-preview Main
```

> **Uwaga:** Składnia `void main()` bez `public static` jest dostępna od Java 21 jako funkcja preview (uproszczona klasa główna). W starszych wersjach należy użyć pełnego `public static void main(String[] args)`.
