
import java.io.*;
import java.util.Arrays;


public class SurveyWriter {

    public static boolean surveyWriter(String user, String[] answers, int surveyID) throws IOException {
        /* IOException = unexpected cases when writing/reading files
        it is required by JAVA and this is the best explanation i found on google:
        (throws IOException) specifies that the method may going to throws IOException and insist
        the compiler that the block which is calling this method needs some special attention
        towards this regarding handling or again throwing back. */

        String dir = "userdatabase/"+user+".txt"; //database location (right now in the same folder as an app

        File database = new File (dir);

        if (database.createNewFile()) {
            System.out.println("userdatabase not found, created new");
        } else {
            System.out.println("userdatabase found, reading");
        }//Add survey to userdatabase file to show it has been completed by user (If no file exist, create it)

        FileWriter fileWriter = new FileWriter(database, true); //initialize filereader (this one opens files)
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); //initialize bufferedreader (this one can read files)
        bufferedWriter.write(surveyID+" "+String.join(" ", Arrays.asList(answers))); //write in database
        bufferedWriter.newLine(); //write \n



        bufferedWriter.close(); //close writer
        return true; //class returns false if all lines are read and no match found
    }
}
