package obliczaniefigur;

public class Prostokat {
    private double dlugosc;
    private double szerokosc;

    public Prostokat(double dlugosc, double szerokosc) {
        setDlugosc(dlugosc);
        setSzerokosc(szerokosc);
    }

    public double getDlugosc() { return dlugosc; }
    public double getSzerokosc() { return szerokosc; }

    public void setDlugosc(double dlugosc) {
        if (dlugosc > 0) this.dlugosc = dlugosc;
        else System.out.println("Błąd: Długość musi być większa od 0!");
    }

    public void setSzerokosc(double szerokosc) {
        if (szerokosc > 0) this.szerokosc = szerokosc;
        else System.out.println("Błąd: Szerokość musi być większa od 0!");
    }

    public double pole() {
        return dlugosc * szerokosc;
    }

    public double obwod() {
        return 2 * (dlugosc + szerokosc);
    }

    public void pokazDane() {
        System.out.println("=== Prostokąt ===");
        System.out.printf("Długość:    %.2f%n", dlugosc);
        System.out.printf("Szerokość:  %.2f%n", szerokosc);
        System.out.printf("Pole:       %.2f%n", pole());
        System.out.printf("Obwód:      %.2f%n", obwod());
    }
}