public class decryptPassword {
    public static String decrypt(String hex) {

//        byte[] bytes = hexStringToByteArray(b);
//        String st = new String(bytes, StandardCharsets.UTF_8);
//        System.out.println(st);


        StringBuilder str = new StringBuilder();
        for (int i = 0; i < hex.length(); i+=2) {
            str.append((char) Integer.parseInt(hex.substring(i, i + 2), 16));
        }
        return str.toString();
    }
}
