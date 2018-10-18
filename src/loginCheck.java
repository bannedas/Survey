public class loginCheck {
    public static boolean authenticate(String username, String password) {
        // hardcoded username and password
        if (username.equals("aau") && password.equals("aau")) {
            return true;
        }
        return false;
    }
}
