import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

public class EncryptedPrinter extends PrinterDecorator{
    public EncryptedPrinter(Printer printer) {
        super(printer);
    }
    @Override
    public void print(String message) {
        String encryptedMessage = "";
        //Character shift encryption
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            c += 12;
            encryptedMessage += c;
        }
        super.print(encryptedMessage);
    }
}
