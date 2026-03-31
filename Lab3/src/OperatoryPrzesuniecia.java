public class OperatoryPrzesuniecia {
    public static void main(String[] args) {

        int a = 8;   // binarnie:  00000000 00000000 00000000 00001000
        int b = -8;  // binarnie:  11111111 11111111 11111111 11111000

        System.out.println("=== << (przesunięcie w lewo) ===");
        System.out.println("a = " + a + "  (bin: " + Integer.toBinaryString(a) + ")");
        System.out.println("a << 1 = " + (a << 1));  // 16  (mnożenie przez 2)
        System.out.println("a << 2 = " + (a << 2));  // 32  (mnożenie przez 4)
        System.out.println("a << 3 = " + (a << 3));  // 64  (mnożenie przez 8)
        System.out.println();

        System.out.println("=== >> (przesunięcie w prawo ZE znakiem) ===");
        System.out.println("a = " + a + "  (bin: " + Integer.toBinaryString(a) + ")");
        System.out.println("a >> 1 = " + (a >> 1));  // 4   (dzielenie przez 2)
        System.out.println("a >> 2 = " + (a >> 2));  // 2
        System.out.println();
        System.out.println("b = " + b + " (bin: " + Integer.toBinaryString(b) + ")");
        System.out.println("b >> 1 = " + (b >> 1));  // -4  (ujemne zostaje ujemne!)
        System.out.println("b >> 2 = " + (b >> 2));  // -2
        System.out.println();

        System.out.println("=== >>> (przesunięcie w prawo BEZ znaku) ===");
        System.out.println("a = " + a);
        System.out.println("a >>> 1 = " + (a >>> 1));  // 4  (dla dodatnich tak samo jak >>)
        System.out.println();
        System.out.println("b = " + b);
        System.out.println("b >>> 1 = " + (b >>> 1));  // ogromna liczba dodatnia!
        System.out.println("b >>> 28 = " + (b >>> 28)); // 15
        System.out.println("(bin po >>> 1): " + Integer.toBinaryString(b >>> 1));

        System.out.println();
        System.out.println("=== Matematyczna zależność ===");
        System.out.println("a << 1 = a * 2 = " + (a << 1));
        System.out.println("a >> 1 = a / 2 = " + (a >> 1));
    }
}
