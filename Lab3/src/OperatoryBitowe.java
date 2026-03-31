public class OperatoryBitowe {
    public static void main(String[] args) {

        int a = 5;  // binarnie: 0101
        int b = 6;  // binarnie: 0110

        System.out.println("a = " + a + "  (binarnie: " + Integer.toBinaryString(a) + ")");
        System.out.println("b = " + b + "  (binarnie: " + Integer.toBinaryString(b) + ")");

        int and = a & b;  // 0101 & 0110 = 0100 = 4
        int or  = a | b;  // 0101 | 0110 = 0111 = 7

        System.out.println("\na & b = " + and + "  (binarnie: " + Integer.toBinaryString(and) + ")");
        System.out.println("a | b = " + or  + "  (binarnie: " + Integer.toBinaryString(or)  + ")");

        // && i || nie działają na int - to błąd kompilacji:
        // if (a && b) { }  // BŁĄD!
    }
}
