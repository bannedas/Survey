public class encryptPassword {
    public static String Encrypt(String strTarget) { //get string
        StringBuilder buf = new StringBuilder(200); //initialize stringbuilder
        for (char ch: strTarget.toCharArray()) { //run for loop and make char array from it
            buf.append(String.format("%02x", (int) ch)); //change from char to int
        }
        return buf.toString(); //return string
    }
}
