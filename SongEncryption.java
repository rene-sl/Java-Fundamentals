import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SongEncryption {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

            while (!input.equalsIgnoreCase("end")) {

                String regex = "([A-Z]{1}[a-z]+([ `]+)?([a-z]+)?):([A-Z ]+)\\b";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(input);


                if (matcher.find()) {
                    String group = matcher.group(1);
                    String song = matcher.group(4);
                    int key = group.length();

                    String groupEncrypted = encrypting(group, key);
                    String songEncrypted = encrypting(song, key);

                    System.out.println("Successful encryption: " + groupEncrypted + "@" + songEncrypted);
                } else{
                    System.out.println("Invalid input!");
                }
                input = scanner.nextLine();
            }
    }

    public static String encrypting(String s, int key){
        String encryptedWord="";
        for (int i = 0; i < s.length(); i++) {
            char letter = (char) s.charAt(i);
            char encryptedChar = (char) (letter + key);

            if (Character.isUpperCase(letter)) {
                if ('Z' < encryptedChar) {
                    int index = key - ((int) 'Z' - (int) letter);
                    letter = (char) ('@' + index);
                } else {
                    letter = (char) (letter + key);
                }
            } else if (Character.isLowerCase(letter)) {
                if ('z' < encryptedChar) {
                    int index = key - ((int) 'z' - (int) letter);
                    letter = (char) ('`' + index);
                } else {
                    letter = (char) (letter + key);
                }
        }
        encryptedWord+=letter;
    }
    return  encryptedWord;
}
}

