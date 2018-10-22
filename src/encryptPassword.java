import javax.xml.bind.DatatypeConverter;

public class encryptPassword {
    public static String Encrypt(String strTarget) {
        String encoded = DatatypeConverter.printBase64Binary(strTarget.getBytes());
        System.out.printf("Encrypted password: %s\n", encoded);
        return encoded;
    }
}
