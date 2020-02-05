import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         String input = scanner.nextLine();

        ArrayDeque<String> history = new ArrayDeque<>();

        while (!input.equalsIgnoreCase("home")){
            if (input.equalsIgnoreCase("back")){
                if (history.size()<2){
                    System.out.printf("no previous URLs%n");

                } else {
                    history.pop();
                }

            } else {
                history.push(input);
            }

            if(!history.isEmpty()) {
                System.out.println(history.peek());
            }

            input = scanner.nextLine();
        }
    }
}
