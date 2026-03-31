public static void main(String[] args) {
    System.out.println("It's all properties");
    System.getProperties().list(System.out);
    System.out.println("\n It's USER NAME properties: ");
    System.out.println(System.getProperty("user.name"));

    System.out.println("\n It's JAVA LIBRARY PATH properties: ");
    System.out.println(System.getProperty("java.library.path"));

}