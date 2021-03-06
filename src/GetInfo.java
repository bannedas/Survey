import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/**
 * GetInfo class with overloaded methods that gets different types of information depending on which version is called.
 *
 * @author Madeleine Blomberg, Simon Houlberg, Kedisha Charles, Paulius Astrauskas, Anders Brenøe Olesen
 * @version 1.0
 * @release 19/12/2018
 */
public class GetInfo {
    /**
     *
     * @param user the current user credentials
     * @param info a string describing which switch case will be used
     * @return returns name/points/username based on input
     * @throws IOException dealing with input/output, so using exception in case of failure
     */
    public static String getInfo(String user, String info) throws IOException {
        String[] parts;
        switch (info) {
            case "name":
                parts = readDatabase(user).split(" ");
                return parts[2];
            case "points":
                parts = readDatabase(user).split(" ");
                return parts[4];
            default:
                break;
        }
        return user;
    }

    /**
     *
     * @param surveyID internal ID of a survey
     * @param info a string describing which switch case will be used
     * @return returns name/lenght/points/error of user based on input
     * @throws IOException dealing with input/output, so using exception in case of failure
     */
    public static String getInfo(int surveyID, String info) throws IOException {
        String[] parts;
        switch (info)   {
            case "name":
                parts = readDatabase(surveyID).split(" ");
                return parts[0];
            case "length":
                parts = readDatabase(surveyID).split(" ");
                return parts[1];
            case "points":
                parts = readDatabase(surveyID).split(" ");
                return parts[2];
            default:
                break;
        }
        return "error";
    }

    /**
     *
     * @param surveyID internal ID of a survey
     * @param question which line of survey file to get question from
     * @return returns parts string array which has
     * @throws IOException dealing with input/output, so using exception in case of failure
     */
    public static String[] getInfo(int surveyID, int question) throws IOException {
        String[] parts = readDatabase(surveyID,question);
        return parts;
    }

    /**
     *
     * @param user the current user credentials
     * @return returns user information from database.txt
     * @throws IOException dealing with input/output, so using exception in case of failure
     */
    private static String readDatabase(String user) throws IOException {
        String dir = "database.txt"; //database location (right now in the same folder as an app
        FileReader fileReader = new FileReader(dir); //initialize filereader (this one opens files)
        BufferedReader bufferedReader = new BufferedReader(fileReader); //initialize bufferedreader (this one can read files)
        String line; //initialize string (later we assign it to readLine so it becomes 1 line of database
        while ((line = bufferedReader.readLine()) != null) { //while (read line is not equal empty line)
            String[] parts = line.split(" "); //split by spaces
            if (parts[0].equals(user)) { //parts[0] = username, parts[1] = password
                bufferedReader.close();
                return line; //class returns true and breaks while loop, so class stops
            }
        }
        bufferedReader.close();
        return user;
    }

    /**
     *
     * @param user the current user credentials
     * @param surveyID internal ID of a survey
     * @return returns true/false depending if user has completed the survey or not
     * @throws IOException dealing with input/output, so using exception in case of failure
     */
    public static Boolean readUserDataBase(String user, int surveyID) throws IOException {
        String dir = "userdatabase/" + user + ".txt"; //database location (right now in the same folder as an app
        File f = new File(dir);
        if (f.exists() && !f.isDirectory()){
            FileReader fileReader = new FileReader(dir); //initialize filereader (this one opens files)
            BufferedReader bufferedReader = new BufferedReader(fileReader); //initialize bufferedreader (this one can read files)
            String line; //initialize string (later we assign it to readLine so it becomes 1 line of database
            while ((line = bufferedReader.readLine()) != null) { //while (read line is not equal empty line)
                String[] parts = line.split(" "); //split by spaces
                if (Integer.valueOf(parts[0]) == surveyID) { //parts[0] = surveyID
                    bufferedReader.close();
                    return true; //class returns true and breaks while loop, so class stops
                }
            }
            bufferedReader.close();
        }
        return false;
    }

    /**
     *
     * @param surveyID internal ID of a survey
     * @param question which line of survey file to get question from
     * @return returns specified question from that file.
     * @throws IOException dealing with input/output, so using exception in case of failure
     */
    private static String[] readDatabase(int surveyID, int question) throws IOException {
        String dir = "survey/"+surveyID; //database location (right now in the survey folder as an app
        FileReader fileReader = new FileReader(dir); //initialize filereader (this one opens files)
        BufferedReader bufferedReader = new BufferedReader(fileReader); //initialize bufferedreader (this one can read files)
        String[] parts = new String[0];
        String line; //initialize string (later we assign it to readLine so it becomes 1 line of database
        int currentLine = 0;
        while ((line = bufferedReader.readLine()) != null) { //while (read line is not equal empty line)
            if (currentLine == question) {
                parts = line.split(":"); //split by :
                break;
            }
            currentLine += 1;
        }
        bufferedReader.close();
        return parts;
    }

    /**
     *
     * @param surveyID internal ID of a survey
     * @return returns first line in survey file
     * @throws IOException dealing with input/output, so using exception in case of failure
     */
    private static String readDatabase(int surveyID) throws IOException {
        String dir = "survey/"+surveyID; //database location (right now in the survey folder as an app
        FileReader fileReader = new FileReader(dir); //initialize filereader (this one opens files)
        BufferedReader bufferedReader = new BufferedReader(fileReader); //initialize bufferedreader (this one can read files)
        String line = bufferedReader.readLine();
        bufferedReader.close();
        return line; //return first line of specified file
    }
}
