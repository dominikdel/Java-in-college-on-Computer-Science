public static void main(String[] args) {
  String firstName, surName;
  int[] declaration = {
          74, 97, 32, 110, 105, 122, 101, 107, 32, 112, 111, 100, 32, 106, 101, 115, 116,
          97, 107, 111, 32, 114, 122, 101, 99, 122, 112, 111, 119, 97, 110, 121, 32, 119,
          105, 101, 108, 107, 105, 32, 115, 119, 111, 106, 101, 32, 105, 109, 105, 281,
          32, 105, 32, 110, 97, 122, 119, 105, 115, 107, 111, 32, 100, 111, 32, 99, 122,
          121, 99, 104, 32, 99, 101, 108, 243, 119, 105, 101, 107
  };

  Scanner scanIn = new Scanner(System.in);
  System.out.print("Podaj swoje imię: ");
  firstName = scanIn.nextLine();
  System.out.print("Podaj swoje nazwisko: ");
  surName = scanIn.nextLine();
  scanIn.close();

  System.out.println("\n\n-------------------------------------------------------------");

  for (int i = 0; i < declaration.length; i++) {
    System.out.print((char) declaration[i]);
  }

  System.out.println("\n\n" + firstName + " " + surName);
}
