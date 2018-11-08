/**
 *
 * GetInfoa class with overloaded methods that gets different types of information depending on which version i called.
 *
 * @author Madeleine Blomberg, Simon Houlberg, Kedisha Charles, Paulius Astrauskas, Anders Brenøe Olesen
 * @version 1.0
 * @release 19/12/2018
 *
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GetInfo {
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
    public static String[] getInfo(int surveyID, int question) throws IOException {
        String[] parts = readDatabase(surveyID,question);


        return parts;
    }
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
    return user;
    }
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
    private static String[] readDatabase(int surveyID, int question) throws IOException { //Reads såecified survey file and returns specified question from that file.
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
        return parts;

    }

    private static String readDatabase(int surveyID) throws IOException {
        String dir = "survey/"+surveyID; //database location (right now in the survey folder as an app
        FileReader fileReader = new FileReader(dir); //initialize filereader (this one opens files)
        BufferedReader bufferedReader = new BufferedReader(fileReader); //initialize bufferedreader (this one can read files)

        return bufferedReader.readLine(); //return first line of specified file

    }

}
