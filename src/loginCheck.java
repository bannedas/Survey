import java.io.*;

public class loginCheck {
    public static boolean loginCheck(String username, String password) throws IOException {
        String database = "database.txt";

        FileReader fileReader = new FileReader(database); //initialize filereader (this one opens files)
        BufferedReader bufferedReader = new BufferedReader(fileReader); //initialize bufferedreader (this one can read files)

            String line;
            while ((line = bufferedReader.readLine()) != null) { //while (read line is not equal empty line)
                String[] parts = line.split(" "); //split by spaces
                if (parts[0].equals(username) && parts[1].equals(password)) { //parts[0] = username, parts[1] = password
                    return true; //class returns true and breaks while loop, so class stops
                }
            }
            return false; //class returns false if all lines are read and no match found
    }
}
