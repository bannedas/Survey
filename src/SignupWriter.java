import java.io.*;
/**
 *
 * SignUpWriter gets all the information given by the user when signing up for an account and saves it to the database.
 *
 * @author Madeleine Blomberg, Simon Houlberg, Kedisha Charles, Paulius Astrauskas, Anders Brenøe Olesen
 * @version 1.0
 * @release 19/12/2018
 */
public class SignUpWriter {
    /**
     *
     * @param username e-mail address given as username by user
     * @param password password given in password field by user
     * @param name name given by user at sign-up
     * @param gender the given gender of the user
     * @return true
     * @throws IOException dealing with input/output, so using exception in case of failure
     */
    public static boolean SignUpWriter(String username, String password, String name, String gender) throws IOException {
        /* IOException = unexpected cases when writing/reading files
        it is required by JAVA and this is the best explanation i found on google:
        (throws IOException) specifies that the method may going to throws IOException and insist
        the compiler that the block which is calling this method needs some special attention
        towards this regarding handling or again throwing back. */

        String database = "database.txt"; //database location (right now in the same folder as an app
        int points = 0; //start with 0 points
        boolean admin = false;

        FileWriter fileWriter = new FileWriter(database, true); //initialize filereader (this one opens files)
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); //initialize bufferedreader (this one can read files)

        password = EncryptPassword.Encrypt(password);

        String firstName = name.substring(0, 1).toUpperCase() + name.substring(1);

        bufferedWriter.write(username.toLowerCase() + " " + password + " " + firstName + " " + gender + " " + points + " " + admin); //write in database (username SPACE password etc.)
        bufferedWriter.newLine(); //write \n
        bufferedWriter.close(); //close writer
        return true;
    }
}
