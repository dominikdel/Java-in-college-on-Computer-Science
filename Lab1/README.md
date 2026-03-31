# Laboratorium 1 – Praca w środowisku NetBeans

**Autor:** Dominik Delimata  
**Kierunek:** Informatyka, rok 1  
**Środowisko:** NetBeans IDE, Java SE  

---

## Spis treści

1. [Zadanie 1 – HelloWorld](#zadanie-1--helloworld)
2. [Zadanie 2 – SystemProperties](#zadanie-2--systemproperties)
3. [Zadanie 3 – DeklaracjaWlasna](#zadanie-3--deklaracjawlasna)
4. [Jak uruchomić projekty](#jak-uruchomić-projekty)

---

## Zadanie 1 – HelloWorld

### Opis zadania
Celem zadania jest uruchomienie środowiska NetBeans, utworzenie nowego projektu Java o nazwie `HelloWorld` i wyświetlenie aktualnej daty oraz godziny.

### Kod źródłowy

```java
package helloworld;

import java.util.*;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Witaj, dzisiaj mamy: ");
        System.out.println(new Date());
    }
}
```

### Wyjaśnienie kodu

| Element | Opis |
|---|---|
| `package helloworld;` | Deklaracja pakietu – grupuje klasy w logiczny moduł o nazwie `helloworld` |
| `import java.util.*;` | Import wszystkich klas z pakietu `java.util`, m.in. klasy `Date` |
| `public class HelloWorld` | Definicja klasy publicznej o nazwie `HelloWorld` – nazwa musi być zgodna z nazwą pliku `.java` |
| `public static void main(String[] args)` | Metoda `main` – punkt wejściowy (startowy) każdej aplikacji Java; JVM wywołuje ją jako pierwszą |
| `System.out.println(...)` | Metoda wypisująca tekst na standardowe wyjście (konsolę) wraz z przejściem do nowej linii |
| `new Date()` | Tworzy nowy obiekt klasy `Date`, który automatycznie pobiera bieżącą datę i czas z systemu operacyjnego |

### Przykładowy wynik
```
Witaj, dzisiaj mamy: 
Tue Mar 31 21:00:00 CEST 2026
```

---

## Zadanie 2 – SystemProperties

### Opis zadania
Celem zadania jest wyświetlenie właściwości systemowych maszyny wirtualnej Java (JVM), w tym pełnej listy wszystkich właściwości, nazwy zalogowanego użytkownika oraz ścieżki do bibliotek natywnych.

### Kod źródłowy

```java
public class SystemProperties {
    public static void main(String[] args) {
        System.out.println("It's all properties");
        System.getProperties().list(System.out);

        System.out.println("\n It's USER NAME properties: ");
        System.out.println(System.getProperty("user.name"));

        System.out.println("\n It's JAVA LIBRARY PATH properties: ");
        System.out.println(System.getProperty("java.library.path"));
    }
}
```

### Wyjaśnienie kodu

| Element | Opis |
|---|---|
| `System.getProperties()` | Zwraca obiekt klasy `Properties` zawierający wszystkie właściwości systemowe JVM jako pary klucz–wartość |
| `.list(System.out)` | Wypisuje wszystkie właściwości na podany strumień wyjściowy – tutaj na standardową konsolę (`System.out`) |
| `System.getProperty("user.name")` | Pobiera pojedynczą właściwość o kluczu `user.name` – zwraca nazwę aktualnie zalogowanego użytkownika systemu operacyjnego |
| `System.getProperty("java.library.path")` | Zwraca ścieżkę do katalogów, w których JVM szuka bibliotek natywnych (`.dll` na Windows, `.so` na Linux) |

### Przykładowe właściwości systemowe

Metoda `System.getProperties().list()` wypisuje m.in.:

```
-- listing properties --
java.version=21.0.x
os.name=Windows 11
user.name=dominik
java.home=C:\Program Files\Java\jdk-21
...
```

### Przykładowy wynik
```
It's all properties
-- listing properties --
java.version=21.0.x
...

 It's USER NAME properties: 
dominik

 It's JAVA LIBRARY PATH properties: 
C:\Program Files\Java\jdk-21\bin;...
```

---

## Zadanie 3 – DeklaracjaWlasna

### Opis zadania
Celem zadania jest stworzenie programu, który wczytuje od użytkownika imię i nazwisko, a następnie wyświetla ukryty tekst zakodowany w tablicy wartości całkowitych (kodów Unicode) razem z podanymi danymi.

### Kod źródłowy

```java
import java.util.Scanner;

public class DeklaracjaWlasna {
    public static void main(String[] args) {
        String firstName, surName;
        int[] declaration = {
            74, 97, 32, 110, 105, 122, 101, 107, 32, 112, 111, 100, 32, 106, 101, 115, 116,
            97, 107, 111, 32, 114, 122, 101, 99, 122, 112, 111, 119, 97, 110, 121, 32, 119,
            105, 101, 108, 107, 105, 32, 115, 119, 111, 106, 101, 32, 105, 109, 105, 281,
            32, 105, 32, 110, 97, 122, 119, 105, 115, 107, 111, 32, 100, 111, 32, 99, 122,
            121, 99, 104, 32, 99, 101, 108, 243, 119, 105, 101, 107
        };

        Scanner scanIn = new Scanner(System.in);
        System.out.print("Podaj swoje imię: ");
        firstName = scanIn.nextLine();
        System.out.print("Podaj swoje nazwisko: ");
        surName = scanIn.nextLine();
        scanIn.close();

        System.out.println("\n\n-------------------------------------------------------------");

        for (int i = 0; i < declaration.length; i++) {
            System.out.print((char) declaration[i]);
        }

        System.out.println("\n\n" + firstName + " " + surName);
    }
}
```

### Wyjaśnienie kodu

| Element | Opis |
|---|---|
| `String firstName, surName;` | Deklaracja dwóch zmiennych tekstowych (`String`) do przechowywania imienia i nazwiska |
| `int[] declaration = { ... }` | Tablica liczb całkowitych zawierająca kody znaków Unicode – każda liczba odpowiada jednemu znakowi tekstu |
| `new Scanner(System.in)` | Tworzy obiekt klasy `Scanner` odczytujący dane wprowadzane przez użytkownika z klawiatury |
| `scanIn.nextLine()` | Odczytuje całą linię tekstu wpisaną przez użytkownika (włącznie ze spacjami) |
| `scanIn.close()` | Zamyka strumień wejściowy – dobra praktyka zwalniania zasobów po zakończeniu odczytu |
| `(char) declaration[i]` | Rzutowanie (konwersja) wartości całkowitej `int` na znak `char` – Java interpretuje liczbę jako kod Unicode i wyświetla odpowiadający mu znak |
| Pętla `for` | Iteruje po każdym elemencie tablicy `declaration` i wypisuje kolejne znaki – razem tworzą ukryty komunikat |
| `firstName + " " + surName` | Konkatenacja (łączenie) stringów – wypisuje imię i nazwisko oddzielone spacją |

### Jak działa kodowanie Unicode?

Tablica `int[] declaration` przechowuje kody Unicode. Przykładowo:
- `74` → `'J'`
- `97` → `'a'`
- `32` → `' '` (spacja)
- `281` → `'ę'` (polska litera)
- `243` → `'ó'` (polska litera)

Po rzutowaniu wszystkich wartości na `char` i wypisaniu otrzymujemy ukryte zdanie zaczynające się od słów: *„Ja niezek pod jestako rzeczpowany wielki swoje imię i nazwisko do czych celów wiek"* – jest to tzw. **deklaracja własna** studenta.

### Przykładowy wynik
```
Podaj swoje imię: Dominik
Podaj swoje nazwisko: Delimata

-------------------------------------------------------------
Ja nizek pod jestako rzeczpowany wielki swoje imię i nazwisko do czych celówiek

Dominik Delimata
```

---

## Jak uruchomić projekty

### Wymagania
- **Java JDK** w wersji 8 lub nowszej
- **NetBeans IDE** (zalecana wersja 12+) lub dowolne IDE obsługujące Javę

### Kroki w NetBeans

1. Otwórz NetBeans IDE
2. Wybierz `File → New Project → Java → Java Application`
3. Nadaj projektowi nazwę zgodną z zadaniem (`HelloWorld`, `SystemProperties`, `DeklaracjaWlasna`)
4. Wklej odpowiedni kod do klasy głównej
5. Uruchom projekt skrótem **`Shift + F6`** lub przyciskiem ▶ Run

### Uruchomienie z linii poleceń

```bash
# Kompilacja
javac HelloWorld.java

# Uruchomienie
java HelloWorld
```

---

## Kluczowe pojęcia Java

| Pojęcie | Opis |
|---|---|
| **Klasa** | Podstawowy element kodu Java – szablon opisujący dane i zachowanie obiektu |
| **Metoda `main`** | Punkt startowy każdej aplikacji Java – JVM wykonuje ją jako pierwszą |
| **`System.out.println()`** | Wypisuje tekst na konsolę i przechodzi do nowej linii |
| **`String`** | Typ danych do przechowywania ciągów znaków (tekstu) |
| **`int[]`** | Tablica liczb całkowitych – zbiór wartości tego samego typu |
| **`Scanner`** | Klasa do odczytywania danych wejściowych od użytkownika (z klawiatury) |
| **Rzutowanie `(char)`** | Konwersja wartości `int` na znak `char` – interpretuje liczbę jako kod Unicode |
| **Unicode** | Standard kodowania znaków – każdemu znakowi (literze, cyfry, symbolu) przypisana jest unikalna liczba |
| **JVM** | Java Virtual Machine – środowisko uruchomieniowe, które wykonuje skompilowany kod Javy |
