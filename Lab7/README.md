# Laboratorium 7 – Dziedziczenie i polimorfizm w języku Java

## Struktura projektu

```
Lab7Java/
├── zadanie1/
│   ├── Osoba.java          <- klasa bazowa
│   ├── Student.java        <- podklasa Osoby
│   ├── Wykladowca.java     <- podklasa Osoby (zaprojektowana samodzielnie)
│   └── MainZadanie1.java   <- klasa testowa
├── zadanie2/
│   ├── Punkt2D.java        <- klasa bazowa
│   ├── Punkt3D.java        <- podklasa Punkt2D
│   └── MainZadanie2.java   <- klasa testowa
└── README.md
```

---

## Jak uruchomić

### Zadanie 1
```bash
cd zadanie1
javac Osoba.java Student.java Wykladowca.java MainZadanie1.java
java MainZadanie1
```

### Zadanie 2
```bash
cd zadanie2
javac Punkt2D.java Punkt3D.java MainZadanie2.java
java MainZadanie2
```

---

## Zadanie 1 – Opis

**Temat:** Dziedziczenie – hierarchia klas opisujacych osoby na uczelni.

**Cel zadania:**
Zaimplementowanie klasy bazowej `Osoba` oraz dwóch klas dziedziczacych:
- `Student` – rozszerzenie o dane studenckie (nr indeksu, typ studiów, kierunek, rok)
- `Wykladowca` – zaprojektowana samodzielnie (nr pracowniczy, tytul naukowy,
  katedra, specjalizacja, staz pracy)

**Hierarchia klas:**
```
java.lang.Object
    └── Osoba
            ├── Student
            └── Wykladowca
```

**Kluczowe mechanizmy:**
- `extends` – deklaracja dziedziczenia
- `super(...)` – wywolanie konstruktora klasy nadrzednej
- `@Override` na `getInfo()` i `toString()` – przeslanianie metod
- Polimorfizm: tablica `Osoba[]` przechowuje obiekty róznych podtypów

**Wnioski:**
Dziedziczenie pozwolilo uniknac powielania kodu – pola `imie`, `nazwisko`,
`dataUrodzenia`, `plec` oraz ich gettery zdefiniowane sa raz w klasie `Osoba`
i automatycznie dostepne w `Student` i `Wykladowca`. Przesloniecie `toString()`
powoduje, ze przy iteracji po tablicy `Osoba[]` kazdy obiekt prezentuje sie
zgodnie ze swoim rzeczywistym typem – to esencja polimorfizmu. Operator
`instanceof` umozliwia bezpieczne sprawdzenie rzeczywistego typu obiektu
przed rzutowaniem (downcastingiem).

---

## Zadanie 2 – Opis

**Temat:** Dziedziczenie i polimorfizm – punkty na plaszczyznie i w przestrzeni.

**Cel zadania:**
Zaimplementowanie klasy `Punkt2D` (punkt 2D z losowaniem wspolrzednych)
oraz klasy `Punkt3D` dziedziczacej z `Punkt2D` z dodanym wymiarem `z`.
Nastepnie wyszukanie par punktow o wspolnych wspolrzednych (x, y)
w dwóch 100-elementowych tablicach.

**Hierarchia klas:**
```
java.lang.Object
    └── Punkt2D
            └── Punkt3D
```

**Kluczowe mechanizmy:**
- Konstruktor bezparametrowy i parametryczny w obu klasach
- Pole `protected` – dostepne w podklasie bez gettera, niedostepne z zewnatrz
- `@Override` na `losujWspolrzedne()` – rozszerza logike nadklasy przez `super.losujWspolrzedne()`
- `@Override` na `toString()` – polimorficzne wyswietlanie
- Polimorfizm: tablica `Punkt2D[]` moze przechowyc obiekty `Punkt3D`
- Petla zagniezdzona O(n^2) = 10 000 porownan do wyszukania wspolnych par

**Analiza statystyczna wyszukiwania par:**
Dziedzina kazdej wspolrzednej to [-10, 10], czyli 21 mozliwych wartosci.
Prawdopodobienstwo, ze losowy Punkt2D(x,y) i Punkt3D(x,y,z) maja te same (x,y):
P = (1/21)^2 = ok. 0.23% na pare
Dla 100 x 100 = 10 000 par oczekiwana liczba trafien ~ 23 pary.

**Wnioski:**
Zastosowanie `protected` zamiast `private` dla pol `x` i `y` umozliwia
bezposredni dostep z `Punkt3D` bez posrednictwa getterow. Wywolanie
`super.losujWspolrzedne()` w `Punkt3D` jest przykladem rozszerzania (nie
zastepowania) logiki nadklasy – zgodnie z zasada DRY (Don't Repeat Yourself).
Polimorfizm przejawia sie w tablicy mieszanej `Punkt2D[]`, gdzie
metoda `toString()` wywoluje odpowiednia wersje dla kazdego obiektu.

---

## Ogólne wnioski z laboratorium

1. **Dziedziczenie** eliminuje duplikacje kodu – wspolna logika zyje w jednym
   miejscu (nadklasie) i jest automatycznie dostepna we wszystkich podklasach.

2. **Przeslanianie metod** (`@Override`) dostosowuje zachowanie do specyfiki podklasy
   przy zachowaniu tego samego interfejsu wywolania.

3. **Polimorfizm** – referencja typu nadklasy moze wskazywac na obiekt podklasy;
   wywolana metoda odpowiada **rzeczywistemu** typowi obiektu w czasie wykonania
   (mechanizm late binding / dynamiczne wiazanie).

4. **`super`** – umozliwia dostep do konstruktora i metod nadklasy, co pozwala
   na rozszerzanie istniejacych zachowan zamiast ich pelnego przepisywania.

5. **`protected`** – odpowiedni modyfikator dla pol przeznaczonych do dziedziczenia;
   zezwala podklasom na bezposredni dostep, lecz chrobi enkapsulacje przed zewnetrzem.

6. **`instanceof`** – pozwala bezpiecznie sprawdzic typ obiektu przed rzutowaniem,
   szczegolnie przydatny przy operacjach na tablicach polimorficznych.
