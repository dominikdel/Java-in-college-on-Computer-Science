package obliczaniefigur;

public class Kolo {
    private double promien;

    public Kolo(double promien) {
        setPromien(promien); // Używamy settera w konstruktorze dla spójności walidacji
    }

    public double getPromien() {
        return promien;
    }

    public void setPromien(double promien) {
        if (promien > 0) this.promien = promien;
        else System.out.println("Błąd: Promień musi być większy od 0!");
    }

    public double pole() {
        return Math.PI * promien * promien;
    }

    public double obwod() {
        return 2 * Math.PI * promien;
    }

    public void pokazDane() {
        System.out.println("=== Koło ===");
        System.out.printf("Promień:  %.2f%n", promien);
        System.out.printf("Pole:     %.2f%n", pole());
        System.out.printf("Obwód:    %.2f%n", obwod());
    }
}