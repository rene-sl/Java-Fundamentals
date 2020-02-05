import java.util.Scanner;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class TTRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true){
            String input = scanner.nextLine();

            String regex = "(([#%$*]+)([A-Za-z]+)\\2)=(\\d+)!!(.+)";
            boolean haveMathes = false;
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);


            while (matcher.find()) {
                String name = matcher.group(3);
                int length = Integer.parseInt(matcher.group(4));
                String geoHashCode = matcher.group(5);
                haveMathes = true;
                if (geoHashCode.length() == length) {
                    StringBuilder encryptedWord = new StringBuilder();
                    for (int j = 0; j < geoHashCode.length(); j++) {
                        char letter = (char) geoHashCode.charAt(j);
                        char encryptedChar = (char) (letter + length);
                        encryptedWord.append(encryptedChar);
                    }
                    System.out.printf("Coordinates found! %s -> %s%n", name, encryptedWord);
                    return;
                } else {
                    haveMathes = false;
                }
            }

            if (!haveMathes){
                System.out.println("Nothing found!");
            }
        }
    }
}
