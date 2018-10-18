import java.io.*;

public class loginCheck {
    public static boolean loginCheck(String username, String password) throws IOException {
        String database = "database.txt";

        FileReader fileReader = new FileReader(database);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        try {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.equals(username)) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (FileNotFoundException ee) {
            ee.printStackTrace();
        } catch (IOException ee) {
            ee.printStackTrace();
        }
        return false;
    }
}
