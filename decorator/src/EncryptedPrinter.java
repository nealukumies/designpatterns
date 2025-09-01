public class EncryptedPrinter extends PrinterDecorator{
    public EncryptedPrinter(Printer printer) {
        super(printer);
    }
    @Override
    public void print(String message) {
        String encryptedMessage = "";
        //Character shift encryption (Caesar shift, ROT13)
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            c += 13;
            encryptedMessage += c;
        }
        super.print(encryptedMessage);
    }
}
