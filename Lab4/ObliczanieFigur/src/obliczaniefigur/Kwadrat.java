package obliczaniefigur;

public class Kwadrat {
    private double bok;

    public Kwadrat(double bok) {
        setBok(bok);
    }

    public double getBok() {
        return bok;
    }

    public void setBok(double bok) {
        if (bok > 0) this.bok = bok;
        else System.out.println("Błąd: Bok musi być większy od 0!");
    }

    public double pole() {
        return bok * bok;
    }

    public double obwod() {
        return 4 * bok;
    }

    public void pokazDane() {
        System.out.println("=== Kwadrat ===");
        System.out.printf("Bok:      %.2f%n", bok);
        System.out.printf("Pole:     %.2f%n", pole());
        System.out.printf("Obwód:    %.2f%n", obwod());
    }
}