import java.io.*;

public class signupWriter {
    public static boolean signupWriter(String username, String password) throws IOException {
            String database = "database.txt";

            FileWriter fileWriter = new FileWriter(database, true); //initialize filereader (this one opens files)
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); //initialize bufferedreader (this one can read files)

            bufferedWriter.write(username + " " + password + "");
            bufferedWriter.newLine();
            bufferedWriter.close();
            return true; //class returns false if all lines are read and no match found
        }
}
