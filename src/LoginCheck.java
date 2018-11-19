/**
 *
 * LoginCheck matches the given username and password and return true only if they match what is in the database.
 *
 * @author Madeleine Blomberg, Simon Houlberg, Kedisha Charles, Paulius Astrauskas, Anders Brenøe Olesen
 * @version 1.0
 * @release 19/12/2018
 *
 */
import java.io.*;

public class LoginCheck {
    public static int loginCheck(String username, String password) throws IOException {
        /* IOException = unexpected cases when writing/reading files
        it is required by JAVA and this is the best explanation i found on google:
        (throws IOException) specifies that the method may going to throws IOException and insist
        the compiler that the block which is calling this method needs some special attention
        towards this regarding handling or again throwing back. */

        String dir = "database.txt"; //database location (right now in the same folder as an app

        File database = new File (dir);
        if(database.createNewFile()) {
            System.out.println("database not found, created new");
        } else {
            System.out.println("database found, reading");
        }

        FileReader fileReader = new FileReader(dir); //initialize filereader (this one opens files)
        BufferedReader bufferedReader = new BufferedReader(fileReader); //initialize bufferedreader (this one can read files)

        String line; //initialize string (later we assign it to readLine so it becomes 1 line of database

        while ((line = bufferedReader.readLine()) != null) { //while (read line is not equal empty line)
            String[] parts = line.split(" "); //split by spaces
            String name = parts[0].toLowerCase();
            if (name.equals(username) && DecryptPassword.decrypt(parts[1]).equals(password)) { //parts[0] = username, parts[1] = password
                if(parts[5].equals("true")) {
                    bufferedReader.close();
                    System.out.println(parts[5]);
                    return 2;
                }
                bufferedReader.close();
                return 1; //class returns true and breaks while loop, so class stops
            }
        }
        bufferedReader.close();
        return 0; //class returns false if all lines are read and no match found
    }
}
