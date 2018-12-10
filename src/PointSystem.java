/**
 *
 * PointSystem finds the given username in the database and add the given points to his or her point sum. If a negative integer is given the value is subtracted.
 *
 * @author Madeleine Blomberg, Simon Houlberg, Kedisha Charles, Paulius Astrauskas, Anders Brenøe Olesen
 * @version 1.0
 * @release 19/12/2018
 *
 * @param username  e-mail address given as username by user
 * @param points    how many points are to be given or subtracted
 * @return          True, only False if there are any errors or insufficient points
 */
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PointSystem {
    public static boolean pointSystem (String username, int points) throws IOException {
        String database = "database.txt"; //database location (right now in the same folder as an app
        String tempDatabase = "tempdatabase.txt";

        FileReader fileReader = new FileReader(database); //initialize filereader (this one opens files)
        BufferedReader bufferedReader = new BufferedReader(fileReader); //initialize bufferedreader (this one can read files)

        File tempfile = new File (tempDatabase);
        File data = new File(database); //initialzie database
        tempfile.createNewFile();

        FileWriter fileWriter = new FileWriter(tempDatabase, true); //initialize filereader (this one opens files)
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); //initialize bufferedreader (this one can read files)

        String line; //initialize string (later we assign it to readLine so it becomes 1 line of database

        while ((line = bufferedReader.readLine()) != null) { //while (read line is not equal empty line)
            String[] parts = line.split(" "); //split by spaces
            if (parts[0].equals(username)) { //parts[0] = username
                int temp = Integer.valueOf(parts[4]);
                if(points < 0) {
                    if(temp + points < 0) {
                        bufferedWriter.close(); //close file so we can delete it
                        bufferedReader.close();
                        tempfile.delete(); //delete old database (because it will be half filled and can conflict later on with new tempdatabase
                        return false; //not enough points so you dont get anything
                    }
                }
                temp += points;
                String addedPoints = String.valueOf(temp);
                bufferedWriter.write(parts[0] + " " + parts[1] + " " + parts[2] + " " + parts[3] + " " + addedPoints + " " + "false"); //write in database (username SPACE password etc.)
                bufferedWriter.newLine();
            } else {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        }
        bufferedWriter.close(); //close writer
        bufferedReader.close(); //close reader

        data.delete(); //delete old database
        if(tempfile.renameTo(data)) return true; //rename tempdatabase to database and return success
    return false; //if something fails return fail
    }
}
