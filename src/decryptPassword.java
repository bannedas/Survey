import javax.xml.bind.DatatypeConverter;

public class decryptPassword {
    public static String Encrypt(String encoded) {

        String decoded = new String(DatatypeConverter.parseBase64Binary(encoded));
        System.out.printf("Password: %s\n", decoded);
        return decoded;
    }
}

