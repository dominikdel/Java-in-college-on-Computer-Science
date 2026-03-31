public class TestLiczba {
    public static void main(String[] args) {
        Liczba a = new Liczba("12345");
        System.out.println("a = " + a);          // 12345
        a.pomnozPrzez(12);
        System.out.println("a * 12 = " + a);     // 148140

        Liczba f = Liczba.silnia(20);
        System.out.println("20! = " + f);
    }
}