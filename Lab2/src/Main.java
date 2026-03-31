// Zadanie 1.
/*
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanIn= new Scanner(System.in);

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
            System.out.println("x = " + x);-1
        } else {
            System.out.println("Brak pierwiastków rzeczywistych (delta < 0).");
        }

        scanIn.close();
    }
}
*/

// Zadanie 2.
/*
import javax.sound.midi.SysexMessage;
import java.util.Scanner;
import static java.lang.Math.*;

    public class Main {
        public static void main(String[] args) {

        Scanner scanIn= new Scanner(System.in);

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
                case 1:
                    System.out.print("Suma = " + (a + b));
                    System.out.print("\n\n");
                    break;
                case 2:
                    System.out.print("Roznica = " + (a - b));
                    System.out.print("\n\n");
                    break;
                case 3:
                    System.out.print("Iloczyn = " + (a * b));
                    System.out.print("\n\n");
                    break;
                case 4:
                    if (b == 0){
                        System.out.print("Nie mozna dzielic przez zero!");
                    } else {
                        System.out.print("Iloraz = " + (a / b));
                    }
                    System.out.print("\n\n");
                    break;
                case 5:
                    System.out.println("Potega(a do potegi b) = " + (pow(a, b)));
                    System.out.print("\n\n");
                case 6:
                    double root = Math.pow(a, 1.0 / b);
                    System.out.println("Pierwiastek z a b-stopnia = " + root);
                    System.out.print("\n\n");
                    break;
                // sinus
                case 7:
                    System.out.print("Sin(x) = " + sin(rad));
                    System.out.print("\n\n");
                    break;
                case 8:
                    System.out.print("Cos(x) = " + cos(rad));
                    System.out.print("\n\n");
                    break;
                case 9:
                    System.out.print("Tan(x) = " + tan(rad));
                    System.out.print("\n\n");
                    break;
                case 10:
                    if (tan(rad) == 0.0) {
                        System.out.println("ctan(x) = nie istnieje (tan(x)=0)");
                    } else {
                        System.out.println("ctan(x) = " + (1.0 / rad));
                    }
                    System.out.print("\n\n");
                    break;
                default:
                    System.out.print("Koniec programu");
                    System.out.print("\n\n");

                    break;
            }
        } while (wybor != 0);
    }
}
*/

// Zadanie 3.
/*
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
        System.out.println();

        if (wybor == 1) {
            for (int i = 0; i < tablica.length; i++) {
                System.out.print(tablica[i] + " ");
            }
            System.out.println();

        } else if (wybor == 2) {
            for (int i = tablica.length - 1; i >= 0; i--) {
                System.out.print(tablica[i] + " ");
            }
            System.out.println();

        } else if (wybor == 3) {
            // nieparzyste indeksy: 1, 3, 5, ...
            for (int i = 0; i < tablica.length; i++) {
                if (i % 2 != 0) {
                    System.out.print(tablica[i] + " ");
                }
            }
            System.out.println();

        } else if (wybor == 4) {
            // parzyste indeksy: 0, 2, 4, ...
            for (int i = 0; i < tablica.length; i++) {
                if (i % 2 == 0) {
                    System.out.print(tablica[i] + " ");
                }
            }
            System.out.println();

        } else if (wybor == 0) {
            System.out.println("Koniec programu.");

        } else {
            System.out.println("Niepoprawny wybór.");
        }

    } while (wybor != 0);
}
*/

// Zadanie 4
/*
void main(){
    Scanner scanIn = new Scanner(System.in);



    double[] tablica = new double[10];
    double Suma = 0;
    double Iloczyn = 1;
    double Srednia = 0;
    int wybor;

    // Wprowadzenie 10 liczb
    for (int i = 0; i < tablica.length; i++) {
        System.out.print("Podaj element tablicy [" + i + "]: ");
        tablica[i] = scanIn.nextDouble();
    }
    System.out.print("\n");

    // Menu
    System.out.print("Wybierz opcje od 1-5.\n");
    System.out.print("\n[1] Oblicz sume elementow tablicy");
    System.out.print("\n[2] Oblicz iloczyn elementow tablicy");
    System.out.print("\n[3] Wyznacz wartosc srednia");
    System.out.print("\n[4] Wyznacz wartosc minimanlna");
    System.out.print("\n[5] Wyznacz wartosc maksymalna\n");
    // Wybor
    System.out.print("Odpowiedz: ");
    wybor = scanIn.nextInt();

    switch (wybor) {
        case 1:
            // Sumowanie liczb
            for (int i = 0; i < tablica.length; i++) {
                Suma += tablica[i];
            }
            System.out.print("Suma = " + Suma);
            System.out.print("\n");
        break;

        case 2:
            // Iloczyn liczb
            for (int i = 0; i < tablica.length; i++) {
                Iloczyn *= tablica[i];
            }
            System.out.print("Iloczyn = " + Iloczyn);
            System.out.print("\n");
        break;

        case 3:
            // Srednia
            for (int i = 0; i < tablica.length; i++) {
                Suma += tablica[i];
                Srednia = Suma / tablica.length;
            }
            System.out.print("Srednia = " + Srednia);
            System.out.print("\n");
        break;

        case 4:
            // Wartosc minimalna
            double Min = 0;
            Min = tablica[0];
            for (int i = 1; i < tablica.length; i++) {
                if (tablica[i] < Min) {
                    Min = tablica[i];
                }
            }
            System.out.println("Najmniejsza liczba: " + Min);
        break;

        case 5:
            // Wartosc maksymalna
            double Max = 0;
            Max = tablica[0];
            for (int i = 1; i < tablica.length; i++) {
                if (tablica[i] > Max) {
                    Max = tablica[i];
                }
            }
            System.out.println("Największa liczba: " + Max);
        break;

        default:
            System.out.print("Koniec programu");
            break;
    }
}
*/
// Zadanie 5
/*
void main(){
    Scanner scanIn = new Scanner(System.in);

    for (int i = 20; i >= 0; i--){
        if (i == 19 || i == 15 || i == 9 || i == 6 || i == 2){
            continue;
        }
        System.out.print(i);
        System.out.print("\n");
    }
}
*/

// Zadanie 6
/*
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
*/

// Zadanie 7
/*
import java.util.Arrays;
import java.util.Scanner;

public class Main {

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
            if (!swapped) break; // optymalizacja: jak brak zamian, to już posortowane [web:324]
        }
    }

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
        // tworzenie tablicy
        double[] tab = new double[n];
        // wpisywanie liczb do tablicy
        for (int i = 0; i < tab.length; i++) {
            System.out.print("Podaj liczbę [" + i + "]: ");
            tab[i] = sc.nextDouble();
        }

        // menu
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
*/