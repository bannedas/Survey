/**
 *
 * DESCRIPTION
 *
 * @author Madeleine Blomberg, Simon Houlberg, Kedisha Charles, Paulius Astrauskas, Anders Brenøe Olesen
 * @version 1.0
 * @release 19/12/2018
 *
 */
public class DecryptPassword {
    public static String decrypt(String hex) { //get string input
        StringBuilder str = new StringBuilder(); //initialize string builder
        for (int i = 0; i < hex.length(); i+=2) { //run loop for whole string lenght
            str.append((char) Integer.parseInt(hex.substring(i, i + 2), 16)); //translate two numbers to char

        }
        return str.toString(); //Returns the string.
    }
}
