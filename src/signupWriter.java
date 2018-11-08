import java.io.*;

public class SignupWriter {
    public static boolean signupWriter(String username, String password, String name, String gender) throws IOException {
        /* IOException = unexpected cases when writing/reading files
        it is required by JAVA and this is the best explanation i found on google:
        (throws IOException) specifies that the method may going to throws IOException and insist
        the compiler that the block which is calling this method needs some special attention
        towards this regarding handling or again throwing back. */

        String database = "database.txt"; //database location (right now in the same folder as an app
        int points = 0; //start with 0 points

        FileWriter fileWriter = new FileWriter(database, true); //initialize filereader (this one opens files)
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); //initialize bufferedreader (this one can read files)

        password = EncryptPassword.Encrypt(password);

        String firstName = name.substring(0, 1).toUpperCase() + name.substring(1);

        bufferedWriter.write(username.toLowerCase() + " " + password + " " + firstName + " " + gender + " " + points); //write in database (username SPACE password etc.)
        bufferedWriter.newLine(); //write \n
        bufferedWriter.close(); //close writer
        return true; //class returns false if all lines are read and no match found
    }
}
