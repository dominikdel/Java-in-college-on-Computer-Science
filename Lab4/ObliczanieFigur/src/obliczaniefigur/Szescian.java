package obliczaniefigur;

public class Szescian {
    private double bok;

    public Szescian(double bok) {
        setBok(bok);
    }

    public double getBok() {
        return bok;
    }

    public void setBok(double bok) {
        if (bok > 0) this.bok = bok;
        else System.out.println("Błąd: Bok musi być większy od 0!");
    }

    public double polePowierzchni() {
        return 6 * bok * bok;
    }

    public double objetosc() {
        return bok * bok * bok;
    }

    public void pokazDane() {
        System.out.println("=== Sześcian ===");
        System.out.printf("Bok:              %.2f%n", bok);
        System.out.printf("Pole powierzchni: %.2f%n", polePowierzchni());
        System.out.printf("Objętość:         %.2f%n", objetosc());
    }
}