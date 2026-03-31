public class Liczba {
    private int[] cyfry;   // cyfry w systemie dziesiętnym, cyfry[0] = jedności
    private int rozmiar;   // faktyczna liczba używanych cyfr

    // Konstruktor z napisu, np. "12345"
    public Liczba(String s) {
        // usuwamy spacje
        s = s.trim();
        // pomijamy ewentualne wiodące zera
        int i = 0;
        while (i < s.length() - 1 && s.charAt(i) == '0') {
            i++;
        }
        s = s.substring(i);

        // tablica wielkości długości napisu
        cyfry = new int[s.length()];
        rozmiar = s.length();

        // zapisujemy cyfry w odwrotnej kolejności
        int idx = 0;
        for (int j = s.length() - 1; j >= 0; j--) {
            char c = s.charAt(j);
            if (c < '0' || c > '9') {
                throw new IllegalArgumentException("Nieprawidłowy znak w liczbie: " + c);
            }
            cyfry[idx++] = c - '0';
        }
    }

    // Prywatna metoda zapewniająca miejsce w tablicy
    private void ensureCapacity(int minCapacity) {
        if (cyfry.length >= minCapacity) return;
        int newCap = Math.max(cyfry.length * 2, minCapacity);
        int[] nowa = new int[newCap];
        System.arraycopy(cyfry, 0, nowa, 0, rozmiar);
        cyfry = nowa;
    }

    // Mnożenie przez liczbę typu int (>= 0)
    public void pomnozPrzez(int m) {
        if (m < 0) {
            throw new IllegalArgumentException("Mnożenie przez liczbę ujemną nieobsługiwane");
        }
        if (m == 0) {
            // wynik = 0
            cyfry = new int[1];
            cyfry[0] = 0;
            rozmiar = 1;
            return;
        }

        int carry = 0;
        for (int i = 0; i < rozmiar; i++) {
            long prod = (long)cyfry[i] * m + carry;
            cyfry[i] = (int)(prod % 10);
            carry = (int)(prod / 10);
        }

        // dopisujemy ewentualne cyfry z przeniesienia
        while (carry > 0) {
            ensureCapacity(rozmiar + 1);
            cyfry[rozmiar] = carry % 10;
            carry /= 10;
            rozmiar++;
        }
    }

    // Wypisanie liczby jako String
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = rozmiar - 1; i >= 0; i--) {
            sb.append(cyfry[i]);
        }
        return sb.toString();
    }

    // Metoda statyczna: silnia n (n!)
    public static Liczba silnia(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Silnia niezdefiniowana dla n < 0");
        }
        Liczba wynik = new Liczba("1");
        for (int i = 2; i <= n; i++) {
            wynik.pomnozPrzez(i);
        }
        return wynik;
    }
}