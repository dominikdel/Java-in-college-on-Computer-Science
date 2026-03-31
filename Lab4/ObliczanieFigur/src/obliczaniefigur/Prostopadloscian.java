package obliczaniefigur;

public class Prostopadloscian {
    private double dlugosc;
    private double szerokosc;
    private double wysokosc;

    public Prostopadloscian(double dlugosc, double szerokosc, double wysokosc) {
        setDlugosc(dlugosc);
        setSzerokosc(szerokosc);
        setWysokosc(wysokosc);
    }

    public double getDlugosc() { return dlugosc; }
    public double getSzerokosc() { return szerokosc; }
    public double getWysokosc() { return wysokosc; }

    public void setDlugosc(double dlugosc) {
        if (dlugosc > 0) this.dlugosc = dlugosc;
        else System.out.println("Błąd: Długość musi być większa od 0!");
    }

    public void setSzerokosc(double szerokosc) {
        if (szerokosc > 0) this.szerokosc = szerokosc;
        else System.out.println("Błąd: Szerokość musi być większa od 0!");
    }

    public void setWysokosc(double wysokosc) {
        if (wysokosc > 0) this.wysokosc = wysokosc;
        else System.out.println("Błąd: Wysokość musi być większa od 0!");
    }

    public double polePowierzchni() {
        return 2 * (dlugosc * szerokosc + szerokosc * wysokosc + dlugosc * wysokosc);
    }

    public double objetosc() {
        return dlugosc * szerokosc * wysokosc;
    }

    public void pokazDane() {
        System.out.println("=== Prostopadłościan ===");
        System.out.printf("Długość:          %.2f%n", dlugosc);
        System.out.printf("Szerokość:        %.2f%n", szerokosc);
        System.out.printf("Wysokość:         %.2f%n", wysokosc);
        System.out.printf("Pole powierzchni: %.2f%n", polePowierzchni());
        System.out.printf("Objętość:         %.2f%n", objetosc());
    }
}