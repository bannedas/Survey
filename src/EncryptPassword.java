/**
 *
 * DESCRIPTION
 *
 * @author Madeleine Blomberg, Simon Houlberg, Kedisha Charles, Paulius Astrauskas, Anders Brenøe Olesen
 * @version 1.0
 * @release 19/12/2018
 *
 */
public class EncryptPassword {
    public static String Encrypt(String strTarget) { //get string
        StringBuilder buf = new StringBuilder(200); //initialize stringbuilder
        for (char ch: strTarget.toCharArray()) { //run for loop and make char array from it
            buf.append(String.format("%02x", (int) ch)); //change from char to int

        }
        return buf.toString(); //Returns string.
    }
}
