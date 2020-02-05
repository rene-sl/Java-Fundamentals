import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String result = "";

        String input = scanner.nextLine();

        while (!input.equalsIgnoreCase("End")){
            String [] commands = input.split("\\s+");
            String command = commands[0];

            switch (command){
                case "Add":
                    String concatString = commands[1];
                    result+=concatString;

                    break;
                case "Upgrade":
                    char charForUpgrade = commands[1].charAt(0);
                    int ascii = (int) charForUpgrade +1 ;
                    char newChar = (char) ascii;
                   result = result.replace(charForUpgrade,newChar);

                    break;
                case "Print":
                    System.out.println(result);
                    break;
                case "Index":
                    char charIndex = commands[1].charAt(0);
                    List<Integer> indexResult = new ArrayList<>();
                    for (int i = 0; i < result.length() ; i++) {
                      if (result.charAt(i)==charIndex) {
                          indexResult.add(i);
                      }
                    }
                    if (0<indexResult.size()) {
                        for (Integer integer : indexResult) {
                            System.out.print(integer + " ");
                        }
                    } else {
                    System.out.println("None");
                }
                    System.out.println();
                    break;
                case "Remove":
                    String forRemoving = commands[1];
                    while (result.contains(forRemoving)){
                   result = result.replace(forRemoving, "");
                    }

                    break;
                    default:break;

            }


            input= scanner.nextLine();
        }

    }


}
