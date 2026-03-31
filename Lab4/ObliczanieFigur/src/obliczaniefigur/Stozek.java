package obliczaniefigur;

public class Stozek {
    private double promien;
    private double wysokosc;

    public Stozek(double promien, double wysokosc) {
        setPromien(promien);
        setWysokosc(wysokosc);
    }

    public double getPromien() { return promien; }
    public double getWysokosc() { return wysokosc; }

    public void setPromien(double promien) {
        if (promien > 0) this.promien = promien;
        else System.out.println("Błąd: Promień musi być większy od 0!");
    }

    public void setWysokosc(double wysokosc) {
        if (wysokosc > 0) this.wysokosc = wysokosc;
        else System.out.println("Błąd: Wysokość musi być większa od 0!");
    }

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
        System.out.printf("Promień:          %.2f%n", promien);
        System.out.printf("Wysokość:         %.2f%n", wysokosc);
        System.out.printf("Tworząca:         %.2f%n", tworzaca());
        System.out.printf("Pole powierzchni: %.2f%n", polePowierzchni());
        System.out.printf("Objętość:         %.2f%n", objetosc());
    }
}