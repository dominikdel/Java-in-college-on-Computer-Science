# Laboratorium 3 – Operatory, rekurencja, typ łańcuchowy w Java

**Autor:** Dominik Delimata  
**Kierunek:** Informatyka, rok 1  
**Środowisko:** NetBeans IDE / IntelliJ IDEA, Java SE  

---

## Spis treści

### 1. Operatory
- [Zadanie 1.1 – Inkrementacja i dekrementacja (pre/post-fiksowa)](#zadanie-11--inkrementacja-i-dekrementacja)
- [Zadanie 1.2 – Operatory logiczne `&&` i `||`](#zadanie-12--operatory-logiczne--i-)
- [Zadanie 1.3 – Różnica między `&&`/`&` i `||`/`|` (short-circuit)](#zadanie-13--różnica-między--i--short-circuit)
- [Zadanie 1.4 – Operatory przesunięć bitowych `<<`, `>>`, `>>>`](#zadanie-14--operatory-przesunięć-bitowych---i-)
- [Zadanie 1.5 – Złożone operatory przypisania `+=`, `-=`, `*=`, `/=`, `%=`](#zadanie-15--złożone-operatory-przypisania)
- [Zadanie 1.6 – Kolejność wykonania inkrementacji](#zadanie-16--kolejność-wykonania-inkrementacji)
- [Zadanie 1.7 – Bramki logiczne NOT i XOR](#zadanie-17--bramki-logiczne-not-i-xor)
- [Zadanie 1.8 – Operator różny `!=`](#zadanie-18--operator-różny-)

### 2. Typ łańcuchowy (String)
- [Zadanie 2.1 – Podstawy klasy String](#zadanie-21--podstawy-klasy-string)
- [Zadanie 2.2 – Metody klasy String](#zadanie-22--metody-klasy-string)

### 3. Rekurencja
- [Zadanie 3.1 – Silnia rekurencyjna](#zadanie-31--silnia-rekurencyjna)
- [Zadanie 3.2 – Silnia iteracyjna (pętla)](#zadanie-32--silnia-iteracyjna-pętla)
- [Zadanie 3.3 – Szybkie potęgowanie (rekurencja + iteracja)](#zadanie-33--szybkie-potęgowanie)
- [Zadanie 3.4 – Ciąg Fibonacciego (rekurencja + iteracja)](#zadanie-34--ciąg-fibonacciego)

---

## Zadanie 1.1 – Inkrementacja i dekrementacja

### Opis zadania
Co zwróci poniższy program? Uzasadnij odpowiedź.

```java
public class IncDec {
    public static void main(String[] arg) {
        double a = 12.12;
        System.out.println(a--);  // 1. wydruk
        System.out.println(a++);  // 2. wydruk
        System.out.println(--a);  // 3. wydruk
        System.out.println(++a);  // 4. wydruk
    }
}
```

### Wyjaśnienie

| Linia | Operator | Działanie | Wydrukowana wartość | Wartość `a` po instrukcji |
|---|---|---|---|---|
| `a--` | Postfiksowy `--` | Zwraca **starą** wartość, potem odejmuje 1 | `12.12` | `11.12` |
| `a++` | Postfiksowy `++` | Zwraca **starą** wartość, potem dodaje 1 | `11.12` | `12.12` |
| `--a` | Prefiksowy `--` | **Najpierw** odejmuje 1, potem zwraca nową wartość | `11.12` | `11.12` |
| `++a` | Prefiksowy `++` | **Najpierw** dodaje 1, potem zwraca nową wartość | `12.12` | `12.12` |

### Kluczowa zasada

- **Postfiksowy** (`a++`, `a--`) → zwróć wartość **przed** zmianą
- **Prefiksowy** (`++a`, `--a`) → zmień **najpierw**, potem zwróć

### Wynik programu
```
12.12
11.12
11.12
12.12
```

---

## Zadanie 1.2 – Operatory logiczne `&&` i `||`

### Opis zadania
Program demonstrujący działanie operatorów logicznych koniunkcji `&&` i alternatywy `||` za pomocą instrukcji `if`. Kod w: `OperatoryLogiczne.java` (sekcja Zadanie 1.2).

```java
int a = 5;
int b = 0;

if (a > 0 && a < 10) {
    System.out.println("a jest w przedziale (0, 10)");
}

if (a < 0 || a == 5) {
    System.out.println("a jest ujemne LUB równe 5");
}

if (b != 0 && (a / b) > 1) {
    System.out.println("To się nie wykona");
} else {
    System.out.println("Bezpiecznie: nie dzielimy przez 0");
}
```

### Wyjaśnienie

| Operator | Nazwa | Znaczenie | Wynik `true` gdy... |
|---|---|---|---|
| `&&` | Koniunkcja (AND) | Logiczne I | **Oba** warunki są `true` |
| `\|\|` | Alternatywa (OR) | Logiczne LUB | **Przynajmniej jeden** warunek jest `true` |

**Ważna cecha `&&`:** jeśli lewy warunek jest `false`, prawy **nie jest w ogóle sprawdzany**. Dlatego `b != 0 && (a/b) > 1` jest bezpieczne – nigdy nie dojdzie do dzielenia przez zero gdy `b == 0`.

### Wynik programu
```
a jest w przedziale (0, 10)
a jest ujemne LUB równe 5
Bezpiecznie: nie dzielimy przez 0
Pierwszy warunek true, więc drugi nie jest liczony
```

---

## Zadanie 1.3 – Różnica między `&&`/`&` i `||`/`|` (short-circuit)

### Opis zadania
Czym różnią się operatory `&&` od `&` oraz `||` od `|`? Program demonstruje efekt **short-circuit evaluation** (leniwe wartościowanie).

### Kod źródłowy (`OperatoryLogiczne.java`)

```java
public class OperatoryLogiczne {

    static int licznik = 0;

    static boolean sprawdz(boolean wynik) {
        licznik++;
        System.out.println("  -> sprawdz() wywołane, zwraca: " + wynik);
        return wynik;
    }

    public static void main(String[] args) {

        // --- && (short-circuit AND) ---
        System.out.println("=== false && sprawdz(true) ===");
        licznik = 0;
        if (false && sprawdz(true)) { }
        System.out.println("Ile razy wywołano sprawdz(): " + licznik); // 0!

        // --- & (bez short-circuit) ---
        System.out.println("\n=== false & sprawdz(true) ===");
        licznik = 0;
        if (false & sprawdz(true)) { }
        System.out.println("Ile razy wywołano sprawdz(): " + licznik); // 1

        // --- || (short-circuit OR) ---
        System.out.println("\n=== true || sprawdz(false) ===");
        licznik = 0;
        if (true || sprawdz(false)) { }
        System.out.println("Ile razy wywołano sprawdz(): " + licznik); // 0!

        // --- | (bez short-circuit) ---
        System.out.println("\n=== true | sprawdz(false) ===");
        licznik = 0;
        if (true | sprawdz(false)) { }
        System.out.println("Ile razy wywołano sprawdz(): " + licznik); // 1
    }
}
```

### Wyjaśnienie

| Operator | Typ | Short-circuit? | Działanie |
|---|---|---|---|
| `&&` | Logiczny AND | ✅ TAK | Gdy lewa strona `false` → prawa **nie jest sprawdzana** |
| `&` | Bitowy AND / nieleniwwy AND | ❌ NIE | **Obie** strony zawsze sprawdzane |
| `\|\|` | Logiczny OR | ✅ TAK | Gdy lewa strona `true` → prawa **nie jest sprawdzana** |
| `\|` | Bitowy OR / nieleniwwy OR | ❌ NIE | **Obie** strony zawsze sprawdzane |

**Dodatkowa różnica:** `&` i `|` działają też jako operatory **bitowe** na liczbach całkowitych (`int`, `long`). Operatory `&&` i `||` na liczbach całkowitych są **błędem kompilacji**.

```java
int a = 5, b = 6;
int and = a & b;  // 0101 & 0110 = 0100 = 4 ✅ (bitowe)
if (a && b) { }   // BŁĄD KOMPILACJI! ❌
```

### Wynik programu
```
=== false && sprawdz(true) ===
Ile razy wywołano sprawdz(): 0

=== false & sprawdz(true) ===
  -> sprawdz() wywołane, zwraca: true
Ile razy wywołano sprawdz(): 1

=== true || sprawdz(false) ===
Ile razy wywołano sprawdz(): 0

=== true | sprawdz(false) ===
  -> sprawdz() wywołane, zwraca: false
Ile razy wywołano sprawdz(): 1
```

---

## Zadanie 1.4 – Operatory przesunięć bitowych `<<`, `>>`, `>>>`

### Opis zadania
Napisz programy demonstrujące działanie operatorów przesunięć bitowych. (`OperatoryPrzesuniecia.java`)

### Kod źródłowy

```java
public class OperatoryPrzesuniecia {
    public static void main(String[] args) {

        int a =  8;  // binarnie: 00000000 00000000 00000000 00001000
        int b = -8;  // binarnie: 11111111 11111111 11111111 11111000

        // << przesunięcie w lewo
        System.out.println("a << 1 = " + (a << 1));  // 16 = 8 * 2
        System.out.println("a << 2 = " + (a << 2));  // 32 = 8 * 4
        System.out.println("a << 3 = " + (a << 3));  // 64 = 8 * 8

        // >> przesunięcie w prawo ZE znakiem (arytmetyczne)
        System.out.println("a >> 1 = " + (a >> 1));  // 4  = 8 / 2
        System.out.println("b >> 1 = " + (b >> 1));  // -4 (znak zachowany!)

        // >>> przesunięcie w prawo BEZ znaku (logiczne)
        System.out.println("b >>> 1 = " + (b >>> 1));    // ogromna liczba dodatnia
        System.out.println("b >>> 28 = " + (b >>> 28));  // 15
    }
}
```

### Wyjaśnienie

| Operator | Nazwa | Efekt matematyczny | Zachowanie znaku |
|---|---|---|---|
| `<<` | Przesunięcie w lewo | `a << n` = `a × 2ⁿ` | Brak – wynik zależy od bitów |
| `>>` | Przesunięcie w prawo **ze znakiem** (arytmetyczne) | `a >> n` = `a / 2ⁿ` | ✅ Zachowany (bity znaku kopiowane) |
| `>>>` | Przesunięcie w prawo **bez znaku** (logiczne) | — | ❌ Uzupełnianie zerami; ujemne dają ogromne liczby |

**Praktyczne zastosowania:**
- `x << 1` → szybkie mnożenie przez 2 (szybsze niż `x * 2`)
- `x >> 1` → szybkie dzielenie przez 2
- `(left + right) >>> 1` → bezpieczne obliczanie środka tablicy bez ryzyka przepełnienia

### Przykłady z liczbami
```
a = 8  (binarnie: 1000)

a << 1  = 16   (10000)     → 8 × 2
a << 2  = 32  (100000)     → 8 × 4
a >> 1  =  4    (100)      → 8 / 2
b = -8
b >> 1  = -4               → dzielenie, znak zachowany
b >>> 1 = 2147483644       → bit znaku staje się wartością!
```

---

## Zadanie 1.5 – Złożone operatory przypisania

### Opis zadania
Jakie działania arytmetyczne reprezentują wyrażenia `+=`, `-=`, `*=`, `/=`, `%=` i jakie wyniki zwrócą? (`ZlozoneOperatory.java`)

### Kod źródłowy

```java
public class ZlozoneOperatory {
    public static void main(String[] args) {
        int a = 17;
        double b = 4.0;

        a += b;  System.out.println("a += b -> a = " + a);  // a = 21
        a -= b;  System.out.println("a -= b -> a = " + a);  // a = 17
        a *= b;  System.out.println("a *= b -> a = " + a);  // a = 68
        a /= b;  System.out.println("a /= b -> a = " + a);  // a = 17
        a %= b;  System.out.println("a %= b -> a = " + a);  // a = 1
    }
}
```

### Wyjaśnienie

| Operator złożony | Odpowiednik pełny | Wyjaśnienie |
|---|---|---|
| `a += b` | `a = (int)(a + b)` | Dodaje `b` do `a` |
| `a -= b` | `a = (int)(a - b)` | Odejmuje `b` od `a` |
| `a *= b` | `a = (int)(a * b)` | Mnoży `a` przez `b` |
| `a /= b` | `a = (int)(a / b)` | Dzieli `a` przez `b` |
| `a %= b` | `a = (int)(a % b)` | Przypisuje resztę z dzielenia `a` przez `b` |

**Ważna uwaga:** `a` jest typu `int`, `b` jest typu `double`. Operatory złożone wykonują **automatyczne rzutowanie** wyniku z powrotem do `int`, obcinając część ułamkową. Odpowiada to wyrażeniu `a = (int)(a op b)`.

### Wynik programu
```
a += b -> a = 21
a -= b -> a = 17
a *= b -> a = 68
a /= b -> a = 17
a %= b -> a = 1
```

---

## Zadanie 1.6 – Kolejność wykonania inkrementacji

### Opis zadania
W jakiej kolejności wykonywane są działania przy wyliczaniu `c = a + b++` oraz `d = (a++) + b`? (`InkrementacjaKolejnosc.java`)

### Kod źródłowy

```java
public class InkrementacjaKolejnosc {
    public static void main(String[] args) {
        int a = 5;
        int b = 3;

        int c = a + b++;
        System.out.println("c = " + c);       // 8
        System.out.println("b po c = " + b);  // 4

        int d = (a++) + b;
        System.out.println("d = " + d);       // 9
        System.out.println("a po d = " + a);  // 6
    }
}
```

### Wyjaśnienie krok po kroku

**Obliczanie `c = a + b++`:**
1. `a` = 5 (bez zmian)
2. `b++` → zwraca **starą** wartość `b` = 3, potem inkrementuje `b` do 4
3. `c = 5 + 3 = 8`
4. Po wykonaniu: `b = 4`

**Obliczanie `d = (a++) + b`:**
1. `a++` → zwraca **starą** wartość `a` = 5, potem inkrementuje `a` do 6
2. `b` = 4 (po poprzedniej operacji)
3. `d = 5 + 4 = 9`
4. Po wykonaniu: `a = 6`

### Wynik programu
```
c = 8
b po c = 4
d = 9
a po d = 6
```

---

## Zadanie 1.7 – Bramki logiczne NOT i XOR

### Opis zadania
Jakimi operatorami w Javie definiuje się operacje logiczne NOT i XOR? Stwórz programy demonstrujące ich tablice prawdy.

### Bramka NOT (`BramkaNOT.java`)

```java
public class BramkaNOT {
    public static void main(String[] args) {
        System.out.println("=== Bramka NOT (!) ===");
        System.out.println("A     | !A");
        System.out.println("------|-----");

        boolean[] wartosci = {false, true};

        for (boolean a : wartosci) {
            System.out.printf("%-5s | %-5s%n", a, !a);
        }

        boolean deszczPada = true;
        if (!deszczPada) {
            System.out.println("Nie pada, możesz wyjść bez parasola");
        } else {
            System.out.println("Pada deszcz, weź parasol");
        }
    }
}
```

**Tablica prawdy NOT:**

| A | !A |
|---|---|
| false | true |
| true | false |

**Operator:** `!` (wykrzyknik) — negacja logiczna

---

### Bramka XOR (`BramkaXOR.java`)

```java
public class BramkaXOR {
    public static void main(String[] args) {
        System.out.println("=== Bramka XOR (^) ===");
        System.out.println("A     | B     | A ^ B");
        System.out.println("------|-------|------");

        boolean[] wartosci = {false, true};

        for (boolean a : wartosci) {
            for (boolean b : wartosci) {
                System.out.printf("%-5s | %-5s | %-5s%n", a, b, a ^ b);
            }
        }

        // Przykład: dwa przełączniki – światło włączone gdy TYLKO JEDEN wciśnięty
        boolean przelacznik1 = true;
        boolean przelacznik2 = false;
        boolean swiatloWlaczone = przelacznik1 ^ przelacznik2;
        System.out.println("Światło włączone: " + swiatloWlaczone); // true
    }
}
```

**Tablica prawdy XOR:**

| A | B | A ^ B |
|---|---|---|
| false | false | false |
| false | true | true |
| true | false | true |
| true | true | false |

**Operator:** `^` (daszek) — alternatywa wykluczająca (XOR zwraca `true` gdy **dokładnie jedna** wartość jest `true`)

**Wyjaśnienie elementów kodu:**

| Element | Opis |
|---|---|
| `for (boolean a : wartosci)` | Pętla for-each – iteruje po każdym elemencie tablicy `wartosci` bez potrzeby licznika `i` |
| `System.out.printf("%-5s \| %-5s%n", a, !a)` | Formatowane wypisanie; `%-5s` – wyrównanie do lewej w polu 5 znaków; `%n` – nowa linia |
| Zagnieżdżone pętle `for` (XOR) | Dwie pętle generują wszystkie 4 kombinacje wartości `(false,false)`, `(false,true)`, itd. |

---

## Zadanie 1.8 – Operator różny `!=`

### Opis zadania
Program demonstrujący działanie operatora `!=` (różny od) jako przeciwieństwo operatora `==`. (`OperatorRozny.java`)

### Kod źródłowy

```java
public class OperatorRozny {
    public static void main(String[] args) {
        int a = 5, b = 10, c = 5;

        System.out.println("a != b : " + (a != b));  // true  (5 ≠ 10)
        System.out.println("a != c : " + (a != c));  // false (5 = 5)
        System.out.println("a == c : " + (a == c));  // true  (5 = 5)

        char litera1 = 'A', litera2 = 'B';
        System.out.println("litera1 != litera2 : " + (litera1 != litera2)); // true

        boolean x = true, y = false;
        System.out.println("x != y : " + (x != y)); // true

        // != w pętli while
        int licznik = 5;
        while (licznik != 0) {
            System.out.print(licznik + " ");
            licznik--;
        }
        // wydruk: 5 4 3 2 1
    }
}
```

### Wyjaśnienie

| Wyrażenie | Znaczenie | Wynik gdy a=5, b=5 | Wynik gdy a=5, b=10 |
|---|---|---|---|
| `a == b` | a **równe** b | `true` | `false` |
| `a != b` | a **różne od** b | `false` | `true` |

`!=` zawsze zwraca wartość odwrotną do `==` – jest to dokładnie `!(a == b)`. Działa na typach prostych: `int`, `char`, `boolean`, `double` itd.

---

## Zadanie 2.1 – Podstawy klasy String

### Opis zadania
Przetestuj działanie poniższego programu i wyjaśnij efekt niemutowalności Stringów.

```java
public class StringExample {
    public static void main(String args[]) {
        String s1 = new String("Happy ");
        String s2 = new String("Birthday");

        System.out.printf("s1 = %s\ns2 = %s\n\n", s1, s2);
        System.out.printf("Result of s1.concat(s2) = %s\n", s1.concat(s2));
        System.out.printf("s1 after concatenation = %s\n", s1);
    }
}
```

### Wyjaśnienie

| Element | Opis |
|---|---|
| `new String("Happy ")` | Jawne tworzenie obiektu String; można też po prostu `String s1 = "Happy "` |
| `System.out.printf(...)` | Formatowane wypisanie; `%s` – miejsce na String, `\n` – nowa linia |
| `s1.concat(s2)` | Łączy `s1` i `s2`, zwracając **nowy** String `"Happy Birthday"` |
| `s1` po concat | Nadal `"Happy "` – **String jest niemutowalny** (immutable)! |

**Kluczowa zasada niemutowalności:** Żadna metoda klasy `String` nie modyfikuje oryginalnego obiektu. Zawsze tworzony jest **nowy** String z wynikiem. Aby zachować wynik, trzeba przypisać do zmiennej: `s1 = s1.concat(s2);`

### Wynik programu
```
s1 = Happy
s2 = Birthday

Result of s1.concat( s2 ) = Happy Birthday
s1 after concatenation = Happy
```

---

## Zadanie 2.2 – Metody klasy String

### Najważniejsze metody klasy `String`

| Metoda | Opis | Przykład |
|---|---|---|
| `toCharArray()` | Zamienia String na tablicę znaków `char[]` | `"abc".toCharArray()` → `['a','b','c']` |
| `getBytes()` | Zamienia String na tablicę bajtów `byte[]` (kody ASCII/UTF-8) | `"A".getBytes()` → `[65]` |
| `equals(str)` | Porównuje Stringi z uwzględnieniem wielkości liter | `"Java".equals("java")` → `false` |
| `equalsIgnoreCase(str)` | Porównuje bez uwzględnienia wielkości liter | `"Java".equalsIgnoreCase("java")` → `true` |
| `compareTo(str)` | Porównanie leksykograficzne; zwraca 0, wartość ujemną lub dodatnią | `"a".compareTo("b")` → `-1` |
| `compareToIgnoreCase(str)` | Jak `compareTo()`, lecz ignoruje wielkość liter | — |
| `indexOf(char)` | Indeks pierwszego wystąpienia znaku, lub -1 | `"hello".indexOf('l')` → `2` |
| `indexOf(str)` | Indeks pierwszego wystąpienia podciągu, lub -1 | `"hello".indexOf("ll")` → `2` |
| `lastIndexOf(char)` | Indeks **ostatniego** wystąpienia znaku | `"hello".lastIndexOf('l')` → `3` |
| `substring(start)` | Podciąg od indeksu `start` do końca | `"hello".substring(2)` → `"llo"` |
| `substring(start, end)` | Podciąg od `start` do `end` (wyłącznie) | `"hello".substring(1,3)` → `"el"` |
| `replace(old, new)` | Zamienia wszystkie wystąpienia znaku | `"aaba".replace('a','x')` → `"xxbx"` |
| `trim()` | Usuwa spacje z początku i końca | `" hi ".trim()` → `"hi"` |
| `toLowerCase()` | Zamienia na małe litery | `"JAVA".toLowerCase()` → `"java"` |
| `toUpperCase()` | Zamienia na wielkie litery | `"java".toUpperCase()` → `"JAVA"` |
| `split(regex)` | Dzieli String na tablicę wg wzorca | `"a,b,c".split(",")` → `["a","b","c"]` |

> **Ważne:** Do porównywania Stringów zawsze używaj `.equals()`, **nigdy `==`**! Operator `==` porównuje referencje (adresy w pamięci), a nie zawartość.

---

## Zadanie 3.1 – Silnia rekurencyjna

### Opis zadania
Zaimplementuj funkcję silnia przy użyciu rekurencji. Wzór: n! = n × (n−1)! dla n > 0, oraz 0! = 1.

### Kod źródłowy (`Silnia.java`)

```java
import java.util.*;

public class Silnia {

    public static int silnia(int wartosc) {
        if (wartosc == 0) return 1;          // warunek stopu
        else return wartosc * silnia(wartosc - 1);  // wywołanie rekurencyjne
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj liczbę: ");
        int liczba = sc.nextInt();
        System.out.println(liczba + "! = " + silnia(liczba));
    }
}
```

### Wyjaśnienie rekurencji

| Element | Opis |
|---|---|
| `if (wartosc == 0) return 1` | **Warunek stopu (base case)** – bez niego rekurencja byłaby nieskończona i skończyłaby się błędem `StackOverflowError` |
| `wartosc * silnia(wartosc - 1)` | **Krok rekurencyjny** – metoda wywołuje samą siebie z argumentem o 1 mniejszym |

### Wizualizacja wywołań dla `silnia(4)`
```
silnia(4)
  = 4 * silnia(3)
       = 3 * silnia(2)
            = 2 * silnia(1)
                 = 1 * silnia(0)
                      = 1          ← warunek stopu
                 = 1 * 1 = 1
            = 2 * 1 = 2
       = 3 * 2 = 6
  = 4 * 6 = 24
```

### Przykładowy wynik
```
Podaj liczbę: 5
5! = 120
```

---

## Zadanie 3.2 – Silnia iteracyjna (pętla)

### Opis zadania
Oblicz silnię bez użycia rekurencji – za pomocą pętli `for`. (`SilniaPetla.java`)

### Kod źródłowy

```java
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
```

### Wyjaśnienie

| Element | Opis |
|---|---|
| `if (liczba < 0)` | Walidacja: silnia nie jest zdefiniowana dla liczb ujemnych |
| `long wynik = 1` | Typ `long` (64-bit) zamiast `int` (32-bit) – silnia rośnie bardzo szybko; `20! = 2 432 902 008 176 640 000` mieści się w `long`, ale nie w `int` |
| `wynik *= i` | Iteracyjne mnożenie: `1 × 1 × 2 × 3 × ... × liczba` |
| Inicjalizacja na `1` | Element neutralny mnożenia – `0` wyzerowałoby wynik |

### Porównanie podejść

| Cecha | Rekurencja | Iteracja (pętla) |
|---|---|---|
| Czytelność | Bardzo bliska definicji matematycznej | Bardziej rozbudowana |
| Wydajność | Wolniejsza (narzut wywołań funkcji) | Szybsza |
| Ryzyko | `StackOverflowError` dla dużych n | Brak |
| Złożoność | O(n) wywołań | O(n) iteracji |

---

## Zadanie 3.3 – Szybkie potęgowanie

### Opis zadania
Zaimplementuj algorytm szybkiego potęgowania w wersji rekurencyjnej i iteracyjnej. Zamiast mnożyć podstawę n razy, algorytm dzieli wykładnik przez 2 przy każdym kroku – złożoność O(log n) zamiast O(n).

### Kod źródłowy (`SzybkiePotegowanie.java`)

```java
import java.util.Scanner;

public class SzybkiePotegowanie {

    // WERSJA REKURENCYJNA
    public static long potegowanieRekurencyjne(long podstawa, int wykladnik) {
        if (wykladnik == 0) return 1;  // x^0 = 1

        if (wykladnik % 2 == 0) {
            long polowa = potegowanieRekurencyjne(podstawa, wykladnik / 2);
            return polowa * polowa;    // x^(2k) = (x^k)²
        }

        long polowa = potegowanieRekurencyjne(podstawa, (wykladnik - 1) / 2);
        return podstawa * polowa * polowa;  // x^(2k+1) = x * (x^k)²
    }

    // WERSJA ITERACYJNA
    public static long potegowanieIteracyjne(long podstawa, int wykladnik) {
        long wynik = 1;
        long baza = podstawa;
        int n = wykladnik;

        while (n > 0) {
            if (n % 2 == 1) {
                wynik *= baza;   // gdy bit nieparzysty – dołącz bazę do wyniku
            }
            baza *= baza;        // baza = baza²
            n /= 2;              // przesuń do następnego bitu
        }
        return wynik;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj podstawę: ");
        long podstawa = sc.nextLong();
        System.out.print("Podaj wykładnik: ");
        int wykladnik = sc.nextInt();

        System.out.println("Wersja rekurencyjna: " + podstawa + "^" + wykladnik
                           + " = " + potegowanieRekurencyjne(podstawa, wykladnik));
        System.out.println("Wersja iteracyjna:   " + podstawa + "^" + wykladnik
                           + " = " + potegowanieIteracyjne(podstawa, wykladnik));
        System.out.println("Weryfikacja (Math.pow): " + (long) Math.pow(podstawa, wykladnik));
    }
}
```

### Wyjaśnienie algorytmu

**Idea:** Zamiast liczyć `2^10 = 2×2×2×2×2×2×2×2×2×2` (9 mnożeń), korzystamy z własności potęg:

- Gdy wykładnik **parzysty**: `x^(2k) = (x^k)²` → oblicz `x^k`, potem podnieś do kwadratu
- Gdy wykładnik **nieparzysty**: `x^(2k+1) = x · (x^k)²`

```
2^10 = (2^5)²        → 2 kroki zamiast 9
2^5  = 2 · (2^2)²   
2^2  = (2^1)²
2^1  = 2 · (2^0)²
2^0  = 1              → warunek stopu
```

| Element | Opis |
|---|---|
| `wykladnik % 2 == 0` | Sprawdza, czy wykładnik jest parzysty (ostatni bit = 0) |
| `polowa * polowa` | Kwadratura – unika podwójnego wywołania rekurencyjnego |
| `n /= 2` (iteracyjna) | Przesunięcie bitowe: analizujemy kolejne bity wykładnika |
| `wynik *= baza` | Gdy aktualny bit = 1, dołączamy aktualną potęgę bazy do wyniku |
| `long` zamiast `int` | Wyniki potęgowania mogą być bardzo duże; `long` pomieści do ~9.2 × 10¹⁸ |

### Złożoność obliczeniowa

| Metoda | Złożoność | Przykład: 2^1000 |
|---|---|---|
| Naiwna (pętla × n) | O(n) | 999 mnożeń |
| Szybkie potęgowanie | **O(log n)** | ~10 mnożeń |

### Przykładowy wynik
```
Podaj podstawę: 2
Podaj wykładnik: 10

Wersja rekurencyjna: 2^10 = 1024
Wersja iteracyjna:   2^10 = 1024
Weryfikacja (Math.pow): 1024
```

---

## Zadanie 3.4 – Ciąg Fibonacciego

### Opis zadania
Zaimplementuj algorytm obliczający wartość ciągu Fibonacciego w wersji rekurencyjnej i iteracyjnej.  
Definicja: F(0) = 0, F(1) = 1, F(n) = F(n−1) + F(n−2) dla n ≥ 2.

### Kod źródłowy (`Fibonacci.java`)

```java
import java.util.Scanner;

public class Fibonacci {

    // WERSJA REKURENCYJNA – złożoność O(2^n)
    public static long fibRekurencyjny(int n) {
        if (n == 0) return 0;   // warunek stopu
        if (n == 1) return 1;   // warunek stopu
        return fibRekurencyjny(n - 1) + fibRekurencyjny(n - 2);
    }

    // WERSJA ITERACYJNA – złożoność O(n)
    public static long fibIteracyjny(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        long poprzedni = 0;
        long obecny    = 1;

        for (int i = 2; i <= n; i++) {
            long nastepny = poprzedni + obecny;
            poprzedni = obecny;
            obecny    = nastepny;
        }
        return obecny;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj n: ");
        int n = sc.nextInt();

        if (n < 0) { System.out.println("n musi być >= 0"); return; }

        System.out.println("F(" + n + ") rekurencyjnie = " + fibRekurencyjny(n));
        System.out.println("F(" + n + ") iteracyjnie   = " + fibIteracyjny(n));

        System.out.println("\nCiąg Fibonacciego od F(0) do F(" + n + "):");
        for (int i = 0; i <= n; i++) {
            System.out.print("F(" + i + ")=" + fibIteracyjny(i));
            if (i < n) System.out.print(", ");
        }
        System.out.println();
    }
}
```

### Wyjaśnienie

| Element | Opis |
|---|---|
| Dwa warunki stopu: `n==0` i `n==1` | Niezbędne – ciąg Fibonacciego ma dwa punkty startowe |
| `fibRekurencyjny(n-1) + fibRekurencyjny(n-2)` | Bezpośrednie odwzorowanie definicji matematycznej |
| `poprzedni`, `obecny`, `nastepny` | Trzy zmienne „przesuwające się" w górę ciągu – wystarczą do obliczenia każdego wyrazu |
| `long` | Ciąg Fibonacciego rośnie szybko; F(92) = 7 540 113 804 746 346 429 to ostatnia wartość mieszcząca się w `long` |

### Porównanie złożoności

| Wersja | Złożoność czasowa | Złożoność pamięciowa | Uwagi |
|---|---|---|---|
| Rekurencyjna | **O(2ⁿ)** – wykładnicza | O(n) – stos wywołań | Dla n > 45 staje się bardzo wolna |
| Iteracyjna | **O(n)** – liniowa | O(1) – stała | Zalecana w praktyce |

### Wizualizacja rekurencji dla F(4)
```
fib(4)
├── fib(3)
│   ├── fib(2)
│   │   ├── fib(1) = 1
│   │   └── fib(0) = 0
│   └── fib(1) = 1
└── fib(2)
    ├── fib(1) = 1
    └── fib(0) = 0
```
fib(2) obliczane jest **dwukrotnie** – to właśnie powód wykładniczej złożoności.

### Przykładowy wynik
```
Podaj n: 8

F(8) rekurencyjnie = 21
F(8) iteracyjnie   = 21

Ciąg Fibonacciego od F(0) do F(8):
F(0)=0, F(1)=1, F(2)=1, F(3)=2, F(4)=3, F(5)=5, F(6)=8, F(7)=13, F(8)=21
```

---

## Kluczowe pojęcia Java

| Pojęcie | Opis |
|---|---|
| **Rekurencja** | Metoda wywołująca samą siebie; wymaga **warunku stopu** (base case), by nie była nieskończona |
| **Warunek stopu** | Przypadek bazowy w rekurencji – wartość zwracana bez dalszego wywołania |
| **Short-circuit** | `&&` i `\|\|` przerywają sprawdzanie gdy wynik jest już znany; `&` i `\|` zawsze sprawdzają obie strony |
| **Niemutowalność String** | Obiekty `String` nie mogą być zmienione po stworzeniu – każda operacja tworzy nowy obiekt |
| **Operator bitowy** | Działa na poszczególnych bitach liczby: `&`, `\|`, `^`, `~`, `<<`, `>>`, `>>>` |
| **`Integer.toBinaryString(n)`** | Metoda zwracająca binarne (dwójkowe) reprezentację liczby jako String |
| **`long`** | Typ 64-bitowy; przechowuje liczby od −9.2×10¹⁸ do 9.2×10¹⁸ – przydatny dla dużych wyników |
| **`printf` / format `%-5s`** | Formatowane wypisanie; `%-5s` – wyrównanie do lewej w polu 5 znaków |
| **For-each** | `for (type var : collection)` – iteracja po kolekcji/tablicy bez ręcznego licznika |
| **O(log n)** | Złożoność logarytmiczna – algorytm dzieli problem na pół przy każdym kroku (szybkie potęgowanie) |
| **O(2ⁿ)** | Złożoność wykładnicza – naiwna rekurencja Fibonacciego; dla dużych n katastrofalnie wolna |

---

## Jak uruchomić projekty

### Wymagania
- **Java JDK 17+** (zalecana LTS)
- **NetBeans IDE** lub **IntelliJ IDEA**

### Kroki

1. Utwórz nowy projekt **Java Application**
2. Skopiuj wybrany plik `.java` do katalogu `src/`
3. Uruchom skrótem **`Shift + F6`** (NetBeans) lub **`Shift + F10`** (IntelliJ)

### Kompilacja z linii poleceń

```bash
# Kompilacja
javac Silnia.java

# Uruchomienie
java Silnia
```
