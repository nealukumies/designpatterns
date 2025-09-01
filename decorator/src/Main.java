public class Main {
    public static void main(String[] args) {
        Printer printer = new BasicPrinter();
        System.out.println("Printing basic message:");
        printer.print("Hello World!");
        System.out.println();

        System.out.println("Printing encrypted message:");
        Printer printer1 = new EncryptedPrinter(new BasicPrinter());
        printer1.print("Hello World!");
        System.out.println();

        System.out.println("Printing XML formatted message:");
        Printer printer3 = new XMLPrinter(new BasicPrinter());
        printer3.print("Hello World!");
        System.out.println();

        System.out.println("Printing encrypted message with XML format:");
        Printer printer2 = new EncryptedPrinter(new XMLPrinter(new BasicPrinter()));
        printer2.print("Hello World!");
        System.out.println();

        System.out.println("Printing XML formatted message with encryption:");
        Printer printer4 = new XMLPrinter(new EncryptedPrinter(new BasicPrinter()));
        printer4.print("Hello World!");
        System.out.println();
    }
}
