public class InkrementacjaKolejnosc {
    public static void main(String[] args) {
        int a = 5;
        int b = 3;

        int c = a + b++;
        System.out.println("c = " + c);
        System.out.println("b po c = " + b);

        int d = (a++) + b;
        System.out.println("d = " + d);
        System.out.println("a po d = " + a);
    }
}
