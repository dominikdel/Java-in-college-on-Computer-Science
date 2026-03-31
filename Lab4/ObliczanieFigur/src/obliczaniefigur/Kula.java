package obliczaniefigur;

public class Kula {
    private double promien;

    public Kula(double promien) {
        setPromien(promien);
    }

    public double getPromien() {
        return promien;
    }

    public void setPromien(double promien) {
        if (promien > 0) this.promien = promien;
        else System.out.println("Błąd: Promień musi być większy od 0!");
    }

    public double polePowierzchni() {
        return 4 * Math.PI * promien * promien;
    }

    public double objetosc() {
        return (4.0 / 3.0) * Math.PI * promien * promien * promien;
    }

    public void pokazDane() {
        System.out.println("=== Kula ===");
        System.out.printf("Promień:          %.2f%n", promien);
        System.out.printf("Pole powierzchni: %.2f%n", polePowierzchni());
        System.out.printf("Objętość:         %.2f%n", objetosc());
    }
}