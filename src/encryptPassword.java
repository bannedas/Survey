public class encryptPassword {
    public static String Encrypt(String strTarget) {
        StringBuilder buf = new StringBuilder(200);
        for (char ch: strTarget.toCharArray()) {
            buf.append(String.format("%02x", (int) ch));
        }
        return buf.toString();
    }
}
